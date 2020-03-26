package mathoperations;

public class Calculator implements MathService {

	@Override
	public double add(double firstValue, double secondValue) {
		return firstValue + secondValue;
	}

	@Override
	public double sub(double firstValue, double secondValue) {
		// TODO Auto-generated method stub
		return firstValue - secondValue;
	}

	@Override
	public double div(double fisrtValue, double secondValue) {
		// TODO Auto-generated method stub
		return fisrtValue / secondValue;
	}

	@Override
	public double mult(double firstValue, double secondValue) {
		// TODO Auto-generated method stub
		return firstValue * secondValue;
	}
}
