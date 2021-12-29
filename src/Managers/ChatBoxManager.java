package Managers;

import Objects.Chat;
import Objects.MessageObject;
import Objects.User;
import Repositories.ChatRepository;
import Repositories.MessageRepository;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.HashMap;

public class ChatBoxManager {

    private static ChatBoxManager instance;
    private VBox vb_message;
    private Chat activeChat;
    private int lastId;


    public static ChatBoxManager getInstance(){
        if(instance == null){
            instance = new ChatBoxManager();
        }

        return instance;
    }

    private ChatBoxManager(){

    }

    public Chat getActiveChat() {
        return activeChat;
    }

    private void setActiveChat(Chat activeChat) {
        this.activeChat = activeChat;
    }

    public void changeActiveChatRoom(Chat chatRoom){
        setActiveChat(chatRoom);
        vb_message.getChildren().clear();
        loadNewChatRoom();
    }

    private void loadNewChatRoom() {
        HashMap<Integer,MessageObject> messageChatList = activeChat.getMessageChatList();
        System.out.println(activeChat.getMessageChatList().size());
        messageChatList.forEach((key,msg)-> addMsg(msg));

    }

    public void updateChatRoom(Chat chatRoom){
        if(activeChat != null) {
            if (activeChat.getChatID() == chatRoom.getChatID()) {
                loadNewChatRoom();
            }
        }
    }


    public VBox getVb_messages() {
        return vb_message;
    }

    public void setVb_messages(VBox vb_message) {
        this.vb_message = vb_message;
    }


    public void addMsg(MessageObject message){
        lastId = message.getId();
        HBox hb = new HBox();
      //  if(message.getFromMessage().equals(User.getInstance().getUsername())){
            hb.setAlignment(Pos.CENTER_RIGHT);
      //  }else
     //   {
        //    hb.setAlignment(Pos.CENTER_LEFT);
     //   }

        hb.setPadding(new Insets(5,5,5,10));
        hb.setUserData(User.getInstance());
        Image imProfil = new Image(getClass().getResourceAsStream("/fileRepository/image/default_avatar_0.png"));
        ImageView iw = new ImageView(imProfil);
        iw.setFitWidth(50);
        iw.setFitHeight(50);


        Text text = new Text(message.getData());
        TextFlow textFlow = new TextFlow(text);
        textFlow.setPadding(new Insets(5,10,5,10));
        textFlow.setStyle("-fx-background-color: rgb(15,135,245)");

        hb.getChildren().add(iw);
        hb.getChildren().add(textFlow);
        vb_message.getChildren().add(hb);



    }
}
