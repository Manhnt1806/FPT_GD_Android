package manhntph29583.baithi.demoadapterview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter  extends BaseAdapter {
    List<Product> listPro ;

    public ProductAdapter(List<Product> listPro) {
        this.listPro = listPro;
    }

    @Override
    public int getCount() {
        return listPro.size();
    }

    @Override
    public Object getItem(int i) {
        return listPro.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listPro.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row ;
        if( view ==null )
            row = View.inflate(viewGroup.getContext(), R.layout.layout_row,null);
        else
            row = view;
        // gán dữ liệu
        Product objPro = listPro.get(i);
        // ánh xạ:
        ImageView img  = row.findViewById(R.id.img_res);
        TextView tv_id = row.findViewById(R.id.tv_id);
        TextView tv_name = row.findViewById(R.id.tv_name);

        //
        img.setImageResource( objPro.getImg_res() );
        tv_id.setText( objPro.getId() +"" );
        tv_name.setText( objPro.getName() );

        return row;
    }
}
