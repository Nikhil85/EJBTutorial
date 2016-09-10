package com.test.script;

public interface ExpectedOtput {
	
	 String TESTCASESTEP = "Test Case Step";
     String INPUTDATA =    "Input Data";
	 String EXPECTEDOUTPUTDATA = "Expected Output Data" ;
     String ACTUALOUTPUT = "Actual Output" ;
	 String STATUS = "Status" ;
	 String PASS = "PASS";
	 String FAIL = "FAIL";
	 
	 String STEP_1 = "Give a miss call to Toll free number"; 
	 String STEP_2 =  "Pick the call";
	 String STEP_3 = "Press 1 when asked for Äre you CORN farmer";
	 String STEP_4 = "Hangup the call";
	 
	
	 
	 String STEP_1_EXP = "User will receive the IVR call";
	 String STEP_2_EXP = "System should play wave file Welcome File and Asking for next dtmf I/p ";
	 String STEP_3_EXP = "System should play wave file playCornFarmer and Asking for next dtmf I/p "; 
	 String STEP_4_EXP = "Phone should be disconnected HangedUp";
	 
	
	 String STEP_1_Actual = "User Picked Call";
	 String STEP_2_Actual = "Yes play same wave  Welcome File"; 
	 String STEP_3_Actual = "Yes play same wave  CornFormer File";
	 String STEP_4_Actual = "Call HangedUp";
	 
	 String STEP_1_INPUT = "18002082088";
	 String STEP_3_INPUT = "1";
	 String STEP_PRESS_ANSWER = "Press Answer";
	 String STEP_PRESS_HANGUP = "Press HangUp";
	 
	 String DTMF_INPUT_1 = "1";
	 String DTMF_INPUT_2 = "2";
	 String DTMF_PINCODE = "444001";
	 
	 
	 
	  String FILE_PLAY1 = "playCornFormer";
	  String EVENT = "Newcall";
	  String MOBILE_NO = "9108484277";
/////////////---------------------------------------------------------------------------------------------------/////////////
	
	  //Partial Script Run Scenario Hards Codede
	  
	  String STEP_5 =" Give a miss call to Toll free number";
	  String STEP_6 ="Pick the call";
	  String STEP_7 = "Press 1 when asked  for which corn brand you prefer?";
	 
	  String STEP_8 = "Press 2 when asked  for which is the second corn brand you prefer";
	  String STEP_9 = "Press 1 when asked  for What is Your Irregation type ?";
	  String STEP_10 = "Enter your area pin after Beep";
	  String STEP_11 = "Press 1 for Yes when asked for  Conformation";
	  
	  String STEP_5_EXP ="User will receive the IVR call";
	  String STEP_6_EXP ="System should play wave file WelcomeFile and Asking for next dtmf I/p";
	  String STEP_7_EXP = "System should play wave file which corn brand you preferand Asking for next dtmf I/p ";
	
	  String STEP_8_EXP = "System should play wave file which is the second corn brand you prefer and Asking for next dtmf I/p";
	  String STEP_9_EXP = "Press 1 when asked  for What is Your Irregation type ?";
	  String STEP_10_EXP = "System should play wave file Enter your area pin after Beep and Asking for next dtmf I/p";
	  String STEP_11_EXP = "System should play wave file Conformation file and call Ended";
	  
	  String STEP_5_Actual = "User will receive the IVR call";
	  String STEP_6_Actual = "Yes play same wave  file WelcomeFile"; 
	  String STEP_7_Actual = "Yes play same wave file playCornFormer";
	
	  String STEP_8_Actual = "Yes play same wave file which is the second corn brand you prefer";
	  String STEP_9_Actual = "Yes play same wave file What is Your Irregation type"; 
	  String STEP_10_Actual = "Yes play same wave file Enter your area pin after Beep";
	  String STEP_11_Actual = "Yes play same wav Conformation file";	
      
	   
		 
	  
	  
}
