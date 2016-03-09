package com.example.w4pity.totlistmanagerproject;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by W4pity on 09/03/2016.
 */
public class CustomeArrayAdapter extends ArrayAdapter<Task> {
    public CustomeArrayAdapter(Context context, ArrayList<Task> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        final Task task = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.program_list, parent, false);
        }
        // Lookup view for data population
        TextView name = (TextView) convertView.findViewById(R.id.textView1);
        final CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkbox);

        cb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (cb.isChecked()) {
                   task.SetChecked(true);
                } else {
                    task.SetChecked(false);
                }
            }
        });
        // Populate the data into the template view using the data object
        name.setText(task.getName());
        //cb.(task.hometown);
        // Return the completed view to render on screen
        cb.setChecked(task.getChecked());
        return convertView;
    }
}
