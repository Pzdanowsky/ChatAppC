package Repositories;

import Objects.ObjectData;
import Services.Observable;
import Services.SendService;

import java.util.HashMap;
import java.util.Map;

public class DataSendRepository implements Observable {

    private static DataSendRepository instance;
    private static Map<String, ObjectData> sendList;
    private static SendService observerSendService;


    public synchronized static DataSendRepository getInstance() {
        if (instance == null) {
            instance = new DataSendRepository();
        }

        return instance;
    }

    private DataSendRepository() {
        sendList = new HashMap<>();
    }

    public void setObserverSender(SendService sendService){
        observerSendService = sendService;
    }

    public boolean addDataSend(ObjectData objectDataSend) {
        sendList.put(objectDataSend.getDataType(), objectDataSend);
        if(sendList.get(objectDataSend.getDataType())!= null){
          notifyObserver();
            return true;
        }
        return false;

    }

    public ObjectData getObjectData(String dataType) {
        ObjectData obj = sendList.get(dataType);
        sendList.remove(dataType);
        return obj;
    }

    public ObjectData iterList(){
        if(!sendList.isEmpty()) {
            for (Map.Entry<String, ObjectData> entry : sendList.entrySet()) {
                ObjectData objectData = entry.getValue();
                sendList.remove(entry.getKey());
                    return objectData;
            }
        }
        return null;
    }

    public static Map<String, ObjectData> getSendList() {
        return sendList;
    }

    public static void setSendList(Map<String, ObjectData> sendList) {
        DataSendRepository.sendList = sendList;
    }

    @Override
    public void notifyObserver() {
        observerSendService.updateNotify();
    }
}