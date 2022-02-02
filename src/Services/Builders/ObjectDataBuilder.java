package Services.Builders;

import Objects.*;

import java.util.List;

public interface ObjectDataBuilder {

    public void makeObject(ObjectData objectData);
    public void makeCommandType();
    public void makeDataType();

    public ObjectData getObjectData();
}
