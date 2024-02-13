package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import Conexion.Conexion;

public class Servidor3 extends Conexion {
	
	public Servidor3() throws IOException{
    	super("servidor2","10.43.101.86");
    }

	public void startServer() {
        try {
        	// ss = new ServerSocket(PUERTO2);// Se crea el socket para el servidor en puerto 1234
            // cs = new Socket(); // Socket para el cliente
            System.out.println("Servidor secundario 2 esperando conexiones...");

            cs = ss.accept();
            System.out.println("Cliente conectado desde: " + cs.getInetAddress().getHostAddress());

            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            String mensaje = entrada.readLine();
            System.out.println("Mensaje recibido del servidor principal: " + mensaje);

            // Aqu� puedes realizar cualquier acci�n que necesites con el mensaje recibido
            
            ss.close(); // Cierra el servidor cuando ya no se necesite
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
