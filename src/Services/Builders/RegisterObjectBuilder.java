package Services.Builders;

import Objects.*;

import java.util.List;

public class RegisterObjectBuilder implements ObjectDataBuilder{
   private ObjectData objectData;


    @Override
    public void makeObject(ObjectData objectData) {
        this.objectData = objectData;
        makeCommandType();
        makeDataType();
    }

    @Override
    public void makeCommandType() {
        objectData.setCommand("00010");
    }

    @Override
    public void makeDataType() {
        objectData.setDataType("RegisterData-Request");
    }


    @Override
    public ObjectData getObjectData() {
        return this.objectData;
    }
}
