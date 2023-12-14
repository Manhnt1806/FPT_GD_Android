package manhntph29583.baithi.demo_crud_recyclerview.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import manhntph29583.baithi.demo_crud_recyclerview.DAO.ProductDAO;
import manhntph29583.baithi.demo_crud_recyclerview.DTO.Product;
import manhntph29583.baithi.demo_crud_recyclerview.R;


public class ProductAdapter
        extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    // phần việc của adapter
    Context context;
    List<Product> listPro;

    public ProductAdapter(Context context, List<Product> listPro) {
        this.context = context;
        this.listPro = listPro;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // khởi tạo layout cho Recyclerview
            LayoutInflater inflater = LayoutInflater.from(context);
        View view_of_item = inflater.inflate(R.layout.layout_row, parent,false);

        ProductViewHolder viewHolder = new ProductViewHolder( view_of_item );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        final int vi_tri = position;
        // phần xử lý tương tác
        Product objPro = listPro.get(position);
        holder.tv_id.setText(  objPro.getId() +"" );
        holder.tv_name.setText(   objPro.getName()  );
        holder.img_res.setImageResource(  objPro.getImage_res() );

        // xử lý xóa
        holder.tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // tạo dialog hỏi, đông ý xóa thì xóa
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Có đồng ý xóa: " + objPro.getName() );
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // code xử lý xóa
                        ProductDAO dao = new ProductDAO(context);
                        dao.deleteRow(  objPro ); // xóa trong csdl
                        dao.close();
                        listPro.remove(  objPro ); // xoa trong list
                        notifyDataSetChanged();  // cập nhật giao diện
                        dialogInterface.dismiss();
                    }
                });
                builder.setNegativeButton("Không xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();// hiển thị dialog

            }
        });

        holder.tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(context,
                        androidx.appcompat.R.style.Theme_AppCompat_DayNight_Dialog_Alert);

                dialog.setContentView(R.layout.layout_dialog_edit);
                // hiển thị dữ liệu cũ
                EditText ed_name = dialog.findViewById(R.id.ed_name01);
                ed_name.setText(  objPro.getName() );

                Button btn = dialog.findViewById(R.id.btn_save);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String ten_moi = ed_name.getText().toString();

                        objPro.setName( ten_moi );

                        ProductDAO dao = new ProductDAO(context );
                        long kq = dao.updateRow( objPro );
                        if(kq>0){
                            // cập nhật giao diện
                            listPro.set(vi_tri, objPro );
                            notifyDataSetChanged();

                            dialog.dismiss();

                        }else{
                            Toast.makeText(context, "Lỗi rồi, xem log đi", Toast.LENGTH_SHORT).show();
                        }


                    }
                });


                dialog.show();

            }
        });










    }

    @Override
    public int getItemCount() {
        return listPro.size();
    }

    //-----------------------------------------------------------
    // Tạo lớp ProductViewHolder để quản lý layout của 1 dòng
    class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView tv_id, tv_name, tv_del, tv_edit;
        ImageView img_res;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            // ánh xạ các View
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_name = itemView.findViewById(R.id.tv_name);
            img_res = itemView.findViewById(R.id.img_res);

            tv_del = itemView.findViewById(R.id.tv_del);
            tv_edit = itemView.findViewById(R.id.tv_edit);
        }
    }

}
