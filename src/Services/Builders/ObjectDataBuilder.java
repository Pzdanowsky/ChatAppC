package Services.Builders;

import Objects.*;

import java.util.List;

public interface ObjectDataBuilder {

    public void makeAuthStatus();
    public void makeCommandType();
    public void makeDataType();
    public void makeUserData();
    public void makeUserDataDestination(String username);
    public void makeMessageObject(MessageObject message);
    public void makeChatList();
    public void addChatList(List<Chat> chatList);
    public void addChatToList(Chat chatRoom);

    public ObjectData getObjectData();
}
