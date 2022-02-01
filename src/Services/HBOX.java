package Services;

import Objects.UserData;
import Objects.MessageObject;
import Objects.Chat;
import javafx.scene.layout.HBox;

import java.util.Objects;

public interface HBOX {

    public void create();
    public void render();
    public void onClick();
    public void draw();

    public void setUserData(UserData user);

    public void setMessageObject(MessageObject msg);

    public void setChat(Chat chat);
}
