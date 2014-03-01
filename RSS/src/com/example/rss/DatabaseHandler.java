package com.example.rss;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 
public class DatabaseHandler extends SQLiteOpenHelper {
    // for our logs
    public static final String TAG = "DatabaseHandler.java";
 
    // database version
    private static final int DATABASE_VERSION = 7;
 
    // database name
    protected static final String DATABASE_NAME = "SuperOnion";
 
    // table details
    public String tableName = "homework";
    public String fieldObjectId = "id";
    public String fieldObjectName = "name";
    public String fieldObjectDate = "date";
     
    // constructor
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // creating table
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "";
 
        sql += "CREATE TABLE " + tableName;
        sql += " ( ";
        sql += fieldObjectId + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += fieldObjectName + " TEXT, ";
        sql += fieldObjectDate + " TEXT ";
        sql += " ) ";
 
        db.execSQL(sql);
 

        String INDEX = "CREATE UNIQUE INDEX locations_index ON "
                        + tableName + " (name, date)";
         
        db.execSQL(INDEX);
    }
 
     
    // When upgrading the database, it will drop the current table and recreate.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 
        String sql = "DROP TABLE IF EXISTS " + tableName;
        db.execSQL(sql);
 
        onCreate(db);
    }
 
 
     
    public void insertname(String string, String string2){
        try{
             
            SQLiteDatabase db = this.getWritableDatabase();
             String x = string;
             String y = string2;
             
             ContentValues values = new ContentValues();
             values.put(fieldObjectName, x);
             values.put(fieldObjectDate, y);

              
             db.insert(tableName, null, values);
             db.close();

             
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
    
    public void insertname2(String string, String string2){
        try{
             
            SQLiteDatabase db = this.getWritableDatabase();
             String x = string;
             String y = string2;
             
             ContentValues values = new ContentValues();
             values.put(fieldObjectName, x);
             values.put(fieldObjectDate, y);

              
             db.insert(tableName, null, values);
             db.close();

             
        }catch(Exception e){
            e.printStackTrace();
        } 
    }

    // deletes all records
    public void deleteRecords(){
         
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ tableName);
        db.close();
    }
    
    public void checknews(){
        
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("select name from "+ tableName +"WHERE   ID = (SELECT MAX(ID)  FROM locations)");

        db.close();
    }
     
    // count records
    public String countRecords(String string, String string2){
         
        SQLiteDatabase db = this.getWritableDatabase();
        String newname = string;
        String newdate = string2;
        Cursor cursor = db.rawQuery("select name from homework WHERE   ID = (SELECT MAX(ID)  FROM homework)", null);
        cursor.moveToFirst();
         
        String recCount = cursor.getString(0);
        cursor.close();

        
        Cursor cursor1 = db.rawQuery("select date from homework WHERE   ID = (SELECT MAX(ID)  FROM homework)", null);
        cursor1.moveToFirst();
        String recCount2 = cursor1.getString(0);
    	  Log.i(TAG, "   newname=" + newname + "   newdate=" + newdate + "   oldname=" + recCount + "   olddate=" + recCount2);
        cursor1.close();
        db.close();
        String checktest;
        if (newname.equals(recCount) && newdate.equals(recCount2)) {
        	Log.i(TAG, "Both are the same");
            checktest = "false";
        	} else {
                checktest = "true";
            	Log.i(TAG, "Not the same");
        	}
        return checktest;
    }

    

     
}

