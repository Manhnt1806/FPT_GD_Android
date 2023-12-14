package manhntph29583.baithi.demo_toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar mToolBar;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolBar = findViewById(R.id.myToolBar);
        tv = findViewById(R.id.tv_Hello);
        setSupportActionBar(mToolBar); //cài đặt vai trò actionbar
        getSupportActionBar().setDisplayShowTitleEnabled(false); //ẩn tittle actionbar
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ActivityCon.class);
                startActivity(i);
            }
        });
        registerForContextMenu(tv);//Đăng ký contextmenu cho textview
    }

    //----------------làm việc với option menu--------------

    @Override //Khởi tạo menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.demo_menu01, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override //tương tác với menu
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnu_01:
                Toast.makeText(this, "Chọn menu 01", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnu_02:
                Toast.makeText(this, "Chọn menu 02", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnu_03:
                Toast.makeText(this, "Chọn menu 03", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //-------------Làm việc với contextMenu------------------

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.demo_menu01, menu);
        //thêm cho contextmenu
        menu.setHeaderTitle("Đây là tiêu đề menu");
        //quay lên hàm onCreate để đăng ký contextmenu cho view
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnu_01:
                Toast.makeText(this, "Chọn menu 01", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnu_02:
                Toast.makeText(this, "Chọn menu 02", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnu_03:
                Toast.makeText(this, "Chọn menu 03", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}