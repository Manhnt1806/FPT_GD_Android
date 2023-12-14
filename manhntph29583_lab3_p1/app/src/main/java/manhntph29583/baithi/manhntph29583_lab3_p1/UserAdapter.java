package manhntph29583.baithi.manhntph29583_lab3_p1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ProductViewHolder> {
    Context context;
    List<User> listPro;

    public UserAdapter(Context context, List<User> listPro) {
        this.context = context;
        this.listPro = listPro;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Khởi tạo layout cho Recyclerview
        LayoutInflater inflater = LayoutInflater.from(context);
        View view_of_item = inflater.inflate(R.layout.layout_row, parent, false);
        ProductViewHolder viewHolder = new ProductViewHolder(view_of_item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        //xử lý tương tác
        User objPro = listPro.get(position);
        holder.tv_name.setText(objPro.getName());
        holder.img_res.setImageResource(objPro.getImg_res());
    }

    @Override
    public int getItemCount() {
        return listPro.size();
    }

    //----------------------------------------------------------
    class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        ImageView img_res;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            img_res = itemView.findViewById(R.id.img_res);
        }
    }
}
