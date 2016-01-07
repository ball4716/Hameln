package com.isoft.ible;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class LocationActivity extends Activity {

    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        mListView = (ListView) findViewById(R.id.list_location);

        ArrayList<Listviewitem> data = new ArrayList<>();

        Listviewitem incheon = new Listviewitem(R.mipmap.incheon, "인천대");
        Listviewitem seoul = new Listviewitem(R.mipmap.seoul, "서울대");
        Listviewitem inha = new Listviewitem(R.mipmap.inha, "인하대");

        data.add(incheon);
        data.add(seoul);
        data.add(inha);

        ListviewAdapter adapter=new ListviewAdapter(this,R.layout.item_location,data);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;
                String item = (String) listView.getItemAtPosition(position);
                Log.i(item, "ok");
                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
