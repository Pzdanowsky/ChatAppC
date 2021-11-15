package Services;

import Objects.ObjectData;
import Objects.User;
import Panels.MainChatPanel;

public class RegisterService implements ResponseStrategy {


    @Override
    public void processObjectData(ObjectData objectData) {

        if(objectData.getUserID() != 0) {

            User.getInstance().setUsername(objectData.getUsername());
            User.getInstance().setSessionNumber(objectData.getSessionNumber());
            User.getInstance().setUserID(objectData.getUserID());
            System.out.println(User.getInstance().getUserID());

            new MainChatPanel().load();
        }else{
            User.getInstance().setSessionNumber(objectData.getSessionNumber());
            System.out.println("Nie tym razem mordo");
        }

    }
}
