package mathoperations;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Worker extends Thread {
	private Socket s;
	private Calculator calc;
	
	public Worker(Socket s, Calculator calc) {
		this.s = s;
		this.calc = calc;
	}
	
	@Override
	public void run() {
		try {
	        ObjectInputStream entrada = new ObjectInputStream(s.getInputStream());
	        ObjectOutputStream saida = new ObjectOutputStream(s.getOutputStream());
	        
	        Operator clientOperation = (Operator) entrada.readObject();
	        switch(clientOperation.getOperation()) {
	        case '+':
	        	clientOperation.setResult(calc.add(clientOperation.getFistValue(), clientOperation.getSecondValue()));
	        	break;
	        case '-':
	        	clientOperation.setResult(calc.sub(clientOperation.getFistValue(), clientOperation.getSecondValue()));
	        	break;
	        case '*':
	        	clientOperation.setResult(calc.mult(clientOperation.getFistValue(), clientOperation.getSecondValue()));
	        	break;
	        case '/':
	        	clientOperation.setResult(calc.div(clientOperation.getFistValue(), clientOperation.getSecondValue()));
	        	break;
	        }
	        
	        saida.writeObject(clientOperation);

	        entrada.close();
	        saida.close();
	        s.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
