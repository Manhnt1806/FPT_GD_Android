package fpt.poly.mob202_ontap.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import fpt.poly.mob202_ontap.DAO.NoteDAO;
import fpt.poly.mob202_ontap.DTO.Note;
import fpt.poly.mob202_ontap.R;

public class fragment_them_ghichu extends Fragment {
    TextInputEditText edt_noidung, edt_thoigian;
    Button btn_ghinho;
    NoteDAO dao;
    List<Note> list;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edt_noidung = view.findViewById(R.id.edt_noidung);
        edt_thoigian = view.findViewById(R.id.edt_thoigian);
        btn_ghinho = view.findViewById(R.id.btn_ghinho);
        list = new ArrayList<>();
        dao = new NoteDAO(getContext());
        list = dao.getAll();
        Note objnote = new Note();
        btn_ghinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objnote.setContent(edt_noidung.getText().toString());
                objnote.setTime(edt_thoigian.getText().toString());
                list.add(objnote);
                if(dao.insertRow(objnote)>0){
                    Snackbar snackbar = Snackbar
                            .make(view, "Lưu thành công", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    resetForm();
                }else {
                    Toast.makeText(getContext(), "Thêm không thành công", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void resetForm()
    {
        edt_noidung.setText("");
        edt_thoigian.setText("");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_ghichu, container, false);
    }
}
