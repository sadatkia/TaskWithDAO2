package com.example.myannuallytasks.greendao;

import android.content.Context;

import com.example.myannuallytasks.model.DaoMaster;

public class PersonOpenHelper extends DaoMaster.OpenHelper {
    public static final String NAME_Person = "person.db";

    public PersonOpenHelper(Context context) {
        super(context, NAME_Person);
    }
}
