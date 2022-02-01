package Objects;

import Managers.ChatBoxManager;
import Managers.ContactBoxManager;
import Repositories.ChatRepository;
import Services.HBOX;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.Map;

public class ContactHbox implements HBOX {
    private Chat chat;
    private HBox hb;
    private TextFlow loginFlow;
    private Button openChat;
    private Map<Integer,Chat> tempChats;
    private Text chat_t;


    @Override
    public void create() {
        clear();
        render();
    }

    @Override
    public void render() {

        for (Map.Entry<Integer, Chat> tempChats : ChatRepository.getInstance().getChatList().entrySet()) {
            hb  = new HBox();
            chat = tempChats.getValue();
            hb.setAlignment(Pos.CENTER);
            hb.setPadding(new Insets(5, 5, 5, 10));

            chat_t = new Text(String.valueOf(tempChats.getKey()));
            loginFlow = new TextFlow(chat_t);
            openChat = new Button("Otworz chat");

            hb.getChildren().add(loginFlow);
            hb.getChildren().add(openChat);
        onClick();
        draw();
        }
        }

    @Override
    public void onClick() {
        openChat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChatBoxManager.getInstance().changeActiveChatRoom(chat);
            }
        });
    }

    @Override
    public void draw() {
        Platform.runLater(() -> {
            try {

               ContactBoxManager.getInstance().getVb_contants().getChildren().add(hb);
               hb.getChildren().clear();
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }
        });

    }

    @Override
    public void setUserData(UserData user) {

    }

    @Override
    public void setMessageObject(MessageObject msg) {

    }

    @Override
    public void setChat(Chat chat) {

    }


    public void clear() {
        Platform.runLater(() -> {
            try {
                ContactBoxManager.getInstance().getVb_contants().getChildren().clear();
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }
        });
    }


}

