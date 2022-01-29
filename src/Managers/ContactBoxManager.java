package Managers;

import Repositories.DataSendRepository;
import Services.PreparationObjectsService;
import javafx.scene.layout.VBox;

public class ContactBoxManager {


    private static ContactBoxManager instance;
    private VBox vb_contants;


    public static ContactBoxManager getInstance(){
        if(instance == null){
            instance = new ContactBoxManager();
        }
        return instance;
    }

    private ContactBoxManager(){

    }

    public VBox getVb_contants() {
        return vb_contants;
    }

    public void setVb_contants(VBox vb_contants) {
        this.vb_contants = vb_contants;
    }


    public void getRequestContanct() {
       // DataSendRepository.getInstance().addDataSend(PreparationObjectsService.);

    }
}
