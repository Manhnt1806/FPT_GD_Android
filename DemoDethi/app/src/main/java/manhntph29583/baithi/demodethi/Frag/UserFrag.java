package manhntph29583.baithi.demodethi.Frag;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import manhntph29583.baithi.demodethi.DAO.UserDao;
import manhntph29583.baithi.demodethi.DTO.User;
import manhntph29583.baithi.demodethi.R;
import manhntph29583.baithi.demodethi.mAdapter.UserAdapter;

public class UserFrag extends Fragment {
    RecyclerView rcvUser;
    UserDao kcDAO;
    ArrayList<User> list = new ArrayList<>();
    UserAdapter adapter;
    Button btnAddUser;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvUser = view.findViewById(R.id.rcv_user);
        btnAddUser = view.findViewById(R.id.btn_add_user);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcvUser.setLayoutManager(layoutManager);
        kcDAO = new UserDao(getContext());
        list = kcDAO.getAll();
        adapter = new UserAdapter(getContext(), list);
        rcvUser.setAdapter(adapter);
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogAddKC();
            }
        });

    }
    private void openDialogAddKC() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.khoanthuchi_add, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        TextView tvTieuDe = view.findViewById(R.id.tv_khoan_add);
        TextView tvSpnKhoan = view.findViewById(R.id.tv_spn_khoan);
        EditText edTienChi = view.findViewById(R.id.ed_tien_khoan);
        TextInputLayout inputNgayChi = view.findViewById(R.id.intput_add_ngay);
        TextInputLayout inputGhiChuKC = view.findViewById(R.id.input_add_note);
        Spinner spnAddKhoanChi = view.findViewById(R.id.spn_add_khoan);
        Button btnHuyAdd_KC = view.findViewById(R.id.btn_exit_add_khoan);
        Button btnAdd_KC = view.findViewById(R.id.btn_add_khoan);
        TextView tvNgayChi = view.findViewById(R.id.dialog_add_ngay);
        tvTieuDe.setText("Thêm khoản chi");
        tvSpnKhoan.setText("Khoản chi");

        LoaiChiDAO lcDAO = new LoaiChiDAO(getContext());
        ArrayList<LoaiChi> listLC = lcDAO.getAll();
        ArrayAdapter adapterKC = new ArrayAdapter(getContext(),
                android.R.layout.simple_spinner_dropdown_item, listLC);
        spnAddKhoanChi.setAdapter(adapterKC);

        Date objDate = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new DateFormat();
        String chuoi_ngay_thang_nam = (String) dateFormat.format("dd/MM/yyyy", objDate);
        inputNgayChi.getEditText().setText(chuoi_ngay_thang_nam);
        tvNgayChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                DatePickerDialog dialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                int nam = i;
                                int thang = i1;
                                int ngay = i2;
                                GregorianCalendar c = new GregorianCalendar(nam, thang, ngay);
                                inputNgayChi.getEditText().setText(sdf.format(c.getTime()));
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DATE)
                );
                dialog.show();
            }
        });

        btnAdd_KC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int tienChi = Integer.parseInt(edTienChi.getText().toString());
                Date ngayChi = null;
                try {
                    ngayChi = sdf.parse(inputNgayChi.getEditText().getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String ghiChuKC = inputGhiChuKC.getEditText().getText().toString();
                LoaiChi lc = (LoaiChi) spnAddKhoanChi.getSelectedItem();
                int idLoaiChi = lc.getId_loaichi();
                KhoanChi kc = new KhoanChi(tienChi, ghiChuKC, ngayChi, idLoaiChi);
                if (kcDAO.insertRow(kc)) {
                    Toast.makeText(getContext(), "Thêm khoản thu thành công", Toast.LENGTH_SHORT).show();
                    list.clear();
                    list.addAll(kcDAO.getAll());
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                } else {
                    Toast.makeText(getContext(), "Thêm khoản thu thất bại", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        btnHuyAdd_KC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }
}
