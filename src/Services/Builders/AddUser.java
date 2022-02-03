package Services.Builders;

import Managers.ChatBoxManager;
import Objects.ObjectData;
import Objects.UserData;
import Services.Builders.ObjectDataBuilder;

public class AddUser implements ObjectDataBuilder {

    private String username;

    private ObjectData objectData;

    public AddUser(String username) {
        this.username = username;
    }

    @Override
    public void makeObject(ObjectData objectData) {
    this.objectData = objectData;
    makeCommandType();
    makeDataType();
    makeUserDataDestination(username);
    addChat();
    }

    @Override
    public void makeCommandType() {
        objectData.setCommand("01010");
    }

    @Override
    public void makeDataType() {
        objectData.setDataType("AddUser-Request");
    }

    @Override
    public ObjectData getObjectData() {
        return objectData;
    }

    public void makeUserDataDestination(String username){
        UserData userData = new UserData();
        userData.setUsername(username);
        objectData.setUserDataDestintion(userData);
    }

    public void addChat(){
        objectData.addChatToList(ChatBoxManager.getInstance().getActiveChat());
    }


}
