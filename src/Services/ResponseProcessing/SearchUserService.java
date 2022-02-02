package Services.ResponseProcessing;

import Managers.SearchBoxManager;
import Objects.ObjectData;
import Objects.User;
import Objects.UserData;
import Repositories.DataSendRepository;
import Services.ResponseStrategy;
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

public class SearchUserService implements ResponseStrategy {

    @Override
    public void processObjectData(ObjectData objectData) {
        SearchBoxManager.getInstance().addSearchedUser(createUser(objectData));
    }

    public UserData createUser(ObjectData objectData){
        UserData user = new UserData();
        user.setUsername(objectData.getUserDataDestintion().getUsername());
        user.setNameUser(objectData.getUserDataDestintion().getNameUser());
        user.setSurname(objectData.getUserDataDestintion().getSurname());
        user.setAvatarID(objectData.getUserDataDestintion().getAvatarID());
    return user;
    }
}
