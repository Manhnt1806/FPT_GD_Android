package manhntph29583.baithi.manhntph29583_ass_mob202.mAdapter.viewpagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import manhntph29583.baithi.manhntph29583_ass_mob202.mFragment.KhoanChiFrag;
import manhntph29583.baithi.manhntph29583_ass_mob202.mFragment.KhoanThuFrag;

public class vpQuanLyAdapter extends FragmentStateAdapter {
    int slPage = 2;
    public vpQuanLyAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new KhoanChiFrag();
            case 1: return new KhoanThuFrag();
            default: return new KhoanChiFrag();
        }
    }

    @Override
    public int getItemCount() {
        return  slPage;
    }
}
