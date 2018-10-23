package com.example.tablayoutpractice;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatusFragment extends Fragment implements AdapterForRecyclerView.onRecyclerItemClickedListener {

    public ArrayList<UserData> dataArrayList;
    RecyclerView recyclerView;
    private AdapterForRecyclerView adapter;
    Context mcontext;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    public StatusFragment() {
        // Required empty public constructor
    }



    public static StatusFragment newInstance(String param1, String param2) {
        StatusFragment fragment = new StatusFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        prepareData();

        View rootView = inflater.inflate(R.layout.status_layout, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerContainerInFragment);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setHasFixedSize(true);

        adapter = new AdapterForRecyclerView(mcontext, dataArrayList);

        recyclerView.setAdapter(adapter);

        adapter.setOnRecyclerItemClickedListener(this);

        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        return rootView;
//        return inflater.inflate(R.layout.status_layout, container, false);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mcontext=context;
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    public void prepareData() {

        dataArrayList = new ArrayList<UserData>();

        for (int index = 0; index < 5; index++) {

            dataArrayList.add(new UserData("Harry Potter", "Amsterdam", R.drawable.ic_launcher_background));
        }

        for (int index = 0; index < 5; index++) {

            dataArrayList.add(new UserData("Peter Pains", "Utrecht", R.drawable.ic_launcher_background));
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClicked(int position) {

        UserData userData = dataArrayList.get(position);

        Toast.makeText(mcontext,userData.getUserName(), Toast.LENGTH_SHORT).show();

    }
}
