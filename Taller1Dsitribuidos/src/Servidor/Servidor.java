package Servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import Conexion.Conexion;

public class Servidor extends Conexion //Se hereda de conexión para hacer uso de los sockets y demás
{
	private Socket servidor1, servidor2; // Sockets para los dos servidores adicionales
	
	
    public Servidor() throws IOException{
    	super("servidor","192.168.56.1");
    	servidor1 = new Socket("192.168.1.100", 1234); // Dirección y puerto del servidor 1
    	servidor2 = new Socket("192.168.1.101", 1234); // Dirección y puerto del servidor 2 //Se usa el constructor para servidor de Conexion
    }
   

    public void startServer()//Método para iniciar el servidor
    {
        try
        {
            System.out.println("Esperando..."); //Esperando conexión

            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente

            System.out.println("Cliente en línea");

            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new DataOutputStream(cs.getOutputStream());

            //Se le envía un mensaje al cliente usando su flujo de salida
            salidaCliente.writeUTF("Petición recibida y aceptada");

            //Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));

            while((mensajeServidor = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
            {
                //Se muestra por pantalla el mensaje recibido
                System.out.println(mensajeServidor);
                //Mandar petición a los servidores bebé
                if (mensajeServidor.equals("accion1")) {
                    enviarMensaje(servidor1, "Mensaje para servidor 1");
                } else if (mensajeServidor.equals("accion2")) {
                    enviarMensaje(servidor2, "Mensaje para servidor 2");
                } else {
                    System.out.println("Mensaje no reconocido");
                }
            }

            System.out.println("Fin de la conexión");

            ss.close();//Se finaliza la conexión con el cliente
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private void enviarMensaje(Socket servidor, String mensaje) throws IOException {
        DataOutputStream salidaServidor = new DataOutputStream(servidor.getOutputStream());
        salidaServidor.writeUTF(mensaje);
    }
}
