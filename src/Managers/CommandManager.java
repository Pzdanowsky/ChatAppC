package Managers;

import Objects.ObjectData;
import Objects.User;
import Repositories.DataReciveRepository;
import Repositories.DataSendRepository;
import Services.LoginService;
import Services.RegisterService;
import Services.ResponseStrategy;

public class CommandManager {

    private static ObjectData objectDataRecive;
    private static ResponseStrategy strategy;

    public static void manage(){

       objectDataRecive = DataReciveRepository.getInstance().iterList();
        if(objectDataRecive == null)
        {
            System.out.println("Pakiet przyszedł pusty");
        }else{

            switch(objectDataRecive.getCommand()){

                case "00001":
                    strategy = new LoginService();
                    break;

                case "00010":
                    strategy = new RegisterService();
                    break;

                case "00011":
                    // Zapomniane hasło
                    break;

                case "00100":
                    // Wyjscie - wylogowanie
                    break;

                case "00101":
                    // Lista znajomych - sprawdzanie aktywnosci
                    break;

                case "00110":
                    // Wysyłanie wiadomości
                    break;

                case "00111":
                    // Wysyłanie pliku
                    break;

                case "01000":
                    // Tworzenie chatu
                    break;

                case "01001":
                    //Pobranie wiadomości dla czatu
                    break;

                case "01010":
                    //Pobranie pliku
                    break;

                case "01011":
                    //Pobranie starszy wiadomości
                    break;

                case "01100":
                    // Potwierdzenie online
                    break;



            }
        strategy.processObjectData(objectDataRecive);

        }
    }
}