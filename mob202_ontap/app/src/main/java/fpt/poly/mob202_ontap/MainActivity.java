package fpt.poly.mob202_ontap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import fpt.poly.mob202_ontap.Adapter.Adapter_pager;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener, NavigationBarView.OnItemReselectedListener {
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    BottomNavigationView bottomNavigationView;
    ViewPager2 viewPager2;
    Adapter_pager adapter_pager;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav_appnote);
        viewPager2 = findViewById(R.id.view_pager_appnote);
        toolbar = findViewById(R.id.toolbar_appNote);
        adapter_pager = new Adapter_pager(this);
        viewPager2.setAdapter(adapter_pager);
        //vuot man hinh chuyen sang cac fragment
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.danhsach).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.them).setChecked(true);
                        break;
                }
            }
        });
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setOnItemReselectedListener(this);
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.danhsach:
                toolbar.setTitle("Danh sách ghi chú");
                viewPager2.setCurrentItem(0);
                break;
            case R.id.them:
                toolbar.setTitle("Thêm Ghi chú");
                viewPager2.setCurrentItem(1);
                break;
        }
        return true;
    }
}