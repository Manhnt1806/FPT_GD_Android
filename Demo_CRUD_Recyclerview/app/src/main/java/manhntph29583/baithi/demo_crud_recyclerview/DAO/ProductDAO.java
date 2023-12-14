package manhntph29583.baithi.demo_crud_recyclerview.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import manhntph29583.baithi.demo_crud_recyclerview.DTO.Product;
import manhntph29583.baithi.demo_crud_recyclerview.Database.MyDbHelper;


public class ProductDAO {
    SQLiteDatabase db;
    MyDbHelper myDbHelper;
    // viết hàm khởi tạo:
    public ProductDAO(Context context){
        myDbHelper = new MyDbHelper(context);
        db = myDbHelper.getWritableDatabase();
    }
    public void close(){
        myDbHelper.close();
    }
    ///==============================
    public List<Product> selectAll(){
        //1. Tạo biến list để chứa ds tạm
        List<Product> listPro = new ArrayList<Product>();

        Cursor c = db.rawQuery("SELECT id,name, img_res FROM tb_product ORDER BY id ASC",null);

        if(c.moveToFirst()){
            // có dữ liệu
            while (!c.isAfterLast()){
                // đọc từng dòng
//                id,name, img_res: 0, 1, 2
                int _id = c.getInt(0);
                String _name = c.getString(1);
                int _img_res = c.getInt(2);

                Product tmpPro = new Product(_id, _name,_img_res );
                listPro.add( tmpPro );
                // không bao giờ quên lệnh dưới
                c.moveToNext();
            }

        }else{
            // không có dữ liệu
            Log.d("zzzzzzzzz", "selectAll: Không có dữ liệu");
        }

        return  listPro;
    }

    public Product selectOne(int id){
        if(id<=0)
            return  null;
        // Tạo chuỗi tham số cho câu lệnh SQL
        String [] tham_so = new String[] {id + ""};

        Cursor c = db.rawQuery("SELECT * FROM tb_product WHERE id = ?", tham_so);

        if(c.moveToFirst()){
            // có dữ liệu
            int _id = c.getInt(0);
            String _name = c.getString(1);
            int _img_res = c.getInt(2);

            Product tmpPro = new Product(_id, _name,_img_res );
            return  tmpPro;

        }else{
            // không có dữ liệu
            return  null;
        }

    }

    public long insertNew(Product objProduct){
        ContentValues values = new ContentValues();
        values.put("name", objProduct.getName() );
        values.put("img_res", objProduct.getImage_res() );
        return  db.insert("tb_product", null, values );
    }

    public int updateRow(Product objProduct){
        ContentValues values = new ContentValues();
        values.put("name", objProduct.getName() );
        values.put("img_res", objProduct.getImage_res() );

        // Tạo chuỗi tham số cho câu lệnh SQL
        String [] tham_so = new String[] {objProduct.getId() + ""};

        return db.update("tb_product",values,"id=?", tham_so);
    }
    public int deleteRow(Product objProduct){
        // Tạo chuỗi tham số cho câu lệnh SQL
        String [] tham_so = new String[] {objProduct.getId() + ""};
        return db.delete("tb_product","id=?", tham_so);
    }
}

