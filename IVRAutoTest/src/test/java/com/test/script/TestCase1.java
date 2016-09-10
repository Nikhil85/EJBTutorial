/**
 * 
 */
package com.test.script;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sikuli.script.Screen;

import com.dto.IvrCallLogData;
import com.dto.IvrIntractionHistory;
import com.dto.ScreenInput;
import com.excel.report.WriteTestDataInExcel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivrlog.rest.client.IVRLogHistoryHttpClient;

/**
 * @author nikhil.sanghvi
 *
 */
public class TestCase1 extends TestCase {
	
	private Script1 script1;
	private WriteTestDataInExcel dataInExcel;
	private List<Map<String, Object[]>> list;
	private Map<String, Object[]> mapData ;
	private String s1;
	private String s2;
	private String s3;
	private String s4;
	private String ac1; 
	private   String ac2; 
	private String ac3; 
	private String ac4;
	private String ac5;
	private String ac6;
	private String ac7;
	private String ac8;
	private boolean st1;
	private boolean st2;
	private boolean st3;
	 Screen screen;
	 String excelReport = "TestScript1";
	 Map<String, ScreenInput> screenStepInput;
	private IVRLogHistoryHttpClient client = null;
	private IvrCallLogData IvrCallLogData = null;
	private ScreenInput screenInput = null;
	private Map<Integer, String> ivrHistoryMap;
	private JSONObject jsonObject = null;
	private ObjectMapper mapper = new ObjectMapper();
	//private IvrIntractionHistory ivrIntrationHistoryObj = new IvrIntractionHistory();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	 
	public TestCase1() {
		super();
	}

	@Before
	protected void setUp() throws Exception{
		super.setUp();
		screen = new Screen();
		script1 = new Script1(screen);
		dataInExcel = new WriteTestDataInExcel(excelReport);
		list = new LinkedList<Map<String,Object[]>>();
		mapData = new LinkedHashMap<String, Object[]>();
	    client = new IVRLogHistoryHttpClient();
	    
	}
	
	@After
	protected void tearDown() throws Exception{
		super.tearDown();
		
		}
	
