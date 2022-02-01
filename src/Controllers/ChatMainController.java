package Controllers;

import Managers.*;
import Objects.MessageObject;
import Objects.User;
import Repositories.DataSendRepository;
import Services.PreparationObjectsService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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
        SearchBoxManager.getInstance().setVb_search(vb_search);
        ContactBoxManager.getInstance().setVb_contants(vb_contacts);
        ContactBoxManager.getInstance().getRequestContanct();
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
        MessageObject msgSend = new MessageObject(User.getInstance().getUserID(),pm.getMessageTxt(),ChatBoxManager.getInstance().getActiveChat().getChatID());
         msgSend.setIdChatRoom(ChatBoxManager.getInstance().getActiveChat().getChatID());
    DataSendRepository.getInstance().addDataSend(PreparationObjectsService.preparationSendMessageObject(msgSend));
       // ChatBoxManager.getInstance().addMsg(msgSend);
    messageField.clear();


    }







}
