package mathoperations;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket server = new ServerSocket(15000);
		Calculator calc = new Calculator();
		while(true) {
			System.out.println("Aguardando cliente...");
			Socket cliente = server.accept();
	        ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
	        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            
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
            cliente.close();
		}
	}
}
