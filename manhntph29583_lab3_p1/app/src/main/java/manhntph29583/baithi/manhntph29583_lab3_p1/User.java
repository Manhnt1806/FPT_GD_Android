package manhntph29583.baithi.manhntph29583_lab3_p1;

public class User {
    int id;
    String name;
    int img_res;

    public User(int id, String name, int img_res) {
        this.id = id;
        this.name = name;
        this.img_res = img_res;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg_res() {
        return img_res;
    }

    public void setImg_res(int img_res) {
        this.img_res = img_res;
    }
}
