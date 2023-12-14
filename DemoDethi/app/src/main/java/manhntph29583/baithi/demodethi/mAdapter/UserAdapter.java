package manhntph29583.baithi.demodethi.mAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import manhntph29583.baithi.demodethi.DAO.UserDao;
import manhntph29583.baithi.demodethi.DTO.User;
import manhntph29583.baithi.demodethi.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    Context context;
    ArrayList<User> list;
    UserDao kcDAO;
    public UserAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
        kcDAO = new UserDao(context);
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_user, parent, false);
        UserViewHolder viewHolder = new UserViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User kc = list.get(position);
        holder.tvUserName.setText(kc.getUserName());
        holder.tvPhone.setText(kc.getPhone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserName, tvPhone;
        ImageView imgDelUser;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tv_userName);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            imgDelUser = itemView.findViewById(R.id.btn_del_user);
        }
    }
}
