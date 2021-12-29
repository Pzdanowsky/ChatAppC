package Repositories;

import Managers.ChatBoxManager;
import Managers.VboxManager;
import Objects.Chat;
import Objects.MessageObject;
import Services.PreparationObjectsService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.HashMap;
import java.util.Map;

public class ChatRepository {

    private static ChatRepository instance;

    private static Map<Integer, Chat> chatList;
    private VboxManager vboxManager;

    public static ChatRepository getInstance(){
        if(instance == null){
            instance = new ChatRepository();
        }

        return instance;
    }


    private ChatRepository(){
        chatList = new HashMap<>();
    }


    public void addChat(Chat chatRoom){
        chatList.put(chatRoom.getChatID(),chatRoom);
        update(chatRoom);
    }

    public Chat getChat(int chatId){

        return chatList.get(chatId);
    }

    public void update(Chat chatRoom){

        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(5,5,5,10));

        Text chat_t = new Text(String.valueOf(chatRoom.getChatID()));
        TextFlow loginFlow = new TextFlow(chat_t);
        Button openChat = new Button("Otworz chat");

        openChat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Chce utworzyc czat z tym uzytkownikiem");
                MessageObject messageObject = new MessageObject();
                messageObject.setData("Siema tu czat: "+ chatRoom.getChatID());
                messageObject.setFromMessage("user");
                chatRoom.addMessage(messageObject);
                ChatBoxManager.getInstance().changeActiveChatRoom(chatRoom);




            }
        });

        hb.getChildren().add(loginFlow);
        hb.getChildren().add(openChat);
        Platform.runLater(() -> {
            try {
                System.out.println(Thread.currentThread());
                VboxManager.getInstance().getVb_contants().getChildren().add(hb);
            }catch(NullPointerException ex){
                ex.printStackTrace();
            }
        });

    }
}
