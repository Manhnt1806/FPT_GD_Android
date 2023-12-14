package manhntph29583.baithi.manhntph29583_ass_mob202.mFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
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

import manhntph29583.baithi.manhntph29583_ass_mob202.R;
import manhntph29583.baithi.manhntph29583_ass_mob202.mAdapter.KhoanThuAdapter;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.KhoanThuDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.LoaiThuDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.KhoanChi;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.KhoanThu;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.LoaiThu;

public class KhoanThuFrag extends Fragment {
    RecyclerView rcvKhoanThu;
    KhoanThuDAO ktDAO;
    ArrayList<KhoanThu> list = new ArrayList<>();
    KhoanThuAdapter adapter;
    Button btnAddKT;
    private SearchView searchView;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.khoanthu_frag, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvKhoanThu = view.findViewById(R.id.rcv_khoanthu);
        btnAddKT = view.findViewById(R.id.btn_addKT);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcvKhoanThu.setLayoutManager(layoutManager);
        ktDAO = new KhoanThuDAO(getContext());
        list = ktDAO.getAll();
        adapter = new KhoanThuAdapter(getContext(), list);
        rcvKhoanThu.setAdapter(adapter);
        btnAddKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogAddKT();
            }
        });
    }
    private void openDialogAddKT(){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.khoanthuchi_add, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        TextView tvTieuDe = view.findViewById(R.id.tv_khoan_add);
        TextView tvSpnKhoan = view.findViewById(R.id.tv_spn_khoan);
        EditText edTienThu = view.findViewById(R.id.ed_tien_khoan);
        TextInputLayout inputNgayThu = view.findViewById(R.id.intput_add_ngay);
        TextInputLayout inputGhiChuKT = view.findViewById(R.id.input_add_note);
        Spinner spnAddKhoanThu = view.findViewById(R.id.spn_add_khoan);
        Button btnHuyAdd_KT = view.findViewById(R.id.btn_exit_add_khoan);
        Button btnAdd_KT = view.findViewById(R.id.btn_add_khoan);
        TextView tvNgayThu = view.findViewById(R.id.dialog_add_ngay);
        tvTieuDe.setText("Thêm khoản thu");
        tvSpnKhoan.setText("Khoản thu");

        LoaiThuDAO ltDAO = new LoaiThuDAO(getContext());
        ArrayList<LoaiThu> listLT = ltDAO.getAll();
        ArrayAdapter adapterKT = new ArrayAdapter(getContext(),
                android.R.layout.simple_spinner_dropdown_item, listLT);
        spnAddKhoanThu.setAdapter(adapterKT);

        Date objDate = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new DateFormat();
        String chuoi_ngay_thang_nam = (String) dateFormat.format("yyyy/MM/dd", objDate);
        inputNgayThu.getEditText().setText(chuoi_ngay_thang_nam);
        tvNgayThu.setOnClickListener(new View.OnClickListener() {
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
                                inputNgayThu.getEditText().setText(ngay +"/"+ (thang + 1) +"/"+ nam);
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DATE)
                );
                dialog.show();
            }
        });

        btnAdd_KT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int tienThu = Integer.parseInt(edTienThu.getText().toString());
                Date ngayThu = null;
                try {
                    ngayThu = sdf.parse(inputNgayThu.getEditText().getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String ghiChuKT = inputGhiChuKT.getEditText().getText().toString();
                LoaiThu lt = (LoaiThu) spnAddKhoanThu.getSelectedItem();
                int idLoaiThu = lt.getId_loaithu();
                KhoanThu kt = new KhoanThu(tienThu, ghiChuKT, ngayThu, idLoaiThu);
                if(ktDAO.insertRow(kt)){
                    Toast.makeText(getContext(), "Thêm khoản thu thành công", Toast.LENGTH_SHORT).show();
                    list.clear();
                    list.addAll(ktDAO.getAll());
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }else{
                    Toast.makeText(getContext(), "Thêm khoản thu thất bại", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        btnHuyAdd_KT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText );
                return false;
            }
        });
    }
}
