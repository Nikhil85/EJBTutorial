package com.utility;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.sikuli.script.Screen;

public class StartAndCloseApplication {

	Runtime rt = Runtime.getRuntime();
	Process p = null;
	static final String APP_PATH = "C:\\Program Files\\BYOND 3G Modem\\BYOND 3G Modem.exe";
	private static Logger logger = Logger
			.getLogger(StartAndCloseApplication.class);

	public void startApp() throws InterruptedException {
		logger.debug("-----Inside StartAndCloseApplication Start startApp Method-----");
		try {

			if (p == null)
				p = rt.exec(APP_PATH);

		} catch (IOException | InternalError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getStackTrace());
			logger.debug(e.getStackTrace());
		}
		logger.debug("-----End startApp Method-----");
	}

	public void closeApp() {
		logger.debug("-----Inside StartAndCloseApplication Start closeApp Method-----");

		try {
			if (p != null)
				p.destroyForcibly();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.printStackTrace();
			System.out.println(e.getStackTrace());
			logger.debug(e.getStackTrace());
		}
		logger.debug("-----Close closeApp Method-----");
	}

	/*
	 * public static void main(String[] args) throws Exception {
	 * StartAndCloseApplication autoTestScenario1 = new
	 * StartAndCloseApplication(); autoTestScenario1.startApp();
	 * Thread.sleep(8000); autoTestScenario1.closeApp(); }
	 */

}
