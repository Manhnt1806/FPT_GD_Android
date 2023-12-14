package manhntph29583.baithi.demodethi.DTO;

import java.util.Date;

public class User {
    int idUser;
    String userName;
    String passWd;
    String fullName;
    String phone;
    Date birth;
    int id_group;

    public User(int idUser, String userName, String passWd, String fullName, String phone, Date birth, int id_group) {
        this.idUser = idUser;
        this.userName = userName;
        this.passWd = passWd;
        this.fullName = fullName;
        this.phone = phone;
        this.birth = birth;
        this.id_group = id_group;
    }

    public User(String userName, String passWd, String fullName, String phone, Date birth, int id_group) {
        this.userName = userName;
        this.passWd = passWd;
        this.fullName = fullName;
        this.phone = phone;
        this.birth = birth;
        this.id_group = id_group;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }
}
