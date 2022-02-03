package Services.ResponseProcessing;

import Objects.ObjectData;
import Repositories.ChatRepository;
import Services.ResponseStrategy;

public class AddChatByOther implements ResponseStrategy {
    @Override
    public void processObjectData(ObjectData objectData) {

        System.out.println("mam");
        ChatRepository.getInstance().addChat(objectData.getChatRoomList().get(0));
    }
}
