package Tests;

import Managers.ChatBoxManager;
import Objects.Chat;
import Objects.MessageObject;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChatBoxManagerTest {

    @Test
    void shouldSetChat(){
        String testString  = "TEST";
        Chat chat = new Chat();
        MessageObject messageObject1 = new MessageObject(1, testString, 1);
        chat.addMessage(messageObject1);
        ChatBoxManager.getInstance().setVb_messages(new VBox());
        ChatBoxManager.getInstance().changeActiveChatRoom(chat);
        assertEquals(chat, ChatBoxManager.getInstance().getActiveChat());
    }

    @Test
    void shouldChangeChat(){
        String testString  = "TEST";
        Chat chat = new Chat();
        MessageObject messageObject1 = new MessageObject(1, testString, 1);
        Chat chat2 = new Chat();
        MessageObject messageObject2 = new MessageObject(1, testString, 2);
        chat.addMessage(messageObject1);
        chat2.addMessage(messageObject2);
        ChatBoxManager.getInstance().setVb_messages(new VBox());
        ChatBoxManager.getInstance().changeActiveChatRoom(chat);
        assertEquals(chat, ChatBoxManager.getInstance().getActiveChat());
        ChatBoxManager.getInstance().changeActiveChatRoom(chat2);
        assertEquals(chat2, ChatBoxManager.getInstance().getActiveChat());
    }
}