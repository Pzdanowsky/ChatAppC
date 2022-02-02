package Tests;

import Objects.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Wysłanie pojedunczej wiadomości
 * */
public class ChatTests {
    @Test
    void shouldSayThatSimpleMessageIsSend(){
        String testString = "TEST";
        Chat chat = new Chat();
        assertEquals(0, chat.getMessageChatList().size());
        MessageObject messageObject = new MessageObject(1, testString, chat.getChatID());
        chat.addMessage(messageObject);
        assertEquals(1, chat.getMessageChatList().size());
    }

    @Test
    void shouldSayThatMessageListIsSend(){
        HashMap<Integer,MessageObject> messageChatList=  new HashMap<>();
        String testString = "TEST";
        Chat chat = new Chat();
        assertEquals(0, chat.getMessageChatList().size());

        //chat.addMessage(messageObject);
        assertEquals(1, chat.getMessageChatList().size());
    }
}
