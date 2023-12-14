package manhntph29583.baithi.demo_tonghop_manhntph29583.Fragment;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import manhntph29583.baithi.demo_tonghop_manhntph29583.AdapterTH.DsAdapter;
import manhntph29583.baithi.demo_tonghop_manhntph29583.DAO.mDAO;
import manhntph29583.baithi.demo_tonghop_manhntph29583.DTO.content;
import manhntph29583.baithi.demo_tonghop_manhntph29583.R;

public class DsFrag extends Fragment {
    RecyclerView rcvDs;
    mDAO dao;
    ArrayList<content> list = new ArrayList<>();
    DsAdapter adapter;
    private SearchView searchView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.edit_frag_layout, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvDs = view.findViewById(R.id.rcv_ds);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcvDs.setLayoutManager(layoutManager);
        dao = new mDAO(getContext());
        list = dao.getAll();
        adapter = new DsAdapter(getContext(), list);
        rcvDs.setAdapter(adapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText );
                return false;
            }
        });
    }
}
