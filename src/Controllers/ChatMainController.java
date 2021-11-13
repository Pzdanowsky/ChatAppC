package Controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ChatMainController {

    @FXML
    TextField textMessage;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vb_message;


    @FXML
    public void initialize(){
       for(int i=0; i <100; i++) {
           addMsg();
       }
       scrollPane.isPannable();
    }



    public void addMsg(){
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER_RIGHT);
        hb.setPadding(new Insets(5,5,5,10));

        Text text = new Text("Siemano tu serwer");
        TextFlow textFlow = new TextFlow(text);
        textFlow.setPadding(new Insets(5,10,5,10));
        textFlow.setStyle("-fx-background-color: rgb(15,135,245)");
        hb.getChildren().add(textFlow);
        vb_message.getChildren().add(hb);
    }

}
