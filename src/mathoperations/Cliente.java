package mathoperations;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Operator op = new Operator();
        Scanner teclado = new Scanner(System.in);
        InetAddress end = InetAddress.getLocalHost();
        Socket s = new Socket(end, 15000);
        
        ObjectOutputStream saida = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream entrada = new ObjectInputStream(s.getInputStream());

        System.out.println("Digite o primeiro número");
        op.setFistValue(teclado.nextDouble());
        System.out.println("Digite o segundo número");
        op.setSecondValue(teclado.nextDouble());
        System.out.println("Digite a operacao");
        op.setOperation(teclado.next().charAt(0));
        
        saida.writeObject(op);
        
        Operator response = (Operator) entrada.readObject();
        System.out.println("Resultado: " + response.getResult());

        entrada.close();
        saida.close();
        teclado.close();
        s.close();
	}
}
