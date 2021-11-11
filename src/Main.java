import Connection.ServerSocketConnection;
import Objects.User;
import Repositories.DataSendRepository;
import Objects.ObjectData;
import Services.ReciveService;
import Services.SendService;

import java.io.File;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Client started");

        ObjectData obj = new ObjectData();
        User.getInstance();
        obj.setSessionNumber(User.getInstance().getSessionNumber());
        obj.setSesionToken(User.getInstance().getSessionToken());

        Scanner scan = new Scanner(System.in);
        ServerSocketConnection.getInstance();
        SendService sendServiceThread = new SendService();
        DataSendRepository.getInstance().setObserverSender(sendServiceThread);
        ReciveService reciverThread = new ReciveService();
        //reciverThread.start();
        Thread threadr = new Thread(reciverThread);
        threadr.start();
        
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
        obj.setTo("bolek");
        obj.setSesionToken(User.getInstance().getSessionToken());
            temp = scan.nextLine();
         /*   if(temp == "change") {
                temp = scan.nextLine();
                obj.setTo(temp);
            }
*/
            obj.setData(temp);
            DataSendRepository.getInstance().addDataSend(obj);
            //Services.CommunicationServices.send("serwer");
            //Services.CommunicationServices.recive();
           //System.out.println(Repositories.DataReciveRepository.getInstance().getObjectData("serwer").getData());
        }




    }
}