	@Test
	public void testScript() {
		
		
   
	try {
		
		TestCase1.tearDownAfterClass();
		script1.startByondApp(screen);
		boolean st1 =	script1.step1(new ScreenInput()); 
		boolean st2 =	script1.step2(new ScreenInput());
		boolean st3 =	script1.step3(new ScreenInput());
	    script1.closeApp();
		TestCase1.setUpBeforeClass();
		
			
		    while(IvrCallLogData==null){
		    	
		    	IvrCallLogData=client.getIvrResponse("9108484277","20160519");
		    }
		    
		    System.out.println(IvrCallLogData.getRequesttime());
			//1.Check Steps output   
			assertEquals(true, st1);

			if (st1 == true) {
				
				screenInput = script1.getCaptureScriptInput().get("step1");
				char[] dialArra = new char[12];
				String  dialNum =null;
				
			     //dialNo.ap
				int count_0 = screenInput.getDtmf_0().size();
				int count_1 = screenInput.getDtmf_1().size();
				int count_2 = screenInput.getDtmf_2().size();
				int count_8 = screenInput.getDtmf_8().size();
				
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
				dialNum =String.copyValueOf(dialArra);
				System.out.println("Dialled TollFreeNumber:-"+dialNum);
				/*ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(1);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);*/
			    ac1 = ExpectedOtput.STEP_1_EXP+","+IvrCallLogData.getRequesttime();//ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
				s1 = ExpectedOtput.PASS;
				
			} else {
				s1 = ExpectedOtput.FAIL;
				/*ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(1);
			  IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
				ac1 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();*/
				ac1 = "User Not Get Call From Kookoo";
			}

			assertEquals(true, st2);
			if (st2 == true) {
				screenInput = script1.getCaptureScriptInput().get("step2");
				//assertEquals("ANSWER", screenInput.DTMF_ANSWER);
				s2 = ExpectedOtput.PASS;
				ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(1);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);
			    ac2 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
			} else {
				s2 =  ExpectedOtput.FAIL;
				ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(1);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);
			    ac2 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
			}
			assertEquals(true, st3);
			if (st3 == true) {
				s3 = ExpectedOtput.PASS;
				ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(2);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);
			    ac3 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
			}else{
				s3 = ExpectedOtput.FAIL;
				ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(2);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);
			    ac3 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
			}
			if (st3 == true) {
				s3 = ExpectedOtput.PASS;
				ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(3);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);
			    ac4 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
			}else{
				s3 = ExpectedOtput.FAIL;
				ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(3);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);
			    ac4 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
			}
			if (st3 == true) {
				s3 = ExpectedOtput.PASS;
				ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(4);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);
			    ac5 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
			}else{
				s3 = ExpectedOtput.FAIL;
				ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(4);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);
			    ac5 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
			}
			if (st3 == true) {
				s3 = ExpectedOtput.PASS;
				ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(5);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);
			    ac6 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
			}else{
				s3 = ExpectedOtput.FAIL;
				ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(5);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);
			    ac6 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
			}
			if (st3 == true) {
				s3 = ExpectedOtput.PASS;
				ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(6);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);
			    ac7 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
			}else{
				s3 = ExpectedOtput.FAIL;
				ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(6);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);
			    ac7 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
			}
			if (st3 == true) {
				s3 = ExpectedOtput.PASS;
				ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(7);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);
			    ac8 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
			}else{
				s3 = ExpectedOtput.FAIL;
				ivrHistoryMap = IvrCallLogData.getIvrinteractionhistory();
			    String ivrIntractionHistory = ivrHistoryMap.get(7);
			    IvrIntractionHistory  ivrIntrationHistoryObj = mapper.readValue(ivrIntractionHistory, IvrIntractionHistory.class);
			    System.out.println(ivrIntrationHistoryObj);
			    ac8 = ivrIntrationHistoryObj.getDtmfinput()+","+ivrIntrationHistoryObj.getCurrentState()+","+ivrIntrationHistoryObj.getEvent();
			}
			//2. Doing comparison of I/P V/S O/P
			
			
		
			assertEquals("919108484277",IvrCallLogData.getMobilenumber() );
			assertNotNull(screenInput);
			assertNotNull(IvrCallLogData);
			assertEquals("Karnataka", IvrCallLogData.getCircle());
			
			
	} catch (AssertionFailedError e) {
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
	if(st2==true){
		ac4 = ExpectedOtput.STEP_4_Actual;
		s4= "Pass";
	}else{
		s4 = "Fail";
		ac4="differ";
		fail(e.getMessage());
	}
	}catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("----------------inside catch block2-------------------");
		e.printStackTrace();
	}
		
	
		//3. Making Report on Basis of Comaparision
	
		//screenInput = script1.testInput();
	   
		
	
mapData.put("0", new Object[] { ExpectedOtput.TESTCASESTEP,ExpectedOtput.INPUTDATA, ExpectedOtput.EXPECTEDOUTPUTDATA,ExpectedOtput.ACTUALOUTPUT, ExpectedOtput.STATUS });
mapData.put("1", new Object[] { ExpectedOtput.STEP_1,ExpectedOtput.STEP_1_INPUT, ExpectedOtput.STEP_1_EXP, ac1, s1 });
mapData.put("2", new Object[] { ExpectedOtput.STEP_2, ExpectedOtput.STEP_PRESS_ANSWER ,ExpectedOtput.STEP_2_EXP, ac2, s2 });
mapData.put("3",new Object[] { ExpectedOtput.STEP_3,  ExpectedOtput.DTMF_INPUT_1,ExpectedOtput.STEP_3_EXP, ac3, s3 });
mapData.put("4", new Object[] { ExpectedOtput.STEP_7, ExpectedOtput.DTMF_INPUT_1,ExpectedOtput.STEP_7_EXP, ac4 , s3});
mapData.put("6", new Object[] { ExpectedOtput.STEP_8, ExpectedOtput.DTMF_INPUT_2,ExpectedOtput.STEP_8_EXP,ac5, s3});
mapData.put("7", new Object[] { ExpectedOtput.STEP_9, ExpectedOtput.DTMF_INPUT_1,ExpectedOtput.STEP_10_EXP,ac6, s3});
mapData.put("8", new Object[] { ExpectedOtput.STEP_10, ExpectedOtput.DTMF_PINCODE,ExpectedOtput.STEP_11_EXP,ac7, s3});
mapData.put("9", new Object[] { ExpectedOtput.STEP_11, ExpectedOtput.DTMF_INPUT_1 ,ExpectedOtput.STEP_11_EXP,ac8, s3});

	    list.add(mapData);
	    dataInExcel.setDataInRowAndColumn(list);
	    
	}
	

} 
