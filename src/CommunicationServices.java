import java.net.*;
import java.io.*;


public class CommunicationServices {

    private static ObjectOutputStream objectOut;
    private static ObjectInputStream objectIn;
    private static ObjectData objectDataResponse;

    private static ObjectData objectDataRecive;
    private static ObjectData objectDataSend;


    public static void send(){

        objectDataSend = DataSendRepository.getInstance().getObjectData("zdanek");

        try{

        objectOut = ServerSocketConnection.getObjectOut();
        objectOut.writeObject(objectDataSend);
        objectOut.reset();
        objectDataSend = null;
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Send to server ERROR in CommunicationServices:send()");
        }

    }

    public static void recive(){
        try{

            objectIn = ServerSocketConnection.getObjectIn();
            objectDataRecive = (ObjectData) objectIn.readObject();
            DataReciveRepository.getInstance().addDataRecive(objectDataRecive);

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Send to server ERROR in CommunicationServices:send()");
        }

    }





}
