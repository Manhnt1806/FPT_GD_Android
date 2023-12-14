package manhntph29583.baithi.manhntph29583_ass_mob202.mDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.KhoanThu;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.ThongKeKT;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.ThongKeLC;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDatabase.DbHelper;

public class KhoanThuDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public KhoanThuDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    public ArrayList<KhoanThu>  getAll(){
        ArrayList<KhoanThu> listKT = new ArrayList<>();
        db = dbHelper.getReadableDatabase();
        String sql = "SELECT k.id_khoanthu, k.tien_thu, k.note_thu, k.ngay_thu, k.id_loaithu, l.ten_loaithu FROM tb_khoanthu k, tb_loaithu l WHERE k.id_loaithu = l.id_loaithu";
        Cursor cs = db.rawQuery(sql, null);
        if (cs.getCount()>0) {
            cs.moveToFirst();
            do{
                int _id_khoanthu = cs.getInt(0);
                int _tien_thu = cs.getInt(1);
                String _note_thu = cs.getString(2);
                Date _ngay_thu = new Date(System.currentTimeMillis());
                try {
                    _ngay_thu = sdf.parse(cs.getString(3));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int _id_loaithu = cs.getInt(4);
                String _ten_loaithu = cs.getString(5);
                listKT.add(new KhoanThu(_id_khoanthu, _tien_thu, _note_thu, _ngay_thu, _id_loaithu, _ten_loaithu));
            }while (cs.moveToNext());
        }
        cs.close();
        db.close();
        return listKT;
    }

    public boolean insertRow(KhoanThu objKhoanthu){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ngay_thu", sdf.format(objKhoanthu.getNgay_thu()));
        values.put("id_loaithu", objKhoanthu.getId_loaithu());
        values.put("tien_thu", objKhoanthu.getTien_thu());
        values.put("note_thu", objKhoanthu.getNote_thu());
        long row = db.insert("tb_khoanthu", null, values);
        return (row>0);
    }
    public boolean updateRow(KhoanThu objKhoanthu){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tien_thu", objKhoanthu.getTien_thu());
        values.put("note_thu", objKhoanthu.getNote_thu());
        values.put("ngay_thu", sdf.format(objKhoanthu.getNgay_thu()));
        values.put("id_loaithu", objKhoanthu.getId_loaithu());
        String [] tham_so = new String[] {objKhoanthu.getId_khoanthu() + ""};
        int row = db.update("tb_khoanthu", values, "id_khoanthu = ?", tham_so);
        return (row > 0);
    }
    public boolean deleteRow(int objKhoanthu){
        db = dbHelper.getWritableDatabase();
        String [] tham_so = new String[] {objKhoanthu + ""};
        int row = db.delete("tb_khoanthu","id_khoanthu=?", tham_so);
        return(row > 0);
    }
    public int getTongThu(){
        db = dbHelper.getWritableDatabase();
        int thu = 0;
        Cursor cs = db.rawQuery("SELECT SUM(tien_thu) FROM tb_khoanthu", null);
        if(cs.getCount()!=0){
            cs.moveToFirst();
            thu =cs.getInt(0);
        }
        return  thu;
    }
    public ArrayList<ThongKeKT> getTongThuTP() {
        ArrayList<ThongKeKT> listTKT = new ArrayList<>();
        db = dbHelper.getWritableDatabase();
        Cursor cs = db.rawQuery("SELECT l.id_loaithu, l.ten_loaithu, SUM(k.tien_thu) FROM tb_loaithu l , tb_khoanthu k WHERE l.id_loaithu=k.id_loaithu GROUP BY l.id_loaithu, l.ten_loaithu", null);
        if (cs.getCount() > 0) {
            cs.moveToFirst();
            do {
                int idThuTP = cs.getInt(0);
                String tenThuTP = cs.getString(1);
                int thuTP = cs.getInt(2);
                listTKT.add(new ThongKeKT(idThuTP, tenThuTP, thuTP));
            } while (cs.moveToNext());
        }
        return listTKT;
    }


}
