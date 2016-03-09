package com.example.w4pity.totlistmanagerproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView) findViewById(R.id.listView);
        final ArrayList<Task> Tasks = new ArrayList<Task>();
        final CustomeArrayAdapter aa = new CustomeArrayAdapter(this,
                Tasks);
// make the list view an observer of the array adapter.
        listView.setAdapter(aa);
// add in 3 strings to the array adapter and ask the list view to update itself
        Tasks.add(new Task("task 1"));
        Tasks.add(new Task("task 2"));
        Tasks.add(new Task("task 3"));

        aa.notifyDataSetChanged();



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View v,
                                           int index, long arg3) {
                Toast.makeText(getApplicationContext(),Tasks.get(index).getName()+" has been removed", Toast.LENGTH_SHORT).show();
                if(arg0 == listView) {
                    Tasks.remove(index);
                    aa.notifyDataSetChanged();
                    return true;
                }
                return false;
            }
        });


        Button add_button = (Button) findViewById(R.id.add_buttom);
        final EditText text = (EditText) findViewById(R.id.text_newTask);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().toString()!= "")
                    Tasks.add(new Task(text.getText().toString()));
                aa.notifyDataSetChanged();
                text.setText("");
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