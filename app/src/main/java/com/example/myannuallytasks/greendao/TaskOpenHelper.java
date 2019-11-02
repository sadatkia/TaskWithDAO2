package com.example.myannuallytasks.greendao;

import android.content.Context;

import com.example.myannuallytasks.model.DaoMaster;

public class TaskOpenHelper extends DaoMaster.OpenHelper{
    public static final String NAME = "task.db";

    public TaskOpenHelper(Context context) {
        super(context, NAME);
    }


}
