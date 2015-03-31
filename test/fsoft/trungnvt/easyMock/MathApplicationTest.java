package fsoft.trungnvt.easyMock;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import fsoft.trungnvt.easyMock.service.CalculatorService;

@RunWith(EasyMockRunner.class)
public class MathApplicationTest{

	// @TestSubject annotation is used to identify the class which is going to use the mock object
//	@TestSubject 
//	MathApplication mathApplication = new MathApplication();
	
	//@Mock annotation is used to create the mock object to be injected
//	@Mock
//	CalculatorService calculatorService;
	
	private MathApplication mathApplication;
	private CalculatorService calculatorService;
	
	@Before
	public void setUp(){
		mathApplication = new MathApplication();
		calculatorService = EasyMock.createMock(CalculatorService.class);
		mathApplication.setCalculatorService(calculatorService);
	}
	
//	@Test(expected = RuntimeException.class)
	@Test
	public void testAdd() {
		
		// add the behavior of calc service to add two numbers
 		EasyMock.expect(calculatorService.add(10.0, 20.0)).andReturn(30.0);
//		EasyMock.expect(calculatorService.add(10.0, 20.0)).andThrow(new RuntimeException("Add implementation RunTime Exception"));
		calculatorService.serviceUsed();
//		EasyMock.expectLastCall().times(1,3);
//		EasyMock.expectLastCall().atLeastOnce();
		EasyMock.expectLastCall().anyTimes();
		
		//activate the mock. With this line, mock work as expect. 
		EasyMock.replay(calculatorService);
		
		Assert.assertEquals(30.0, mathApplication.add(10.0, 20.0),0);
		
		EasyMock.verify(calculatorService);
	}

}
 