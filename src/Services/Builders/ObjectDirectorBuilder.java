package Services.Builders;

import Objects.ObjectData;
import Objects.User;
import Objects.UserData;
import Services.MainObjectBuilder;

public class ObjectDirectorBuilder implements MainObjectBuilder {

    protected ObjectDataBuilder objectDataBuilder;
    public ObjectData objectData;

    public ObjectDirectorBuilder(ObjectDataBuilder objectDataBuilder) {
        this.objectDataBuilder = objectDataBuilder;
        this.objectData = new ObjectData();

    }


    @Override
    public ObjectData creationObjectData() {
        makeAuthStatus();
        makeUserData();
        objectDataBuilder.makeObject(objectData);
        return objectDataBuilder.getObjectData();
    }

    @Override
    public void makeAuthStatus() {
        objectData.setAuthenticated(User.getInstance().isAuthenticated());
    }


    @Override
    public void makeUserData() {
        UserData userData = new UserData();
        userData.setUserID(User.getInstance().getUserID());
        userData.setSessionToken(User.getInstance().getSessionToken());
        userData.setSessionNumber(User.getInstance().getSessionNumber());
        userData.setUsername(User.getInstance().getUsername());
        userData.setPassword(User.getInstance().getPassword());
        userData.setNameUser(User.getInstance().getName());
        userData.setSurname(User.getInstance().getSurname());
        userData.setEmail(User.getInstance().getEmail());
        objectData.setUserData(userData);
    }
}
