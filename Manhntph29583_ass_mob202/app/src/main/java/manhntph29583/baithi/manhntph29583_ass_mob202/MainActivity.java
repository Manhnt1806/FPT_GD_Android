package manhntph29583.baithi.manhntph29583_ass_mob202;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import manhntph29583.baithi.manhntph29583_ass_mob202.mAdapter.KhoanChiAdapter;
import manhntph29583.baithi.manhntph29583_ass_mob202.mFragment.GioiThieuFrag;
import manhntph29583.baithi.manhntph29583_ass_mob202.mFragment.PhanLoaiFrag;
import manhntph29583.baithi.manhntph29583_ass_mob202.mFragment.QuanLyFrag;
import manhntph29583.baithi.manhntph29583_ass_mob202.mFragment.ThongKeFrag;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;
    TextView tvToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        tvToolBar = findViewById(R.id.tv_toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar, R.string.nav_open, R.string.nav_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new ThongKeFrag());
        navigationView.getMenu().findItem(R.id.nav_thongKe).setChecked(true);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        Fragment fragment = new Fragment();
        switch (itemId){
            case R.id.nav_thongKe:
                fragment = new ThongKeFrag();
                tvToolBar.setText("Thống kê");
                break;
            case R.id.nav_QLTC:
                fragment = new QuanLyFrag();
                tvToolBar.setText("Quản lý thu chi");
                break;
            case R.id.nav_PLTC:
                fragment = new PhanLoaiFrag();
                tvToolBar.setText("Phân loại thu chi");
                break;
            case R.id.nav_info:
                fragment = new GioiThieuFrag();
                tvToolBar.setText("Giới thiệu");
                break;
            case R.id.nav_exit:
                AlertDialog.Builder mDialog = new AlertDialog.Builder(this);
                mDialog.setTitle("Question");
                mDialog.setMessage("Are you sure You want to Exit?");
                mDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), ScreenDangNhap.class);
                        startActivity(intent);
                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startActivity(startMain);
                        finish();
                    }
                });
                mDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                mDialog.create().show();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment).addToBackStack(null).commit();
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }


}