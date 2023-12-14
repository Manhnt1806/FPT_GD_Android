package manhntph29583.baithi.demodethi.DataBasse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "crub_db";
    static final int DB_VERSION = 1;
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE tb_group(id_group INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, username_gr TEXT NOT NULL UNIQUE)";
        sqLiteDatabase.execSQL(sql);
         sql = "CREATE TABLE tb_user(id_user INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, username TEXT NOT NULL UNIQUE, passwd TEXT NOT NULL, fullname TEXT NOT NULL, phone TEXT NOT NULL, birth DATE NOT NULL, id_group INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_user");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_group");
        onCreate(sqLiteDatabase);
    }
}
