import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Client started");

        ObjectData obj = new ObjectData();
        User.getInstance();
        obj.setSessionNumber(User.getInstance().getSessionNumber());
        obj.setSesionToken(User.getInstance().getSessionToken());

        Scanner scan = new Scanner(System.in);
        ServerSocketConnection.getInstance();
        Sender senderThread = new Sender();
        DataSendRepository.getInstance().setObserverSender(senderThread);
        ReciveService reciverThread = new ReciveService();
        reciverThread.start();


        String temp;
        obj.setCommand("message");
        System.out.println("Twoja nazwa");
        temp = scan.nextLine();
        User.getInstance().setUsername(temp);
        obj.setUsername(temp);
        obj.setFrom(temp);
        obj.setTo("zdanek");
        DataSendRepository.getInstance().addDataSend(obj);
        System.out.println(obj.getUsername());

        while(true){

        obj.setCommand("message");
        obj.setDataType("serwer");
        obj.setSessionNumber(User.getInstance().getSessionNumber());
        obj.setTo("zdanek");
        obj.setSesionToken(User.getInstance().getSessionToken());
            temp = scan.nextLine();
         /*   if(temp == "change") {
                temp = scan.nextLine();
                obj.setTo(temp);
            }
*/
            obj.setData(temp);
            DataSendRepository.getInstance().addDataSend(obj);
            //CommunicationServices.send("serwer");
            //CommunicationServices.recive();
           //System.out.println(DataReciveRepository.getInstance().getObjectData("serwer").getData());
        }




    }
}
