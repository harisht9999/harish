package com.example.statistics;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.Myviewholder> {
     Context ct;
     List<users> u;
    public Myadapter(Context c, List<users> data) {
        u=data;
        ct=c;
    }

    @NonNull
    @Override
    public Myadapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ct).inflate(R.layout.myitem,parent,false);
        Myviewholder holder=new Myviewholder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Myadapter.Myviewholder holder, int position) {
           final users go=u.get(position);
           holder.t1.setText(go.getState());
           holder.t2.setText(go.getActive()+"");
           holder.t3.setText(go.getRecovered()+"");
           holder.t4.setText(go.getDeceased()+"");
           holder.t1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
              Intent i=new Intent(ct,District_data.class);
              i.putExtra("position",holder.getAdapterPosition());
              i.putExtra("state",go.getState());
              ct.startActivity(i);
               }
           });
    }

    @Override
    public int getItemCount() {
        return u.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3,t4;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.state);
            t2=itemView.findViewById(R.id.active);
            t3=itemView.findViewById(R.id.recover);
            t4=itemView.findViewById(R.id.death);
        }
    }
}
