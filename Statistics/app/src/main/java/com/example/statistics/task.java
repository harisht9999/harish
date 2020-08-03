package com.example.statistics;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class task extends AsyncTask<Void,Void,String> {
    int pos;
    RecyclerView r;
    Context context;
    String state;
    ArrayList<users> list;
    ProgressDialog p;
    PieChart gopal;
    ArrayList<PieEntry> pieEntries;
    String url="https://api.covid19india.org/state_district_wise.json";
    public task(District_data district_data, int position, RecyclerView rv, String statename, PieChart pc) {
        context=district_data;
        pos=position;
        r=rv;
        state=statename;
        gopal=pc;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        p=new ProgressDialog(context);
        p.setTitle("Loading......");
        p.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        p.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL ur=new URL(url);
            HttpURLConnection connection= (HttpURLConnection) ur.openConnection();
            InputStream inputStream=connection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            StringBuilder builder=new StringBuilder();
            while((line=reader.readLine())!=null)
            {
                builder.append(line);
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        p.dismiss();
        super.onPostExecute(s);
        list=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(s);
            JSONObject object=jsonObject.getJSONObject(state);
            JSONObject  dl=object.getJSONObject("districtData");
            Iterator<?> keys=dl.keys();
            while(keys.hasNext()) {
                String key= (String) keys.next();
                if(dl.get(key) instanceof JSONObject) {
                    JSONObject sp = dl.getJSONObject(key);
                    String active = sp.getString("confirmed");
                    String recover = sp.getString("recovered");
                    String deceased = sp.getString("deceased");
                    Log.i("data", key + ":" + active + ":" + recover + ":" + deceased);
                    users us = new users(key, Integer.parseInt(active), Integer.parseInt(recover), Integer.parseInt(deceased));
                    list.add(us);
                }
            }
            r.setLayoutManager(new LinearLayoutManager(context));
            adapter l=new adapter(context,list);
            r.setAdapter(l);
            pieEntries=new ArrayList<>();
            users use;
            for(int sta=0;sta<list.size();sta++) {
                use=list.get(sta);
                pieEntries.add(new PieEntry(use.getActive(),use.getState()));
            }
            PieDataSet dataSet=new PieDataSet(pieEntries,"covid cases");
            dataSet.setValueTextSize(0f);
            ArrayList<Integer> colors=new ArrayList<>();
            for(int c: ColorTemplate.VORDIPLOM_COLORS)
                colors.add(c);
            for(int c:ColorTemplate.JOYFUL_COLORS)
                colors.add(c);
            for(int c:ColorTemplate.COLORFUL_COLORS)
                colors.add(c);
            for(int c:ColorTemplate.LIBERTY_COLORS)
                colors.add(c);
            for(int c:ColorTemplate.PASTEL_COLORS)
                colors.add(c);
            for(int c:ColorTemplate.MATERIAL_COLORS)
                colors.add(c);
            colors.add(ColorTemplate.getHoloBlue());
            dataSet.setColors(colors);
            dataSet.setValueTextColor(Color.BLACK);
            PieData pieData=new PieData(dataSet);
            gopal.setData(pieData);
            gopal.setCenterText("covid cases india");
            gopal.getDescription().setEnabled(false);
            gopal.animate();
            gopal.setEntryLabelTextSize(7f);
            gopal.setEntryLabelColor(Color.BLACK);
            gopal.setHoleRadius(40f);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
