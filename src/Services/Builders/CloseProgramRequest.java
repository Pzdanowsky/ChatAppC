package Services.Builders;

import Objects.ObjectData;

public class CloseProgramRequest implements ObjectDataBuilder {

    private ObjectData objectData;

    @Override
    public void makeObject(ObjectData objectData) {
    this.objectData = objectData;
    makeCommandType();
    makeDataType();
    }

    @Override
    public void makeCommandType() {
        objectData.setCommand("00100");
    }

    @Override
    public void makeDataType() {
        objectData.setDataType("CloseProgram-Request");
    }

    @Override
    public ObjectData getObjectData() {
        return objectData;
    }
}
