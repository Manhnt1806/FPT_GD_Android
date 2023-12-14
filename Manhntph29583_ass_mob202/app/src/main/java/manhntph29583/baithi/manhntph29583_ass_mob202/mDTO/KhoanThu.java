package manhntph29583.baithi.manhntph29583_ass_mob202.mDTO;

import java.util.Date;

public class KhoanThu {
    int id_khoanthu;
    int tien_thu;
    String note_thu;
    Date ngay_thu;
    int id_loaithu;
    String ten_loaithu;

    public KhoanThu(int id_khoanthu, int tien_thu, String note_thu, Date ngay_thu, int id_loaithu, String ten_loaithu) {
        this.id_khoanthu = id_khoanthu;
        this.tien_thu = tien_thu;
        this.note_thu = note_thu;
        this.ngay_thu = ngay_thu;
        this.id_loaithu = id_loaithu;
        this.ten_loaithu = ten_loaithu;
    }

    public KhoanThu(int id_khoanthu, int tien_thu, String note_thu, Date ngay_thu, int id_loaithu) {
        this.id_khoanthu = id_khoanthu;
        this.tien_thu = tien_thu;
        this.note_thu = note_thu;
        this.ngay_thu = ngay_thu;
        this.id_loaithu = id_loaithu;
    }

    public KhoanThu(int tien_thu, String note_thu, Date ngay_thu, int id_loaithu) {
        this.tien_thu = tien_thu;
        this.note_thu = note_thu;
        this.ngay_thu = ngay_thu;
        this.id_loaithu = id_loaithu;
    }

    public int getId_khoanthu() {
        return id_khoanthu;
    }

    public void setId_khoanthu(int id_khoanthu) {
        this.id_khoanthu = id_khoanthu;
    }

    public int getTien_thu() {
        return tien_thu;
    }

    public void setTien_thu(int tien_thu) {
        this.tien_thu = tien_thu;
    }

    public String getNote_thu() {
        return note_thu;
    }

    public void setNote_thu(String note_thu) {
        this.note_thu = note_thu;
    }

    public Date getNgay_thu() {
        return ngay_thu;
    }

    public void setNgay_thu(Date ngay_thu) {
        this.ngay_thu = ngay_thu;
    }

    public int getId_loaithu() {
        return id_loaithu;
    }

    public void setId_loaithu(int id_loaithu) {
        this.id_loaithu = id_loaithu;
    }

    public String getTen_loaithu() {
        return ten_loaithu;
    }

    public void setTen_loaithu(String ten_loaithu) {
        this.ten_loaithu = ten_loaithu;
    }
}



















