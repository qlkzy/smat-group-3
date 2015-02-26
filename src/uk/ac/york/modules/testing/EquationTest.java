package uk.ac.york.modules.testing;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EquationTest {

	private class RobotThread extends Thread {
		private Robot robot;
		private ArrayList<Integer> keys;
		
		public RobotThread() throws AWTException {
			robot = new Robot();
			keys = new ArrayList<Integer>();
		}
		
		public void add(int keycode) {
			keys.add(keycode);
		}
		
		public void run() {
			try {sleep(100);} catch (InterruptedException e) {}
			for(int k : keys) {
				robot.keyPress(k);
				robot.delay(100);
				robot.keyRelease(k);
				robot.delay(100);
			}
		}
	}
		
	private RobotThread robot;
	
	@Before
	public void setUp() throws Exception {
		robot = new RobotThread();
	}

	@After
	public void tearDown() throws InterruptedException {
		robot.join();
	}
	
	@Test		
	public void shouldCancelNicely() {
		robot.add(KeyEvent.VK_TAB);
		robot.add(KeyEvent.VK_TAB);
		robot.add(KeyEvent.VK_ENTER);
		robot.start();
		Equation e = Equation.createEquationFromType(SinusBasedEquation.class);
	}

	@Test
	public void shouldBeUserFriendlyOnInvalidInput() {
		robot.add(KeyEvent.VK_H);
		robot.add(KeyEvent.VK_ENTER);
		robot.start();
		Equation e = Equation.createEquationFromType(SinusBasedEquation.class);
	}
	
}
