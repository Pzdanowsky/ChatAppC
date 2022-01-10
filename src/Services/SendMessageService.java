package Services;

import Managers.ChatBoxManager;
import Managers.VboxManager;
import Objects.ObjectData;
import javafx.application.Platform;

public class SendMessageService implements ResponseStrategy {

    @Override
    public void processObjectData(ObjectData objectData) {
        System.out.println("Wiadomość potwierdzona");

        Platform.runLater(() -> {
            try {
                ChatBoxManager.getInstance().getActiveChat().addMessage(objectData.getMessageObject());
            }catch(NullPointerException ex){
                ex.printStackTrace();
            }
        });

    }
}
