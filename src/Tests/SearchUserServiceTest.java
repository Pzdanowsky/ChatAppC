package Tests;

import Managers.ChatBoxManager;
import Managers.SearchBoxManager;
import Objects.Chat;
import Objects.ContactHbox;
import Objects.ObjectData;
import Objects.UserData;
import Repositories.ChatRepository;
import Repositories.DataSendRepository;
import Services.PreparationObjectsService;
import Services.ResponseProcessing.CreateChatService;
import Services.ResponseProcessing.SearchUserService;
import Services.SendService;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SearchUserServiceTest {
    @Test
    void shouldCreateUser() {
        ContactHbox.IS_TEST = true;
        String testString = "TEST";
        Chat testChat = new Chat();
        ObjectData objectData = PreparationObjectsService.preparationCreateChatObject(testString);
        objectData.addChatToList(testChat);
        SendService sendServiceThread = new SendService();
        DataSendRepository.getInstance().setObserverSender(sendServiceThread);
        CreateChatService service = new CreateChatService();
        service.processObjectData(objectData);
        Chat chat = ChatRepository.getInstance().getChat(testChat.getChatID());
        assertNotNull(chat);
    }
}

