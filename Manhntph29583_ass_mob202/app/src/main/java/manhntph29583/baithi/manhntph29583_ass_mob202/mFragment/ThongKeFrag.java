package manhntph29583.baithi.manhntph29583_ass_mob202.mFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import manhntph29583.baithi.manhntph29583_ass_mob202.R;
import manhntph29583.baithi.manhntph29583_ass_mob202.mAdapter.ThongKeKTAdapter;
import manhntph29583.baithi.manhntph29583_ass_mob202.mAdapter.ThongKeLCAdapter;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.KhoanChiDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDAO.KhoanThuDAO;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.KhoanThu;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.ThongKeKT;
import manhntph29583.baithi.manhntph29583_ass_mob202.mDTO.ThongKeLC;

public class ThongKeFrag extends Fragment {
    TextView tvTongThu, cvTongThu, tvTuNgayTk, tvTongChi, cvTongChi, tvSoDu;
    KhoanThuDAO ktDAO;
    KhoanChiDAO kcDAO;
    RecyclerView rcvThongKeTPC, rcvThongKeKT;
    ThongKeLCAdapter kcAdapter;
    ThongKeKTAdapter ktAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.thongke_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvTongThu = view.findViewById(R.id.tv_tong_thu);
        cvTongThu = view.findViewById(R.id.cv_tong_thu);
        tvTuNgayTk = view.findViewById(R.id.tv_tungay_tk);
        tvTongChi = view.findViewById(R.id.tv_tong_chi);
        cvTongChi = view.findViewById(R.id.cv_tong_chi);

        tvSoDu = view.findViewById(R.id.tv_so_du);
        rcvThongKeTPC = view.findViewById(R.id.rcv_thongke_TPC);
        rcvThongKeKT = view.findViewById(R.id.rcv_thongke_KT);

        Date objDate = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new DateFormat();
        String chuoi_ngay_thang_nam = (String) dateFormat.format("dd/MM/yyyy", objDate);
        tvTuNgayTk.setText(chuoi_ngay_thang_nam);

        ktDAO = new KhoanThuDAO(getContext());
        tvTongThu.setText(ktDAO.getTongThu()+"");
        cvTongThu.setText(ktDAO.getTongThu()+"");
        kcDAO = new KhoanChiDAO(getContext());
        tvTongChi.setText(kcDAO.getTongChi()+"");
        cvTongChi.setText(kcDAO.getTongChi()+"");
        tvSoDu.setText((ktDAO.getTongThu()-kcDAO.getTongChi())+"");

        rcvThongKeTPC.setLayoutManager(new LinearLayoutManager(getContext()));
        List<ThongKeLC> listTKC = kcDAO.getTongChiTP();
        kcAdapter = new ThongKeLCAdapter(getContext(), listTKC);
        rcvThongKeTPC.setAdapter(kcAdapter);

        rcvThongKeKT.setLayoutManager(new LinearLayoutManager(getContext()));
        List<ThongKeKT> listTKT = ktDAO.getTongThuTP();
        ktAdapter = new ThongKeKTAdapter(getContext(), listTKT);
        rcvThongKeKT.setAdapter(ktAdapter);


    }
}
