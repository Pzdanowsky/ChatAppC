package Controllers;

import Panels.LoginPanel;
import Services.LoadPanel;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Controller {

    @FXML
    private StackPane stackPane;

    @FXML
    public void initialize(){

        MainController.getInstance().setMainControl(this);
        MainController.getInstance().setStackPane(stackPane);
        loadLoginPanel();
    }


    public void loadLoginPanel(){
       // LoadPanel loadPanel;
       new LoginPanel().load();
    }


    public void setSceen(Pane pane){
        stackPane.getChildren().clear();
        stackPane.getChildren().add(pane);
    }

}
