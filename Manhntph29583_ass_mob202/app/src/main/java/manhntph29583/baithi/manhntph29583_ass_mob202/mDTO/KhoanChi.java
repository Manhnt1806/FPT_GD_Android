package manhntph29583.baithi.manhntph29583_ass_mob202.mDTO;

import java.util.Date;

public class KhoanChi {
    int id_khoanchi;
    int tien_chi;
    String note_chi;
    Date ngay_chi;
    int id_loaichi;
    String ten_loaichi;

    public KhoanChi(int id_khoanchi, int tien_chi, String note_chi, Date ngay_chi, int id_loaichi, String ten_loaichi) {
        this.id_khoanchi = id_khoanchi;
        this.tien_chi = tien_chi;
        this.note_chi = note_chi;
        this.ngay_chi = ngay_chi;
        this.id_loaichi = id_loaichi;
        this.ten_loaichi = ten_loaichi;
    }

    public KhoanChi(int id_khoanchi, int tien_chi, String note_chi, Date ngay_chi, int id_loaichi) {
        this.id_khoanchi = id_khoanchi;
        this.tien_chi = tien_chi;
        this.note_chi = note_chi;
        this.ngay_chi = ngay_chi;
        this.id_loaichi = id_loaichi;
    }

    public KhoanChi(int tien_chi, String note_chi, Date ngay_chi, int id_loaichi) {
        this.tien_chi = tien_chi;
        this.note_chi = note_chi;
        this.ngay_chi = ngay_chi;
        this.id_loaichi = id_loaichi;
    }

    public int getId_khoanchi() {
        return id_khoanchi;
    }

    public void setId_khoanchi(int id_khoanchi) {
        this.id_khoanchi = id_khoanchi;
    }

    public int getTien_chi() {return tien_chi;}

    public void setTien_chi(int tien_chi) {
        this.tien_chi = tien_chi;
    }

    public String getNote_chi() {
        return note_chi;
    }

    public void setNote_chi(String note_chi) {
        this.note_chi = note_chi;
    }

    public Date getNgay_chi() {return ngay_chi;}

    public void setNgay_chi(Date ngay_chi) {
        this.ngay_chi = ngay_chi;
    }

    public int getId_loaichi() {
        return id_loaichi;
    }

    public void setId_loaichi(int id_loaichi) {
        this.id_loaichi = id_loaichi;
    }

    public String getTen_loaichi() {
        return ten_loaichi;
    }

    public void setTen_loaichi(String ten_loaichi) {
        this.ten_loaichi = ten_loaichi;
    }
}
