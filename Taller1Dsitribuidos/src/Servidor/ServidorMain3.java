package Servidor;

import java.io.IOException;

public class ServidorMain3 {

	public static void main(String[] args) throws IOException {
		Servidor3 serv = new Servidor3(); //Se crea el servidor

        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor
	}
}
