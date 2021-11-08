import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Client started");

        ObjectData obj = new ObjectData();
        //obj.setDataType("zdanek");

        Scanner scan = new Scanner(System.in);
        ServerSocketConnection.getInstance();

        System.out.println("Jak się nazywasz");
        String username = scan.nextLine();
        //User userhome =  new User();
        obj.setUsername(username);
        obj.setDataType("serwer");
        obj.setData("Bolo");
        DataSendRepository.getInstance().addDataSend(obj);
        CommunicationServices.send("serwer");



        System.out.println("Do kogo piszesz?:");
        String tag = scan.nextLine();
        obj.setDataType("Zdanek");


        String temp;

        while(true){

            temp = scan.nextLine();
            obj.setData(temp);
            DataSendRepository.getInstance().addDataSend(obj);
            CommunicationServices.send(tag);
            CommunicationServices.recive();
            System.out.println(DataReciveRepository.getInstance().getObjectData("serwer").getData());
        }




    }
}
