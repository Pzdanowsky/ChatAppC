package Repositories;

import Managers.ContactBoxManager;
import Managers.SearchBoxManager;
import Objects.Chat;
import Services.Observable;
import Services.PreparationObjectsService;

import java.util.HashMap;
import java.util.Map;

public class ChatRepository implements Observable {

    private static ChatRepository instance;
    private ContactBoxManager observerContactBoxManager;
    private static Map<Integer, Chat> chatList;
    private SearchBoxManager vboxManager;

    public static ChatRepository getInstance(){
        if(instance == null){
            instance = new ChatRepository();
        }

        return instance;
    }


    private ChatRepository(){
        chatList = new HashMap<>();
    }


    public void addChat(Chat chatRoom){
        if(!chatList.isEmpty()){
            for (Map.Entry<Integer,Chat> chat: chatList.entrySet()) {
                if(chat.getValue().getChatID() == chatRoom.getChatID()){
                    System.out.println("Dodano juz tej pokoj");
                    break;
                }else{
                    chatList.put(chatRoom.getChatID(), chatRoom);
                    update(chatRoom);
                }
            }
        }else {
            chatList.put(chatRoom.getChatID(), chatRoom);
            update(chatRoom);
           //System.out.println("Pusta lista");
        }
    }

    public Chat getChat(int chatId){

        return chatList.get(chatId);
    }

    public void update(Chat chatRoom){
        DataSendRepository.getInstance().addDataSend(PreparationObjectsService.preparationRequestMessageList(chatRoom));
        notifyObserver();

    }

    @Override
    public void notifyObserver() {
        ContactBoxManager.getInstance().updateNotify();
    }

    public Map<Integer, Chat> getChatList() {
        return chatList;
    }
}
