package manhntph29583.baithi.manhntph29583_ass_mob202.mFragment;

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

import manhntph29583.baithi.manhntph29583_ass_mob202.R;
import manhntph29583.baithi.manhntph29583_ass_mob202.mAdapter.viewpagerAdapter.vpQuanLyAdapter;

public class QuanLyFrag extends Fragment {

    TabLayout mTabLayout;
    ViewPager2 mViewPager;
    vpQuanLyAdapter viewpagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.quanly_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTabLayout =view.findViewById(R.id.tab_layoutQL);
        mViewPager = view.findViewById(R.id.viewpagerQL);
        viewpagerAdapter = new vpQuanLyAdapter(this);
        mViewPager.setAdapter(viewpagerAdapter);

        TabLayoutMediator mediator =new TabLayoutMediator(mTabLayout, mViewPager, (tab, position) -> {
            switch (position){
                case 0: tab.setText("Chi tiêu");
                   break;
                case 1: tab.setText("Thu nhập");
                    break;
            }
        });
        mediator.attach();
    }
}
