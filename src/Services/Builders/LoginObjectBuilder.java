package Services.Builders;

import Objects.*;

import java.util.List;

public class LoginObjectBuilder implements ObjectDataBuilder {

    private ObjectData objectData;


    @Override
    public void makeObject(ObjectData objectData) {
        this.objectData = objectData;
        makeCommandType();
        makeDataType();
    }

    @Override
    public void makeCommandType() {
        objectData.setCommand("00001");
    }

    @Override
    public void makeDataType() {
        objectData.setDataType("LoginData-Request");
    }


    @Override
    public ObjectData getObjectData() {
        return this.objectData;
    }
}
