package com.general.commom.script;

import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.dto.ScreenInput;
import com.utility.StartAndCloseApplication;

public class CommonScript {

	private Region region;
	private Match match;

	protected Pattern winStartIcon;
	protected Pattern winSearchIcon;
	protected Pattern byondDashBoard;
	protected Pattern dialTap;
	protected Pattern keyPadIcon;
	protected Pattern callRecPopup;
	protected Pattern network;
	protected Pattern signal;
	protected StartAndCloseApplication startAndCloseApplication;
	protected Map<String, ScreenInput> captureScriptInput;

	private static Logger logger = Logger.getLogger(CommonScript.class);

	public CommonScript() {

		// TODO Auto-generated constructor stub
		// logger.debug("Initialized CommonScript.class Inside Constructor");

		ImagePath.add("D:\\Test_Workspace\\IVRAutoTest\\src\\main\\resources");
		keyPadIcon = new Pattern("keyPadIcon.png");
		winStartIcon = new Pattern("WinStartIcon.png");
		winSearchIcon = new Pattern("WinSearchIcon.png");
		byondDashBoard = new Pattern("ByondDashBoard.png");
		dialTap = new Pattern("DialTap.png");
		callRecPopup = new Pattern("CallRecPopup.png");
		network = new Pattern("Network.png");
		signal = new Pattern("Signal.png");
		region = new Region(keyPadIcon.getTargetOffset().getScreen().getRect());
		startAndCloseApplication = new StartAndCloseApplication();
		captureScriptInput = new TreeMap<String, ScreenInput>();
	}

	public Map<String, ScreenInput> getCaptureScriptInput() {
		return captureScriptInput;
	}

	public void dialButton(KeyPadButton button) {

		// logger.debug("Inside CommonScript.class in dialButton Method");
		try {
			switch (button) {
			case DAIL_0:
				Pattern Dial_0 = new Pattern("keyPadIcon")
						.targetOffset(-3, 162);
				match = region.exists(Dial_0);
				match.click();
				break;

			case DAIL_1:
				Pattern Dial_1 = new Pattern("keyPadIcon")
						.targetOffset(-67, 70);
				match = region.exists(Dial_1);
				match.click();
				break;

			case DAIL_2:
				Pattern Dial_2 = new Pattern("keyPadIcon").targetOffset(-2, 70);
				match = region.exists(Dial_2);
				match.click();
				break;

			case DAIL_3:
				Pattern Dial_3 = new Pattern("keyPadIcon").targetOffset(66, 70);
				match = region.exists(Dial_3);
				match.click();
				break;

			case DAIL_4:
				Pattern Dial_4 = new Pattern("keyPadIcon").targetOffset(-68,
						100);
				match = region.exists(Dial_4);
				match.click();
				break;

			case DAIL_5:
				Pattern Dial_5 = new Pattern("keyPadIcon")
						.targetOffset(-0, 100);
				match = region.exists(Dial_5);
				match.click();
				break;

			case DAIL_6:
				Pattern Dial_6 = new Pattern("keyPadIcon")
						.targetOffset(64, 100);
				match = region.exists(Dial_6);
				match.click();
				break;

			case DAIL_7:
				Pattern Dial_7 = new Pattern("keyPadIcon").targetOffset(-68,
						130);
				match = region.exists(Dial_7);
				match.click();
				break;

			case DAIL_8:
				Pattern Dial_8 = new Pattern("keyPadIcon")
						.targetOffset(-3, 130);
				System.out.println(Dial_8.getSimilar());
				match = region.exists(Dial_8);
				match.click();
				break;

			case DAIL_9:
				Pattern Dial_9 = new Pattern("keyPadIcon")
						.targetOffset(66, 130);
				match = region.exists(Dial_9);
				match.click();
				break;

			case DAIL_Answer:
				Pattern Dial_Answer = new Pattern("keyPadIcon").targetOffset(
						-68, 38);
				match = region.exists(Dial_Answer);
				match.click();
				break;

			case DAIL_Disconnect:
				Pattern DAIL_Disconnect = new Pattern("keyPadIcon")
						.targetOffset(64, 38);
				match = region.exists(DAIL_Disconnect);
				match.click();
				break;

			default:
				System.out.println("Please Press Desire DTMF Input");
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.debug("Inside CommonScript.class in dialButton Method Catch block"
					+ e.getStackTrace());
			System.out.println(e.getStackTrace());
		}
		// logger.debug("Inside CommonScript.class in dialButton Method");
	}

	public void startByondApp(Screen screen) {

		// logger.debug("Inside CommonScript.class in startByondApp Method");
		try {

			long milliSecond = 0;
			boolean matchFlag = false;
			boolean networkFlag = false;

			startAndCloseApplication.startApp();
			Thread.sleep(5000);
			screen.wait(byondDashBoard);
			screen.waitVanish(network);
			networkFlag = ((screen.exists(network) == null) ? true : false);
			matchFlag = ((screen.exists(signal) != null) ? true : false);

			if (networkFlag && matchFlag) {
				screen.click(byondDashBoard.targetOffset(111, -11));
				screen.wait(dialTap);
			} else {

				while (screen.exists(network) != null) {
					milliSecond += 100;
					if (milliSecond > 1500)
						break;
				}

				while ((screen.exists(signal) == null)) {
					milliSecond += 100;
					if (milliSecond > 1500)
						break;
				}

				networkFlag = ((screen.exists(network) == null) ? true : false);
				matchFlag = ((screen.exists(signal) != null) ? true : false);

				if (networkFlag && matchFlag) {
					screen.click(byondDashBoard.targetOffset(111, -11));
					screen.wait(dialTap);
				}
			}
		} catch (FindFailed | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.printStackTrace();
			logger.debug("Inside CommonScript.class in startByondApp Method Catch block"
					+ e.getStackTrace());
			System.out.println(e.getStackTrace());

		}
		// logger.debug("Inside CommonScript.class in startByondApp Method");
	}

	public boolean step1(ScreenInput step1Input) throws Exception {

		return false;
	}

	public boolean step2(ScreenInput step1Input) throws Exception {

		return false;
	}

	public boolean step3(ScreenInput step1Input) throws Exception {

		return false;
	}

	public boolean step4(ScreenInput step1Input) throws Exception {

		return false;
	}

	public boolean step5(ScreenInput step1Input) throws Exception {

		return false;
	}

	public boolean step6(ScreenInput step1Input) throws Exception {

		return false;
	}

	public boolean step7(ScreenInput step1Input) throws Exception {

		return false;
	}

	public boolean step8(ScreenInput step1Input) throws Exception {

		return false;
	}

	public boolean step9(ScreenInput step1Input) throws Exception {

		return false;
	}

	public boolean step10(ScreenInput step1Input) throws Exception {

		return false;
	}

	public boolean step11(ScreenInput step1Input) throws Exception {

		return false;
	}

	public boolean step12(ScreenInput step1Input) throws Exception {

		return false;
	}

	public boolean step13(ScreenInput step1Input) throws Exception {

		return false;
	}

	public boolean step14(ScreenInput step1Input) throws Exception {

		return false;
	}

	public boolean step15(ScreenInput step1Input) throws Exception {

		return false;
	}
}
