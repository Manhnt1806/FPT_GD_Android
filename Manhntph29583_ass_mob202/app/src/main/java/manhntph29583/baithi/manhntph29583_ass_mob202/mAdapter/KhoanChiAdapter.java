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
import java.util.GregorianCalendar;

import manhntph29583.baithi.manhntph29583_ass_mob202.R;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.KhoanChiDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.LoaiChiDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.KhoanChi;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.LoaiChi;

public class KhoanChiAdapter extends RecyclerView.Adapter<KhoanChiAdapter.KhoanChiViewHolder> implements Filterable {
    Context context;
    ArrayList<KhoanChi> list;
    ArrayList<KhoanChi> mList;
    KhoanChiDAO kcDAO;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public KhoanChiAdapter(Context context, ArrayList<KhoanChi> list) {
        this.context = context;
        this.list = list;
        this.mList = list;
        kcDAO = new KhoanChiDAO(context);
    }

    @NonNull
    @Override
    public KhoanChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_khoanchi, parent, false);
        KhoanChiViewHolder viewHolder = new KhoanChiViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KhoanChiViewHolder holder, int position) {
        KhoanChi kc = list.get(position);
        holder.tvTienChi.setText(kc.getTien_chi()+"");
        holder.tvNoteKhoanChi.setText(kc.getNote_chi());
        holder.tvNgayChi.setText(simpleDateFormat.format(kc.getNgay_chi()));
        holder.tvTenKhoanChi.setText(kc.getTen_loaichi());

        holder.cardviewKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                view = inflater.inflate(R.layout.dialog_chi_tiet, null);
                builder.setView(view);
                Dialog dialog = builder.create();
                dialog.show();

                TextView tvTenLoaiCT = view.findViewById(R.id.tv_tenloai_ct);
                TextView tvTienCT = view.findViewById(R.id.tv_tien_ct);
                TextView tvPhanLoaiCT = view.findViewById(R.id.tv_phanloai_ct);
                TextView tvNgayCT = view.findViewById(R.id.tv_ngay_ct);
                TextView tvNoteCT = view.findViewById(R.id.tv_note_ct);
                ImageView btnBack = view.findViewById(R.id.btn_back_ct);
                ImageView btnDel = view.findViewById(R.id.btn_del_ct);
                Button btnEdit = view.findViewById(R.id.btn_edit_ct);
                tvTenLoaiCT.setText(kc.getTen_loaichi());
                tvTienCT.setText(kc.getTien_chi()+"");
                tvPhanLoaiCT.setText("Chi tiêu");
                tvNgayCT.setText(simpleDateFormat.format(kc.getNgay_chi()));
                tvNoteCT.setText(kc.getNote_chi());

                btnDel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
                        builder.setTitle("Bạn có chắc muốn xóa?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(kcDAO.deleteRow(kc.getId_khoanchi())){
                                    Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                                    list.clear();
                                    list.addAll(kcDAO.getAll());
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
                        EditText edTienChi = view.findViewById(R.id.ed_tien_ct);
                        Button btnHuyEditKT = view.findViewById(R.id.btn_exit_edit_ct);
                        TextInputLayout inputNgayCT = view.findViewById(R.id.input_edit_ngay_ct);
                        TextInputLayout inputNoteCT = view.findViewById(R.id.input_edit_note_ct);
                        Button btnEditKC = view.findViewById(R.id.btn_save_edit_ct);
                        Spinner spnEditCT = view.findViewById(R.id.spn_edit_ct);
                        tvEditCt.setText("Chỉnh sửa chi tiêu");

                        LoaiChiDAO lcDAO = new LoaiChiDAO(context);
                        ArrayList<LoaiChi> listLC = lcDAO.getAll();
                        ArrayAdapter adapterKC = new ArrayAdapter(context,
                                android.R.layout.simple_spinner_dropdown_item, listLC);
                        spnEditCT.setAdapter(adapterKC);
                        for(int i=0; i< listLC.size(); i++){
                            if(kc.getTen_loaichi().equalsIgnoreCase(String.valueOf(listLC.get(i)))){
                                spnEditCT.setSelection(i);
                            }
                        }

                        edTienChi.setText(kc.getTien_chi()+"");
                        inputNgayCT.getEditText().setText(simpleDateFormat.format(kc.getNgay_chi()));
                        inputNoteCT.getEditText().setText(kc.getNote_chi());
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
                                                GregorianCalendar c = new GregorianCalendar(nam, thang, ngay);
                                                inputNgayCT.getEditText().setText(simpleDateFormat.format(c.getTime()));
                                            }
                                        },
                                        calendar.get(Calendar.YEAR),
                                        calendar.get(Calendar.MONTH),
                                        calendar.get(Calendar.DATE)
                                );
                                dialog.show();
                            }
                        });

                        btnEditKC.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                kc.setTien_chi(Integer.parseInt(edTienChi.getText().toString()));
                                kc.setNote_chi(inputNoteCT.getEditText().getText().toString());
                                try {
                                    kc.setNgay_chi(simpleDateFormat.parse(inputNgayCT.getEditText().getText().toString()));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                LoaiChi lc = (LoaiChi) spnEditCT.getSelectedItem();
                                int idLoaiChi = lc.getId_loaichi();
                                kc.setId_loaichi(idLoaiChi);
                                if (kcDAO.updateRow(kc)) {
                                    Toast.makeText(context, "Update thành công", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                    list.clear();
                                    list.addAll(kcDAO.getAll());
                                    notifyDataSetChanged();

                                    lc = (LoaiChi) spnEditCT.getSelectedItem();
                                    tvTenLoaiCT.setText(lc.getTen_loaichi());
                                    tvTienCT.setText(kc.getTien_chi()+"");
                                    tvPhanLoaiCT.setText("Chi tiêu");
                                    tvNgayCT.setText(simpleDateFormat.format(kc.getNgay_chi()));
                                    tvNoteCT.setText(kc.getNote_chi());
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



    public class KhoanChiViewHolder extends RecyclerView.ViewHolder{
        TextView tvNgayChi, tvChi, tvTenKhoanChi, tvNoteKhoanChi, tvTienChi;
        ImageView imgChi;
        CardView cardviewKhoanChi;
        public KhoanChiViewHolder(@NonNull View view) {
            super(view);
            tvNgayChi = view.findViewById(R.id.tv_ngay_chi);
            tvChi = view.findViewById(R.id.tv_chi);
            tvTenKhoanChi = view.findViewById(R.id.tv_ten_khoanchi);
            tvNoteKhoanChi = view.findViewById(R.id.tv_note_khoanchi);
            tvTienChi = view.findViewById(R.id.tv_tien_chi);
            imgChi = view.findViewById(R.id.img_chi);
            cardviewKhoanChi = view.findViewById(R.id.cardview_khoan_chi);
        }

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
                    ArrayList<KhoanChi> mListOld = new ArrayList<>();
                    for (KhoanChi khoanChi: mList){
                        if(khoanChi.getTen_loaichi().toLowerCase().contains(strSearch.toLowerCase())){
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
                list = (ArrayList<KhoanChi>) filterResults.values;
                notifyDataSetChanged();

            }
        };
    }
}
