package manhntph29583.baithi.demoadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    ListView lv01;
    GridView grid01;
    Spinner spin01;

    String dssp[] = {"Xe máy", "Tivi","Máy tính", "Điện thoại"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv01 = findViewById(R.id.lv01);
        grid01 = findViewById(R.id.grid01);
        spin01 = findViewById(R.id.spinner01);

        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dssp);

        lv01.setAdapter( adapter );
        grid01.setAdapter( adapter );
        spin01.setAdapter( adapter );
    }
}