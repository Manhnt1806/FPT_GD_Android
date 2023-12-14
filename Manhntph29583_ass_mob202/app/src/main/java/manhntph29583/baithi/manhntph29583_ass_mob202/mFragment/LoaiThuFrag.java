package manhntph29583.baithi.manhntph29583_ass_mob202.mFragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import manhntph29583.baithi.manhntph29583_ass_mob202.R;
import manhntph29583.baithi.manhntph29583_ass_mob202.mAdapter.LoaiThuAdapter;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.LoaiThuDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.LoaiThu;

public class LoaiThuFrag extends Fragment {
    RecyclerView rcvLoaiThu;
    LoaiThuDAO ltDAO;
    ArrayList<LoaiThu> list = new ArrayList<>();
    LoaiThuAdapter adapter;
    Button btnAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.loaithu_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvLoaiThu = view.findViewById(R.id.rcv_loaithu);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcvLoaiThu.setLayoutManager(layoutManager);
        ltDAO = new LoaiThuDAO(getContext());
        list = ltDAO.getAll();
        adapter = new LoaiThuAdapter(getContext(), list);
        rcvLoaiThu.setAdapter(adapter);
        btnAdd = view.findViewById(R.id.btn_addLT);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogAddLT();
            }
        });
    }
    private void openDialogAddLT(){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.phanloai_add_edit, null);
        builder.setView(view);
        TextView tvPLaddEdit = view.findViewById(R.id.tv_PL_add_edit);
        TextInputLayout inputTenLoai = view.findViewById(R.id.input_TenLoai);
        Button btnHuyAddPL = view.findViewById(R.id.btn_exit_add_edit_PL);
        Button btnAddPL = view.findViewById(R.id.btn_add_edit_PL);
        tvPLaddEdit.setText("Thêm loại thu mới");

        Dialog dialog = builder.create();
        dialog.show();
        btnAddPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenLT = inputTenLoai.getEditText().getText().toString();
                if (ltDAO.insertRow(tenLT)) {
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    list.clear();
                    list.addAll(ltDAO.getAll());
                    adapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();

                }
            }
        });
        btnHuyAddPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }
}
