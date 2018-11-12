package com.example.codelab_tablayout;


import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TIleContentFragment extends Fragment {


    public TIleContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);

        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());

        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);

        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);


        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));

        //return inflater.inflate(R.layout.item_tile, container, false);

        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView picture;
        public TextView name;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_tile, parent, false));

            picture = itemView.findViewById(R.id.tile_picture);
            name = itemView.findViewById(R.id.tile_title);

        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder>{

        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 18;
        private final String[] mPlaces;
        private final Drawable[] mPlacePics;


        public ContentAdapter(Context context) {

            Resources resources = context.getResources();

            mPlaces = resources.getStringArray(R.array.places);
            TypedArray a = resources.obtainTypedArray(R.array.places_picture);
            mPlacePics = new Drawable[a.length()];
            for (int i = 0; i < mPlacePics.length; i++) {
                mPlacePics[i] = a.getDrawable(i);
            }
            a.recycle();

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()),parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            holder.picture.setImageDrawable(mPlacePics[position % mPlacePics.length]);
            holder.name.setText(mPlaces[position % mPlacePics.length]);

        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }

}
