package manhntph29583.baithi.manhntph29583_lab3_p1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv = findViewById(R.id.rcv);
        List<User> list = new ArrayList<>();
        list.add(new User(1,"Người nhện", R.drawable.img1));
        list.add(new User(2,"Nguyễn Thế Mạnh", R.drawable.img2));
        list.add(new User(3,"Nguyễn Thị Gấm", R.drawable.img3));
        list.add(new User(4,"Nguyễn Thị Nở", R.drawable.img4));
        list.add(new User(5,"Nguyễn Chí Phèo", R.drawable.img5));
        UserAdapter adapter = new UserAdapter(this, list);
        rcv.setAdapter(adapter);
    }
}