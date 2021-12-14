package Services;

import Objects.ObjectData;
import Objects.User;
import Panels.MainChatPanel;

public class RegisterService implements ResponseStrategy {


    @Override
    public void processObjectData(ObjectData objectData) {

        if(objectData.getUserDataDestintion().getUserID() != 0) {

            User.getInstance().setUsername(objectData.getUserData().getUsername());
            User.getInstance().setSessionNumber(objectData.getUserData().getSessionNumber());
            User.getInstance().setUserID(objectData.getUserData().getUserID());
            System.out.println(User.getInstance().getUserID());

            new MainChatPanel().load();
        }else{
            User.getInstance().setSessionNumber(objectData.getUserData().getSessionNumber());
            System.out.println("Nie tym razem mordo");
        }

    }
}
