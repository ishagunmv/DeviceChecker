package mysql;

import java.io.Serializable;

public class UsersTable implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String telegram;

    public UsersTable(){ }

    public UsersTable(String name, String telegram) {
        this.name = name;
        this.telegram = telegram;
    }

    public UsersTable(int id, String name, String telegram) {
        this.id = id;
        this.name = name;
        this.telegram = telegram;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }
}
