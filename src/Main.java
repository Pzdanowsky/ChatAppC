import Connection.ServerSocketConnection;
import Objects.FileObject;
import Objects.MessageObject;
import Objects.User;
import Repositories.DataSendRepository;
import Objects.ObjectData;
import Services.FileCreatorService;
import Services.ReciveService;
import Services.SendService;
import javafx.application.Application;
import javafx.stage.Stage;

//import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Main extends Application {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Client started");
        ObjectData obj = new ObjectData();
        User.getInstance();
        obj.setSessionNumber(User.getInstance().getSessionNumber());
        obj.setSesionToken(User.getInstance().getSessionToken());


       //  ServerSocketConnection.getInstance();
        SendService sendServiceThread = new SendService();
        DataSendRepository.getInstance().setObserverSender(sendServiceThread);
        ReciveService reciverThread = new ReciveService();
        //reciverThread.start();
        Thread threadr = new Thread(reciverThread);
        threadr.start();

       // System.out.println(obj.getUsername());


        File send = new File("src/fileRepository/send/zdj.jpg");
        if(send.exists()){
            System.out.println("Mam plik");
            FileObject fileObject = FileCreatorService.preparationFileObject(send);
            //FileCreatorService.preparationFile(fileObject);
            //Desktop.getDesktop().open(FileCreatorService.preparationFile(fileObject));
            obj.setFileObject(fileObject);
        }else{
            System.out.println("Nie mam pliku");
        }


        obj.setUsername("zdanek");
        obj.setMessageObject(new MessageObject("zdanek", "zdanek", "wiadomość"));
        obj.setSessionNumber(User.getInstance().getSessionNumber());
        obj.setCommand("file");
        obj.setSesionToken(User.getInstance().getSessionToken());


       // DataSendRepository.getInstance().addDataSend(obj);

            launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
    }
}
