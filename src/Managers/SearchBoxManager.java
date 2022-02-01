package Managers;

import Services.Factors.SearchHboxFactor;
import Objects.UserData;
import Services.HBOX;
import Services.Factors.HboxFactory;
import javafx.scene.layout.VBox;

public class SearchBoxManager {

    private static SearchBoxManager instance;



    private VBox vb_search;



    public static SearchBoxManager getInstance(){
        if(instance == null){
            instance = new SearchBoxManager();
        }
        return instance;
    }

    private SearchBoxManager(){
    }


    public VBox getVb_search() {
        return vb_search;
    }

    public void setVb_search(VBox vb_search) {
        this.vb_search = vb_search;
    }

    public void addSearchedUser(UserData user){

        HboxFactory a = new SearchHboxFactor();
        HBOX hb = a.createHbox();
        hb.setUserData(user);
        hb.create();




        //textFlow.setPadding(new Insets(5,10,5,10));
        //textFlow.setStyle("-fx-background-color: rgb(15,135,245)");


    }


}
