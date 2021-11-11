package Connection;

import java.io.*;
import java.net.Socket;


public class ServerSocketConnection {

/**
 * Klasa Connection.ServerSocketConnection nazwiązuje połączenie z serverem po stronie klienta
 */

    private static ServerSocketConnection instance;
    private static Socket client;
    private static ObjectOutputStream objectOut;
    private static ObjectInputStream objectIn;
    //private Socket client;

    public static ServerSocketConnection getInstance(){
        if(instance == null){
            instance = new ServerSocketConnection();
        }
            return instance;

    }

    private ServerSocketConnection(){
        try {
            client = new Socket("localhost", 1909); //192.168.8.108
            objectOut = new ObjectOutputStream(client.getOutputStream());
            objectIn = new ObjectInputStream(client.getInputStream());

        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("Porblem połaczenia z serwerem podcza tworzenia socketu");
        }
    }

    public Socket getClient(){
        return client;
    }

    public static ObjectOutputStream getObjectOut() {
        return objectOut;
    }

    public static ObjectInputStream getObjectIn() {
        return objectIn;
    }
}