package Managers;

import Objects.Chat;
import Objects.ObjectData;
import Objects.User;
import Repositories.ChatRepository;
import Repositories.DataSendRepository;
import Services.Factors.ContactBoxFactor;
import Services.Factors.HboxFactory;
import Services.HBOX;
import Services.Observer;
import Services.PreparationObjectsService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.Map;

public class ContactBoxManager implements Observer {


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
      DataSendRepository.getInstance().addDataSend(PreparationObjectsService.preparationRequestContactList());

    }


    @Override
    public void updateNotify() {
        addContacts();
    }

    public void addContacts() {
        HboxFactory hboxFactory = new ContactBoxFactor();
        int lastElement = ChatRepository.getInstance().getChatList().size()-1;
         System.out.println(lastElement);

            HBOX hb = hboxFactory.createHbox();
            hb.setChat(ChatRepository.getInstance().getChatList().get(lastElement));

    }

}
