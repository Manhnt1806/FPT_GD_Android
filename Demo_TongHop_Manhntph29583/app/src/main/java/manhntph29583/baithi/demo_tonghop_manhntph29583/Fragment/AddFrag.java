package manhntph29583.baithi.demo_tonghop_manhntph29583.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import manhntph29583.baithi.demo_tonghop_manhntph29583.AdapterTH.DsAdapter;
import manhntph29583.baithi.demo_tonghop_manhntph29583.DAO.mDAO;
import manhntph29583.baithi.demo_tonghop_manhntph29583.DTO.content;
import manhntph29583.baithi.demo_tonghop_manhntph29583.R;

public class AddFrag extends Fragment {
    TextInputLayout edTittle, edContent;
    Button btnAdd, btnExit;
    DsAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_frag_layout, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edTittle = view.findViewById(R.id.input_Tittle);
        edContent = view.findViewById(R.id.input_Content);
        btnAdd = view.findViewById(R.id.btn_add);
        btnExit = view.findViewById(R.id.btn_exit_add);
        mDAO dsDao = new mDAO(getContext());
        ArrayList<content> list = dsDao.getAll();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle = edTittle.getEditText().getText().toString();
                String content = edContent.getEditText().getText().toString();
                content ds =new content(tittle, content);
                if (dsDao.insertRow(ds)) {
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    list.clear();
                    list.addAll(dsDao.getAll());

                }else{
                    Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mDialog = new AlertDialog.Builder(getContext());
                mDialog.setTitle("Question");
                mDialog.setMessage("Are you sure You want to Exit?");
                mDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startActivity(startMain);
                    }
                });
                mDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                mDialog.create().show();
            }
        });
    }
}
