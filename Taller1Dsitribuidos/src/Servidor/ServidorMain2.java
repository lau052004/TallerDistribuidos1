package Servidor;

import java.io.IOException;

public class ServidorMain2 {

	public static void main(String[] args) throws IOException {
		Servidor2 serv = new Servidor2(); //Se crea el servidor

        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor
	}
}
