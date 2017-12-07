package productions.darthplagueis.midtermassessment.controller;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
//import android.support.v4.app.FragmentManager;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import productions.darthplagueis.midtermassessment.NumbersFragment;
import productions.darthplagueis.midtermassessment.R;
import productions.darthplagueis.midtermassessment.model.Numbers;

/**
 * Created by oleg on 12/6/17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<Numbers> numbersList;

    public ListAdapter(List<Numbers> numbersList) {
        this.numbersList = numbersList;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_itemview, parent, false);
        return new ListViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(final ListViewHolder holder, int position) {
        Numbers numbers = numbersList.get(position);
        holder.textView.setText(numbers.getNumbersSting());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int getNumber = Integer.parseInt(holder.textView.getText().toString());
                int newNumber = getNumber * 10;
                String displayNumber = String.valueOf(newNumber);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                NumbersFragment numbersFragment = new NumbersFragment();
                Bundle bundle = new Bundle();
                bundle.putString("text", displayNumber);
                numbersFragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.list_container, numbersFragment).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return numbersList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linearLayout;
        private TextView textView;

        public ListViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.recycler_layout);
            textView = (TextView) itemView.findViewById(R.id.recycler_textview);

        }
    }
}
