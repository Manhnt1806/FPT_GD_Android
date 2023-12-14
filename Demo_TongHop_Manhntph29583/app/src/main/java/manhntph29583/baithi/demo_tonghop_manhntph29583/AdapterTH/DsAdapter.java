package manhntph29583.baithi.demo_tonghop_manhntph29583.AdapterTH;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import manhntph29583.baithi.demo_tonghop_manhntph29583.DAO.mDAO;
import manhntph29583.baithi.demo_tonghop_manhntph29583.DTO.content;
import manhntph29583.baithi.demo_tonghop_manhntph29583.R;

public class DsAdapter
        extends RecyclerView.Adapter<DsAdapter.DsViewHolder> implements Filterable {
    Context context;
    ArrayList<content> list;
    ArrayList<content> mList;
    mDAO dsDAO;

    public DsAdapter(Context context, ArrayList<content> list) {
        this.context = context;
        this.list = list;
        this.mList = list;
        dsDAO = new mDAO(context);
    }

    @NonNull
    @Override
    public DsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.cardview, parent, false);
        DsAdapter.DsViewHolder viewHolder = new DsAdapter.DsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DsViewHolder holder, int position) {
        content obj = list.get(position);
        holder.tvContent.setText(obj.getTittle());
        holder.tvTittle.setText(obj.getTittle());
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
                    ArrayList<content> mListOld = new ArrayList<>();
                    for (content content: mList){
                        if(content.getTittle().toLowerCase().contains(strSearch.toLowerCase())){
                            mListOld.add(content);
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

            }
        };
    }

    public class DsViewHolder extends RecyclerView.ViewHolder{
        TextView tvTittle, tvContent;
        ImageView imgDel;
        CardView cvDs;

        public DsViewHolder(@NonNull View view) {
            super(view);
            tvTittle = view.findViewById(R.id.tv_tittle);
            tvContent = view.findViewById(R.id.tv_content);
            imgDel = view.findViewById(R.id.img_delete);
            cvDs = view.findViewById(R.id.cardview_ds);

        }
    }
}
