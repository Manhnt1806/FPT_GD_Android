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

public class Frag01 extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            // Khởi tạo layout
            return inflater.inflate(R.layout.layout_frag01, container, false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            // Xử lý tương tác với các view
            TextView tv01 = view.findViewById(R.id.tv01);
            Button btn01 = view.findViewById(R.id.btn01);
            //Bấm nút thì thay đổi nội dung
            btn01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tv01.setText("Frag 01111 đã thay đổi!");
                }
            });
        }
}
