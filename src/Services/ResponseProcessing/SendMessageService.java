package Services.ResponseProcessing;

import Managers.ChatBoxManager;
import Objects.ObjectData;
import Services.ResponseStrategy;
import javafx.application.Platform;

public class SendMessageService implements ResponseStrategy {

    @Override
    public void processObjectData(ObjectData objectData) {

        Platform.runLater(() -> {
            try {
                ChatBoxManager.getInstance().getActiveChat().addMessage(objectData.getMessageObject());
            }catch(NullPointerException ex){
                ex.printStackTrace();
            }
        });

    }
}
