package com.test.script;

import java.util.Map;

import org.apache.log4j.Logger;
import org.sikuli.script.Screen;

import com.dto.ScreenInput;
import com.general.commom.script.CommonScript;
import com.general.commom.script.KeyPadButton;

public class Script2 extends CommonScript {

	private boolean isStep_2_Pass;
	private Screen screen;

	private static Logger logger = Logger.getLogger(Script2.class);

	public Script2(Screen screen) {

		super();
		logger.debug("--- Inside Script2.Class Initialized Images package");
		this.screen = screen;
	}

	void startScriptTest() {

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

			// step3: Wait for KeyPad screen and given dtmf input 1 for
			// CornFormer Registration

			step3(new ScreenInput());

			step4(new ScreenInput());

			step5(new ScreenInput());

			step6(new ScreenInput());

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

	/*
	 * void OpenModemScreen() throws Exception{
	 * 
	 * // Open Modem Application
	 * 
	 * logger.debug("Inside Script2.Class Start OpenModemScreen ");
	 * 
	 * screen.click(winStartIcon); screen.wait(winSearchIcon);
	 * screen.type("BYOND 3G Modem"+Key.ENTER); screen.wait(byondDashBoard);
	 * Thread.sleep(8000); screen.click(byondDashBoard.targetOffset(111,-11));
	 * screen.wait(dialTap);
	 * 
	 * logger.debug("-------Inside Script2.Class End OpenModemScreen-------");
	 * 
	 * 
	 * 
	 * }
	 */

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
			Thread.sleep(20000);
			isStep_2_Pass = true;
			captureScriptInput.put("step2", step2Input);
			logger.debug("-------Inside Script2.Class End step2-----------");
			return true;

		} else {
			logger.debug("-------Inside Script2.Class End step2-----------");
			return false;
		}

	}

	public boolean step3(ScreenInput step3Input) throws Exception {

		// step3: Wait for KeyPad screen and given dtmf input 1 for CornFormer
		// Registration
		logger.debug("-------------Inside Script2.Class Start step3---------");
		// step3Input = new ScreenInput();
		if (isStep_2_Pass) {
			screen.wait(dialTap);
			Thread.sleep(5000);
			// Press button #1
			this.dialButton(KeyPadButton.DAIL_1);
			step3Input.dtmf_1.add(ScreenInput.DTMF_1);
			Thread.sleep(15000);
			// Click Hangup
			this.dialButton(KeyPadButton.DAIL_Disconnect);
			this.dialButton(KeyPadButton.DAIL_Disconnect);
			step3Input.dtmf_Hangup.add(ScreenInput.DTMF_HANGUP);
			logger.debug("-----------Inside Script2.Class End step3------------");
			captureScriptInput.put("step3", step3Input);
			return true;
		} else {
			logger.debug("-----------Inside Script2.Class End step3------------");
			return false;
		}
	}

	@Override
	public boolean step4(ScreenInput step4Input) throws Exception {
		// TODO Auto-generated method stub
		// again give a miss call to toll free no.

		logger.debug("-------Inside Script2.Class Start step4------");

		// step4Input = new ScreenInput();

		// #Press 1
		this.dialButton(KeyPadButton.DAIL_1);
		step4Input.dtmf_1.add(ScreenInput.DTMF_1);
		// #Press 8
		this.dialButton(KeyPadButton.DAIL_8);
		step4Input.dtmf_8.add(ScreenInput.DTMF_8);
		// #Press 0
		this.dialButton(KeyPadButton.DAIL_0);
		step4Input.dtmf_0.add(ScreenInput.DTMF_0);
		// #Press0
		this.dialButton(KeyPadButton.DAIL_0);
		step4Input.dtmf_0.add(ScreenInput.DTMF_0);
		// #Press 2
		this.dialButton(KeyPadButton.DAIL_2);
		step4Input.dtmf_2.add(ScreenInput.DTMF_2);
		// #Press 0
		this.dialButton(KeyPadButton.DAIL_0);
		step4Input.dtmf_0.add(ScreenInput.DTMF_0);
		// #Press 8
		this.dialButton(KeyPadButton.DAIL_8);
		step4Input.dtmf_8.add(ScreenInput.DTMF_8);
		// #Press 2
		this.dialButton(KeyPadButton.DAIL_2);
		step4Input.dtmf_2.add(ScreenInput.DTMF_2);
		// #Press 0
		this.dialButton(KeyPadButton.DAIL_0);
		step4Input.dtmf_0.add(ScreenInput.DTMF_0);
		// #Press 8
		this.dialButton(KeyPadButton.DAIL_8);
		step4Input.dtmf_8.add(ScreenInput.DTMF_8);
		// #Press 8
		this.dialButton(KeyPadButton.DAIL_8);
		step4Input.dtmf_8.add(ScreenInput.DTMF_8);
		// #Press Answer
		this.dialButton(KeyPadButton.DAIL_Answer);
		step4Input.dtmf_Answer.add(ScreenInput.DTMF_ANSWER);

		captureScriptInput.put("step4", step4Input);

		logger.debug("-------Inside Script2.Class End step4--------");

		return true;
	}

	@Override
	public boolean step5(ScreenInput step5Input) throws Exception {
		// TODO Auto-generated method stub
		// again pick up the call
		logger.debug("------Inside Script2.Class Start step5-----------");
		// step5Input = new ScreenInput();
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
			step5Input.dtmf_Answer.add(ScreenInput.DTMF_ANSWER);
			Thread.sleep(20000);
			isStep_2_Pass = true;
			captureScriptInput.put("step5", step5Input);
			logger.debug("-------Inside Script2.Class End step2-----------");
			return true;

		} else {
			logger.debug("-------Inside Script2.Class End step5-----------");
			return false;
		}

	}

	@Override
	public boolean step6(ScreenInput step6Input) throws Exception {

		// TODO Auto-generated method stub
		logger.debug("------Inside Script2.Class Start step6-----------");
		// step6Input = new ScreenInput();
		if (isStep_2_Pass) {
			screen.wait(dialTap);
			Thread.sleep(10000);

			// Press 1 when asked for "which corn brand you prefer
			this.dialButton(KeyPadButton.DAIL_1);
			step6Input.dtmf_1.add(ScreenInput.DTMF_1);
			Thread.sleep(10000);

			// Press 2 when asked for
			// "which is the second corn brand you prefer?"
			this.dialButton(KeyPadButton.DAIL_2);
			step6Input.dtmf_2.add(ScreenInput.DTMF_2);
			Thread.sleep(10000);

			// Press 1 when asked for "What is Your Irregation type ?
			this.dialButton(KeyPadButton.DAIL_1);
			step6Input.dtmf_1.add(ScreenInput.DTMF_1);
			Thread.sleep(3000);

			// Enter your area pin after Beep
			this.dialButton(KeyPadButton.DAIL_4);
			step6Input.dtmf_4.add(ScreenInput.DTMF_4);
			this.dialButton(KeyPadButton.DAIL_4);
			step6Input.dtmf_4.add(ScreenInput.DTMF_4);
			this.dialButton(KeyPadButton.DAIL_4);
			step6Input.dtmf_4.add(ScreenInput.DTMF_4);
			this.dialButton(KeyPadButton.DAIL_0);
			step6Input.dtmf_0.add(ScreenInput.DTMF_0);
			this.dialButton(KeyPadButton.DAIL_0);
			step6Input.dtmf_0.add(ScreenInput.DTMF_0);
			this.dialButton(KeyPadButton.DAIL_1);
			step6Input.dtmf_1.add(ScreenInput.DTMF_1);
			Thread.sleep(10000);

			// .Press 1 for Yes when asked for Conformation
			this.dialButton(KeyPadButton.DAIL_1);
			step6Input.dtmf_1.add(ScreenInput.DTMF_1);
			Thread.sleep(10000);
			captureScriptInput.put("step6", step6Input);
			logger.debug("-----------Inside Script2.Class End step6------------");
			return true;
		} else {
			logger.debug("-----------Inside Script2.Class End step6------------");
			return false;
		}
	}

	public Map<String, ScreenInput> getCaptureScriptInput() {

		return captureScriptInput;
	}

	public void closeApp() {
		startAndCloseApplication.closeApp();
	}

	public static void test() {

	}

	public static void main(String[] args) {
		Screen screen = new Screen();
		Script2 Script2 = new Script2(screen);
		Script2.startScriptTest();

	}

}
