package Services.Builders;

import Objects.*;

import java.util.List;

public class SendMessageObjectBuilder implements ObjectDataBuilder{

    private ObjectData objectData;
    private MessageObject message;

    public SendMessageObjectBuilder(MessageObject message) {
       this.message = message;
    }


    @Override
    public void makeObject(ObjectData objectData) {
        this.objectData = objectData;
        makeCommandType();
        makeDataType();
        makeMessageObject(message);
    }

    @Override
    public void makeCommandType() {
        objectData.setCommand("00111");
    }

    @Override
    public void makeDataType() {
        objectData.setDataType("SendMessaget-Request");
    }

    public void makeMessageObject(MessageObject messageObject) {
        objectData.setMessageObject(messageObject);
    }

    @Override
    public ObjectData getObjectData() {
        return objectData;
    }
}
