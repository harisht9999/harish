package com.example.statistics;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mytask extends AsyncTask<Void,Void,String> {
    Context c;
    RecyclerView recyclerView;
    ProgressDialog pd;
    PieChart pieChart;
    ArrayList<PieEntry> pieEntries;
    ArrayList<String> t;
    String url="https://api.covid19india.org/state_district_wise.json";
    public Mytask(MainActivity mainActivity, RecyclerView r, PieChart chart) {
        c=mainActivity;
        recyclerView=r;
        pieChart=chart;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Loading......");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL u=new URL(url);
            HttpURLConnection connection= (HttpURLConnection) u.openConnection();
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
        pd.dismiss();
        t=new ArrayList<>();
        try {
            JSONObject object=new JSONObject(s);
            Iterator<?> keys=object.keys();
            int i=0;
            int ja=0;
            int ka=0;
            String co="";
            List<users> data=new ArrayList<>();
            while(keys.hasNext())
            {
                String key= (String) keys.next();
                if(object.get(key) instanceof JSONObject)
                {
                    JSONObject j=object.getJSONObject(key);
                    JSONObject b=j.getJSONObject("districtData");
                    Iterator<?> dis=b.keys();
                    i=0;
                    ja=0;
                    ka=0;
                    while(dis.hasNext())
                    {
                        String District= (String) dis.next();
                        if(b.get(District) instanceof JSONObject)
                        {
                            JSONObject g=b.getJSONObject(District);
                            String active=g.getString("confirmed");
                            String recovered=g.getString("recovered");
                            String deceased=g.getString("deceased");
                            i=i+Integer.parseInt(active);
                            ja=ja+Integer.parseInt(recovered);
                            ka=ka+Integer.parseInt(deceased);

                        }
                    }
                    users u=new users(key,i,ja,ka);
                    co=j.getString("statecode");
                    t.add(co);
                    data.add(u);
                }
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(c));
            Myadapter myadapter=new Myadapter(c,data);
            recyclerView.setAdapter(myadapter);
            pieEntries=new ArrayList<>();
            users use;
             for(int sta=0;sta<37;sta++) {
                  use=data.get(sta);
                 pieEntries.add(new PieEntry(use.getActive(), t.get(sta)));
             }
            PieDataSet dataSet=new PieDataSet(pieEntries,"covid cases");
            dataSet.setValueTextSize(0f);
            ArrayList<Integer> colors=new ArrayList<>();
            for(int c:ColorTemplate.VORDIPLOM_COLORS)
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
            pieChart.setData(pieData);
            pieChart.setCenterText("covid cases india");
            pieChart.getDescription().setEnabled(false);
            pieChart.animate();
            pieChart.setEntryLabelTextSize(7f);
            pieChart.setEntryLabelColor(Color.BLACK);
            pieChart.setHoleRadius(40f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onPostExecute(s);
    }
}