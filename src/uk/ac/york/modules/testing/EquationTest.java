package uk.ac.york.modules.testing;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class EquationTest {

	private static class RobotThread extends Thread {
		private static int delayMs = 250;
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
			delay();
			for(int k : keys) {
				robot.keyPress(k);
				robot.keyRelease(k);
			}
		}
		
		private void delay() {
			robot.delay(delayMs);
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
	
	@Ignore
	@Test
	public void shouldDoSomethingSensibleOnEmptyString() {
		robot.add(KeyEvent.VK_ENTER);
		robot.start();
		Equation e = Equation.createEquationFromType(SinusBasedEquation.class);		
	}

	@Ignore
	@Test		
	public void shouldCancelNicely() {
		robot.add(KeyEvent.VK_TAB);
		robot.add(KeyEvent.VK_TAB);
		robot.add(KeyEvent.VK_ENTER);
		robot.start();
		Equation e = Equation.createEquationFromType(SinusBasedEquation.class);
	}

	@Ignore
	@Test
	public void shouldBeUserFriendlyOnInvalidInput() {
		robot.add(KeyEvent.VK_H);
		robot.add(KeyEvent.VK_ENTER);
		robot.start();
		Equation e = Equation.createEquationFromType(SinusBasedEquation.class);
	}
	
}
