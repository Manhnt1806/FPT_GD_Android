package manhntph29583.baithi.demo_tonghop_manhntph29583.DTO;

public class content {
    int id_ds;
    String tittle;
    String content;

    public content(int id_ds, String tittle, String content) {
        this.id_ds = id_ds;
        this.tittle = tittle;
        this.content = content;
    }

    public content(String tittle, String content) {
        this.tittle = tittle;
        this.content = content;
    }

    public int getId_ds() {
        return id_ds;
    }

    public void setId_ds(int id_ds) {
        this.id_ds = id_ds;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
