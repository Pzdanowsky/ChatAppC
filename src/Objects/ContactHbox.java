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
    private HBox hb = new HBox();
    private TextFlow loginFlow;
    private Button openChat;
    private Text chat_t;

    public static  boolean IS_TEST = false;


    @Override
    public void create() {
        //clear();
        render();
        draw();
    }

    @Override
    public void render() {

            hb.setAlignment(Pos.CENTER);
            hb.setPadding(new Insets(5, 5, 5, 10));

            chat_t = new Text(String.valueOf(chat.getChatID()));
            loginFlow = new TextFlow(chat_t);
            openChat = new Button("Otworz chat");
            onClick();
        hb.getChildren().add(loginFlow);
        hb.getChildren().add(openChat);
        }


    @Override
    public void onClick() {
        openChat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Wciskasz ID:" +chat.getChatID());
                ChatBoxManager.getInstance().changeActiveChatRoom(chat);

            }
        });
    }

    @Override
    public void draw() {
        Platform.runLater(() -> {
            try {

               ContactBoxManager.getInstance().getVb_contants().getChildren().add(hb);
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
        this.chat = chat;
        if (IS_TEST == false){
            create();
        }
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

