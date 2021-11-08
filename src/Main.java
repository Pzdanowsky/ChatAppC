import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Client started");

        ObjectData obj = new ObjectData();
        obj.setDataType("zdanek");
        Scanner scan = new Scanner(System.in);
        ServerSocketConnection.getInstance();
        String temp;
        while(true){

            temp = scan.nextLine();
            obj.setData(temp);
            DataSendRepository.getInstance().addDataSend(obj);
            CommunicationServices.send();
            CommunicationServices.recive();
            System.out.println(DataReciveRepository.getInstance().getObjectData("serwer").getData());
        }




    }
}
