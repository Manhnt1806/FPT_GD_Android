package manhntph29583.baithi.demo_datetime_pickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    String TAG = "zzzzz";
    EditText edNgay;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNgay = findViewById(R.id.ed_ngay);
        btnSave = findViewById(R.id.btn_save);
        edNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogDate();// Hiện dialog chọn ngày
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, edNgay.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        //Lấy thời gian hiện tại
        Date objDate = new Date(System.currentTimeMillis());
        //định dạng ngày tháng sử dụng đối tượng DateFormat với các ký hiệu dd, MM, yyyy
        android.text.format.DateFormat dateFormat = new DateFormat();
        String chuoi_ngay_thang_nam = (String) dateFormat.format("dd/MM/yyyy", objDate);
        //Ghi log chuỗi ngày tháng
        Log.d(TAG, "onCreate: Ngày hiện tại = "+ chuoi_ngay_thang_nam);
        //============================================
        String chuoi_ngay_vn = "26/12/2022"; //--> Cần chuyển về: 2022-12-26
        Log.d(TAG, "onCreate: ngày NV = "+ chuoi_ngay_vn);
        //Tạo ra đối tượng để chuyển đổi
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //truyền vào định dạng của chuỗi ban đầu
        try {
            Date objNgay = format.parse(chuoi_ngay_vn);
            android.text.format.DateFormat dateFormat22 = new DateFormat();
            String chuoi_moi = (String) dateFormat22.format("yyy-MM-dd", objNgay);
            Log.d(TAG, "onCreate: ngày mới = "+ chuoi_moi);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void showDialogDate(){
        // Sử dụng đối tượng lịch (colendar) để cài đặt
        Calendar calendar = Calendar.getInstance();
        //thiết lập ngày giờ hiện tại
        calendar.setTimeInMillis(System.currentTimeMillis());
        //Khởi tạo Dialog chọn ngày tháng
        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                //Nơi viết code khi người dùng chọn ngày tháng
                int nam = i;
                int thang = i1;// nhận giá trị từ 0--11
                int ngay = i2;
                //gắn dữ liệu vào edittext
                edNgay.setText(ngay +"/"+ (thang + 1) +"/"+ nam);
            }
        },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE)
        );
        dialog.show();
    }
}