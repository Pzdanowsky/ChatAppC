package Services.ResponseProcessing;

import Managers.ContactBoxManager;
import Objects.Chat;
import Objects.ObjectData;
import Repositories.ChatRepository;
import Services.ResponseStrategy;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContactListService implements ResponseStrategy {

    @Override
    public void processObjectData(ObjectData objectData) {

        if(objectData.getChatRoomList().isEmpty()){
            System.out.println("Brak kontaktów dla ID: "+ objectData.getUserData().getUserID());

        }else{
            Platform.runLater(() -> {
                try {

                    ContactBoxManager.getInstance().getVb_contants().getChildren().clear();
                } catch (NullPointerException ex) {
                    ex.printStackTrace();
                }
            });

            for (Chat chat : objectData.getChatRoomList()) {
                ChatRepository.getInstance().addChat(chat);
            }
        }
    }
}
