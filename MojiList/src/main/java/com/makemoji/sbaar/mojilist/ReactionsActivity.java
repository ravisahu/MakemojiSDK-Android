package com.makemoji.sbaar.mojilist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.makemoji.mojilib.model.ReactionsData;

import org.json.JSONArray;

import java.util.ArrayList;

public class ReactionsActivity extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reactions);
        lv = (ListView)findViewById(R.id.list_view);
        ReactionsAdapter adapter = new ReactionsAdapter(this,new ArrayList<MojiMessage>());
        try {
            for (int i = 0; i < Sample.reactions.length; i++) {
                adapter.add(new MojiMessage(Sample.reactions[i]));
            }
        }
        catch (Exception e){}
        lv.setAdapter(adapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ReactionsData.onActivityResult(requestCode,resultCode,data);
    }
}
