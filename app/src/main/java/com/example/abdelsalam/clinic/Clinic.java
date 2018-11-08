package com.example.abdelsalam.clinic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Clinic extends SQLiteOpenHelper {

    public static final String DBName = "hospital";
    public static final String table1 = "Doctors";

    public static final String t1col1 = "id";
    public static final String t1col2 = "name";
    public static final String t1col3 = "phone";
    public static final String t1col4 = "address";
    public static final String t1col5 = "age";

    public static final String table2 = "patient";

    public static final String t2col1 = "id";
    public static final String t2col2 = "name";
    public static final String t2col3 = "phone";
    public static final String t2col4 = "address";
    public static final String t2col5 = "age";


    public static final String table3 = "nurses";

    public static final String t3col1 = "id";
    public static final String t3col2 = "name";
    public static final String t3col3 = "phone";
    public static final String t3col4 = "address";
    public static final String t3col5 = "age";

    public Clinic(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+table1+" ( "+t1col1+" INTEGER , "+t1col2+" TEXT , "+t1col3+" TEXT , "+t1col4+" TEXT , "+t1col5+" INTEGER )");
        db.execSQL("CREATE TABLE "+table2+" ( "+t2col1+" INTEGER , "+t2col2+" TEXT , "+t2col3+" TEXT , "+t2col4+" TEXT , "+t2col5+" INTEGER )");
        db.execSQL("CREATE TABLE "+table3+" ( "+t3col1+" INTEGER , "+t3col2+" TEXT , "+t3col3+" TEXT , "+t3col4+" TEXT , "+t3col5+" INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+table1);
        db.execSQL("DROP TABLE IF EXIST "+table2);
        db.execSQL("DROP TABLE IF EXIST "+table3);
        onCreate(db);
    }




    public String insert1(int id , String name , String phone , String address , int age )
    {
        try
        {
            ContentValues cv1 = new ContentValues();
            cv1.put(t1col1,id);
            cv1.put(t1col2,name);
            cv1.put(t1col3,phone);
            cv1.put(t1col4,address);
            cv1.put(t1col5,age);
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(table1,null,cv1);
            return "Success ";

        }
        catch (Exception e)
        {
            return "Error "+e.getMessage().toString();
        }
    }

    public String insert2(int id , String name , String phone , String address , int age )
    {
        try
        {
            ContentValues cv2 = new ContentValues();
            cv2.put(t2col1,id);
            cv2.put(t2col2,name);
            cv2.put(t2col3,phone);
            cv2.put(t2col4,address);
            cv2.put(t2col5,age);
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(table2,null,cv2);
            return "Success ";

        }
        catch (Exception e)
        {
            return "Error "+e.getMessage().toString();
        }
    }

    public String insert3(int id , String name , String phone , String address , int age )
    {
        try
        {
            ContentValues cv3 = new ContentValues();
            cv3.put(t3col1,id);
            cv3.put(t3col2,name);
            cv3.put(t3col3,phone);
            cv3.put(t3col4,address);
            cv3.put(t3col5,age);
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(table3,null,cv3);
            return "Success ";

        }
        catch (Exception e)
        {
            return "Error "+e.getMessage().toString();
        }
    }


    public Cursor AllData_table1(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+table1,null);
            return c;
                }

    public Cursor AllData_table2() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + table2, null);
            return c;
            }

    public Cursor AllData_table3(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+table3,null);
        return c;
    }

    public String delete_table1()
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(table1,null,null);

            return "Delete Success";
        }
        catch (Exception e)
        {
            return "Exception "+e.getMessage().toString();
        }
    }

    public String deleteByID_table1(int id)
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + table1 + " WHERE "+t1col1+" = " + id);

            return "Data where id = "+id+" Deleted";
        }
        catch (Exception e)
        {
            return "Exception "+e.getMessage().toString();
        }
    }






    public String delete_table2()
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(table2,null,null);
            return "Delete Success";
        }
        catch (Exception e)
        {
            return "Exception "+e.getMessage().toString();
        }
    }

    public String delete_table3()
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(table3,null,null);
            return "Delete Success";
        }
        catch (Exception e)
        {
            return "Exception "+e.getMessage().toString();
        }
    }

    public String updateNameT1(int id , String name )
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("UPDATE " + table1 + " SET " + t1col2 + " ='" + name + "' WHERE id= " + id);
            return "Update Success ";
        } catch (Exception e) {
            return "Error " + e.getMessage().toString();
        }

    }


    public String updateNameT2(int id , String name )
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("UPDATE " + table2 + " SET " + t2col2 + " ='" + name + "' WHERE id= " + id);
            return "Update Success ";
        } catch (Exception e) {
            return "Error " + e.getMessage().toString();
        }
    }

    public String updateNameT3(int id , String name )
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("UPDATE " + table3 + " SET " + t3col2 + " ='" + name + "' WHERE id= " + id);
            return "Update Success ";
        } catch (Exception e) {
            return "Error " + e.getMessage().toString();
        }

    }

















}
