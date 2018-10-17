package com.example.recyclerpractice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


//  2)    The view holder objects are managed by an adapter, which you create by extending RecyclerView.Adapter.
//        The adapter creates view holders as needed. The adapter also binds the view holders to their data.
//        It does this by assigning the view holder to a position,
//        and calling the adapter's onBindViewHolder() method.
//        That method uses the view holder's position to determine what the contents should be, based on its list position.

public class cityAdapter extends RecyclerView.Adapter {

    Context mcontext;
    private onRecyclerItemClikedListener onRecyclerItemClikedListener;


// 1)   The views in the list are represented by view holder objects.
//    These objects are instances of a class you define by extending RecyclerView.ViewHolder.
//    Each view holder is in charge of displaying a single item with a view.
//    For example, if your list shows music collection, each view holder might represent a single album.
//    The RecyclerView creates only as many view holders as are needed to display the on-screen
//    portion of the dynamic content, plus a few extra. As the user scrolls through the list,
//    the RecyclerView takes the off-screen views and rebinds them to the data which is scrolling onto the screen.
//


    private ArrayList<nederalndsCities> nederalndsCitiesArrayList;//2

    public cityAdapter(Context mcontext, ArrayList<nederalndsCities> nederalndsCitiesArrayList){//2.1
        this.mcontext = mcontext;
        this.nederalndsCitiesArrayList = nederalndsCitiesArrayList;
    }

    public void setOnRecyclerItemClickedListener(cityAdapter.onRecyclerItemClikedListener onRecyclerItemClickedListener) {
        this.onRecyclerItemClikedListener = onRecyclerItemClickedListener;
    }



    public class HolderForLayout extends RecyclerView.ViewHolder{//1

        CircleImageView circleimage;
        TextView personName;
        TextView cityName;

        public HolderForLayout(View view){
            super(view);

            circleimage = view.findViewById(R.id.imageOfCity);
            personName = view.findViewById(R.id.nameOfPerson);
            cityName = view.findViewById(R.id.nameOfCity);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRecyclerItemClikedListener.onItemClicked(getAdapterPosition()
                    );
                }
            });


        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);

        return new HolderForLayout(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        nederalndsCities nederalndsCities = nederalndsCitiesArrayList.get(position);

        nederalndsCities.setCityImage(nederalndsCities.getCityImage());
        nederalndsCities.setCityName(nederalndsCities.getCityName());
        nederalndsCities.setPersonName(nederalndsCities.getPersonName());
    }


    @Override
    public int getItemCount() {
        return nederalndsCitiesArrayList.size();
    }


    public interface onRecyclerItemClikedListener{

        public void onItemClicked(int position);

    }

}
