package com.example.covid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {
    List<users> myList;
    Context c;
    public myAdapter(Context context, List<users> list) {
        c=context;
        myList=list;
    }

    @NonNull
    @Override
    public myAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.activity_details,parent,false);

        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.myViewHolder holder, int position) {
        users us=myList.get(position);
        holder.date.setText(us.getDate());
        holder.dea.setText(us.getDeath());
        holder.ac.setText(us.getActive());
        holder.re.setText(us.getRecovered());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView ac,date,re,dea;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            ac=itemView.findViewById(R.id.active);
            date=itemView.findViewById(R.id.date);
            re=itemView.findViewById(R.id.recover);
            dea=itemView.findViewById(R.id.death);
        }
    }
}
