package Services;

import Repositories.DataReciveRepository;
import Repositories.DataSendRepository;
import Objects.ObjectData;

import java.io.*;
import Connection.*;

public class CommunicationServices {

    private static ObjectOutputStream objectOut;
    private static ObjectInputStream objectIn;
    private static ObjectData objectDataResponse;

    private static ObjectData objectDataRecive;
    private static ObjectData objectDataSend;


    public static void send(){

        objectDataSend = DataSendRepository.getInstance().getObjectData("zdanek");
        System.out.println(objectDataSend.getData());
        try{

        objectOut = ServerSocketConnection.getObjectOut();
        objectOut.writeObject(objectDataSend);

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Send to server ERROR in Services.CommunicationServices:send()");
        }

    }

    public static void recive(){
        try{

            objectIn = ServerSocketConnection.getObjectIn();
            objectDataRecive = (ObjectData) objectIn.readObject();
            DataReciveRepository.getInstance().addDataRecive(objectDataRecive);

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Send to server ERROR in Services.CommunicationServices:send()");
        }

    }





}