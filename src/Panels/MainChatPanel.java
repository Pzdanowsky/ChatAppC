package Panels;

import Controllers.MainController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainChatPanel implements LoadPanel {

    private StackPane stackPane = MainController.getInstance().getStackPane();

    private Stage primaryStage = MainController.getInstance().getStage();

    @Override
    public void load() {

        FXMLLoader loader = null;
        Pane pane = null;
        try{
            loader = new FXMLLoader(this.getClass().getResource("/fxml/chatMain.fxml"));
            pane = loader.load();

        }catch(IOException ex){
            System.out.println("Blad chatMain");
            ex.printStackTrace();
            ex.getCause();
        }
        setScene(pane);

    }

    @Override
    public void setScene(Pane pane) {


        Scene scena = new Scene(pane,1100,700);
       // scena.getStylesheets().add(StyleUtils.BUTTON_CSS_FILE);
        primaryStage.setScene(scena);
        primaryStage.setTitle("Chat Aplikacja");
        primaryStage.centerOnScreen();
        primaryStage.show();
              //  stackPane.getChildren().clear();
              //  stackPane.getChildren().add(pane);



    }
}
