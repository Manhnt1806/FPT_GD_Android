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
import manhntph29583.baithi.manhntph29583_ass_mob202.mAdapter.LoaiChiAdapter;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.LoaiChiDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.LoaiChi;

public class LoaiChiFrag extends Fragment {
    RecyclerView rcvLoaiChi;
    LoaiChiDAO lcDAO;
    ArrayList<LoaiChi> list = new ArrayList<>();
    LoaiChiAdapter adapter;
    Button btnAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.loaichi_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvLoaiChi = view.findViewById(R.id.rcv_loaichi);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcvLoaiChi.setLayoutManager(layoutManager);
        lcDAO = new LoaiChiDAO(getContext());
        list = lcDAO.getAll();
        adapter = new LoaiChiAdapter(getContext(), list);
        rcvLoaiChi.setAdapter(adapter);
        btnAdd = view.findViewById(R.id.btn_addLC);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogAddLC();
            }
        });
    }
    private void openDialogAddLC(){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.phanloai_add_edit, null);
        builder.setView(view);
        TextView tvPLaddEdit = view.findViewById(R.id.tv_PL_add_edit);
        TextInputLayout inputTenLoai = view.findViewById(R.id.input_TenLoai);
        Button btnHuyAddPL = view.findViewById(R.id.btn_exit_add_edit_PL);
        Button btnAddPL = view.findViewById(R.id.btn_add_edit_PL);
        tvPLaddEdit.setText("Thêm loại chi mới");

        Dialog dialog = builder.create();
        dialog.show();
        btnAddPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenLC = inputTenLoai.getEditText().getText().toString();
                if (lcDAO.insertRow(tenLC)) {
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    list.clear();
                    list.addAll(lcDAO.getAll());
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
