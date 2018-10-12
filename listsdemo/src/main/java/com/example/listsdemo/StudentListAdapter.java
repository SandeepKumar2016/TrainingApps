package com.example.listsdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>{

Context context;
ArrayList<Student> dataArrayList;
    public StudentListAdapter(Context context, ArrayList<Student> dataArrayList){
        this.context=context;
        this.dataArrayList=dataArrayList;
    }
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_item_view,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student=dataArrayList.get(position);
        holder.tvForName.setText(student.getName());
        holder.tvForAddress.setText(student.getAddress());
        holder.imgForProfilePic.setImageDrawable(ContextCompat.getDrawable(context,student.getProfilePic()));

    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder{

        TextView tvForAddress,tvForName;
        ImageView imgForProfilePic;
        public StudentViewHolder(View itemView) {
            super(itemView);
            tvForAddress=itemView.findViewById(R.id.tvForStudentAddress);
            tvForName=itemView.findViewById(R.id.tvForStudentName);
            imgForProfilePic=itemView.findViewById(R.id.imgForProfilePic);
        }
    }
}
