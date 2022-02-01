package Services.ResponseProcessing;

import Objects.ObjectData;
import Repositories.ChatRepository;
import Services.ResponseStrategy;

public class CreateChatService implements ResponseStrategy {

    @Override
    public void processObjectData(ObjectData objectData) {
        if(!objectData.getChatRoomList().isEmpty()) {
            ChatRepository.getInstance().addChat(objectData.getChatRoomList().get(0));
        }
    }
}
