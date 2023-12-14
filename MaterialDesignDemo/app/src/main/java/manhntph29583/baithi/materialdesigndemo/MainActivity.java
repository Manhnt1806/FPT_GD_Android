package manhntph29583.baithi.materialdesigndemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    TextInputLayout inputUsername, inputPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btn_login);
        inputUsername = findViewById(R.id.input_username);
        inputPass = findViewById(R.id.input_password);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = inputUsername.getEditText().getText().toString();
                String pass = inputPass.getEditText().getText().toString();
                if(user.length()<6){
                    inputUsername.setError("Username có ít nhất 6 ký tự");
                }else{
                    inputUsername.setError(null);
                }
                if(pass.length()<6){
                    inputPass.setError("Password có ít nhất 6 ký tự");
                }else{
                    inputPass.setError(null);
                }
            }
        });
        BottomNavigationView buBottomNavigationView = findViewById(R.id.bnav);
        buBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bmenu_home:
                    Toast.makeText(MainActivity.this, "Chọn Home", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.bmenu_contact:
                        Toast.makeText(MainActivity.this, "Chọn Contact", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bmenu_settings:
                        Toast.makeText(MainActivity.this, "Chọn Settings", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}