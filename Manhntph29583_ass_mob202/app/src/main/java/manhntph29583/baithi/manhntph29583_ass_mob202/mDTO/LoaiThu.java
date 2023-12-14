package manhntph29583.baithi.manhntph29583_ass_mob202.mDTO;

public class LoaiThu {
    int id_loaithu;
    String ten_loaithu;

    public LoaiThu(int id_loaithu, String ten_loaithu) {
        this.id_loaithu = id_loaithu;
        this.ten_loaithu = ten_loaithu;
    }

    public LoaiThu(String ten_loaithu) {this.ten_loaithu = ten_loaithu;}

    @Override
    public String toString() {
        return ten_loaithu;
    }

    public int getId_loaithu() {
        return id_loaithu;
    }

    public void setId_loaithu(int id_loaithu) {
        this.id_loaithu = id_loaithu;
    }

    public String getTen_loaithu() {return ten_loaithu;}

    public void setTen_loaithu(String ten_loaithu) {
        this.ten_loaithu = ten_loaithu;
    }
}
