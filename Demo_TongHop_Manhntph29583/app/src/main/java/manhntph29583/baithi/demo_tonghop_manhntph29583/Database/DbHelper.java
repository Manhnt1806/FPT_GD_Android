package manhntph29583.baithi.demo_tonghop_manhntph29583.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "crub_ds";
    static final int DB_VERSION = 1;
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE tb_content(id_content INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, tittle TEXT NOT NULL, content TEXT NOT NULL)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_content VALUES(null, 'Tiền lương', 'abcd')";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_content");
        onCreate(sqLiteDatabase);
    }
}
