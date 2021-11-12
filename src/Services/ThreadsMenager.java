package Services;

public class ThreadsMenager {

    private static ThreadsMenager instance;

    private static Thread reciveThread;


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
        reciveThread.start();
    }

    public void stopRecive(){
        reciveThread.stop();
    }

}
