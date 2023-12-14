package manhntph29583.baithi.manhntph29583_ass_mob202.mDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.LoaiChi;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDatabase.DbHelper;

public class LoaiChiDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;

    public LoaiChiDAO(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<LoaiChi> getAll(){
        db = dbHelper.getReadableDatabase();
        ArrayList<LoaiChi> listLC = new ArrayList<>();
        Cursor cs = db.rawQuery("SELECT id_loaichi, ten_loaichi FROM tb_loaichi ORDER BY id_loaichi ASC", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            int _id_loaichi = cs.getInt(0);
            String _ten_loaichi = cs.getString(1);
            LoaiChi lc = new LoaiChi(_id_loaichi, _ten_loaichi);
            listLC.add(lc);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return listLC;
    }

    public boolean insertRow(LoaiChi objLoaichi){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten_loaichi", objLoaichi.getTen_loaichi());
        long row = db.insert("tb_loaichi", null, values);
        return (row>0);
    }
    public boolean insertRow(String ten_loaichi){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten_loaichi", ten_loaichi);
        long row = db.insert("tb_loaichi", null, values);
        return (row>0);
    }
    public boolean updateRow(LoaiChi objLoaichi){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten_loaichi", objLoaichi.getTen_loaichi());
        String [] tham_so = new String[] {objLoaichi.getId_loaichi() + ""};
        int row = db.update("tb_loaichi", values, "id_loaichi=?", tham_so);
        return (row>0);
    }
    public boolean deleteRow(int objLoaichi){
        db = dbHelper.getWritableDatabase();
        String [] tham_so = new String[] {objLoaichi + ""};
        int row = db.delete("tb_loaichi","id_loaichi=?", tham_so);
        return(row>0);
    }
}
