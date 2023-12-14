package manhntph29583.baithi.manhntph29583_ass_mob202.mDTO;

public class ThongKeKT {
    int idThuTP;
    String tenThuTP;
    int thuTP;

    public ThongKeKT(int idThuTP, String tenThuTP, int thuTP) {
        this.idThuTP = idThuTP;
        this.tenThuTP = tenThuTP;
        this.thuTP = thuTP;
    }

    public ThongKeKT(String tenThuTP, int thuTP) {
        this.tenThuTP = tenThuTP;
        this.thuTP = thuTP;
    }

    public int getIdThuTP() {
        return idThuTP;
    }

    public void setIdThuTP(int idThuTP) {
        this.idThuTP = idThuTP;
    }

    public String getTenThuTP() {
        return tenThuTP;
    }

    public void setTenThuTP(String tenThuTP) {
        this.tenThuTP = tenThuTP;
    }

    public int getThuTP() {
        return thuTP;
    }

    public void setThuTP(int thuTP) {
        this.thuTP = thuTP;
    }
}
