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
public class ListContentFragment extends Fragment {


    public ListContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.item_list, container, false);

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);

        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());

        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));


        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView avatar;
        TextView title, desc;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_list, parent, false));

            avatar = itemView.findViewById(R.id.list_avatar);
            title = itemView.findViewById(R.id.list_title);
            desc = itemView.findViewById(R.id.list_desc);
        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {

        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 18;
        private final String[] mPlaces;
        private final String[] mPlaceDesc;
        private final Drawable[] mPlaceAvatars;




        public ContentAdapter(Context context) {

            Resources resources = context.getResources();

            mPlaces = resources.getStringArray(R.array.places);
            mPlaceDesc = resources.getStringArray(R.array.place_desc);

            TypedArray a = resources.obtainTypedArray(R.array.place_avator);

            mPlaceAvatars = new Drawable[a.length()];

            for (int i = 0; i < mPlaceAvatars.length; i++) {
                mPlaceAvatars[i] = a.getDrawable(i);
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

            holder.avatar.setImageDrawable(mPlaceAvatars[position % mPlaceAvatars.length]);

            holder.title.setText(mPlaces[position % mPlaces.length]);

            holder.desc.setText(mPlaceDesc[position % mPlaceDesc.length]);

        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }

}
