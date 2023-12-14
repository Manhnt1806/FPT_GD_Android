package manhntph29583.baithi.demodethi.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import manhntph29583.baithi.demodethi.DTO.User;
import manhntph29583.baithi.demodethi.DataBasse.DbHelper;

public class UserDao {
    SQLiteDatabase db;
    DbHelper dbHelper;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public UserDao(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<User> getAll() {
        ArrayList<User> list = new ArrayList<>();
        db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM tb_user";
        Cursor cs = db.rawQuery(sql, null);
        if (cs.getCount() > 0) {
            cs.moveToFirst();
            do {
                int _id_user = cs.getInt(0);
                String _username = cs.getString(1);
                String _passwd = cs.getString(2);
                String _fullname = cs.getString(3);
                String _phone = cs.getString(4);
                Date _birth = new Date(System.currentTimeMillis());
                try {
                    _birth = sdf.parse(cs.getString(5));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int _id_group = cs.getInt(6);
                list.add(new User(_id_user, _username, _passwd, _fullname, _phone, _birth, _id_group));
            } while (cs.moveToNext());
        }
        cs.close();
        db.close();
        return list;
    }

    public boolean insertRow(User obj) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", obj.getIdUser());
        values.put("passwd", obj.getPassWd());
        values.put("fullname", obj.getFullName());
        values.put("phone", obj.getPhone());
        values.put("birth", sdf.format(obj.getBirth()));
        values.put("id_group", obj.getId_group());

        long row = db.insert("tb_user", null, values);
        return (row > 0);
    }
    public boolean updateRow(User obj) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", obj.getIdUser());
        values.put("passwd", obj.getPassWd());
        values.put("fullname", obj.getFullName());
        values.put("phone", obj.getPhone());
        values.put("birth", sdf.format(obj.getBirth()));
        values.put("id_group", obj.getId_group());
        String[] tham_so = new String[]{obj.getIdUser() + ""};
        int row = db.update("tb_user", values, "id_user = ?", tham_so);
        return (row > 0);
    }

    public boolean deleteRow(int obj) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] tham_so = new String[]{obj + ""};
        int row = db.delete("tb_user", "id_user=?", tham_so);
        return (row > 0);
    }
}
