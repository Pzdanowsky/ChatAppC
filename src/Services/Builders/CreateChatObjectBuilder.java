package Services.Builders;

import Objects.*;

import java.util.List;

public class CreateChatObjectBuilder implements ObjectDataBuilder{

    private ObjectData objectData;
    private String username;

    public CreateChatObjectBuilder(String username) {
       this.username = username;
    }

    @Override
    public void makeObject(ObjectData objectData) {
        this.objectData = objectData;
        makeCommandType();
        makeDataType();
        makeUserDataDestination(username);
    }

    @Override
    public void makeCommandType() {
        objectData.setCommand("01000");

    }

    @Override
    public void makeDataType() {
        objectData.setDataType("CreateChat-Request");

    }

    public void makeUserDataDestination(String username) {
        UserData userDataDestination = new UserData();
        userDataDestination.setUsername(username);
        objectData.setUserDataDestintion(userDataDestination);

    }

    @Override
    public ObjectData getObjectData() {
        return this.objectData;
    }
}
