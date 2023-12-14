package manhntph29583.baithi.manhntph29583_ass_mob202.mDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.LoaiThu;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDatabase.DbHelper;

public class LoaiThuDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;

    public LoaiThuDAO(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public ArrayList<LoaiThu> getAll(){
        db = dbHelper.getReadableDatabase();
        ArrayList<LoaiThu> listLT = new ArrayList<>();
        Cursor cs = db.rawQuery("SELECT id_loaithu, ten_loaithu FROM tb_loaithu ORDER BY id_loaithu ASC", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            int _id_loaithu = cs.getInt(0);
            String _ten_loaithu = cs.getString(1);
            LoaiThu lt = new LoaiThu(_id_loaithu, _ten_loaithu);
            listLT.add(lt);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return listLT;
    }

    public boolean insertRow(LoaiThu objLoaithu){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten_loaithu", objLoaithu.getTen_loaithu());
        long row = db.insert("tb_loaithu", null, values);
        return (row>0);
    }
    public boolean insertRow(String ten_loaithu){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten_loaithu", ten_loaithu);
        long row = db.insert("tb_loaithu", null, values);
        return (row>0);
    }
    public boolean updateRow(LoaiThu objLoaithu){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten_loaithu", objLoaithu.getTen_loaithu());
        String [] tham_so = new String[] {objLoaithu.getId_loaithu() + ""};
        int row = db.update("tb_loaithu", values, "id_loaithu=?", tham_so);
        return (row>0);
    }
    public boolean deleteRow(int objLoaiThu){
        db = dbHelper.getWritableDatabase();
        String [] tham_so = new String[] {objLoaiThu + ""};
        int row = db.delete("tb_loaithu","id_loaithu=?", tham_so);
        return(row>0);
    }
}
