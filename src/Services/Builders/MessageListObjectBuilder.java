package Services.Builders;

import Objects.*;

import java.util.List;

public class MessageListObjectBuilder implements ObjectDataBuilder{

    private ObjectData objectData;

    public MessageListObjectBuilder() {
        this.objectData = new ObjectData();
    }

    @Override
    public void makeAuthStatus() {
        objectData.setAuthenticated(User.getInstance().isAuthenticated());
    }

    @Override
    public void makeCommandType() {
        objectData.setCommand("01001");
    }

    @Override
    public void makeDataType() {
        objectData.setDataType("InitMessageListt-Request");
    }

    @Override
    public void makeUserData() {
        UserData userData = new UserData();
        userData.setSessionToken(User.getInstance().getSessionToken());
        userData.setSessionNumber(User.getInstance().getSessionNumber());
        userData.setUsername(User.getInstance().getUsername());
        userData.setUserID(User.getInstance().getUserID());
        objectData.setUserData(userData);
    }

    @Override
    public void makeUserDataDestination(String username) {

    }

    @Override
    public void makeMessageObject(MessageObject message) {

    }

    @Override
    public void makeChatList() {

    }

    @Override
    public void addChatList(List<Chat> chatList) {

    }

    @Override
    public void addChatToList(Chat chatRoom) {
        objectData.addChatToList(chatRoom);
    }

    @Override
    public ObjectData getObjectData() {
        return objectData;
    }
}
