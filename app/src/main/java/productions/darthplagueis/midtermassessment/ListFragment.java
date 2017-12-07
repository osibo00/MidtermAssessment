package productions.darthplagueis.midtermassessment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import productions.darthplagueis.midtermassessment.controller.ListAdapter;
import productions.darthplagueis.midtermassessment.model.Numbers;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;
    private TextView textView;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.listfrag_recycler);
        textView = (TextView) rootView.findViewById(R.id.listfrag_textview);
        Intent intent = getActivity().getIntent();
        String user = intent.getStringExtra("currentUser");
        textView.setText(user);

        List<Numbers> numbersList = new ArrayList<>();
//        for (int i = 0; i <= 10; i++) {
//            String number = String.valueOf(i);
//            numbersList.add(new Numbers(number));
//        }
        numbersList.add(new Numbers("0"));
        numbersList.add(new Numbers("1"));
        numbersList.add(new Numbers("2"));


        ListAdapter listAdapter = new ListAdapter(numbersList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        return rootView;
    }

}
