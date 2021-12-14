package Services;

import Objects.ObjectData;
import Objects.User;
import Objects.UserData;

public class PreparationObjectsService {

    private static ObjectData objectData;


    public static ObjectData preparationLoginObject(){
        UserData userData = new UserData();
        userData.setSessionToken(User.getInstance().getSessionToken());
        userData.setSessionNumber(User.getInstance().getSessionNumber());
        userData.setUsername(User.getInstance().getUsername());
        userData.setPassword(User.getInstance().getPassword());

        objectData = new ObjectData();
        objectData.setUserData(userData);
        objectData.setCommand("00001");
        objectData.setDataType("LoginData-Request");
        objectData.setAuthenticated(User.getInstance().isAuthenticated());
        return objectData;
    }

    public static ObjectData preparationRegisterObject(){
        UserData userData = new UserData();
        userData.setSessionToken(User.getInstance().getSessionToken());
        userData.setSessionNumber(User.getInstance().getSessionNumber());
        userData.setUsername(User.getInstance().getUsername());
        userData.setPassword(User.getInstance().getPassword());
        userData.setNameUser(User.getInstance().getName());
        userData.setSurname(User.getInstance().getSurname());
        userData.setEmail(User.getInstance().getEmail());

        objectData = new ObjectData();

        objectData.setUserData(userData);
        objectData.setCommand("00010");
        objectData.setDataType("RegisterData-Request");
        objectData.setAuthenticated(User.getInstance().isAuthenticated());
        return objectData;
    }

    public static ObjectData preparationSearchUserObject(String username){
        UserData userData = new UserData();
        userData.setSessionToken(User.getInstance().getSessionToken());
        userData.setSessionNumber(User.getInstance().getSessionNumber());
        userData.setUsername(User.getInstance().getUsername());
        userData.setUserID(User.getInstance().getUserID());

        UserData userDataDestination = new UserData();
        userDataDestination.setUsername(username);
        objectData = new ObjectData();

        objectData.setUserData(userData);
        objectData.setUserDataDestintion(userDataDestination);
        objectData.setCommand("00110");
        objectData.setDataType("SearchUser-Request");
        objectData.setAuthenticated(User.getInstance().isAuthenticated());

        return objectData;
    }

}
