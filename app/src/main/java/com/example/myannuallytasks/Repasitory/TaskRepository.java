package com.example.myannuallytasks.Repasitory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myannuallytasks.Controller.State;
import com.example.myannuallytasks.greendao.TaskOpenHelper;
import com.example.myannuallytasks.model.DaoMaster;
import com.example.myannuallytasks.model.DaoSession;
import com.example.myannuallytasks.model.Task;
import com.example.myannuallytasks.model.TaskDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*import com.example.myannuallytasks.model.DataBase.TaskCursorWrapper;
import com.example.myannuallytasks.model.DataBase.TaskDataBaseSchema;*/

/*import static com.example.myannuallytasks.model.DataBase.TaskDataBaseSchema.TaskTable.Cols;
import static com.example.myannuallytasks.model.DataBase.TaskDataBaseSchema.TaskTable.NAME;*/


public class TaskRepository {
    private static TaskRepository instance;
    protected Context mContext;
    private TaskDao mTaskDao;


    List<Task> mTasks;

    List<Task> mTasksToDo;
    List<Task> mTasksDone;
    List<Task> mTasksDoing;


    public static TaskRepository getInstance(Context context) {
        if (instance == null)
            instance = new TaskRepository(context);

        return instance;

    }
    private TaskRepository(Context context) {
        mContext = context.getApplicationContext();
        //mDatabase = new TaskOpenHelper(context).getWritableDatabase();////چهار تا را صدا می کند .عین crud اگر دیتا بیس هست اپدیتش را می بیند ایا هست یا نه ؟اگر دارد کهههههه؟

        SQLiteDatabase db = new TaskOpenHelper(mContext).getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
       mTaskDao = daoSession.getTaskDao();

    }


    public List<Task>  getmTasksToDo() {

        mTasksToDo=new ArrayList<>();
        mTasks=new ArrayList<>();
        mTasks=mTaskDao.loadAll();
        for (int i=0;i<mTasks.size();i++){
            if (mTasks.get(i).getmState().equals(State.TODO)){
                mTasksToDo.add(mTasks.get(i));
            }
        }


            return mTasksToDo;
        }


    public List<Task>  getmTasksDone() {
        mTasksDone=new ArrayList<>();
        mTasks=new ArrayList<>();
        mTasks=mTaskDao.loadAll();
        for (int i=0;i<mTasks.size();i++){
            if (mTasks.get(i).getmState().equals(State.DONE)){
                mTasksDone.add(mTasks.get(i));
            }
        }


        return mTasksDone;
    }

    public List<Task>  getmTasksDoing() {
        mTasksDoing=new ArrayList<>();
        mTasks=new ArrayList<>();
        mTasks=mTaskDao.loadAll();
        for (int i=0;i<mTasks.size();i++){
            if (mTasks.get(i).getmState().equals(State.DOING)){
                mTasksDoing.add(mTasks.get(i));
            }
        }


        return mTasksDoing;
    }

    //////////////////////////////
    //read
    public  int getPosition(UUID uuid){
        //   List<Task> tasks=  mTaskDao.queryBuilder().list();
        List<Task> tasks=getmTasks();
        for(int i=0; i<tasks.size() ; i++) {
            if (tasks.get(i).getId().equals(uuid))
                return i;
        }
        return 0;
    }

    public Task getTask(UUID uuid) {
        return mTaskDao.queryBuilder().where(TaskDao.Properties.Id.eq(uuid)).unique();
    }

    public  List<Task> getmTasks(){
        // return  mTaskDao.queryBuilder().list();  this is true too
        return  mTaskDao.loadAll();
    }


    ////////////////////////////////////////
    //insert
    public void insertTask(Task task) {
       mTaskDao.insert(task);
        if(task.getmState().equals(State.TODO))
            mTasksToDo.add(task);

        else if(task.getmState().equals(State.DONE))
            mTasksDone.add(task);

        else if(task.getmState().equals(State.DOING))
            mTasksDoing.add(task);
    }
    //////////////////////////////////
    //UpDate
    public void updateTask(Task task) {
        mTaskDao.update(task);

        /*if(task.getmState().equals(State.TODO))
            mTasksToDo.add(task);

        else if(task.getmState().equals(State.DONE))
            mTasksDone.add(task);

        else if(task.getmState().equals(State.DOING))
            mTasksDoing.add(task);*/


    }

    //delete
    public void deleteTask(Task task) {
        mTaskDao.delete(task);
        if (task != null  && task.getmState().equals(State.TODO))
            mTasksToDo.remove(task);

        else  if (task != null  && task.getmState().equals(State.DONE))
            mTasksDone.remove(task);


        else if (task != null  && task.getmState().equals(State.DOING))
            mTasksDoing.remove(task);
    }

////////////////////////////////////////
    //delete
    public void deleteTask(UUID id) {
        deleteTask(getTask(id));
    }


}
