package Managers;

import Objects.ObjectData;
import Repositories.DataReciveRepository;
import Services.*;

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
                     strategy = new SearchUserService();
                    break;

                case "00111":
                    // Wysyłanie pliku
                    break;

                case "01000":
                    strategy = new CreateChatService();
                    break;

                case "01001":
                   // strategy = new AddChatRoom();
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
