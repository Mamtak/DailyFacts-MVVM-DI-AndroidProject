package com.app.dailyfacts.ui.dailyfacts;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.dailyfacts.HostApplication;
import com.app.dailyfacts.databinding.FragmentDailyFactsListBinding;
import com.app.dailyfacts.viewModel.DailyFactsViewModel;

import java.util.List;

import javax.inject.Inject;

public class DailyFactsFragment extends Fragment {
    private List<String> listOfFact;
    private LayoutInflater layoutInflater;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    DailyFactsViewModel dailyFactsViewModel;
    private FragmentDailyFactsListBinding fragmentDailyFactsListBinding;
    private DailyFactsAdapter adapter;
    public DailyFactsFragment() {
    }

    @NonNull
    public static DailyFactsFragment newInstance() {
        return new DailyFactsFragment();
    }

    /*------------------------------- Lifecycle -------------------------------*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((HostApplication) getActivity().getApplication())
                .getApplicationComponent()
                .inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentDailyFactsListBinding = FragmentDailyFactsListBinding.inflate(inflater, container, false);
        layoutInflater = getActivity().getLayoutInflater();
        return fragmentDailyFactsListBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Set up and subscribe (observe) to the ViewModel
        dailyFactsViewModel = new ViewModelProvider(this, viewModelFactory).get(DailyFactsViewModel.class);
        dailyFactsViewModel.getDailyDogFacts();
        dailyFactsViewModel.getDailyFactsList().observe(getViewLifecycleOwner(), this::setListOfFacts);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void setListOfFacts(List<String> listOfFacts) {
        fragmentDailyFactsListBinding.layoutProgressBar.getRoot().setVisibility(View.GONE);
        this.listOfFact = listOfFacts;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        fragmentDailyFactsListBinding.recListActivity.setLayoutManager(layoutManager);
        adapter = new DailyFactsAdapter(this.layoutInflater, getActivity());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(fragmentDailyFactsListBinding.recListActivity.getContext(),
                layoutManager.getOrientation());
        fragmentDailyFactsListBinding.recListActivity.addItemDecoration(dividerItemDecoration);
        fragmentDailyFactsListBinding.recListActivity.setAdapter(adapter);
        adapter.setListOfFacts(listOfFact);
    }

}
