package Services.ResponseProcessing;

import Objects.ObjectData;
import Repositories.ChatRepository;
import Services.ResponseStrategy;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class ResponseMessageService implements ResponseStrategy {
    @Override
    public void processObjectData(ObjectData objectData) {
        System.out.println("Mam");
        ChatRepository.getInstance().getChat(objectData.getMessageObject().getIdChatRoom()).addMessage(objectData.getMessageObject());


    }
}
