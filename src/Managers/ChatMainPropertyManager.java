package Managers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ChatMainPropertyManager {

    private StringProperty messageTxt = new SimpleStringProperty();


    public String getMessageTxt() {
        return messageTxt.get();
    }

    public StringProperty messageTxtProperty() {
        return messageTxt;
    }

    public void setMessageTxt(String messageTxt) {
        this.messageTxt.set(messageTxt);
    }
}
