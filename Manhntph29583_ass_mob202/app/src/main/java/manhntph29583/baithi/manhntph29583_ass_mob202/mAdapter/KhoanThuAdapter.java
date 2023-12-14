package manhntph29583.baithi.manhntph29583_ass_mob202.mAdapter;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import manhntph29583.baithi.manhntph29583_ass_mob202.R;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.KhoanThuDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.LoaiThuDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.KhoanChi;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.KhoanThu;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.LoaiChi;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.LoaiThu;

public class KhoanThuAdapter extends RecyclerView.Adapter<KhoanThuAdapter.KhoanThuViewHolder>implements Filterable {
    Context context;
    ArrayList<KhoanThu> list;
    ArrayList<KhoanThu> mList;
    KhoanThuDAO ktDAO;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public KhoanThuAdapter(Context context, ArrayList<KhoanThu> list) {
        this.context = context;
        this.list = list;
        this.mList = list;
        ktDAO = new KhoanThuDAO(context);
    }

    @NonNull
    @Override
    public KhoanThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_khoanthu, parent, false);
        KhoanThuViewHolder viewHolder = new KhoanThuViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KhoanThuViewHolder holder, int position) {
        KhoanThu kt = list.get(position);
        holder.tvTienThu.setText(kt.getTien_thu()+"");
        holder.tvNoteKhoanThu.setText(kt.getNote_thu());
        holder.tvNgayThu.setText(simpleDateFormat.format(kt.getNgay_thu()));
        holder.tvTenKhoanThu.setText(kt.getTen_loaithu());

        holder.cardviewKhoanThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                view = inflater.inflate(R.layout.dialog_chi_tiet, null);
                builder.setView(view);
                Dialog  dialog = builder.create();
                dialog.show();

                TextView tvTenLoaiCT = view.findViewById(R.id.tv_tenloai_ct);
                TextView tvTienCT = view.findViewById(R.id.tv_tien_ct);
                TextView tvPhanLoaiCT = view.findViewById(R.id.tv_phanloai_ct);
                TextView tvNgayCT = view.findViewById(R.id.tv_ngay_ct);
                TextView tvNoteCT = view.findViewById(R.id.tv_note_ct);
                ImageView btnBack = view.findViewById(R.id.btn_back_ct);
                ImageView btnDel = view.findViewById(R.id.btn_del_ct);
                Button btnEdit = view.findViewById(R.id.btn_edit_ct);
                tvTenLoaiCT.setText(kt.getTen_loaithu());
                tvTienCT.setText(kt.getTien_thu()+"");
                tvPhanLoaiCT.setText("Thu nhập");
                tvNgayCT.setText(simpleDateFormat.format(kt.getNgay_thu()));
                tvNoteCT.setText(kt.getNote_thu());

                btnDel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
                        builder.setTitle("Bạn có chắc muốn xóa?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(ktDAO.deleteRow(kt.getId_khoanthu())){
                                    Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                                    list.clear();
                                    list.addAll(ktDAO.getAll());
                                    notifyDataSetChanged();
                                    dialogInterface.dismiss();
                                    dialog.dismiss();
                                }else{
                                    Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        builder.create().show();
                    }
                });
                btnEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
                        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                        view = inflater.inflate(R.layout.dialog_edit_chi_tiet, null);
                        builder.setView(view);
                        Dialog dialog = builder.create();
                        dialog.show();

                        TextView tvEditCt = view.findViewById(R.id.tv_edit_ct);
                        TextView tvEditNgayCt = view.findViewById(R.id.btn_edit_ngay_ct);
                        EditText edTienThu = view.findViewById(R.id.ed_tien_ct);
                        Button btnHuyEditKT = view.findViewById(R.id.btn_exit_edit_ct);
                        TextInputLayout inputNgayCT = view.findViewById(R.id.input_edit_ngay_ct);
                        TextInputLayout inputNoteCT = view.findViewById(R.id.input_edit_note_ct);
                        Button btnEditKT = view.findViewById(R.id.btn_save_edit_ct);
                        Spinner spnEditCT = view.findViewById(R.id.spn_edit_ct);
                        tvEditCt.setText("Chỉnh sửa thu nhập");

                        LoaiThuDAO ltDAO = new LoaiThuDAO(context);
                        ArrayList<LoaiThu> listLT = ltDAO.getAll();
                        ArrayAdapter adapterKT = new ArrayAdapter(context,
                                android.R.layout.simple_spinner_dropdown_item, listLT);
                        spnEditCT.setAdapter(adapterKT);
                        for(int i=0; i< listLT.size(); i++){
                            if(kt.getTen_loaithu().equalsIgnoreCase(String.valueOf(listLT.get(i)))){
                                spnEditCT.setSelection(i);
                            }
                        }

                        edTienThu.setText(kt.getTien_thu()+"");
                        inputNgayCT.getEditText().setText(simpleDateFormat.format(kt.getNgay_thu()));
                        inputNoteCT.getEditText().setText(kt.getNote_thu());
                        tvEditNgayCt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTimeInMillis(System.currentTimeMillis());
                                DatePickerDialog dialog = new DatePickerDialog(context,
                                        new DatePickerDialog.OnDateSetListener() {
                                            @Override
                                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                                int nam = i;
                                                int thang = i1;
                                                int ngay = i2;
                                                inputNgayCT.getEditText().setText(ngay +"/"+ (thang + 1) +"/"+ nam);
                                            }
                                        },
                                        calendar.get(Calendar.YEAR),
                                        calendar.get(Calendar.MONTH),
                                        calendar.get(Calendar.DATE)
                                );
                                dialog.show();
                            }
                        });

                        btnEditKT.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                kt.setTien_thu(Integer.parseInt(edTienThu.getText().toString()));
                                kt.setNote_thu(inputNoteCT.getEditText().getText().toString());
                                try {
                                    kt.setNgay_thu(simpleDateFormat.parse(inputNgayCT.getEditText().getText().toString()));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                LoaiThu lt = (LoaiThu) spnEditCT.getSelectedItem();
                                int idLoatThu = lt.getId_loaithu();
                                kt.setId_loaithu(idLoatThu);
                                if (ktDAO.updateRow(kt)) {
                                    Toast.makeText(context, "Update thành công", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                    list.clear();
                                    list.addAll(ktDAO.getAll());
                                    notifyDataSetChanged();

                                    lt = (LoaiThu) spnEditCT.getSelectedItem();
                                    tvTenLoaiCT.setText(lt.getTen_loaithu());
                                    tvTienCT.setText(kt.getTien_thu()+"");
                                    tvPhanLoaiCT.setText("Thu nhập");
                                    tvNgayCT.setText(simpleDateFormat.format(kt.getNgay_thu()));
                                    tvNoteCT.setText(kt.getNote_thu());
                                }else{
                                    Toast.makeText(context, "Update thất bại", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                        btnHuyEditKT.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.cancel();
                            }
                        });
                    }
                });
                btnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch = charSequence.toString();
                if(strSearch.isEmpty()){
                    list = mList;
                }else {
                    ArrayList<KhoanThu> mListOld = new ArrayList<>();
                    for (KhoanThu khoanChi: mList){
                        if(khoanChi.getTen_loaithu().toLowerCase().contains(strSearch.toLowerCase())){
                            mListOld.add(khoanChi);
                        }
                    }
                    list = mListOld;
                }
                FilterResults results = new FilterResults();
                results.values = list;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                list = (ArrayList<KhoanThu>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class KhoanThuViewHolder extends RecyclerView.ViewHolder{
        TextView tvNgayThu, tvThu, tvTenKhoanThu, tvNoteKhoanThu, tvTienThu;
        ImageView imgThu;
        CardView cardviewKhoanThu;
        public KhoanThuViewHolder(@NonNull View view) {
            super(view);
            tvNgayThu = view.findViewById(R.id.tv_ngay_thu);
            tvThu = view.findViewById(R.id.tv_thu);
            tvTenKhoanThu = view.findViewById(R.id.tv_ten_khoanthu);
            tvNoteKhoanThu = view.findViewById(R.id.tv_note_khoanthu);
            tvTienThu = view.findViewById(R.id.tv_tien_thu);
            imgThu = view.findViewById(R.id.img_thu);
            cardviewKhoanThu = view.findViewById(R.id.cardview_khoan_thu);
        }
    }
}
