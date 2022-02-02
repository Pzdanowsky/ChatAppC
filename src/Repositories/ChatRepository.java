package Repositories;

import Managers.ContactBoxManager;
import Managers.SearchBoxManager;
import Objects.Chat;
import Services.Observable;
import Services.PreparationObjectsService;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatRepository implements Observable {

    private static ChatRepository instance;
    private ContactBoxManager observerContactBoxManager;
    private volatile static CopyOnWriteArrayList<Chat> chatList;
    private volatile static ConcurrentModificationException chats;
    private SearchBoxManager vboxManager;

    public static ChatRepository getInstance(){
        if(instance == null){
            instance = new ChatRepository();
        }

        return instance;
    }


    private ChatRepository(){
        chatList = new CopyOnWriteArrayList<>();

    }


    public void addChat(Chat chatRoom){

        if(!chatList.isEmpty()){

                if(chatList.contains(chatRoom)){
                    System.out.println("Dodano juz tej pokoj");

                }else{
                    chatList.add(chatRoom);
                    update(chatRoom);
                }

        }else {
            System.out.println("Puusta lista: "+chatRoom.getChatID());
            chatList.add(chatRoom);
            update(chatRoom);
        }
    }

    public Chat getChat(int chatId){
        for (Chat chat: chatList) {
            if(chat.getChatID() == chatId){
                return chat;
            }
        }

        return null;
    }

    public void update(Chat chatRoom){
        System.out.println("Wielkosc repo: "+ chatList.size());
      DataSendRepository.getInstance().addDataSend(PreparationObjectsService.preparationRequestMessageList(chatRoom));
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        ContactBoxManager.getInstance().updateNotify();
    }

    public List<Chat> getChatList() {
        return chatList;
    }
}
