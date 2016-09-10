package com.test.script;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sikuli.script.Screen;

import com.dto.IvrCallLogData;
import com.dto.ScreenInput;
import com.excel.report.WriteTestDataInExcel;

public class TestCase2 extends TestCase {
	
	
	private Script2 script2;
	private WriteTestDataInExcel dataInExcel;
	private List<Map<String, Object[]>> list;
	private Map<String, Object[]> mapData ;
	private String s1;
	private String s2;
	private String s3;
	private String s4;
	private String s5;
	private String s6;
	private String ac1; 
	private String ac2; 
	private String ac3; 
	private String ac4;
	private String ac5; 
	private String ac6;
	boolean st1;
	boolean st2;
	boolean st3;
	boolean st4;
	boolean st5;
	boolean st6;
	Screen screen;
	String excelReport = "TestScript2";
	Map<String, ScreenInput> screenStepInput;
	
	

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
	}

	 
	public TestCase2() {
		super();
	}

	@Before
	protected void setUp() throws Exception{
		super.setUp();
		screen = new Screen();
		script2 = new Script2(screen);
		dataInExcel = new WriteTestDataInExcel(excelReport);
		mapData = new LinkedHashMap<String, Object[]>();
		list = new LinkedList<Map<String,Object[]>>();
		
	}
	
	@After
	protected void tearDown() throws Exception{
		super.tearDown();
		
		}
	
	@Test
	public void testScript() throws Exception {
		
		
		try {
		TestCase2.tearDownAfterClass();
		script2.startByondApp(screen);
		boolean st1 =	script2.step1(new ScreenInput()); 
		boolean st2 =	script2.step2(new ScreenInput());
		boolean st3 =	script2.step3(new ScreenInput());
		boolean st4 =   script2.step4(new ScreenInput());
		boolean st5 =   script2.step5(new ScreenInput());
		boolean st6 = 	script2.step6(new ScreenInput());
		script2.closeApp();
	  
	    TestCase2.setUpBeforeClass();
		
	    
	   
	    
	    assertEquals(true, st1);
	    
		if (st1 == true) {
			
			s1 = "Pass";
			
			//Expected I/P
			ac1 = ExpectedOtput.STEP_1_Actual;
			
			ScreenInput step2Ip = script2.getCaptureScriptInput().get("step1");
			
			char[] dialArra = new char[12];
			String  dialNum =null;
			
		     //dialNo.ap
			int count_0 = step2Ip.getDtmf_0().size();
			int count_1 = step2Ip.getDtmf_1().size();
			int count_2 = step2Ip.getDtmf_2().size();
			int count_8 = step2Ip.getDtmf_8().size();
			
			for (int i=0;i<count_1;i++)  {
				
				dialArra[0] = '1';
				
			}
			for (int i=0;i<count_0;i++) {
				
				if(i==0)
				
					dialArra[2] = '0';
				if(i==1)
				
					dialArra[3] ='0';
				if(i==2)
			
					dialArra[5] = '0';
				if(i==3)
				
					dialArra[8] = '0';
			
			}
		
			for (int i=0;i<count_2;i++) {
				if(i==0)
				
					dialArra[4] = '2';
				if(i==1)
				
					dialArra[7] = '2';
			}
			for (int i=0;i<count_8;i++)  {
				
				if(i==0)
					dialArra[1] = '8';
				
				if(i==1)
					dialArra[6] = '8';
				
				if(i==2)
					dialArra[9] ='8';
				
				if(i==3)
					dialArra[10] = '8';
				
				
			}
//			for (String string : step2Ip.getDtmf_Answer()) {
//				dialNo.append(string);
//			}
			
			//INPUT Dialed No.
			dialNum =String.copyValueOf(dialArra);
			
			//IVR Log dataase
			IvrCallLogData ivrCallLogData = new IvrCallLogData();
			//cheking dialed no.
			//assertEquals(dialNum.toString(), ExpectedOtput.STEP_1_INPUT);
			
			System.out.println("Dialed Number Digit Count------"+ dialNum.toString() +"Just Cheking But Not Squence Vice");
			
		} else {
			s1 = "Fail";
			ac1 = "differ";
		}

		assertEquals(true, st2);
		
		if (st2 == true) {
			s2 = "Pass";
			ac2 = ExpectedOtput.STEP_2_Actual;
			System.out.println(st2);
		} else {
			s2 =  "Fail";
			ac2 = "differ";
		}
		assertEquals(true, st3);
		if (st3 == true) {
			s3 = "Pass";
			ac3 = ExpectedOtput.STEP_3_Actual;
		}else{
			s3 = "Fail";
			ac3 = "differ";
		}if(st4==true){
			ac4 = ExpectedOtput.STEP_4_Actual;
			s4= "Pass";
		}else{
			s4 = "Fail";
			ac4="differ";
		}if(st5==true){
			ac5 = ExpectedOtput.STEP_5_Actual;
			s5= "Pass";
		}else{
			s4 = "Fail";
			ac4="differ";
		}if(st6==true){
			ac6 = ExpectedOtput.STEP_6_Actual;
			s6= "Pass";
		}else{
			s6 = "Fail";
			ac6="differ";
		}
		
	}catch (AssertionFailedError e) {
		// TODO Auto-generated catch block
		System.out.println("------------inside catch block1--------------------");
		if (st1 == true) {
			s1 = "Pass";
			ac1 = ExpectedOtput.STEP_1_Actual;
		} else {
			s1 = "Fail";
			ac1 = "differ";
			fail(e.getMessage());
		}
		if (st2 == true) {
			s2 = "Pass";
			ac2 = ExpectedOtput.STEP_2_Actual;
			System.out.println(st2);
		} else {
			s2 =  "Fail";
			ac2 = "differ";
			fail(e.getMessage());
		}
		if (st3 == true) {
			s3 = "Pass";
			ac3 = ExpectedOtput.STEP_3_Actual;
		}else{
			s3 = "Fail";
			ac3 = "differ";
			fail(e.getMessage());
		}
		if(st4==true){
			ac4 = ExpectedOtput.STEP_4_Actual;
			s4= "Pass";
	    }
		else{
	    	s4 = "Fail";
	    	ac4="differ";
	    	fail(e.getMessage());
	    }
		if(st5==true){
			ac5 = ExpectedOtput.STEP_5_Actual;
			s5= "Pass";
	    }
		else{
			s5 = "Fail";
			ac5="differ";
			fail(e.getMessage());
	    }
		if(st6==true){
			ac6 = ExpectedOtput.STEP_6_Actual;
			s6= "Pass";
	    }
		else{
			s6 = "Fail";
			ac6="differ";
			fail(e.getMessage());
	}
	
	}catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("----------------inside catch block2-------------------");
		e.printStackTrace();
	}
		
		//3. Making Report on Basis of Comaparision
		
			//screenInput = script1.testInput();
			IvrCallLogData IvrCallLogData = new IvrCallLogData();
		
	mapData.put("0", new Object[] { ExpectedOtput.TESTCASESTEP,ExpectedOtput.INPUTDATA, ExpectedOtput.EXPECTEDOUTPUTDATA,ExpectedOtput.ACTUALOUTPUT, ExpectedOtput.STATUS });
	mapData.put("1", new Object[] { ExpectedOtput.STEP_1,ExpectedOtput.STEP_1_INPUT, ExpectedOtput.STEP_1_EXP, ac1, s1 });
	mapData.put("2", new Object[] { ExpectedOtput.STEP_2,ExpectedOtput.STEP_PRESS_ANSWER,ExpectedOtput.STEP_2_EXP, ac2, s2 });
	mapData.put("3", new Object[] { ExpectedOtput.STEP_3, ExpectedOtput.STEP_1_INPUT,ExpectedOtput.STEP_3_EXP, ac3, s3 });
	mapData.put("4", new Object[] { ExpectedOtput.STEP_4,ExpectedOtput.STEP_PRESS_HANGUP,ExpectedOtput.STEP_4_EXP,ac4, s4});
	mapData.put("5", new Object[] { ExpectedOtput.STEP_5, ExpectedOtput.STEP_1_INPUT,ExpectedOtput.STEP_5_EXP,ac5, s5});
	mapData.put("6", new Object[] { ExpectedOtput.STEP_6,ExpectedOtput.STEP_PRESS_ANSWER,ExpectedOtput.STEP_6_EXP,ac6, s6});
	mapData.put("7", new Object[] { ExpectedOtput.STEP_7, ExpectedOtput.DTMF_INPUT_1,ExpectedOtput.STEP_7_EXP, ExpectedOtput.STEP_7_Actual , s4});
	mapData.put("8", new Object[] { ExpectedOtput.STEP_8, ExpectedOtput.DTMF_INPUT_2,ExpectedOtput.STEP_8_EXP,ExpectedOtput.STEP_8_Actual, s4});
	mapData.put("9", new Object[] { ExpectedOtput.STEP_9, ExpectedOtput.DTMF_INPUT_1,ExpectedOtput.STEP_9_EXP,ExpectedOtput.STEP_9_Actual, s4});
	mapData.put("10", new Object[] { ExpectedOtput.STEP_10, ExpectedOtput.DTMF_PINCODE,ExpectedOtput.STEP_10_EXP,ExpectedOtput.STEP_10_Actual, s4});
	mapData.put("11", new Object[] { ExpectedOtput.STEP_11, ExpectedOtput.DTMF_INPUT_1,ExpectedOtput.STEP_11_EXP,ExpectedOtput.STEP_11_Actual, s4});
	
            
	      
		    list.add(mapData);
		  
		    dataInExcel.setDataInRowAndColumn(list);
		    
		   // this.checkStep();
   }
	
//	@Test
//    public void checkStep(){
//		failNotEquals("Test Case Fail", false, st2);
//		failNotEquals("Test Case Fail", false, st3);
//		failNotEquals("Test Case Fail", false, st4);
//		failNotEquals("Test Case Fail", false, st5);
//		failNotEquals("Test Case Fail", false, st6);
//    }
	
	
}
