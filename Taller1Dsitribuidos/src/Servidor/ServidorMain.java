package Servidor;

import java.io.IOException;

public class ServidorMain {

	public static void main(String[] args) throws IOException {
		Servidor serv = new Servidor(); //Se crea el servidor

        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor
	}
}
