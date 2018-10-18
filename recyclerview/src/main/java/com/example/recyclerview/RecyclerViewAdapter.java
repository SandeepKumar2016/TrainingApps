package com.example.recyclerview;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<String> imageData = new ArrayList<>();
    private ArrayList<String> personNameData = new ArrayList<>();
    private ArrayList<String> addressData = new ArrayList<>();

    private Context mContext;
    private onRecyclerItemClickedListener onRecyclerItemClickedListener;//this is to hold the interface implemented object by the class who implements our interface

    public RecyclerViewAdapter(Context mCotext, ArrayList<String> imageData, ArrayList<String> personNameData, ArrayList<String> addressData) {
        this.imageData = imageData;
        this.personNameData = personNameData;
        this.addressData = addressData;
        this.mContext = mCotext;
    }

    public void setOnRecyclerItemClickedListener(RecyclerViewAdapter.onRecyclerItemClickedListener onRecyclerItemClickedListener) {
        this.onRecyclerItemClickedListener = onRecyclerItemClickedListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This method is responsible for inflating the view

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layut_list_item, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //

        Log.d("TAG", "OnBindVewHolder is created");

        //First get the images
       Glide.with(mContext).load(imageData.get(position)).into(holder.image);


        holder.personName.setText(personNameData.get(position));

        holder.addressofPerson.setText(addressData.get(position));
    }

    @Override
    public int getItemCount() {
        //This method tells adapter that how list items are present in the list
        return imageData.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView  personName;
        TextView addressofPerson;
        RelativeLayout parent_Layout;

        public MyViewHolder(View itemView) {
            super(itemView);

         image = itemView.findViewById(R.id.imageOfList);
         personName = itemView.findViewById(R.id.nameOfPerson);
         addressofPerson = itemView.findViewById(R.id.addressOfPeroson);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                    public void onClick(View v) {
                            onRecyclerItemClickedListener.onItemClicked(getAdapterPosition());
                    }
                });
        }
    }

    public interface onRecyclerItemClickedListener{
        public void onItemClicked(int position);
    }
}
