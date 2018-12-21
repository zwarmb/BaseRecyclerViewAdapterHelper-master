package com.example.yida.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yida on 2018/12/13.
 */
public class DBHelper extends SQLiteOpenHelper {

    // 数据库名
    private static final String DB_NAME = "yida.db";
    // 表名1
    public static final String USER_TABLE_NAME = "user";
    // 表名 2
    public static final String PHONE_TAB = "phone";




    // 表的版本
    private static final int DB_VERSION = 1;

    // 创建用户表的语句
    private String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS "
            + USER_TABLE_NAME + "(_id INTEFER PRIMARY KEY, name TEXT, token TEXT)";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);

        // 创建表2的语句 phone
        db.execSQL("CREATE TABLE IF NOT EXISTS " + PHONE_TAB + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, num TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
