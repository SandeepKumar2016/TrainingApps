package com.example.fragmentwithrecyclerview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentWithRecyclerView.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentWithRecyclerView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentWithRecyclerView extends Fragment implements AdapterForRecyclerView.onRecyclerItemClickedListener{

    public ArrayList<UserData> dataArrayList;
    RecyclerView recyclerView;
    private AdapterForRecyclerView adapter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentWithRecyclerView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentWithRecyclerView.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentWithRecyclerView newInstance(String param1, String param2) {
        FragmentWithRecyclerView fragment = new FragmentWithRecyclerView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        prepareData();

        View rootView = inflater.inflate(R.layout.fragment_fragment_with_recycler_view, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerContainerInFragment);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);

        adapter.setOnRecyclerItemClickedListener(this);

        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(new AdapterForRecyclerView(getActivity(),dataArrayList));

        return rootView;

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
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
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
    public void onItemClicked(int position) {
        UserData userData = dataArrayList.get(position);



    }



}
