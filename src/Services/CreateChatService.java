package Services;

import Managers.VboxManager;
import Objects.ObjectData;
import Repositories.ChatRepository;
import Repositories.DataSendRepository;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class CreateChatService implements ResponseStrategy {

    @Override
    public void processObjectData(ObjectData objectData) {
        ChatRepository.getInstance().addChat(objectData.getChatRoom());
    }
}
