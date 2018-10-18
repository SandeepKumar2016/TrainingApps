package com.example.fragmentwithrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterForRecyclerView extends RecyclerView.Adapter<AdapterForRecyclerView.MyViewHolder>{

    ArrayList<UserData> userDataArrayList;
    Context mContext;
    private onRecyclerItemClickedListener onRecyclerItemClikedListener;


    public AdapterForRecyclerView(FragmentActivity mContext, ArrayList<UserData> userDataArrayList) {
        this.userDataArrayList = userDataArrayList;
        this.mContext = mContext;
    }

    public void setOnRecyclerItemClickedListener(AdapterForRecyclerView.onRecyclerItemClickedListener onRecyclerItemClickedListener) {
        this.onRecyclerItemClikedListener = onRecyclerItemClickedListener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d("TAG", "onCreateViewHolder is created");


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Log.d("TAG", "OnBindVewHolder is created");


        UserData userData = userDataArrayList.get(position);
        holder.cityName.setText(userData.getUserCity());
        holder.personName.setText(userData.getUserName());
        userData.setCityImage(userData.getCityImage());



        //Glide.with(mContext).load(holder.imageOfCity).into(holder.imageOfCity);

    }

    @Override
    public int getItemCount() {
        return userDataArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imageOfCity;
        TextView personName;
        TextView cityName;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageOfCity = itemView.findViewById(R.id.imageOfCity);
            personName = itemView.findViewById(R.id.nameOfPerson);
            cityName = itemView.findViewById(R.id.cityOfPeroson);

            itemView.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                onRecyclerItemClikedListener.onItemClicked(getAdapterPosition());
                                            }
                                        }
            );
        }
    }


    interface onRecyclerItemClickedListener{

        public void onItemClicked(int position);
    }

}
