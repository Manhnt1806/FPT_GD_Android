package manhntph29583.manhntph29583_lab2_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question2 extends AppCompatActivity {
    Button btnA2, btnB2, btnC2, btnD2, btnPre2, btnNext2;
    TextView tvKq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        btnA2 = findViewById(R.id.A2);
        btnB2 = findViewById(R.id.B2);
        btnC2 = findViewById(R.id.C2);
        btnD2 = findViewById(R.id.D2);
        btnPre2 = findViewById(R.id.btn_Pre2);
        btnNext2 = findViewById(R.id.btn_Next2);
        tvKq = findViewById(R.id.tv_kq2);
        btnPre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Question2.this, Question1.class);
                startActivity(intent);
            }
        });
        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvKq.getText().toString() == "Đáp án chính xác!\nXin chúc mừng!"){
                    Intent intent =new Intent(Question2.this, Question3.class);
                    startActivity(intent);
                }else{
                    tvKq.setText("Vui lòng chọn đáp án đúng!");
                }
            }
        });
        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnB2.setBackground(getDrawable(R.drawable.background_da));
                btnC2.setBackground(getDrawable(R.drawable.background_da));
                btnD2.setBackground(getDrawable(R.drawable.background_da));
                btnA2.setBackground(getDrawable(R.drawable.background_click));
                tvKq.setText("Đáp án chính xác!\nXin chúc mừng!");
            }
        });
        btnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnA2.setBackground(getDrawable(R.drawable.background_da));
                btnC2.setBackground(getDrawable(R.drawable.background_da));
                btnD2.setBackground(getDrawable(R.drawable.background_da));
                btnB2.setBackground(getDrawable(R.drawable.background_click));
                tvKq.setText("Đáp án chưa chính xác!\nVui lòng chọn lại!");
            }
        });
        btnC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnB2.setBackground(getDrawable(R.drawable.background_da));
                btnA2.setBackground(getDrawable(R.drawable.background_da));
                btnD2.setBackground(getDrawable(R.drawable.background_da));
                btnC2.setBackground(getDrawable(R.drawable.background_click));
                tvKq.setText("Đáp án chưa chính xác!\nVui lòng chọn lại!");
            }
        });
        btnD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnB2.setBackground(getDrawable(R.drawable.background_da));
                btnC2.setBackground(getDrawable(R.drawable.background_da));
                btnA2.setBackground(getDrawable(R.drawable.background_da));
                btnD2.setBackground(getDrawable(R.drawable.background_click));
                tvKq.setText("Đáp án chưa chính xác!\nVui lòng chọn lại!");
            }
        });
    }
}