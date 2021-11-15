package Objects;

import java.util.ArrayList;
import java.util.HashMap;

public class Chat {

    private int id;
    private int userID;
    private int frendID;
    private HashMap<Integer,MessageObject> messageChatList;
    private HashMap<Integer, FileObject> fileChatList;


    public void addMessage(MessageObject messageObject){
        this.messageChatList.put(messageObject.getId(), messageObject);
    }

    public MessageObject getMessage(int messageID){
       return this.messageChatList.get(messageID);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getFrendID() {
        return frendID;
    }

    public void setFrendID(int frendID) {
        this.frendID = frendID;
    }




}
