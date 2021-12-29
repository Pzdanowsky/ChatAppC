package Managers;

import Objects.MessageObject;
import Objects.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class VboxManager {

    private static VboxManager instance;

    private VBox vb_contants;

    private VBox vb_search;

    private VBox vb_message;

    public static VboxManager getInstance(){
        if(instance == null){
            instance = new VboxManager();
        }
        return instance;
    }

    private VboxManager(){

    }

    public VBox getVb_contants() {
        return vb_contants;
    }

    public void setVb_contants(VBox vb_contants) {
        this.vb_contants = vb_contants;
    }

    public VBox getVb_search() {
        return vb_search;
    }

    public void setVb_search(VBox vb_search) {
        this.vb_search = vb_search;
    }

    public VBox getVb_message() {
        return vb_message;
    }

    public void setVb_message(VBox vb_message) {
        this.vb_message = vb_message;
    }




}
