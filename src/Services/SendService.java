package Services;

import Objects.ObjectData;
import Repositories.*;
import Connection.*;

import java.io.ObjectOutputStream;

public class SendService {

    private static ObjectOutputStream objectOut;

    private static ObjectData objectDataSend;


    public void send() {

            objectDataSend = DataSendRepository.getInstance().iterList();
            if(objectDataSend == null){

            }else {

                try {
                    objectOut = ServerSocketConnection.getObjectOut();
                    objectOut.writeObject(objectDataSend);
                    objectOut.reset();
                    //System.out.println(objectDataSend.getData());
                    objectDataSend = null;
                    System.out.println("Wysłano");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Send to server ERROR in Services.CommunicationServices:send()");
                }
            }


    }


    public void notice(){
        send();
    }
}
