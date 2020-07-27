package com.example.covid19;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MyTask extends AsyncTask<Void,Void,String> {
    String url="https://api.covid19api.com/dayone/country/IN";
    Context context;
    RecyclerView r;
    public MyTask(MainActivity mainActivity, RecyclerView rv) {
        context=mainActivity;
        r=rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL u=new URL(url);
            HttpsURLConnection httpsURLConnection= (HttpsURLConnection) u.openConnection();
            InputStream inputStream=httpsURLConnection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            String Line="";
            StringBuilder builder=new StringBuilder();
            while((Line=reader.readLine())!=null)
            {
                builder.append(Line);
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        List<users> list=new ArrayList<>();
        try {
            JSONArray j=new JSONArray(s);
            for(int i=(j.length()-1);i>=0;i--) {
                JSONObject o = j.getJSONObject(i);
                String date = o.getString("Date").substring(0,10);
                String active = o.getString("Active");
                String Recovered = o.getString("Recovered");
                String death = o.getString("Deaths");
                users u = new users(date, active, Recovered, death);
                list.add(u);
            }
           r.setLayoutManager(new LinearLayoutManager(context));
           r.setAdapter(new myAdapter(context,list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
