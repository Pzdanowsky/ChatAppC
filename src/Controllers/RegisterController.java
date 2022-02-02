package Controllers;

import Managers.RegisterPropertyManager;
import Objects.User;
import Repositories.DataSendRepository;
import Services.PreparationObjectsService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private Button registerButton;

    private RegisterPropertyManager rpm = new RegisterPropertyManager();

    @FXML
    public void initialize(){
        nameField.textProperty().bindBidirectional(rpm.namePropetyProperty());
        surnameField.textProperty().bindBidirectional(rpm.surnamePropertyProperty());
        loginField.textProperty().bindBidirectional(rpm.loginPropertyProperty());
        passwordField.textProperty().bindBidirectional(rpm.passwordPropertyProperty());
        emailField.textProperty().bindBidirectional(rpm.emailPropertyProperty());
        System.out.println("Działa");
    }

    @FXML
    public void registerAction(){
        User.getInstance().setName(rpm.getNamePropety());
        User.getInstance().setSurname(rpm.getSurnameProperty());
        User.getInstance().setUsername(rpm.getLoginProperty());
        User.getInstance().setPassword(rpm.getPasswordProperty());
        User.getInstance().setEmail(rpm.getEmailProperty());
        System.out.println(rpm.getPasswordProperty());
        DataSendRepository.getInstance().addDataSend(PreparationObjectsService.preparationRegisterObject());

        System.out.println("Rejestruje");
    }


}
