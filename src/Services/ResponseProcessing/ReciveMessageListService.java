package Services.ResponseProcessing;

import Objects.Chat;
import Objects.ObjectData;
import Repositories.ChatRepository;
import Services.ResponseStrategy;

public class ReciveMessageListService implements ResponseStrategy {

    @Override
    public void processObjectData(ObjectData objectData) {

        if(objectData.getChatRoomList().isEmpty()){
            System.out.println("Brak wiadomosci");
        }else {
            ChatRepository.getInstance().getChat(objectData.getChatRoomList().get(0).getChatID())
                    .addMessageList(objectData.getChatRoomList().get(0).getMessageChatList());
        }
    }
}
