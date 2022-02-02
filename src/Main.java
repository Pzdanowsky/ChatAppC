import Connection.ServerSocketConnection;
import Controllers.MainController;
import Objects.FileObject;
import Objects.MessageObject;
import Objects.User;
import Repositories.DataSendRepository;
import Objects.ObjectData;
import Services.FileCreatorService;
import Services.PreparationObjectsService;
import Services.ReciveService;
import Services.SendService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
            launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/mainFXML.fxml"));
        StackPane paneStack = loader.load();



        Scene scena = new Scene(paneStack,800,500);

        stage.setScene(scena);
        stage.setTitle("ChatApp - Czatuj z byczkiem");
        stage.show();
        stage.setOnCloseRequest(event -> {

            if(User.getInstance().checkEqualsSesion("00000")){
                System.out.println("Stage is closing");
            }else{
                System.out.println("Stage is closing and send data to serwer");
                ObjectData objectData = PreparationObjectsService.preparationCloseProgram();
                System.out.println(objectData.getCommand());
                DataSendRepository.getInstance().addDataSend(PreparationObjectsService.preparationCloseProgram());
            }

        });



        MainController.getInstance().setStage(stage);
        //MainController.getInstance().setStackPane(paneStack);
        //Stage.initStyle(StageStyle.UNDECORATED);
    }
}
