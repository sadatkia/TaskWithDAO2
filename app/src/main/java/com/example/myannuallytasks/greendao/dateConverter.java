package com.example.myannuallytasks.greendao;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.Date;

public class dateConverter implements PropertyConverter<Date,Long> {
    @Override
    public Date convertToEntityProperty(Long databaseValue) {
        if(databaseValue==null)
            return  null;
        return new Date(databaseValue);
    }

    @Override
    public Long convertToDatabaseValue(Date entityProperty) {
        if(entityProperty==null)
            return null;
        return entityProperty.getTime();
    }
}
