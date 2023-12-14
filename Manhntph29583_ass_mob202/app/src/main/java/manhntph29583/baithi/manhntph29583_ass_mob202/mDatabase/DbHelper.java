package manhntph29583.baithi.manhntph29583_ass_mob202.mDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "crub_thu_chi";
    static final int DB_VERSION = 1;
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE tb_loaithu(id_loaithu INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ten_loaithu TEXT NOT NULL UNIQUE)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_loaithu VALUES(null, 'Tiền lương')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_loaithu VALUES(null, 'Làm thêm')";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE tb_loaichi(id_loaichi INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ten_loaichi TEXT NOT NULL UNIQUE)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_loaichi VALUES(null, 'Hưởng thụ')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_loaichi VALUES(null, 'Quỹ giáo dục')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_loaichi VALUES(null, 'Quỹ đầu tư')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_loaichi VALUES(null, 'Quỹ từ thiện')";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE tb_khoanthu(id_khoanthu INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, tien_thu INTEGER NOT NULL, note_thu TEXT, ngay_thu DATE NOT NULL, id_loaithu INTEGER NOT NULL )";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_khoanthu VALUES(null, 1000, 'Bán hàng online', '2022/10/18', 2)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_khoanthu VALUES(null, 1000, 'Lương tháng 11', '2022/11/01', 1)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_khoanthu VALUES(null, 1500, 'Giao hàng', '2022/11/01', 2)";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE tb_khoanchi(id_khoanchi INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, tien_chi INTEGER NOT NULL, note_chi TEXT, ngay_chi DATE NOT NULL,  id_loaichi INTEGER NOT NULL )";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_khoanchi VALUES(null, 3600, 'Từ thiện', '18/06/2003', 4)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_khoanchi VALUES(null, 43000, 'Tiền tiết kiệm', '20/11/2022', 3)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO tb_khoanchi VALUES(null, 2000, 'Ăn nướng', '11/11/2222', 1)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_loaithu");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_loaichi");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_khoanthu");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_khoanchi");
        onCreate(sqLiteDatabase);
    }
}
