package Managers;

import Panels.LoadPanel;
import Services.ReciveService;

public class ThreadsMenager {

    private static ThreadsMenager instance;

    private static Thread reciveThread;

    private static Thread mainThreadFX;

    private static LoadPanel loadPanels;




    public static ThreadsMenager getInstance(){
        if(instance == null){
            instance = new ThreadsMenager();
        }
        return instance;
    }

    private ThreadsMenager(){

    }

    public void startRecive(ReciveService rs){
        reciveThread = new Thread(rs);
       // reciveThread.setDaemon(true);
        System.out.println(Thread.currentThread());
        reciveThread.start();
    }

    public void stopRecive(){
        reciveThread.stop();
    }

    public Thread getMainThreadFX() {
        return mainThreadFX;
    }

    public  void setMainThreadFX(Thread mainThreadFX) {
        ThreadsMenager.mainThreadFX = mainThreadFX;
    }

    public LoadPanel getLoadPanels() {
        return loadPanels;
    }

    public static void setLoadPanels(LoadPanel loadPanels) {
        System.out.println(loadPanels.toString());
        ThreadsMenager.loadPanels = loadPanels;

    }


    public static LoadPanel waitForPanel(){
        System.out.println(loadPanels.toString());
        return loadPanels;
    }



}
