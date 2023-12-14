package manhntph29583.baithi.demo_crud_recyclerview.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "demo_crud_product_cp18103";
    static final int DB_VERSION = 1;
    public MyDbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE  tb_product  (id  INTEGER NOT NULL,name  TEXT NOT NULL,img_res  INTEGER,PRIMARY KEY( id  AUTOINCREMENT))";
        sqLiteDatabase.execSQL( sql );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

