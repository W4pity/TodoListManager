package com.example.w4pity.totlistmanagerproject;

import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by W4pity on 09/03/2016.
 */
public class Task{

    private String tv;
    private boolean checked = false;

    public Task(String name)
    {
        tv = name;
    }


    public boolean getChecked()
    {
        return checked;
    }
    public String getName()
    {
        return tv;
    }

    public void SetChecked(boolean b)
    {
        checked = b;
    }
    public void setName(String n)
    {
        tv = n;
    }

}
