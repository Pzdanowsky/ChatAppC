package Services.Builders;

import Objects.*;

import java.util.List;

public class MessageListObjectBuilder implements ObjectDataBuilder{

    private ObjectData objectData;
    private Chat chat;

    public MessageListObjectBuilder(Chat chat) {
        this.chat = chat;
    }


    @Override
    public void makeObject(ObjectData objectData) {
        this.objectData = objectData;
        makeCommandType();
        makeDataType();
        addChatToList(chat);
    }

    @Override
    public void makeCommandType() {
        objectData.setCommand("01001");
    }

    @Override
    public void makeDataType() {
        objectData.setDataType("InitMessageListt-Request");
    }

    public void addChatToList(Chat chatRoom) {
        objectData.addChatToList(chatRoom);
    }

    @Override
    public ObjectData getObjectData() {
        return objectData;
    }
}
