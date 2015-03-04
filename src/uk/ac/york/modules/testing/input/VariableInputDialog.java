package uk.ac.york.modules.testing.input;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VariableInputDialog extends JDialog implements ActionListener, DocumentListener {

	private final JTextField text;
	private final JButton ok;
	private final JButton cancel;
	private final Border normalBorder;
	private final Border redBorder;
	
	public static class Cancelled extends Exception {
		
	}
	
	public VariableInputDialog(String name, String description) {
		super();
		this.text = new JTextField();
		this.ok = new JButton("OK");
		this.cancel = new JButton("Cancel");
		
		this.normalBorder = BorderFactory.createLineBorder(Color.black);
		this.redBorder = BorderFactory.createLineBorder(Color.red);
		
		setModal(true);
		setLocationRelativeTo(null);
		setTitle("Enter value of variable '" + name + '"');
		
		Box dbox = Box.createHorizontalBox();
		JLabel desc = new JLabel(new VariableHighlighter(description).highlight(name),
				SwingConstants.CENTER);
		dbox.add(Box.createHorizontalGlue());
		dbox.add(desc);
		dbox.add(Box.createHorizontalGlue());
		
		Box entry = Box.createHorizontalBox();
		JLabel label = new JLabel(name + " = ");
		entry.add(label);
		entry.add(text);
		
		Box buttons = Box.createHorizontalBox();
		buttons.add(ok);
		buttons.add(Box.createHorizontalStrut(3));
		buttons.add(cancel);
		
		Box vbox = Box.createVerticalBox();
		vbox.add(Box.createVerticalStrut(12));
		vbox.add(dbox);
		vbox.add(Box.createVerticalStrut(12));
		vbox.add(entry);
		vbox.add(Box.createVerticalStrut(12));
		vbox.add(buttons);
		vbox.add(Box.createVerticalStrut(12));
		
		Box hbox = Box.createHorizontalBox();
		hbox.add(Box.createHorizontalStrut(6));
		hbox.add(vbox);
		hbox.add(Box.createHorizontalStrut(6));
		
		add(hbox);
		pack();
		
		checkValid();
		text.getDocument().addDocumentListener(this);
		text.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (validDouble() && (e.getSource() == ok || e.getSource() == text)) {
			setVisible(false);
		} else if (e.getSource() == cancel) {
			setVisible(false);
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		checkValid();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		checkValid();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		checkValid();
	}
	
	public boolean validDouble() {
		return DoubleValidator.isValid(text.getText());
	}
	
	public double value() {
		return Double.parseDouble(text.getText());
	}
	
	public static double prompt(String name, String description) throws Cancelled {
		VariableInputDialog vi = new VariableInputDialog(name, description);
		vi.setVisible(true);
		if (!vi.validDouble()) {
			throw new Cancelled();
		}
		double d = vi.value();
		vi.dispose();
		return vi.value();
	}
	
	private void checkValid() {
		if (DoubleValidator.isValid(text.getText())) {
			ok.setEnabled(true);
			text.setBorder(normalBorder);
		} else {
			ok.setEnabled(false);
			text.setBorder(redBorder);
		}
	}
}
