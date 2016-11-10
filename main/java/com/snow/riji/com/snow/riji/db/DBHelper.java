package com.snow.riji.com.snow.riji.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.snow.riji.until.SnowLog;

public class DBHelper {
    private static final String TAG = "DBHelper";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;
    private Context context;

    public DBHelper(Context context) {
        this.context = context;
        SnowLog.d(TAG, "DBHelper");
        mDbHelper = new DatabaseHelper(this.context);
    }

    private static DBHelper DBHelper = null;

    public static DBHelper getInstance(Context context) {
        if (null == DBHelper) DBHelper = new DBHelper(context);
        return DBHelper;
    }

    public DBHelper open() throws SQLException {
        SnowLog.d(TAG,"open");

        mDb = mDbHelper.getWritableDatabase();
        SnowLog.d(TAG, "md open" + mDb.getPath());

        return this;
    }

    public DBHelper close() throws SQLException {
        mDb.close();
        mDbHelper.close();

        return this;
    }

    public void clearDBTableByName(String tableName) {
        mDb.delete(tableName, "1=1", null);
    }

    public SQLiteDatabase getMDB() {
        return mDb;
    }
    
/*    public long insertPic(String name, byte[] picByte)
    {
        ContentValues cv = new ContentValues();
        cv.put(DBConfig.SportPic.PIC, picByte);
        cv.put(DBConfig.SportPic.NAME, name);
        return mDb.insert(DBConfig.SportPic.TABLE_NAME, null, cv);  
    }*/
    private static class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, DBConfig.DB_NAME, null, DBConfig.DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            SnowLog.d(TAG, "DatabaseHelper onCreate");
          //  db.execSQL(DBConfig.SportPic.CREATE_PIC_RECORD_SQL);
            db.execSQL(DBConfig.SportRecord.CREATE_SPORT_RECORD_SQL);
            db.execSQL(DBConfig.PainRecord.CREATE_PAIN_RECORD_SQL);
            db.execSQL(DBConfig.DietRecord.CREATE_DIET_RECORD_SQL);
            db.execSQL(DBConfig.DrugRecord.CREATE_DRUG_RECORD_SQL);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ", it will destroy all old data");
          //  db.execSQL("DROP TABLE IF EXISTS " + DBConfig.SportPic.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + DBConfig.SportRecord.TABLE_SPORT);
            db.execSQL("DROP TABLE IF EXISTS " + DBConfig.PainRecord.TABLE_PAIN);
            db.execSQL("DROP TABLE IF EXISTS " + DBConfig.DietRecord.TABLE_DIET);
            db.execSQL("DROP TABLE IF EXISTS " + DBConfig.DrugRecord.TABLE_DRUG);
            onCreate(db);
        }
    }
}
