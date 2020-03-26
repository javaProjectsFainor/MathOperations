package mathoperations;

import java.io.Serializable;

public class Operator implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double fistValue;
	private double secondValue;
	private char operation;
	private double result;

	public double getSecondValue() {
		return secondValue;
	}
	public void setSecondValue(double secondValue) {
		this.secondValue = secondValue;
	}
	public char getOperation() {
		return operation;
	}
	public void setOperation(char operation) {
		this.operation = operation;
	}
	public double getFistValue() {
		return fistValue;
	}
	public void setFistValue(double fistValue) {
		this.fistValue = fistValue;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	
	
}
