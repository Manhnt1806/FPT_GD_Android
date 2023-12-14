package manhntph29583.baithi.demoadapterview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv_01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv_01 = findViewById(R.id.rcv_01);
        List<Product> list = new ArrayList<>();
        list.add(new Product(1,"Máy tính 1", R.drawable.loi));
        list.add(new Product(2,"Máy tính 2", R.drawable.loi));
        list.add(new Product(3,"Máy tính 3", R.drawable.loi));
        ProductAdapter adapter = new ProductAdapter(this, list);
        rcv_01.setAdapter(adapter);
    }
}