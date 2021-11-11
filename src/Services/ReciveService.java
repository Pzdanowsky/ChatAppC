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
    public synchronized void run() {
        System.out.println("Thread recive run");

        while(true) {

            try {
                objectDataRecive = (ObjectData) objectIn.readObject();
                if(objectDataRecive != null) {
                    if(objectDataRecive.getCommand().equals("message")) {
                        System.out.println("Odebrano: " + objectDataRecive.getMessageObject().getData());
                    }
                    if(objectDataRecive.getCommand().equals("file")){
                       File fl = FileCreatorService.preparationFile(objectDataRecive.getFileObject());
                        //Desktop.getDesktop().open(fl);
                    }

                    if(User.getInstance().checkEqualsToken("00000")){
                        User.getInstance().setSessionToken(objectDataRecive.getSesionToken());
                        User.getInstance().setSessionNumber(objectDataRecive.getSessionNumber());
                    }

                       DataReciveRepository.getInstance().addDataRecive(objectDataRecive);

                }

            }catch(IOException e){
                e.printStackTrace();
                System.out.println("Send to server ERROR in Services.ReciveService:run()");
                break;
            }catch(ClassNotFoundException ex){
                System.err.println(ex);
            }

        }
    }

}
