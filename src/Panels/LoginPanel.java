package Panels;

import Controllers.MainController;
import Services.LoadPanel;
import com.sun.tools.javac.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class LoginPanel implements LoadPanel {


    private StackPane stackPane = MainController.getInstance().getStackPane();

    @Override
    public void load() {
        FXMLLoader loader = null;
        Pane pane = null;
        try{
            loader = new FXMLLoader(this.getClass().getResource("/fxml/loginFXML.fxml"));
            pane = loader.load();

        }catch(IOException ex){
            System.out.println("Blad Login");
            ex.printStackTrace();
            ex.getCause();
        }
        setScene(pane);
    }

    @Override
    public void setScene(Pane pane) {
        stackPane.getChildren().clear();
        stackPane.getChildren().add(pane);
        System.out.println("login gra");

    }
}
