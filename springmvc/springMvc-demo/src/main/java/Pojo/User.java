package Pojo;

public class User {
    String name;
    String paw;

    public User(String name, String paw) {
        this.name = name;
        this.paw = paw;
    }

    public User() {
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return paw;
    }

    public void setPassWord(String paw) {
        this.paw = paw;
    }
}
