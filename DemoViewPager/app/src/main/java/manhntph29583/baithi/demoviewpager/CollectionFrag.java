package manhntph29583.baithi.demoviewpager;

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

public class CollectionFrag extends Fragment {
    ViewPager2 pager2;
    PagerAdapter01 adapter01;
    TabLayout tabLayout01;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_collection_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Gắn adapter vào pager
        pager2 = view.findViewById(R.id.pager01);
        adapter01 = new PagerAdapter01(this);
        pager2.setAdapter(adapter01)    ;
        //Gắn tab vào viewpager
        tabLayout01 = view.findViewById(R.id.tab01);
        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout01, pager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText("Tab "+position);
            }
        });
        mediator.attach();//gắn tab vào viewpager
    }
}
