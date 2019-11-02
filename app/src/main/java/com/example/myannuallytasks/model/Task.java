package com.example.myannuallytasks.model;

import com.example.myannuallytasks.Controller.State;
import com.example.myannuallytasks.greendao.Stateconverter;
import com.example.myannuallytasks.greendao.UuidConverter;


import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;
import org.greenrobot.greendao.annotation.Generated;



@Entity(nameInDb = "Task")
public class Task {

    @Id(autoincrement = true)
    private Long _id;

    @Property(nameInDb = "uuid")
    @Index(unique = true)
    @Convert(converter = UuidConverter.class, columnType = String.class)
    private UUID id;

   /* @Property(nameInDb = "id_user")
    @Index(unique = true)
    @Convert(converter = UuidConverter.class, columnType = String.class)
    private  UUID id_user;*/

    @Property(nameInDb = "title")
    String mTitle;

    @Property(nameInDb = "detaile")
    String mdetaile;


    @Property(nameInDb = "state")
    @Convert(converter = Stateconverter.class, columnType = String.class)
    State mState;


    /// @Convert(converter = dateConverter.class, columnType = Long.class)
    @Property(nameInDb = "date")
    Date mDate;


    @Property(nameInDb = "time")
    Date mTime;

    public Task(String mTitle, String mdetaile, State mState, Date mDate, Date mTime) {
        this.mTitle = mTitle;
        this.mdetaile = mdetaile;
        this.mState = mState;
        this.mDate = mDate;
        this.mTime = mTime;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public UUID getId() {
        return id;
    }

    public String getmTitle() {
        return mTitle;
    }

    public State getmState() {
        return mState;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmState(State mState) {
        this.mState = mState;
    }

    public String getmdetaile() {
        return mdetaile;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmdetaile(String mdetaile) {
        this.mdetaile = mdetaile;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    /////////////////////////////
    public Task() {
        id = UUID.randomUUID();
      //  mDate = generateRandomDate();
//        mDate = new Date();  زمان همان لحطه
    }

    @Generated(hash = 1283240592)
    public Task(Long _id, UUID id, String mTitle, String mdetaile, State mState, Date mDate,
            Date mTime) {
        this._id = _id;
        this.id = id;
        this.mTitle = mTitle;
        this.mdetaile = mdetaile;
        this.mState = mState;
        this.mDate = mDate;
        this.mTime = mTime;
    }

  ///////////////

    private int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMTitle() {
        return this.mTitle;
    }

    public void setMTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getMdetaile() {
        return this.mdetaile;
    }

    public void setMdetaile(String mdetaile) {
        this.mdetaile = mdetaile;
    }

    public State getMState() {
        return this.mState;
    }

    public void setMState(State mState) {
        this.mState = mState;
    }

    public Date getMDate() {
        return this.mDate;
    }

    public void setMDate(Date mDate) {
        this.mDate = mDate;
    }

    public Date getMTime() {
        return this.mTime;
    }

    public void setMTime(Date mTime) {
        this.mTime = mTime;
    }
}
