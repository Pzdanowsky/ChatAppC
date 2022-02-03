package Tests;

import Objects.Chat;
import Objects.MessageObject;
import Objects.ObjectData;
import Services.PreparationObjectsService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreparationObjectsServiceTest {
    @Test
    void shouldPreparationLoginObject() {
        ObjectData objectData = PreparationObjectsService.preparationLoginObject();

        assertEquals("00001", objectData.getCommand());
        assertEquals("LoginData-Request", objectData.getDataType());
    }

    @Test
    void shouldPreparationRegisterObject() {
        ObjectData objectData = PreparationObjectsService.preparationRegisterObject();

        assertEquals("00010", objectData.getCommand());
        assertEquals("RegisterData-Request", objectData.getDataType());
    }

    @Test
    void shouldPreparationSearchUserObject() {
        String username = "Ala";
        ObjectData objectData = PreparationObjectsService.preparationSearchUserObject(username);

        assertEquals("00110", objectData.getCommand());
        assertEquals("SearchUser-Request", objectData.getDataType());
    }

    @Test
    void shouldPreparationCreateChatObject() {
        String username = "Ala";
        ObjectData objectData = PreparationObjectsService.preparationCreateChatObject(username);

        assertEquals("01000", objectData.getCommand());
        assertEquals("CreateChat-Request", objectData.getDataType());
    }

    @Test
    void shouldPreparationSendMessageObject() {
        String testString  = "TEST";
        MessageObject messageObject = new MessageObject(1, testString, 1);
        ObjectData objectData = PreparationObjectsService.preparationSendMessageObject(messageObject);

        assertEquals("00111", objectData.getCommand());
        assertEquals("SendMessaget-Request", objectData.getDataType());
    }


    @Test
    void shouldPreparationRequestContactList() {
        ObjectData objectData = PreparationObjectsService.preparationRequestContactList();

        assertEquals("00101", objectData.getCommand());
        assertEquals("ContactList-Request", objectData.getDataType());
    }

    @Test
    void shouldPreparationRequestMessageList() {
        String testString  = "TEST";
        Chat chat = new Chat();
        MessageObject messageObject = new MessageObject(1, testString, 1);
        chat.addMessage(messageObject);
        ObjectData objectData = PreparationObjectsService.preparationRequestMessageList(chat);

        assertEquals("01001", objectData.getCommand());
        assertEquals("InitMessageListt-Request", objectData.getDataType());
    }


    @Test
    void shouldPreparationCloseProgram() {
        ObjectData objectData = PreparationObjectsService.preparationCloseProgram();

        assertEquals("00100", objectData.getCommand());
        assertEquals("CloseProgram-Request", objectData.getDataType());
    }
}
