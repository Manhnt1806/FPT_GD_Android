package manhntph29583.baithi.manhntph29583_ass_mob202.mDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.KhoanChi;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.ThongKeKT;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.ThongKeLC;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDatabase.DbHelper;

public class KhoanChiDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public KhoanChiDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<KhoanChi> getAll() {
        ArrayList<KhoanChi> listKC = new ArrayList<>();
        db = dbHelper.getReadableDatabase();
        String sql = "SELECT k.id_khoanchi, k.tien_chi, k.note_chi, k.ngay_chi, k.id_loaichi, l.ten_loaichi FROM tb_khoanchi k, tb_loaichi l WHERE k.id_loaichi = l.id_loaichi";
        Cursor cs = db.rawQuery(sql, null);
        if (cs.getCount() > 0) {
            cs.moveToFirst();
            do {
                int _id_khoanchi = cs.getInt(0);
                int _tien_chi = cs.getInt(1);
                String _note_chi = cs.getString(2);
                Date _ngay_chi = new Date(System.currentTimeMillis());
                try {
                    _ngay_chi = sdf.parse(cs.getString(3));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int _id_loaichi = cs.getInt(4);
                String _ten_loaichi = cs.getString(5);
                listKC.add(new KhoanChi(_id_khoanchi, _tien_chi, _note_chi, _ngay_chi, _id_loaichi, _ten_loaichi));
            } while (cs.moveToNext());
        }
        cs.close();
        db.close();
        return listKC;
    }

    public boolean insertRow(KhoanChi objKhoanchi) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ngay_chi", sdf.format(objKhoanchi.getNgay_chi()));
        values.put("id_loaichi", objKhoanchi.getId_loaichi());
        values.put("tien_chi", objKhoanchi.getTien_chi());
        values.put("note_chi", objKhoanchi.getNote_chi());
        long row = db.insert("tb_khoanchi", null, values);
        return (row > 0);
    }

    public boolean updateRow(KhoanChi objKhoanchi) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tien_chi", objKhoanchi.getTien_chi());
        values.put("note_chi", objKhoanchi.getNote_chi());
        values.put("ngay_chi", sdf.format(objKhoanchi.getNgay_chi()));
        values.put("id_loaichi", objKhoanchi.getId_loaichi());
        String[] tham_so = new String[]{objKhoanchi.getId_khoanchi() + ""};
        int row = db.update("tb_khoanchi", values, "id_khoanchi = ?", tham_so);
        return (row > 0);
    }

    public boolean deleteRow(int objKhoanchi) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] tham_so = new String[]{objKhoanchi + ""};
        int row = db.delete("tb_khoanchi", "id_khoanchi=?", tham_so);
        return (row > 0);
    }

    public int getTongChi() {
        db = dbHelper.getWritableDatabase();
        int chi = 0;
        Cursor cs = db.rawQuery("SELECT SUM(tien_chi) FROM tb_khoanchi", null);
        if (cs.getCount() != 0) {
            cs.moveToFirst();
            chi = cs.getInt(0);
        }
        return chi;
    }

    public ArrayList<ThongKeLC> getTongChiTP() {
        ArrayList<ThongKeLC> listTKC = new ArrayList<>();
        db = dbHelper.getWritableDatabase();
        Cursor cs = db.rawQuery("SELECT l.id_loaichi, l.ten_loaichi, SUM(k.tien_chi) FROM tb_loaichi l , tb_khoanchi k WHERE l.id_loaichi=k.id_loaichi GROUP BY l.id_loaichi, l.ten_loaichi", null);
        if (cs.getCount() > 0) {
            cs.moveToFirst();
            do {
                int idChiTP = cs.getInt(0);
                String tenchiTP = cs.getString(1);
                int chiTP = cs.getInt(2);
                listTKC.add(new ThongKeLC(idChiTP, tenchiTP, chiTP));
            } while (cs.moveToNext());
        }
        return listTKC;
    }
}
