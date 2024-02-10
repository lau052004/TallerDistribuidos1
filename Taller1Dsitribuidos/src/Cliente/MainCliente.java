package Cliente;

import java.io.IOException;

public class MainCliente {

	public static void main(String[] args) throws IOException {
		Cliente cli;
		
		cli = new Cliente();
	
		System.out.println("Iniciando cliente\n");
        cli.startClient(); //Se inicia el cliente
        
	}

}
