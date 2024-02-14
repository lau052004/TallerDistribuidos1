package Conexion;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
    private final int PUERTO = 8080; // Puerto para la conexi�n
    private final int PUERTO2 = 8081;
    private final int PUERTO3 = 8082; 
    private String host; // Host para la conexi�n
    protected String mensajeServidor; // Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket ss; // Socket del servidor
    protected Socket cs, ServerServer2, ServerServer3; // Socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente; // Flujo de datos de salida

    public Conexion(String tipo, String host) throws IOException // Constructor
    {
        this.host = host;
        if (tipo.equalsIgnoreCase("servidor2")){
            ss = new ServerSocket(PUERTO2);
            cs = new Socket(); // Socket para el cliente 
        }
        else if (tipo.equalsIgnoreCase("servidor3")){
            ss = new ServerSocket(PUERTO3);
            cs = new Socket(); // Socket para el cliente 
        }
        else if (tipo.equalsIgnoreCase("servidor-master")){
        	ss = new ServerSocket(PUERTO);// Se crea el socket para el servidor en puerto 1234
            cs = new Socket(); // Socket para el cliente 
            ServerServer2 = new Socket(host, PUERTO2);
            ServerServer3 = new Socket(host, PUERTO3);
        }
        else {
            cs = new Socket(host, PUERTO); // Socket para el cliente en el host y puerto especificados
        }
    }
}

