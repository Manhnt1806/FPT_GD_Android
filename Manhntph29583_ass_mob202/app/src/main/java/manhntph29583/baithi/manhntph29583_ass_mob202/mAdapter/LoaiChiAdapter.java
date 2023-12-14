package manhntph29583.baithi.manhntph29583_ass_mob202.mAdapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import manhntph29583.baithi.manhntph29583_ass_mob202.R;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.LoaiChiDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.LoaiChi;

public class LoaiChiAdapter extends RecyclerView.Adapter<LoaiChiAdapter.LoaiChiViewHolder> {
    Context context;
    ArrayList<LoaiChi> list;
    LoaiChiDAO lcDAO;

    public LoaiChiAdapter(Context context, ArrayList<LoaiChi> list) {
        this.context = context;
        this.list = list;
        lcDAO = new LoaiChiDAO(context);
    }

    @NonNull
    @Override
    public LoaiChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.cardview_phanloai, parent, false);
        LoaiChiAdapter.LoaiChiViewHolder viewHolder = new LoaiChiAdapter.LoaiChiViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiChiViewHolder holder, int position) {
        LoaiChi lc = list.get(position);
        holder.tvTenLC.setText(lc.getTen_loaichi());
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogUpdatePL(lc);

            }
        });
        holder.imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
                builder.setTitle("Bạn có chắc muốn xóa?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(lcDAO.deleteRow(lc.getId_loaichi())){
                            Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                            list.clear();
                            list.addAll(lcDAO.getAll());
                            notifyDataSetChanged();
                            dialogInterface.dismiss();
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
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LoaiChiViewHolder extends RecyclerView.ViewHolder{
        TextView tvTenLC;
        ImageView imgPL, imgDel, imgEdit;
        CardView cvPhanLoai;
        public LoaiChiViewHolder(@NonNull View view) {
            super(view);
            tvTenLC = view.findViewById(R.id.tv_tenloai);
            imgPL = view.findViewById(R.id.img_phanloai);
            imgDel = view.findViewById(R.id.img_delete);
            imgEdit = view.findViewById(R.id.img_edit);
            cvPhanLoai = view.findViewById(R.id.cardview_phan_loai);
        }
    }
    private void openDialogUpdatePL(LoaiChi lc){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.phanloai_add_edit, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        TextView tvPLaddEdit = view.findViewById(R.id.tv_PL_add_edit);
        TextInputLayout inputEditTenLC = view.findViewById(R.id.input_TenLoai);
        Button btnHuyEditPL = view.findViewById(R.id.btn_exit_add_edit_PL);
        Button btnEditPL = view.findViewById(R.id.btn_add_edit_PL);
        tvPLaddEdit.setText("Sửa loại chi");

        inputEditTenLC.getEditText().setText(lc.getTen_loaichi());
        btnEditPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lc.setTen_loaichi(inputEditTenLC.getEditText().getText().toString());
                if (lcDAO.updateRow(lc)) {
                    Toast.makeText(context, "Update thành công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    list.clear();
                    list.addAll(lcDAO.getAll());
                    notifyDataSetChanged();
                }else{
                    Toast.makeText(context, "Update thất bại", Toast.LENGTH_SHORT).show();

                }
            }
        });
        btnHuyEditPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }
}
