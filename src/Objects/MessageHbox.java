package Objects;

import Managers.ChatBoxManager;
import Managers.SearchBoxManager;
import Services.HBOX;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class MessageHbox implements HBOX{
    HBox hb;
    MessageObject message;

    @Override
    public void create() {
        render();
        draw();
    }

    @Override
    public void render() {
        hb = new HBox();
        if(message.getAuthorId() == User.getInstance().getUserID()){
            hb.setAlignment(Pos.CENTER_RIGHT);
        }else
        {
            hb.setAlignment(Pos.CENTER_LEFT);
        }

        hb.setPadding(new Insets(5,5,5,10));
        hb.setUserData(User.getInstance());
        Image imProfil = new Image(getClass().getResourceAsStream("/fileRepository/image/default_avatar_0.png"));
        ImageView iw = new ImageView(imProfil);
        iw.setFitWidth(50);
        iw.setFitHeight(50);


        Text text = new Text(message.getContent());
        TextFlow textFlow = new TextFlow(text);
        textFlow.setPadding(new Insets(5,10,5,10));
        textFlow.setStyle("-fx-background-color: rgb(15,135,245)");

        hb.getChildren().add(iw);
        hb.getChildren().add(textFlow);

    }

    @Override
    public void onClick() {

    }

    @Override
    public void draw() {


        Platform.runLater(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                ChatBoxManager.getInstance().getVb_messages().getChildren().add(hb);
            }catch(NullPointerException ex){
                ex.printStackTrace();
            }
        });
    }

    @Override
    public void setUserData(UserData user) {

    }


    public void setMessageObject(MessageObject msg) {
    this.message = msg;
    }

    @Override
    public void setChat(Chat chat) {

    }
}
