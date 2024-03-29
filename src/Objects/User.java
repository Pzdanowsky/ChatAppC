package Objects;

public class User {

    private static User instance;

    private int userID;
    private String username;
    private String sessionNumber;
    private String sessionToken;
    private String password;
    private boolean authenticated;
    private String name;
    private String surname;
    private String email;



    public static User getInstance(){
        if(instance == null){
            instance = new User();
        }
        return instance;
    }

    private User(){
    this.sessionNumber = "00000";
    this.sessionToken = "0000000000";
    this.authenticated = false;
    this.name = "null";
    this.surname = "null";
    this.email = "null";
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}