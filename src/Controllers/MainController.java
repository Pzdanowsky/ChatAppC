package Controllers;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainController {

    private static MainController instance = null;

    private Controller mainControl;

    private StackPane stackPane;

    private Scene scene;

    private Stage primaryStage;

    public static MainController getInstance(){
        if(instance == null){
            instance = new MainController();
        }
        return instance;
    }


    private MainController(){
        this.mainControl = new Controller();
      this.stackPane = new StackPane();
       this.primaryStage = new Stage();
    }

    public MainController setMainControl(Controller mainControl){
        this.mainControl = mainControl;
        return this;
    }

    public void setStackPane(StackPane stackPane){
        this.stackPane = stackPane;
    }

    public Controller getMainControl(){

        return this.mainControl;
    }

    public StackPane getStackPane(){
        return this.stackPane;
    }


    public void setStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public Stage getStage(){
        return this.primaryStage;
    }
}
