package Services.Builders;

import Objects.*;

import java.util.List;

public class ContactListObjectBuilder implements ObjectDataBuilder{

    private ObjectData objectData;


    @Override
    public void makeObject(ObjectData objectData) {
        this.objectData = objectData;
        makeCommandType();
        makeDataType();
    }



    public void makeCommandType() {
        objectData.setCommand("00101");

    }

    public void makeDataType() {
        objectData.setDataType("ContactList-Request");
    }



    @Override
    public ObjectData getObjectData() {
        return this.objectData;
    }
}
