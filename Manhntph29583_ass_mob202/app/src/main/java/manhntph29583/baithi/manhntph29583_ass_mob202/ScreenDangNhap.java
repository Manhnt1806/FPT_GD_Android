package manhntph29583.baithi.manhntph29583_ass_mob202;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ScreenDangNhap extends AppCompatActivity {
    EditText edPass;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    TextView btnExit;
    ImageView btnDelPass;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_dang_nhap);
        edPass = findViewById(R.id.ed_pass);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDelPass = findViewById(R.id.btn_delpass);
        btnExit = findViewById(R.id.btn_Exit1);
        btnDelPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edPass.setText("");
            }
        });
        edPass.setFocusable(false);
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            edPass.setRawInputType(InputType.TYPE_CLASS_TEXT);
            edPass.setTextIsSelectable(true);
        }
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mDialog = new AlertDialog.Builder(ScreenDangNhap.this);
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
            }
        });
        dangNhap();
    }
    public void dangNhap(){
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = "0";
                if(pass.length() < 4) {
                    pass = edPass.getText().toString() + pass;
                    edPass.setText(pass);
                    if(pass.length()==4 && pass.equals("1234")){
                        Intent intent =new Intent(ScreenDangNhap.this, MainActivity.class);
                        startActivity(intent);
                        edPass.setText("");
                    }else if(pass.length()==4){
                        edPass.setText("");
                        Toast.makeText(ScreenDangNhap.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = "1";
                if(pass.length() < 4) {
                    pass = edPass.getText().toString() + pass;
                    edPass.setText(pass);
                    if(pass.length()==4 && pass.equals("1234")){
                        Intent intent =new Intent(ScreenDangNhap.this, MainActivity.class);
                        startActivity(intent);
                        edPass.setText("");
                    }else if(pass.length()==4){
                        edPass.setText("");
                        Toast.makeText(ScreenDangNhap.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = "2";
                if(pass.length() < 4) {
                    pass = edPass.getText().toString() + pass;
                    edPass.setText(pass);
                    if(pass.length()==4 && pass.equals("1234")){
                        Intent intent =new Intent(ScreenDangNhap.this, MainActivity.class);
                        startActivity(intent);
                        edPass.setText("");
                    }else if(pass.length()==4){
                        edPass.setText("");
                        Toast.makeText(ScreenDangNhap.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = "3";
                if(pass.length() < 4) {
                    pass = edPass.getText().toString() + pass;
                    edPass.setText(pass);
                    if(pass.length()==4 && pass.equals("1234")){
                        Intent intent =new Intent(ScreenDangNhap.this, MainActivity.class);
                        startActivity(intent);
                        edPass.setText("");
                    }else if(pass.length()==4){
                        edPass.setText("");
                        Toast.makeText(ScreenDangNhap.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = "4";
                if(pass.length() < 4) {
                    pass = edPass.getText().toString() + pass;
                    edPass.setText(pass);
                    if(pass.length()==4 && pass.equals("1234")){
                        Intent intent =new Intent(ScreenDangNhap.this, MainActivity.class);
                        startActivity(intent);
                        edPass.setText("");
                    }else if(pass.length()==4){
                        edPass.setText("");
                        Toast.makeText(ScreenDangNhap.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = "5";
                if(pass.length() < 4) {
                    pass = edPass.getText().toString() + pass;
                    edPass.setText(pass);
                    if(pass.length()==4 && pass.equals("1234")){
                        Intent intent =new Intent(ScreenDangNhap.this, MainActivity.class);
                        startActivity(intent);
                        edPass.setText("");
                    }else if(pass.length()==4){
                        edPass.setText("");
                        Toast.makeText(ScreenDangNhap.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = "6";
                if(pass.length() < 4) {
                    pass = edPass.getText().toString() + pass;
                    edPass.setText(pass);
                    if(pass.length()==4 && pass.equals("1234")){
                        Intent intent =new Intent(ScreenDangNhap.this, MainActivity.class);
                        startActivity(intent);
                        edPass.setText("");
                    }else if(pass.length()==4){
                        edPass.setText("");
                        Toast.makeText(ScreenDangNhap.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = "7";
                if(pass.length() < 4) {
                    pass = edPass.getText().toString() + pass;
                    edPass.setText(pass);
                    if(pass.length()==4 && pass.equals("1234")){
                        Intent intent =new Intent(ScreenDangNhap.this, MainActivity.class);
                        startActivity(intent);
                        edPass.setText("");
                    }else if(pass.length()==4){
                        edPass.setText("");
                        Toast.makeText(ScreenDangNhap.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = "8";
                if(pass.length() < 4) {
                    pass = edPass.getText().toString() + pass;
                    edPass.setText(pass);
                    if(pass.length()==4 && pass.equals("1234")){
                        Intent intent =new Intent(ScreenDangNhap.this, MainActivity.class);
                        startActivity(intent);
                        edPass.setText("");
                    }else if(pass.length()==4){
                        edPass.setText("");
                        Toast.makeText(ScreenDangNhap.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = "9";
                if(pass.length() < 4) {
                    pass = edPass.getText().toString() + pass;
                    edPass.setText(pass);
                    if(pass.length()==4 && pass.equals("1234")){
                        Intent intent =new Intent(ScreenDangNhap.this, MainActivity.class);
                        startActivity(intent);
                        edPass.setText("");
                    }else if(pass.length()==4){
                        edPass.setText("");
                        Toast.makeText(ScreenDangNhap.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }

}