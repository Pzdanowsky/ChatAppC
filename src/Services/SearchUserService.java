package Services;

import Managers.VboxManager;
import Objects.ObjectData;
import Objects.User;
import Panels.MainChatPanel;
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
        String login = objectData.getUserDataDestintion().getUsername();
        String name = objectData.getUserDataDestintion().getNameUser();
        String surname = objectData.getUserDataDestintion().getSurname();
        ImageView iw = null;

        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(5,5,5,10));
        if(objectData.getUserDataDestintion().getAvatarID() == 1) {
            Image imProfil = new Image(getClass().getResourceAsStream("/fileRepository/image/default_avatar_0.png"));
            iw = new ImageView(imProfil);
        }
        iw.setFitWidth(50);
        iw.setFitHeight(50);


        Text loginT = new Text(login);
        Text nameT = new Text(name);
        Text surnameT = new Text(surname);

        TextFlow loginFlow = new TextFlow(loginT);
        TextFlow nameFlow = new TextFlow(nameT);
        TextFlow surnameFlow = new TextFlow(surnameT);
        Button createBtn = new Button("Utworz chat");

        createBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Chce utworzyc czat z tym uzytkownikiem");
                DataSendRepository.getInstance().addDataSend(PreparationObjectsService.preparationCreateChatObject(login));
            }
        });

        //textFlow.setPadding(new Insets(5,10,5,10));
        //textFlow.setStyle("-fx-background-color: rgb(15,135,245)");
        VBox dane = new VBox();
        HBox imnazw = new HBox();
        imnazw.getChildren().add(nameFlow);
        imnazw.getChildren().add(surnameFlow);
        imnazw.getChildren().add(createBtn);
        dane.getChildren().add(imnazw);
        dane.getChildren().add(loginFlow);


        hb.getChildren().add(iw);
        hb.getChildren().add(dane);





        Platform.runLater(() -> {
            try {
                System.out.println(Thread.currentThread());
                VboxManager.getInstance().getVb_search().getChildren().add(hb);
            }catch(NullPointerException ex){
                ex.printStackTrace();
            }
        });

    }



    public void create(){


    }
}
