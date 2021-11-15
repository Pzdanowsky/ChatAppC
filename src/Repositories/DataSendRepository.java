package Repositories;

import Objects.ObjectData;
import Services.SendService;

import java.util.HashMap;
import java.util.Map;

public class DataSendRepository {

    private static DataSendRepository instance;
    private static Map<String, ObjectData> sendList;
    private static SendService observerSendService;


    public static DataSendRepository getInstance() {
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

    public void addDataSend(ObjectData objectDataSend) {
        sendList.put(objectDataSend.getDataType(), objectDataSend);
        update();
    }

    public ObjectData getObjectData(String dataType) {
        ObjectData obj = sendList.get(dataType);
        sendList.remove(dataType);
        return obj;
    }

    public void update(){
        observerSendService.notice();
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
}