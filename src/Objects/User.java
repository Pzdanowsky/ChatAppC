package Objects;

public class User {

    private static User instance;

    private String username;
    private String sessionNumber;
    private String sessionToken;
    private String password;
    private boolean authenticated;



    public static User getInstance(){
        if(instance == null){
            instance = new User();
        }
        return instance;
    }

    public User(){
    this.sessionNumber = "00000";
    this.sessionToken = "0000000000";
    this.authenticated = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(String sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public boolean checkEqualsToken(String sesionToken){
        if(this.sessionToken.equals(sesionToken)){
            return true;
        }
        return false;
    }

    public boolean checkEqualsSesion(String sessionNumber){
        if(this.sessionNumber.equals(sessionNumber)){
            return true;
        }
        return false;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}