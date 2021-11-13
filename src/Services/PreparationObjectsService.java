package Services;

import Objects.ObjectData;
import Objects.User;

public class PreparationObjectsService {

    private static ObjectData objectData;


    public static ObjectData preparationLoginObject(){
        objectData = new ObjectData();
        objectData.setSessionNumber(User.getInstance().getSessionNumber());
        objectData.setSesionToken(User.getInstance().getSessionToken());
        objectData.setUsername(User.getInstance().getUsername());
        objectData.setPassword(User.getInstance().getPassword());
        objectData.setCommand("00001");
        objectData.setDataType("LoginData-Request");
        objectData.setAuthenticated(User.getInstance().isAuthenticated());
        return objectData;
    }

}
