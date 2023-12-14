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
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.LoaiThuDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.LoaiThu;

public class LoaiThuAdapter extends RecyclerView.Adapter<LoaiThuAdapter.LoaiThuViewHolder> {
    Context context;
    ArrayList<LoaiThu> list;
    LoaiThuDAO ltDAO;

    public LoaiThuAdapter(Context context, ArrayList<LoaiThu> list) {
        this.context = context;
        this.list = list;
        ltDAO = new LoaiThuDAO(context);
    }

    @NonNull
    @Override
    public LoaiThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.cardview_phanloai, parent, false);
        LoaiThuAdapter.LoaiThuViewHolder viewHolder = new LoaiThuAdapter.LoaiThuViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiThuViewHolder holder, int position) {
        LoaiThu lt = list.get(position);
        holder.tvTenLT.setText(lt.getTen_loaithu());
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogUpdatePL(lt);

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
                        if(ltDAO.deleteRow(lt.getId_loaithu())){
                            Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                            list.clear();
                            list.addAll(ltDAO.getAll());
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

    public class LoaiThuViewHolder extends RecyclerView.ViewHolder{
        TextView tvTenLT;
        ImageView imgPL, imgDel, imgEdit;
        CardView cvPhanLoai;
        public LoaiThuViewHolder(@NonNull View view) {
            super(view);
            tvTenLT = view.findViewById(R.id.tv_tenloai);
            imgPL = view.findViewById(R.id.img_phanloai);
            imgDel = view.findViewById(R.id.img_delete);
            imgEdit = view.findViewById(R.id.img_edit);
            cvPhanLoai = view.findViewById(R.id.cardview_phan_loai);
        }
    }
    private void openDialogUpdatePL(LoaiThu lt){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.phanloai_add_edit, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        TextView tvPLaddEdit = view.findViewById(R.id.tv_PL_add_edit);
        TextInputLayout inputEditTenLT = view.findViewById(R.id.input_TenLoai);
        Button btnHuyEditPL = view.findViewById(R.id.btn_exit_add_edit_PL);
        Button btnEditPL = view.findViewById(R.id.btn_add_edit_PL);
        tvPLaddEdit.setText("Sửa loại thu");

        inputEditTenLT.getEditText().setText(lt.getTen_loaithu());
        btnEditPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lt.setTen_loaithu(inputEditTenLT.getEditText().getText().toString());
                if (ltDAO.updateRow(lt)) {
                    Toast.makeText(context, "Update thành công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    list.clear();
                    list.addAll(ltDAO.getAll());
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
