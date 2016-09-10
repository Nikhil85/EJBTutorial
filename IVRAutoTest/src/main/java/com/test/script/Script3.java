package com.test.script;

import org.apache.log4j.Logger;
import org.sikuli.script.Screen;

import com.dto.ScreenInput;
import com.general.commom.script.CommonScript;
import com.general.commom.script.KeyPadButton;

public class Script3 extends CommonScript {

	private boolean isStep_2_Pass;
	private Screen screen;

	private static Logger logger = Logger.getLogger(Script2.class);

	public Script3(Screen screen) {

		super();
		logger.debug("--- Inside Script2.Class Initialized Images package");
		this.screen = screen;
	}

	public void startScriptTest() {

		logger.debug("------Inside Script2.Class Start startScriptTest------- ");

		try {
			// Open Modem Application
			// OpenModemScreen();
			this.startByondApp(screen);
			// Step1: Dialing toll free no. : Expected Result " Call back should
			// be received

			step1(new ScreenInput());

			// Step2: Wait and recieve call : Expected Result "playCornFormer"
			// file
			step2(new ScreenInput());

			// close application
			this.closeApp();

			logger.debug("-----Inside Script2.Class End startScriptTest------ ");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getStackTrace());
			logger.debug(e.getStackTrace());
		}
		logger.debug("-------Inside Script2.Class End startScriptTest-------");
	}

	public boolean step1(ScreenInput step1Input) throws Exception {

		// Step1: Dialing toll free no. : Expected Result " Call back should be
		// received

		logger.debug("-------Inside Script2.Class Start step1------");

		// step1Input = new ScreenInput();

		// #Press 1
		this.dialButton(KeyPadButton.DAIL_1);
		step1Input.dtmf_1.add(ScreenInput.DTMF_1);
		// #Press 8
		this.dialButton(KeyPadButton.DAIL_8);
		step1Input.dtmf_8.add(ScreenInput.DTMF_8);
		// #Press 0
		this.dialButton(KeyPadButton.DAIL_0);
		step1Input.dtmf_0.add(ScreenInput.DTMF_0);
		// #Press0
		this.dialButton(KeyPadButton.DAIL_0);
		step1Input.dtmf_0.add(ScreenInput.DTMF_0);
		// #Press 2
		this.dialButton(KeyPadButton.DAIL_2);
		step1Input.dtmf_2.add(ScreenInput.DTMF_2);
		// #Press 0
		this.dialButton(KeyPadButton.DAIL_0);
		step1Input.dtmf_0.add(ScreenInput.DTMF_0);
		// #Press 8
		this.dialButton(KeyPadButton.DAIL_8);
		step1Input.dtmf_8.add(ScreenInput.DTMF_8);
		// #Press 2
		this.dialButton(KeyPadButton.DAIL_2);
		step1Input.dtmf_2.add(ScreenInput.DTMF_2);
		// #Press 0
		this.dialButton(KeyPadButton.DAIL_0);
		step1Input.dtmf_0.add(ScreenInput.DTMF_0);
		// #Press 8
		this.dialButton(KeyPadButton.DAIL_8);
		step1Input.dtmf_8.add(ScreenInput.DTMF_8);
		// #Press 8
		this.dialButton(KeyPadButton.DAIL_8);
		step1Input.dtmf_8.add(ScreenInput.DTMF_8);
		// #Press Answer
		this.dialButton(KeyPadButton.DAIL_Answer);
		step1Input.dtmf_Answer.add(ScreenInput.DTMF_ANSWER);

		System.out.println(step1Input.dtmf_0.size());

		captureScriptInput.put("step1", step1Input);

		logger.debug("-------Inside Script2.Class End step1--------");

		return true;
	}

	public boolean step2(ScreenInput step2Input) throws Exception {

		// Step3: Wait and recieve call : Expected Result "playCornFormer" file

		logger.debug("------Inside Script2.Class Start step2-----------");
		// step2Input = new ScreenInput();
		long milliSecond = 0;
		boolean loopFlag = false;

		while (screen.exists(callRecPopup) == null) {
			// Thread.sleep(1000);
			loopFlag = ((milliSecond > 16000) ? true : false);
			milliSecond += 1000;

			if (loopFlag)
				break;
		}

		// #wait for PopupScreen
		if (!loopFlag) {
			screen.wait(callRecPopup);
			// #Press Answer
			screen.click(callRecPopup.targetOffset(-20, 9));
			step2Input.dtmf_Answer.add(ScreenInput.DTMF_ANSWER);
			Thread.sleep(10000);
			isStep_2_Pass = true;
			captureScriptInput.put("step2", step2Input);
			logger.debug("-------Inside Script2.Class End step2-----------");
			return true;

		} else {
			logger.debug("-------Inside Script2.Class End step2-----------");
			return false;
		}

	}

	public void closeApp() {
		startAndCloseApplication.closeApp();
	}

}
