package fpt.poly.mob202_ontap.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fpt.poly.mob202_ontap.Adapter.Adapter_list_note;
import fpt.poly.mob202_ontap.DAO.NoteDAO;
import fpt.poly.mob202_ontap.DTO.Note;
import fpt.poly.mob202_ontap.R;

public class fragment_danhsach_ghichu extends Fragment {
    RecyclerView ryc_listnote;
    Button btn_themghichu;
    NoteDAO dao;
    List<Note> listNote;
    Adapter_list_note adapter;

    public fragment_danhsach_ghichu() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ryc_listnote = view.findViewById(R.id.ryc_listnote);
        btn_themghichu = view.findViewById(R.id.btn_themghichu);


        btn_themghichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                ryc_listnote.setLayoutManager(layoutManager);
                dao = new NoteDAO(getContext());
                listNote = dao.getAll();
                adapter = new Adapter_list_note(getContext(), listNote);
                ryc_listnote.setAdapter(adapter);
            }
        });
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_danhsach_ghichu,container,false);

    }

    @Override
    public void onResume() {
        super.onResume();
        listNote = new ArrayList<>();
        dao = new NoteDAO(getContext());
        listNote = dao.getAll();
        adapter = new Adapter_list_note(getContext(),listNote);
        ryc_listnote.setAdapter(adapter);
    }
}
