package com.isoft.ible;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class LocationdetailActivity extends Activity {

    private ListView m_ListView;
    private ArrayAdapter<String> m_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        m_Adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);

        m_ListView = (ListView) findViewById(R.id.location);

        m_ListView.setAdapter(m_Adapter);

        m_ListView.setOnItemClickListener(onClickListItem);

        m_Adapter.add("인천대");
        m_Adapter.add("인하대");
    }

    private OnItemClickListener onClickListItem = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            //Toast.makeText(getApplicationContext(),m_Adapter.getItem(arg2),Toast.LENGTH_SHORT).show();
            if(arg2 == 0){
                //Toast.makeText(getApplicationContext(), "d", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LocationdetailActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        }
    };


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
