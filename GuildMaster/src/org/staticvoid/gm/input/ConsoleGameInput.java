package org.staticvoid.gm.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleGameInput implements GameIO {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	@Override
	public String nextInput() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-11);
		}
		return null;
	}

	@Override
	public int getAnswer() {
		return Integer.parseInt(nextInput());
	}

	@Override
	public void println(String output) { System.out.println(output); }

	@Override
	public void println() { System.out.println(); }

	@Override
	public void clear() {
		for(int i = 0; i < 40; i++)
			System.out.println();
		
//		System.out.flush();
//		try {
//			Robot r = new Robot();
//			r.keyPress(KeyEvent.VK_SHIFT);
//	        r.keyPress(KeyEvent.VK_F10);
//	        r.keyRelease(KeyEvent.VK_SHIFT);
//	        r.keyRelease(KeyEvent.VK_F10);
//	        
//	        for(int i = 0; i < 7; i++) {
//	        	r.keyPress(KeyEvent.VK_DOWN);
//	        	r.keyRelease(KeyEvent.VK_DOWN);
//	        }
//	        
//	        r.keyPress(KeyEvent.VK_ENTER);
//	        r.keyRelease(KeyEvent.VK_ENTER);
//		} catch (AWTException e) {
//			throw new Error("Failed to clear console.");
//		}
	}
	

}
