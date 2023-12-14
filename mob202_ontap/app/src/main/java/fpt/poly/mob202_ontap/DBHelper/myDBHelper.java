package fpt.poly.mob202_ontap.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class myDBHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "CRUD_APP_NOTE";
    static final int DB_VERSION = 1;
    public myDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sql) {
        String appnote = "create table note_table( id integer not null primary key autoincrement," +
                "content text not null unique," +
                "time text not null);";
        sql.execSQL(appnote);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
