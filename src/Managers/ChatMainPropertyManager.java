package Managers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ChatMainPropertyManager {

    private StringProperty messageTxt = new SimpleStringProperty();

    private StringProperty searchText = new SimpleStringProperty();

    private StringProperty addText = new SimpleStringProperty();

    public String getAddText() {
        return addText.get();
    }

    public StringProperty addTextProperty() {
        return addText;
    }

    public void setAddText(String addText) {
        this.addText.set(addText);
    }

    public String getSearchText() {
        return searchText.get();
    }

    public StringProperty searchTextProperty() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText.set(searchText);
    }

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
