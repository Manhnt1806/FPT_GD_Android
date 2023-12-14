package manhntph29583.baithi.demo_crud_recyclerview.DTO;

public class Product {
    int id;
    String name;
    int image_res;

    public Product(){  }

    public Product(int id, String name, int image_res) {
        this.id = id;
        this.name = name;
        this.image_res = image_res;
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

    public int getImage_res() {
        return image_res;
    }

    public void setImage_res(int image_res) {
        this.image_res = image_res;
    }
}

