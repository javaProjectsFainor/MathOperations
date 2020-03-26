package mathoperations;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket server = new ServerSocket(15000);
		Calculator calc = new Calculator();
		while(true) {
			System.out.println("Aguardando cliente...");
			Socket cliente = server.accept();
			Worker worker = new Worker(cliente, calc);
			worker.start();
		}
	}
}
