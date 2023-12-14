package manhntph29583.baithi.manhntph29583_ass_mob202.mAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import manhntph29583.baithi.manhntph29583_ass_mob202.R;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.KhoanChiDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.LoaiChiDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.KhoanChi;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.LoaiChi;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.ThongKeLC;

public class ThongKeLCAdapter extends RecyclerView.Adapter<ThongKeLCAdapter.ThongKeViewHolder> {
    Context context;
    List<ThongKeLC> mList;
    KhoanChiDAO kcDAO;
    public ThongKeLCAdapter(Context context, List<ThongKeLC> listTKC) {
        this.context = context;
        this.mList = listTKC;
        kcDAO = new KhoanChiDAO(context);
    }
    @NonNull
    @Override
    public ThongKeLCAdapter.ThongKeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_thongke, parent, false);
        ThongKeLCAdapter.ThongKeViewHolder viewHolder = new ThongKeLCAdapter.ThongKeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ThongKeLCAdapter.ThongKeViewHolder holder, int position) {
        if(mList != null){
            holder.tvTenTP.setText(mList.get(position).getTenchiTP());
            holder.tvTienThongKe.setText(mList.get(position).getChiTP()+"");
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
