package fpt.poly.mob202_ontap.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fpt.poly.mob202_ontap.fragment.fragment_danhsach_ghichu;
import fpt.poly.mob202_ontap.fragment.fragment_them_ghichu;

public class Adapter_pager extends FragmentStateAdapter {
    int quantityPage = 2;
    public Adapter_pager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new fragment_danhsach_ghichu();
            case 1:
                return new fragment_them_ghichu();
            default:
                return new fragment_danhsach_ghichu();
        }
    }

    @Override
    public int getItemCount() {
        return quantityPage;
    }
}
