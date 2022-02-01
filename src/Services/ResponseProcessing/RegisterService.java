package Services.ResponseProcessing;

import Objects.ObjectData;
import Objects.User;
import Panels.MainChatPanel;
import Services.ResponseStrategy;

public class RegisterService implements ResponseStrategy {


    @Override
    public void processObjectData(ObjectData objectData) {

        if(objectData.getUserDataDestintion().getUserID() != 0) {
            setUserData(objectData,1);
            new MainChatPanel().load();
        }else{
            setUserData(objectData,0);
        }
    }

    private void setUserData(ObjectData objectDataRecive,int flags){
        if(flags == 1) {
            User.getInstance().setUsername(objectDataRecive.getUserData().getUsername());
            User.getInstance().setSessionNumber(objectDataRecive.getUserData().getSessionNumber());
            User.getInstance().setUserID(objectDataRecive.getUserData().getUserID());

        }
        if(flags == 0){
            User.getInstance().setSessionNumber(objectDataRecive.getUserData().getSessionNumber());

        }
    }
}
