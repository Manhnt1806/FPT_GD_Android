package manhntph29583.manhntph29583_lab2_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question1 extends AppCompatActivity {
    Button btnA1, btnB1, btnC1, btnD1, btnPre1, btnNext1;
    TextView tvKq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        btnA1 = findViewById(R.id.A1);
        btnB1 = findViewById(R.id.B1);
        btnC1 = findViewById(R.id.C1);
        btnD1 = findViewById(R.id.D1);
        btnPre1 = findViewById(R.id.btn_Pre1);
        btnNext1 = findViewById(R.id.btn_Next1);
        tvKq = findViewById(R.id.tv_kq1);

        btnA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnB1.setBackground(getDrawable(R.drawable.background_da));
                btnC1.setBackground(getDrawable(R.drawable.background_da));
                btnD1.setBackground(getDrawable(R.drawable.background_da));
                btnA1.setBackground(getDrawable(R.drawable.background_click));
                tvKq.setText("Đáp án chưa chính xác!\nVui lòng chọn lại!");
            }
        });
        btnB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnA1.setBackground(getDrawable(R.drawable.background_da));
                btnC1.setBackground(getDrawable(R.drawable.background_da));
                btnD1.setBackground(getDrawable(R.drawable.background_da));
                btnB1.setBackground(getDrawable(R.drawable.background_click));
                tvKq.setText("Đáp án chưa chính xác!\nVui lòng chọn lại!");
            }
        });
        btnC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnB1.setBackground(getDrawable(R.drawable.background_da));
                btnA1.setBackground(getDrawable(R.drawable.background_da));
                btnD1.setBackground(getDrawable(R.drawable.background_da));
                btnC1.setBackground(getDrawable(R.drawable.background_click));
                tvKq.setText("Đáp án chưa chính xác!\nVui lòng chọn lại!");
            }
        });
        btnD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnB1.setBackground(getDrawable(R.drawable.background_da));
                btnC1.setBackground(getDrawable(R.drawable.background_da));
                btnA1.setBackground(getDrawable(R.drawable.background_da));
                btnD1.setBackground(getDrawable(R.drawable.background_click));
                tvKq.setText("Đáp án chính xác!\nXin chúc mừng!");
            }
        });
        btnPre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Question1.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvKq.getText().toString() == "Đáp án chính xác!\nXin chúc mừng!"){
                    Intent intent =new Intent(Question1.this, Question2.class);
                    startActivity(intent);
                }else{
                    tvKq.setText("Vui lòng chọn đáp án đúng!");
                }

            }
        });
    }
}