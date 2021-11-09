import java.io.ObjectOutputStream;

public class Sender{

    private static ObjectOutputStream objectOut;

    private static ObjectData objectDataSend;


    public void send() {

            objectDataSend = DataSendRepository.getInstance().iterList();
            if(objectDataSend == null){

            }else {
               // System.out.println(DataSendRepository.getSendList().size());
                try {

                    objectOut = ServerSocketConnection.getObjectOut();
                    objectOut.writeObject(objectDataSend);
                    objectOut.reset();
                    //System.out.println(objectDataSend.getData());
                    objectDataSend = null;
                    System.out.println("Wysłano");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Send to server ERROR in CommunicationServices:send()");
                }
            }


    }


    public void notif(){
        send();
    }
}
