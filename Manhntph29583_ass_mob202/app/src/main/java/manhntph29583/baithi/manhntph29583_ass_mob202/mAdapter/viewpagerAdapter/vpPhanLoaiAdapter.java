package manhntph29583.baithi.manhntph29583_ass_mob202.mAdapter.viewpagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import manhntph29583.baithi.manhntph29583_ass_mob202.mFragment.LoaiChiFrag;
import manhntph29583.baithi.manhntph29583_ass_mob202.mFragment.LoaiThuFrag;

public class vpPhanLoaiAdapter extends FragmentStateAdapter {
    int slPage = 2;
    public vpPhanLoaiAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new LoaiChiFrag();
            case 1: return new LoaiThuFrag();
            default: return new LoaiChiFrag();
        }
    }

    @Override
    public int getItemCount() {
        return  slPage;
    }
}
