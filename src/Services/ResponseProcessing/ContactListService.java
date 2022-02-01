package Services.ResponseProcessing;

import Managers.ContactBoxManager;
import Objects.Chat;
import Objects.ObjectData;
import Repositories.ChatRepository;
import Services.ResponseStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContactListService implements ResponseStrategy {

    @Override
    public void processObjectData(ObjectData objectData) {

        if(objectData.getChatRoomList().isEmpty()){
            System.out.println("Brak kontaktów dla ID: "+ objectData.getUserData().getUserID());

        }else{

            for (Chat chat : objectData.getChatRoomList()) {
                ChatRepository.getInstance().addChat(chat);
            }
        }
    }
}
