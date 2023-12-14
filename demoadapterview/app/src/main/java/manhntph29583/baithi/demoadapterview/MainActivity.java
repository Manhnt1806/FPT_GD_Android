package manhntph29583.baithi.demoadapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ListView lv01;
    GridView grid01;
    Spinner spin01;
    List<Product> dssp; // khai báo ở phạm vi class để truy cập được trong các hàm click

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv01 = findViewById(R.id.lv01);
        grid01 = findViewById(R.id.grid01);
        spin01 = findViewById(R.id.spinner01);

        dssp = new ArrayList<Product>();

        dssp.add(    new Product(1,"Máy tính", R.drawable.loi)     );
        dssp.add(    new Product(2,"Máy tính222", R.drawable.loi )     );
        dssp.add(    new Product(3,"Máy tính333", R.drawable.loi )     );
        dssp.add(    new Product(4,"Máy tính444", R.drawable.loi )     );

        ProductAdapter adapter = new ProductAdapter(dssp);
        lv01.setAdapter( adapter );
        grid01.setAdapter(adapter);

        spin01.setAdapter(adapter);
        // tương tác với listview và gridview

        lv01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // xử lý click vào 1 dòng
            }
        });
        // tương tác với spinner
        spin01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // tương tác ở đây.....
                Product sanpham = dssp.get(i);
                Toast.makeText(MainActivity.this, "ID SP = " + sanpham.getId() + "----" + sanpham.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}