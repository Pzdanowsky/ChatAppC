package Services.ResponseProcessing;

import Objects.ObjectData;
import Objects.User;
import Panels.MainChatPanel;
import Services.ResponseStrategy;
import javafx.application.Platform;

public class LoginService implements ResponseStrategy {

    @Override
    public void processObjectData(ObjectData objectDataRecive) {

        if(objectDataRecive.isAuthenticated()) {
            setUserData(objectDataRecive,1);

            Platform.runLater(() -> {
                try {
                    new MainChatPanel().load();
                }catch(NullPointerException ex){
                    ex.printStackTrace();
                }
            });

        }else{
            setUserData(objectDataRecive,0);
        }
    }


    private void setUserData(ObjectData objectDataRecive,int flags){
        if(flags == 1) {
            User.getInstance().setAuthenticated(objectDataRecive.isAuthenticated());
            User.getInstance().setUsername(objectDataRecive.getUserData().getUsername());
            User.getInstance().setSessionNumber(objectDataRecive.getUserData().getSessionNumber());
            User.getInstance().setSessionToken(objectDataRecive.getUserData().getSessionToken());
            User.getInstance().setUserID(objectDataRecive.getUserData().getUserID());
        }
        if(flags == 0){
            User.getInstance().setSessionNumber(objectDataRecive.getUserData().getSessionNumber());

        }
    }
}
