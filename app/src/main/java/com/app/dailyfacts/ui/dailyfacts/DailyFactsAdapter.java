package com.app.dailyfacts.ui.dailyfacts;


import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dailyfacts.R;

import java.util.List;

public class DailyFactsAdapter extends RecyclerView.Adapter<DailyFactsAdapter.DailyFactsViewHolder> {
    private static final String EXTRA_PERSON_ID = "EXTRA_PERSON_ID";

    public List<String> getListOfPeople() {
        return listOfFacts;
    }

    public void setListOfFacts(List<String> listOfFacts) {
        this.listOfFacts = listOfFacts;
    }

    private List<String> listOfFacts;
    private LayoutInflater layoutInflater;
    private Activity activity;

    public DailyFactsAdapter(LayoutInflater layoutInflater, Activity activity) {
        this.layoutInflater = layoutInflater;
        this.activity = activity;
    }

    @NonNull
    @Override
    public DailyFactsAdapter.DailyFactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.facts_item, parent, false);
        return new DailyFactsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DailyFactsAdapter.DailyFactsViewHolder holder, int position) {
        //11. and now the ViewHolder data
        String currentItem = listOfFacts.get(position);
        holder.facts.setText(currentItem);

    }

    @Override
    public int getItemCount() {
        // 12. Returning 0 here will tell our Adapter not to make any Items. Let's fix that.
        Log.e("SIZEEEE", ""+listOfFacts.size());
      return listOfFacts.size();
    }

    static class DailyFactsViewHolder extends RecyclerView.ViewHolder {
        private final TextView facts;

        public DailyFactsViewHolder(View itemView) {
            super(itemView);
            this.facts = (TextView) itemView.findViewById(R.id.lbl_facts);
        }
    }
}
