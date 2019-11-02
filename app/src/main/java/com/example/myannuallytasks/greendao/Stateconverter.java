package com.example.myannuallytasks.greendao;

import com.example.myannuallytasks.Controller.State;

import org.greenrobot.greendao.converter.PropertyConverter;

//import org.greenrobot.greendao.converter.PropertyConverter;

public class Stateconverter implements PropertyConverter<State, String> {
    @Override
    public State convertToEntityProperty(String databaseValue) {
        if(databaseValue==null)
            return  null;

        return State.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(State entityProperty) {
        if(entityProperty==null)
            return null;

        return entityProperty.name();
    }
}
