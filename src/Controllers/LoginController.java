package Controllers;

import Connection.ServerSocketConnection;
import Managers.CommandManager;
import Managers.ThreadsMenager;
import Objects.ObjectData;
import Objects.User;
import Panels.LoadPanel;
import Panels.RegisterPanel;
import Repositories.DataReciveRepository;
import Repositories.DataSendRepository;
import Managers.LoginPropertyManager;
import Services.*;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLOutput;

public class LoginController {

    private ObjectData objectDataLogin;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label label;


      LoginPropertyManager man = new LoginPropertyManager();



    @FXML
    public void initialize(){

        loginField.textProperty().bindBidirectional(man.loginProperty());
        passwordField.textProperty().bindBidirectional(man.passwordProperty());
        label.textProperty().bind(man.loginProperty());
        loginButton.disableProperty().bind(man.loginBooleanProperty());

        ServerSocketConnection.getInstance();

        ThreadsMenager.getInstance().setMainThreadFX(Thread.currentThread());
        SendService sendServiceThread = new SendService();
        DataSendRepository.getInstance().setObserverSender(sendServiceThread);
        ReciveService reciverThread = new ReciveService();
        ThreadsMenager.getInstance().startRecive(reciverThread);
        CommandManager commandManager = new CommandManager();
        DataReciveRepository.setObserverCommandManager(commandManager);

    }

    public void loginAction(ActionEvent actionEvent){

       User.getInstance().setPassword(man.getPassword());
       User.getInstance().setUsername(man.getLogin());
       DataSendRepository.getInstance().addDataSend(PreparationObjectsService.preparationLoginObject());


    }

    public void registerAction(ActionEvent actionEvent) {
        new RegisterPanel().load();
    }

}
