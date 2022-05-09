package com.siqi.timestamp.today;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.siqi.timestamp.Model;
import com.siqi.timestamp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TodayFragment extends Fragment {

    private View rootView;
    // recyclerview
    RecyclerView recyclerViewMustDone;
    RecyclerView recyclerViewLater;
    RecyclerView recyclerViewPostponed;
    Model.EntrySource entrySourceMustDone;
    Model.EntrySource entrySourceViewLater;
    Model.EntrySource entrySourcePostponed;

    // add icon init
    ImageView add_today_must_done;
    ImageView add_today_maybe_later;
    ImageView add_today_postponed;

    // add item request
    List<Model.Entry> entries_must_done  = new ArrayList<>();
    List<Model.Entry> entries_maybe_later  = new ArrayList<>();
    List<Model.Entry> entries_postpone  = new ArrayList<>();
    public static int adding = 0; // 1: must, 2:maybe, 3: postpone
    public final static int ADD_MUST_CODE = 1;
    public final static int ADD_MAYBE_CODE = 2;
    public final static int ADD_POSTPONE_CODE = 3;
    public final static int ADDITEM_REQUEST = 9;
    public final static String CONTENT = "CONTENT";

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

        // recyclerview
        recyclerViewMustDone = rootView.findViewById(R.id.id_recycler_today_must_done);
        recyclerViewLater = rootView.findViewById(R.id.id_recycler_today_maybe_later);
        recyclerViewPostponed = rootView.findViewById(R.id.id_recycler_today_postponed);


        // add icon init
        add_today_must_done = rootView.findViewById(R.id.id_add_today_must_done);
        add_today_maybe_later = rootView.findViewById(R.id.id_add_today_maybe_later);
        add_today_postponed = rootView.findViewById(R.id.id_add_today_postponed);

        // set recyclerView minimum height
        recyclerViewMustDone.setMinimumHeight(400);
        recyclerViewLater.setMinimumHeight(400);
        recyclerViewPostponed.setMinimumHeight(400);


        // demo code
        entries_must_done.add(new Model.Entry("1. this is for demo only"));
        entries_must_done.add(new Model.Entry("2. this is the test for long scaled content, let's see what will happen"));
        entrySourceMustDone = new Model.EntrySource(entries_must_done);
        EntryAdapter entryAdapter = new EntryAdapter(TodayFragment.super.getContext(), entrySourceMustDone);
        recyclerViewMustDone.setAdapter(entryAdapter);
        recyclerViewMustDone.setLayoutManager(new LinearLayoutManager(TodayFragment.super.getContext()));

        // initAddIcons
        ArrayList<View> icons = new ArrayList<>();
        icons.add(add_today_must_done);
        icons.add(add_today_maybe_later);
        icons.add(add_today_postponed);
        initAddIcons(icons);

    }

    @SuppressLint("NonConstantResourceId")
    private void initAddIcons(ArrayList<View> icons){
        for (View icon: icons){
            icon.setOnClickListener(view -> {

                // start new activity
                Intent addItemIntent = new Intent(getContext(),AddItemActivity.class);
                switch (icon.getId()){
                    case R.id.id_add_today_must_done:
                        adding = ADD_MUST_CODE;
                        break;
                    case R.id.id_add_today_maybe_later:
                        adding = ADD_MAYBE_CODE;
                        break;
                    case R.id.id_add_today_postponed:
                        adding = ADD_POSTPONE_CODE;
                        break;
                }
                startActivityForResult(addItemIntent,ADDITEM_REQUEST);
            });
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        String content;
        if (resultCode == RESULT_OK && requestCode == ADDITEM_REQUEST && intent!=null){
                content = intent.getStringExtra(CONTENT);
                switch (adding) {
                    case ADD_MUST_CODE:
                         entries_must_done.add(new Model.Entry(content));
                        break;
                    case ADD_MAYBE_CODE:
                        entries_maybe_later.add(new Model.Entry(content));
                        break;
                    case ADD_POSTPONE_CODE:
                        entries_postpone.add(new Model.Entry(content));
                        break;
                }

                // update recycler view
                entrySourceMustDone = new Model.EntrySource(entries_must_done);
                entrySourceViewLater = new Model.EntrySource(entries_maybe_later);
                entrySourcePostponed = new Model.EntrySource(entries_postpone);

                EntryAdapter entryAdapterMD = new EntryAdapter(TodayFragment.super.getContext(), entrySourceMustDone);
                EntryAdapter entryAdapterML = new EntryAdapter(TodayFragment.super.getContext(), entrySourceViewLater);
                EntryAdapter entryAdapterPP = new EntryAdapter(TodayFragment.super.getContext(), entrySourcePostponed);

                recyclerViewMustDone.setAdapter(entryAdapterMD);
                recyclerViewLater.setAdapter(entryAdapterML);
                recyclerViewPostponed.setAdapter(entryAdapterPP);

                recyclerViewMustDone.setLayoutManager(new LinearLayoutManager(TodayFragment.super.getContext()));
                recyclerViewLater.setLayoutManager(new LinearLayoutManager(TodayFragment.super.getContext()));
                recyclerViewPostponed.setLayoutManager(new LinearLayoutManager(TodayFragment.super.getContext()));


        }

    }

}