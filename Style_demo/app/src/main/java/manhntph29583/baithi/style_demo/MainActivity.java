package manhntph29583.baithi.style_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv =findViewById(R.id.tv);
        Typeface tf = Typeface.createFromAsset(getAssets(), "XanhMono-Italic.ttf");
        tv.setTypeface(tf);
    }
}