package com.example.database.nativeDb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;

public class NativeDbHelper extends SQLiteOpenHelper {

    private static NativeDbHelper nativeDbHelperInstance;
    private static final int VERSION = 1;
    private static final String DBNAME = "Natywna DB";

    public static NativeDbHelper getInstance(Context context) {
        if (nativeDbHelperInstance == null) {
            nativeDbHelperInstance = new NativeDbHelper(context, DBNAME, null, VERSION);
        }
        return nativeDbHelperInstance;
    }

    public NativeDbHelper(@Nullable Context context,
                          @Nullable String name,
                          @Nullable SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(DBNAME, "onCreate start");
        recreateDB(db);
        Log.d(DBNAME, "onCreate done");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(DBNAME, "onUpgrade start");
        recreateDB(db);
        Log.d(DBNAME, "onUpdate done");
    }

    private void recreateDB(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("CREATE TABLE user (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "firstname TEXT, " +
                "lastname TEXT" +
                ")");
    }
}
