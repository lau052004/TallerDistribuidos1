package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor2 {
	 private final int PUERTO = 1234; // Puerto para la conexi�n

	    public void startServer() {
	        try {
	            ServerSocket ss = new ServerSocket(PUERTO);
	            System.out.println("Servidor secundario 1 esperando conexiones...");

	            Socket cliente = ss.accept();
	            System.out.println("Cliente conectado desde: " + cliente.getInetAddress().getHostAddress());

	            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
	            String mensaje = entrada.readLine();
	            System.out.println("Mensaje recibido del servidor principal: " + mensaje);

	            // Aqu� puedes realizar cualquier acci�n que necesites con el mensaje recibido
	            

	            ss.close(); // Cierra el servidor cuando ya no se necesite
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        Servidor2 servidorSecundario1 = new Servidor2();
	        servidorSecundario1.startServer();
	    }
}
