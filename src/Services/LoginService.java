package Services;

import Controllers.LoginController;
import Objects.ObjectData;
import Objects.User;
import Panels.MainChatPanel;
import Repositories.DataReciveRepository;

public class LoginService implements ResponseStrategy{



    @Override
    public void processObjectData(ObjectData objectDataRecive) {


        if(objectDataRecive.isAuthenticated()) {
            User.getInstance().setAuthenticated(objectDataRecive.isAuthenticated());
            User.getInstance().setUsername(objectDataRecive.getUsername());
            User.getInstance().setSessionNumber(objectDataRecive.getSessionNumber());
            User.getInstance().setSessionToken(objectDataRecive.getSesionToken());
            User.getInstance().setUserID(objectDataRecive.getUserID());
            System.out.println(User.getInstance().getUserID());

            new MainChatPanel().load();
        }else{
            User.getInstance().setSessionNumber(objectDataRecive.getSessionNumber());
            System.out.println("Nie tym razem mordo");
        }


    }
}
