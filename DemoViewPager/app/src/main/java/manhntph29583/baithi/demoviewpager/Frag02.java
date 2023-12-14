package manhntph29583.baithi.demoviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag02 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Khởi tạo layout
        return inflater.inflate(R.layout.layout_frag02, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Xử lý tương tác với các view
        TextView tv02 = view.findViewById(R.id.tv02);
        Button btn02 = view.findViewById(R.id.btn02);
        //Bấm nút thì thay đổi nội dung
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv02.setText("Frag 02222 đã thay đổi!");
            }
        });
    }
}
