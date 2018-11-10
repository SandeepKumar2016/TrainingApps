package com.example.codelab_tablayout;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardContentFragment extends Fragment {


    public CardContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.item_card, container, false);
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);

        TIleContentFragment.ContentAdapter adapter = new TIleContentFragment.ContentAdapter();

        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        //return inflater.inflate(R.layout.item_tile, container, false);

        return recyclerView;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));
        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<TIleContentFragment.ViewHolder>{

        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 18;

        public ContentAdapter() {
        }

        @NonNull
        @Override
        public TIleContentFragment.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TIleContentFragment.ViewHolder(LayoutInflater.from(parent.getContext()),parent);
        }

        @Override
        public void onBindViewHolder(@NonNull TIleContentFragment.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }

}
