package Controllers;

import Managers.ChatMainPropertyManager;
import Managers.ThreadsMenager;
import Managers.VboxManager;
import Objects.User;
import Repositories.DataSendRepository;
import Services.PreparationObjectsService;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ChatMainController {

    @FXML
    TextField textMessage;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vb_message;

    @FXML
    private VBox vb_contacts;

    @FXML
    private  VBox vb_search;

    @FXML
    private TextField tf_search;

    @FXML
    private TextField messageField;

    @FXML
    private Button messageBTN;

    @FXML
    private Button searchBTN;

    private ChatMainPropertyManager pm = new ChatMainPropertyManager();

    @FXML
    public void initialize(){
        messageField.textProperty().bindBidirectional(pm.messageTxtProperty());
        tf_search.textProperty().bindBidirectional(pm.searchTextProperty());
       // System.out.println("Thread chatu"+Thread.currentThread());
        VboxManager.getInstance().setVb_search(vb_search);
    }

    @FXML
    public void onSearchUser(){
        System.out.println(pm.getSearchText());
        DataSendRepository.getInstance().addDataSend(PreparationObjectsService.preparationSearchUserObject(pm.getSearchText()));

    }



    @FXML
    public void sendMessage(){
      System.out.println(pm.getMessageTxt());
      addMsg(pm.getMessageTxt());
      messageField.clear();


    }





    public void addMsg(String message){
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER_RIGHT);
        hb.setPadding(new Insets(5,5,5,10));
        hb.setUserData(User.getInstance());
        Image imProfil = new Image(getClass().getResourceAsStream("/fileRepository/image/default_avatar_0.png"));
        ImageView iw = new ImageView(imProfil);
        iw.setFitWidth(50);
        iw.setFitHeight(50);


        Text text = new Text(message);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setPadding(new Insets(5,10,5,10));
        textFlow.setStyle("-fx-background-color: rgb(15,135,245)");

            hb.getChildren().add(iw);
            hb.getChildren().add(textFlow);
            vb_message.getChildren().add(hb);



    }

}
