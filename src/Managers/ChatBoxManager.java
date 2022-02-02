package Managers;

import Objects.Chat;
import Objects.MessageHbox;
import Objects.MessageObject;
import Services.Factors.HboxFactory;
import Services.Factors.MessageBoxFactor;
import Services.HBOX;
import Services.Observer;
import javafx.scene.layout.VBox;

import java.util.HashMap;

public class ChatBoxManager implements Observer {

    private static ChatBoxManager instance;
    private VBox vb_message;
    private Chat activeChat;
    private int lastId =0;


    public static ChatBoxManager getInstance(){
        if(instance == null){
            instance = new ChatBoxManager();
        }

        return instance;
    }

    private ChatBoxManager(){
    activeChat = new Chat();
    activeChat.setChatID(-1);
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
        lastId = 0;
        loadNewChatRoom();
    }

    private void loadNewChatRoom() {
        HashMap<Integer,MessageObject> messageChatList = activeChat.getMessageChatList();
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
        if(message.getIdChatRoom() == activeChat.getChatID()) {

            if(lastId < message.getId()) {
                HboxFactory hboxFactory = new MessageBoxFactor();
                HBOX hb = hboxFactory.createHbox();
                hb.setMessageObject(message);
                hb.create();
                lastId = message.getId();
            }
        }
    }

    @Override
    public void updateNotify() {
       updateChatRoom(activeChat);
    }
}
