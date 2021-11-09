import javax.imageio.IIOException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReciveService extends Thread{

    private static ObjectInputStream objectIn;

    private static ObjectData objectDataRecive;


    ReciveService(){
        try {
            objectIn = ServerSocketConnection.getObjectIn();
        }catch(Exception e){
            System.err.println(e);
        }
        System.out.println("Thread recive done!");
    }



    @Override
    public  void run() {
        System.out.println("Thread recive run");

        while(true) {

            try {
                objectDataRecive = (ObjectData) objectIn.readObject();
                if(objectDataRecive != null) {
                    System.out.println(objectDataRecive.getData());

                    if(User.getInstance().checkEqualsToken("00000")){
                        User.getInstance().setSessionToken(objectDataRecive.getSesionToken());
                        User.getInstance().setSessionNumber(objectDataRecive.getSessionNumber());
                    }

                       DataReciveRepository.getInstance().addDataRecive(objectDataRecive);

                }

            }catch(IOException e){
                e.printStackTrace();
                System.out.println("Send to server ERROR in ReciveService:run()");
            }catch(ClassNotFoundException ex){
                System.err.println(ex);
            }

        }
    }


    public boolean checkUserData(ObjectData objectDataRecive){
        if(User.getInstance().checkEqualsToken("00000")){
            User.getInstance().setSessionToken(objectDataRecive.getSesionToken());
            User.getInstance().setSessionNumber(objectDataRecive.getSessionNumber());
            return true;
        }else if(User.getInstance().checkEqualsToken(objectDataRecive.getSesionToken())){
            System.out.println("Dobry token");
            return true;
        }
       return false;
    }
}
