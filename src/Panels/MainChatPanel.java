package Panels;

import Controllers.MainController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainChatPanel implements LoadPanel {

    private StackPane stackPane = MainController.getInstance().getStackPane();

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
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Scene scena = new Scene(pane,1100,700);
                MainController.getInstance().getStage().setScene(scena);
                stackPane.getChildren().clear();
                stackPane.getChildren().add(pane);
            }
        });



    }
}
