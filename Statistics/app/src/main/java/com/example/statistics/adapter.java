package com.example.statistics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.Holder> {
    Context c;
    ArrayList<users> d;
    public adapter(Context context, ArrayList<users> list) {
        c=context;
        d=list;
    }

    @NonNull
    @Override
    public adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.myitem,parent,false);
        Holder h=new Holder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.Holder holder, int position) {
          users gi=d.get(position);
        holder.t1.setText(gi.getState());
        holder.t2.setText(gi.getActive()+"");
        holder.t3.setText(gi.getRecovered()+"");
        holder.t4.setText(gi.getDeceased()+"");
    }

    @Override
    public int getItemCount() {
        return d.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3,t4;
        public Holder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.state);
            t2=itemView.findViewById(R.id.active);
            t3=itemView.findViewById(R.id.recover);
            t4=itemView.findViewById(R.id.death);
        }
    }
}
