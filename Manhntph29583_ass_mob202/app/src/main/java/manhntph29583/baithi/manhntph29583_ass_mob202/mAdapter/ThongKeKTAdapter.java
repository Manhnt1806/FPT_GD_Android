package manhntph29583.baithi.manhntph29583_ass_mob202.mAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import manhntph29583.baithi.manhntph29583_ass_mob202.R;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.KhoanChiDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.KhoanThuDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.ThongKeKT;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.ThongKeLC;

public class ThongKeKTAdapter extends RecyclerView.Adapter<ThongKeKTAdapter.ThongKeViewHolder> {
    Context context;
    List<ThongKeKT> mList;
    KhoanThuDAO ktDAO;
    public ThongKeKTAdapter(Context context, List<ThongKeKT> listTKT) {
        this.context = context;
        this.mList = listTKT;
        ktDAO = new KhoanThuDAO(context);
    }
    @NonNull
    @Override
    public ThongKeKTAdapter.ThongKeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_thongke, parent, false);
        ThongKeKTAdapter.ThongKeViewHolder viewHolder = new ThongKeKTAdapter.ThongKeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ThongKeKTAdapter.ThongKeViewHolder holder, int position) {
        if(mList != null){
            holder.tvTenTP.setText(mList.get(position).getTenThuTP());
            holder.tvTienThongKe.setText(mList.get(position).getThuTP()+"");
        }
    }

    @Override
    public int getItemCount() {
        if(mList==null){
            return 0;
        }
        return mList.size();
    }
    public class ThongKeViewHolder extends RecyclerView.ViewHolder{
        TextView tvTenTP, tvTienThongKe;
        ImageView imgTK;
        CardView cvThongKe;
        public ThongKeViewHolder(@NonNull View view) {
            super(view);
            tvTenTP = view.findViewById(R.id.tv_tenloai_tk);
            tvTienThongKe = view.findViewById(R.id.tv_tien_thongke);
            imgTK = view.findViewById(R.id.img_tk);
            cvThongKe = view.findViewById(R.id.cardview_thongke);

        }
    }
}
