package manhntph29583.baithi.manhntph29583_ass_mob202.mDTO;

import java.util.Date;

public class ThongKeLC {
    int idChiTP;
    String tenchiTP;
    int chiTP;

    public ThongKeLC(int idChiTP, String tenchiTP, int chiTP) {
        this.idChiTP = idChiTP;
        this.tenchiTP = tenchiTP;
        this.chiTP = chiTP;
    }

    public ThongKeLC(String tenchiTP, int chiTP) {
        this.tenchiTP = tenchiTP;
        this.chiTP = chiTP;
    }


    public int getIdChiTP() {
        return idChiTP;
    }

    public void setIdChiTP(int idChiTP) {
        this.idChiTP = idChiTP;
    }

    public String getTenchiTP() {
        return tenchiTP;
    }

    public void setTenchiTP(String tenchiTP) {
        this.tenchiTP = tenchiTP;
    }

    public int getChiTP() {
        return chiTP;
    }

    public void setChiTP(int chiTP) {
        this.chiTP = chiTP;
    }
}
