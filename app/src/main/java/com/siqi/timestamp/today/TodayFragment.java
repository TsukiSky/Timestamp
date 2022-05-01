package com.siqi.timestamp.today;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siqi.timestamp.R;

public class TodayFragment extends Fragment {
    private View rootView;

    public TodayFragment() {
        // Required empty public constructor
    }

    public static TodayFragment newInstance() {
        TodayFragment fragment = new TodayFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_today, container, false);

        initView();

        return rootView;
    }

    private void initView() {
        RecyclerView recyclerViewMustDone = rootView.findViewById(R.id.id_recycler_today_must_done);
        RecyclerView recyclerViewLater = rootView.findViewById(R.id.id_recycler_today_maybe_later);
        RecyclerView recyclerViewPostponed = rootView.findViewById(R.id.id_recycler_today_postponed);


    }
}