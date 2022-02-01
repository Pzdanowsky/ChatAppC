package Objects;

import Managers.SearchBoxManager;
import Repositories.DataSendRepository;
import Services.HBOX;
import Services.PreparationObjectsService;
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

public class SearchHbox implements HBOX {
    private HBox hb = new HBox();
    private ImageView iw = null;
    private Image imProfil;
    private Text loginT;
    private Text nameT;
    private Text surnameT;
    private TextFlow loginFlow;
    private TextFlow nameFlow;
    private TextFlow surnameFlow;
    private Button createBtn;
    private VBox dane = new VBox();
    private HBox imnazw = new HBox();

    private UserData user;


    @Override
    public void create() {
        render();
        draw();
    }

    @Override
   public void render() {

        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(5,5,5,10));

            imProfil = new Image(getClass().getResourceAsStream("/fileRepository/image/default_avatar_0.png"));
            iw = new ImageView(imProfil);

        iw.setFitWidth(50);
        iw.setFitHeight(50);


        loginT= new Text(user.getUsername());
        nameT= new Text(user.getNameUser());
        surnameT = new Text(user.getSurname());

        loginFlow = new TextFlow(loginT);
        nameFlow = new TextFlow(nameT);
        surnameFlow = new TextFlow(surnameT);
        createBtn = new Button("Utworz chat");

        onClick();




    }


    public void onClick() {
        createBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                DataSendRepository.getInstance()
                        .addDataSend(PreparationObjectsService
                                .preparationCreateChatObject(user.getUsername()));
            }
        });
    }


    public void draw(){
        Platform.runLater(() -> {
            try {
                System.out.println(Thread.currentThread());
                imnazw.getChildren().add(nameFlow);
                imnazw.getChildren().add(surnameFlow);
                imnazw.getChildren().add(createBtn);
                dane.getChildren().add(imnazw);
                dane.getChildren().add(loginFlow);

                hb.getChildren().add(iw);
                hb.getChildren().add(dane);
                SearchBoxManager.getInstance().getVb_search().getChildren().add(hb);
            }catch(NullPointerException ex){
                ex.printStackTrace();
            }
        });

    }


    public void setUserData(UserData user) {
        this.user = user;

    }

    @Override
    public void setMessageObject(MessageObject msg) {

    }

    @Override
    public void setChat(Chat chat) {

    }

}
