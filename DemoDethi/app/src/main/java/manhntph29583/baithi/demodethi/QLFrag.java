package manhntph29583.baithi.demodethi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import manhntph29583.baithi.demodethi.mAdapter.vpAdapter;

public class QLFrag extends Fragment {
    ViewPager2 pager2;
    vpAdapter adapter01;
    TabLayout tabLayout01;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ql_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Gắn adapter vào pager
        pager2 = view.findViewById(R.id.viewpagerQL);
        adapter01 = new vpAdapter(this);
        pager2.setAdapter(adapter01);
        //Gắn tab vào viewpager
        tabLayout01 = view.findViewById(R.id.tab_layoutQL);
        TabLayoutMediator mediator =new TabLayoutMediator(tabLayout01, pager2, (tab, position) -> {
            switch (position){
                case 0: tab.setText("User");
                    break;
                case 1: tab.setText("Group");
                    break;
            }
        });
        mediator.attach();//gắn tab vào viewpager
    }
}
