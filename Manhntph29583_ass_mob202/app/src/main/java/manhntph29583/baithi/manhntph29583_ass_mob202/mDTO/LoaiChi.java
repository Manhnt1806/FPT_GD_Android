package manhntph29583.baithi.manhntph29583_ass_mob202.mDTO;

public class LoaiChi {
    int id_loaichi;
    String ten_loaichi;

    public LoaiChi(int id_loaichi, String ten_loaichi) {
        this.id_loaichi = id_loaichi;
        this.ten_loaichi = ten_loaichi;
    }

    public LoaiChi(String ten_loaichi) {this.ten_loaichi = ten_loaichi;}

    @Override
    public String toString() {
        return ten_loaichi;
    }

    public int getId_loaichi() {
        return id_loaichi;
    }

    public void setId_loaichi(int id_loaichi) {
        this.id_loaichi = id_loaichi;
    }

    public String getTen_loaichi() {return ten_loaichi;}

    public void setTen_loaichi(String ten_loaichi) {
        this.ten_loaichi = ten_loaichi;
    }
}

