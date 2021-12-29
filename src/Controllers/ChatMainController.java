package Controllers;

import Managers.ChatBoxManager;
import Managers.ChatMainPropertyManager;
import Managers.ThreadsMenager;
import Managers.VboxManager;
import Objects.MessageObject;
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
        scrollPane.vvalueProperty().bind(vb_message.heightProperty());
        messageField.textProperty().bindBidirectional(pm.messageTxtProperty());
        tf_search.textProperty().bindBidirectional(pm.searchTextProperty());
       // System.out.println("Thread chatu"+Thread.currentThread());
        VboxManager.getInstance().setVb_search(vb_search);
        VboxManager.getInstance().setVb_contants(vb_contacts);
        ChatBoxManager.getInstance().setVb_messages(vb_message);
    }

    @FXML
    public void onSearchUser(){
        //System.out.println(pm.getSearchText());
        DataSendRepository.getInstance().addDataSend(PreparationObjectsService.preparationSearchUserObject(pm.getSearchText()));

    }



    @FXML
    public void sendMessage(){
     // System.out.println(pm.getMessageTxt());
        MessageObject msgSend = new MessageObject(User.getInstance().getUsername(),pm.getMessageTxt());
      ChatBoxManager.getInstance().getActiveChat().addMessage(msgSend);

      messageField.clear();


    }







}
