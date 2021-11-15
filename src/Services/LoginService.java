package Services;

import Controllers.LoginController;
import Managers.ThreadsMenager;
import Objects.ObjectData;
import Objects.User;
import Panels.LoadPanel;
import Panels.MainChatPanel;
import Repositories.DataReciveRepository;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;

public class LoginService implements ResponseStrategy{

    LoadPanel loadPanel;

    @Override
    public void processObjectData(ObjectData objectDataRecive) {


        if(objectDataRecive.isAuthenticated()) {
            User.getInstance().setAuthenticated(objectDataRecive.isAuthenticated());
            User.getInstance().setUsername(objectDataRecive.getUsername());
            User.getInstance().setSessionNumber(objectDataRecive.getSessionNumber());
            User.getInstance().setSessionToken(objectDataRecive.getSesionToken());
            User.getInstance().setUserID(objectDataRecive.getUserID());
            System.out.println(User.getInstance().getUserID());



            Platform.runLater(() -> {
                try {
                    System.out.println(Thread.currentThread());
                    new MainChatPanel().load();
                }catch(NullPointerException ex){
                    ex.printStackTrace();
                }
            });

        }else{
            User.getInstance().setSessionNumber(objectDataRecive.getSessionNumber());
            System.out.println("Nie tym razem mordo");
        }


    }
}
