package fsoft.trungnvt.easyMock;

import fsoft.trungnvt.easyMock.service.CalculatorService;

public class MathApplication {

	private CalculatorService calService;

	public void setCalculatorService(CalculatorService calculatorService) {
		this.calService = calculatorService;
	}

	public double add(double input1, double input2) {
		calService.serviceUsed();
		calService.serviceUsed();
//		calService.serviceUsed();
		return calService.add(input1, input2);
	}

	public double subtract(double input1, double input2) {
		return calService.subtract(input1, input2);
	}

	public double multiply(double input1, double input2) {
		return calService.multiply(input1, input2);
	}

	public double divide(double input1, double input2) {
		return calService.divide(input1, input2);
	}
}
