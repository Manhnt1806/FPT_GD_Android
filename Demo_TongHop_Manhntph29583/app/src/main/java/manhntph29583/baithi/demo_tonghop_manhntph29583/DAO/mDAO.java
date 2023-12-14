package manhntph29583.baithi.demo_tonghop_manhntph29583.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import manhntph29583.baithi.demo_tonghop_manhntph29583.DTO.content;
import manhntph29583.baithi.demo_tonghop_manhntph29583.Database.DbHelper;

public class mDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;
    public mDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<content> getAll() {
        ArrayList<content> listDS = new ArrayList<>();
        db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM tb_content ORDER BY id_content ASC";
        Cursor cs = db.rawQuery(sql, null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            int _id_ds = cs.getInt(0);
            String _tittle = cs.getString(1);
            String _content = cs.getString(2);
            content ds = new content(_id_ds, _tittle, _content);
            listDS.add(ds);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return listDS;
    }
    public boolean insertRow(content obj) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("tittle", obj.getTittle());
        values.put("content", obj.getContent());
        long row = db.insert("tb_content", null, values);
        return (row > 0);
    }
    public boolean updateRow(content obj) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_content", obj.getId_ds());
        values.put("tittle", obj.getTittle());
        values.put("content", obj.getContent());
        String[] tham_so = new String[]{obj.getId_ds() + ""};
        int row = db.update("tb_content", values, "id_content = ?", tham_so);
        return (row > 0);
    }

    public boolean deleteRow(int obj) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] tham_so = new String[]{obj + ""};
        int row = db.delete("tb_content", "id_content=?", tham_so);
        return (row > 0);
    }
}
