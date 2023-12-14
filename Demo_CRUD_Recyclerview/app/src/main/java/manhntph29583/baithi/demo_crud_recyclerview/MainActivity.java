package manhntph29583.baithi.demo_crud_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import manhntph29583.baithi.demo_crud_recyclerview.Adapter.ProductAdapter;
import manhntph29583.baithi.demo_crud_recyclerview.DAO.ProductDAO;
import manhntph29583.baithi.demo_crud_recyclerview.DTO.Product;


public class MainActivity extends AppCompatActivity {
    EditText ed_name ;
    Button btn_add;
    RecyclerView rc_product ;

    ProductAdapter adapter;
    ProductDAO productDAO;
    List<Product> listPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_name = findViewById(R.id.ed_name);
        btn_add = findViewById(R.id.btn_add);
        rc_product = findViewById(R.id.rc_product);

        productDAO = new ProductDAO(this);
        listPro = productDAO.selectAll();

        adapter = new ProductAdapter(this,listPro);
        rc_product.setAdapter( adapter );

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _name = ed_name.getText().toString();
                Product objPro = new Product();
                objPro.setName( _name );
                objPro.setImage_res(  R.drawable.loi );
                
                long res = productDAO.insertNew(  objPro );
                if(res >0 ){
                    listPro.clear();
                    listPro.addAll( productDAO.selectAll() );
                    // cập nhật giao diện
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Lỗi, xem log đi", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}