package manhntph29583.baithi.demodethi.mAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import manhntph29583.baithi.demodethi.Frag.GroupFrag;
import manhntph29583.baithi.demodethi.Frag.UserFrag;

public class vpAdapter extends FragmentStateAdapter {
    int soluongPage = 2;
    public vpAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new UserFrag();
            case 1: return new GroupFrag();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return soluongPage;
    }
}
