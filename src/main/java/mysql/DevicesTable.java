package mysql;

import java.io.Serializable;

public class DevicesTable implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String ip;
    private String arch;
    private String status;
    private int usersId;

    public DevicesTable(){ }

    public DevicesTable(String ip, String arch, String status, int usersId) {
        this.ip = ip;
        this.arch = arch;
        this.status = status;
        this.usersId = usersId;
    }

    public DevicesTable(int id, String ip, String arch, String status, int usersId) {
        this.id = id;
        this.ip = ip;
        this.arch = arch;
        this.status = status;
        this.usersId = usersId;
    }

    public int getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }
}