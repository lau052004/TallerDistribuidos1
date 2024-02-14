package Cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import Conexion.Conexion;

public class Cliente extends Conexion {

	public Cliente() throws IOException {
		super("cliente", "localhost");
	}
	
	public void startClient() //M�todo para iniciar el cliente
    {
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());
            BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        
            System.out.println("This is the req");
            System.out.println(entradaServidor.readLine());
            
            
            cs.close();//Fin de la conexi�n
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
	
	public void ingresarOperacion() {
		Scanner sc = new Scanner(System.in);
    	int op,num1,num2;
    	String opcion1 = "Suma",opcion2 = "Resta", info;
    	
	    	
		System.out.println("Ingrese el número de la operación que desea realizar: ");
        System.out.println("1. " + opcion1);
        System.out.println("2. " + opcion2);
        op = sc.nextInt();
        
        switch(op) {
        case 1:
        	// Le envía al servidor la peticion de una suma 
        	try {
        		System.out.println("Ingresa el primer número: ");
        		num1 = sc.nextInt();
        		System.out.println("Ingresa el segundo número: ");
        		num2 = sc.nextInt();
        		info = opcion1 + ";" + num1 + ";" + num2;
        		salidaServidor.writeUTF(info);
        	} catch (Exception e) {
        		System.out.println(e.getMessage());
        	}
        case 2:
        	try {
        		System.out.println("Ingresa el primer número: ");
        		num1 = sc.nextInt();
        		System.out.println("Ingresa el segundo número: ");
        		num2 = sc.nextInt();
        		info = opcion2 + ";" + num1 + ";" + num2;
        		salidaServidor.writeUTF(info);        	
        	} catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
        }
	}
}
