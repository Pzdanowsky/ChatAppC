package Services;

import Repositories.DataReciveRepository;
import Objects.ObjectData;

//import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import Connection.*;
import Objects.*;

public class ReciveService extends Thread{

    private static ObjectInputStream objectIn;

    private static ObjectData objectDataRecive;


    public ReciveService(){
        try {
            objectIn = ServerSocketConnection.getObjectIn();
        }catch(Exception e){
            System.err.println(e);
        }
        System.out.println("Thread recive done!");

    }



    @Override
    public void run() {
        System.out.println("Thread recive run");
        while(true) {

            try {
                objectDataRecive = (ObjectData) objectIn.readObject();
                if(objectDataRecive != null) {
                    DataReciveRepository.getInstance().addDataRecive(objectDataRecive);
                }

            }catch(IOException e){
                e.printStackTrace();
                System.out.println("Response from server ERROR in Services.ReciveService:run()");
                break;
            }catch(ClassNotFoundException ex){
                System.err.println(ex);
            }

        }
    }
}
