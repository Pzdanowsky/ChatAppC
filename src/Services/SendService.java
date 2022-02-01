package Services;

import Objects.ObjectData;
import Repositories.*;
import Connection.*;

import java.io.ObjectOutputStream;

public class SendService implements Observer
{

    private static ObjectOutputStream objectOut;

    private static ObjectData objectDataSend;


    public void send() {

            objectDataSend = DataSendRepository.getInstance().iterList();
            if(objectDataSend == null){

            }else {

                try {
                    objectOut = ServerSocketConnection.getObjectOut();
                    if (objectOut == null) {
                        System.out.println("Brak połaczenia z serwerem");
                    } else {
                        objectOut.writeObject(objectDataSend);
                        objectOut.reset();
                        objectDataSend = null;

                    }
                    } catch(Exception ex){
                        System.out.println("Request to server ERROR in Services.SendService:send()");
                    }

            }

    }

    @Override
    public void updateNotify() {
        send();
    }
}
