package Repositories;

import Objects.ObjectData;
import Managers.CommandManager;

import java.util.HashMap;
import java.util.Map;

public class DataReciveRepository {

    private static DataReciveRepository instance;
    private static Map<String, ObjectData> reciveList;
    private static CommandManager observerCommandManager;


    public static DataReciveRepository getInstance(){
        if(instance == null){
            instance = new DataReciveRepository();
        }

        return instance;
    }


    private DataReciveRepository(){
        reciveList = new HashMap<>();
    }


    public static void setObserverCommandManager(CommandManager observerCommandManager) {
        DataReciveRepository.observerCommandManager = observerCommandManager;
    }

    public void addDataRecive(ObjectData objectDataRecive){
        reciveList.put(objectDataRecive.getDataType(),objectDataRecive);
        update();
    }



    public void update(){
        observerCommandManager.manage();
    }

    public ObjectData getObjectData(String dataType){
        if(!reciveList.isEmpty()) {
            ObjectData obj = reciveList.get(dataType);
            reciveList.remove(dataType);
            return obj;
        }
        return null;
    }

    public ObjectData iterList(){
        if(!reciveList.isEmpty()) {
            for (Map.Entry<String, ObjectData> entry : reciveList.entrySet()) {
                ObjectData objectData = entry.getValue();
                reciveList.remove(entry.getKey());
                return objectData;


            }
        }
        return null;
    }


}
