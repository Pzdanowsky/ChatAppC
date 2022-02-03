package Managers;

import Objects.Chat;
import Objects.MessageHbox;
import Objects.MessageObject;
import Services.Factors.HboxFactory;
import Services.Factors.MessageBoxFactor;
import Services.HBOX;
import Services.Observer;
import javafx.application.Platform;
import javafx.scene.layout.VBox;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class ChatBoxManager implements Observer {

    private static ChatBoxManager instance;
    private VBox vb_message;
    private Chat activeChat;
    private Timestamp lastTime;


    public static ChatBoxManager getInstance(){
        if(instance == null){
            instance = new ChatBoxManager();
        }

        return instance;
    }

    private ChatBoxManager(){
    activeChat = new Chat();
    activeChat.setChatID(-1);
    lastTime = new Timestamp(1000);
    }

    public Chat getActiveChat() {
        return activeChat;
    }

    private void setActiveChat(Chat activeChat) {
        this.activeChat = activeChat;
    }

    public void changeActiveChatRoom(Chat chatRoom){
        setActiveChat(chatRoom);
        loadNewChatRoom();

    }

    private void loadNewChatRoom() {

        Platform.runLater(() -> {
            try {
                vb_message.getChildren().clear();
            }catch(NullPointerException ex){
                ex.printStackTrace();
            }
        });


        lastTime = new Timestamp(10);
        ArrayList<MessageObject> messageChatList= activeChat.getMessageChatList();
        messageChatList.sort(Comparator.comparing(MessageObject::getCreated));
        messageChatList.forEach((msg)->addMsg(msg));

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
        if(message.getIdChatRoom() == activeChat.getChatID()) {



            if(message.getCreated().after(lastTime)) {
                HboxFactory hboxFactory = new MessageBoxFactor();
                HBOX hb = hboxFactory.createHbox();
                hb.setMessageObject(message);
                hb.create();
              lastTime = message.getCreated();
            }


        }
    }

    @Override
    public void updateNotify() {
       updateChatRoom(activeChat);
    }
}
