package Services.Builders;

import Objects.*;

import java.util.List;

public class LoginObjectBuilder implements ObjectDataBuilder {

    private ObjectData objectData;

    public LoginObjectBuilder() {
        this.objectData = new ObjectData();
    }

    @Override
    public void makeAuthStatus() {
        objectData.setAuthenticated(User.getInstance().isAuthenticated());
    }

    @Override
    public void makeCommandType() {
        objectData.setCommand("00001");
    }

    @Override
    public void makeDataType() {
        objectData.setDataType("LoginData-Request");
    }

    @Override
    public void makeUserData() {
        UserData userData = new UserData();
        userData.setSessionToken(User.getInstance().getSessionToken());
        userData.setSessionNumber(User.getInstance().getSessionNumber());
        userData.setUsername(User.getInstance().getUsername());
        userData.setPassword(User.getInstance().getPassword());
        objectData.setUserData(userData);
    }

    @Override
    public void makeUserDataDestination(String username) {

    }

    @Override
    public void makeMessageObject(MessageObject message) {
    objectData.setMessageObject(message);
    }

    @Override
    public void makeChatList() {

    }

    @Override
    public void addChatList(List<Chat> chatRoomList) {
        objectData.setChatRoomList(chatRoomList);
    }

    @Override
    public void addChatToList(Chat chaRoom) {
        objectData.addChatToList(chaRoom);
    }

    @Override
    public ObjectData getObjectData() {
        return this.objectData;
    }
}
