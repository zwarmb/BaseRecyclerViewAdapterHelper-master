package com.example.yida.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by yida on 2018/12/13.
 */
public class Myprovider extends ContentProvider {

    private Context mContext;
    DBHelper mDBHelper = null;
    SQLiteDatabase db = null;

    // 设置contentprovider唯一标识
    public static final String AUTOHORITY = "yida.com.provider";

    public static final int User_Code = 1;
    public static final int Phone_Code = 2;

    // UriManager类使用,  在Contentprovider 中注册 URI
    private static final UriMatcher mMatcher;

    static {
        mMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        // 初始化
        mMatcher.addURI(AUTOHORITY, "user", User_Code);
        mMatcher.addURI(AUTOHORITY, "phone", Phone_Code);
    }

    /**
     * 初始化 contentprovider
     * @return
     */
    @Override
    public boolean onCreate() {
        mContext = getContext();
        // 在 Contentprovider 创建时对数据库进行初始化
        // 运行在主线程, 不能做耗时操作
        mDBHelper = new DBHelper(getContext());
        db = mDBHelper.getWritableDatabase();

        // 初始化表的数据( 先清空表数据, 再加入一条自定义的数据 )
        db.execSQL("delete from user");
        // 添加自定义数据
        db.execSQL("insert into user values(1, '现在的那个他', '对你还好吗');");


        // 对表2做处理
        db.execSQL("delete from phone");
        db.execSQL("insert into phone values(1, 'android', 12345678900);");
        return true;
    }

    /**
     * 查询数据
     * @param uri
     * @param projection
     * @param selection
     * @param selectionArgs
     * @param sortOrder
     * @return
     */
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        // 根据Uri 匹配 URI_CODE, 从而匹配 Contentprovider中相应的表名

        String tableName = getTableName(uri);

        return db.query(tableName, projection, selection, selectionArgs, null, null, null);
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    /**
     * 添加数据
     * @param uri
     * @param values
     * @return
     */
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // 匹配表名
        String name = getTableName(uri);
        // 向表中添加数据
        db.insert(name, null, values);

        // 当该Uri的contentprovider 数据发生变化时, 通知外界( 即访问该contentprovider数据的访问者 )
        mContext.getContentResolver().notifyChange(uri, null);

        return uri;
    }

    /**
     * 删除数据
     * @param uri
     * @param selection
     * @param selectionArgs
     * @return
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    /**
     * 更新数据
     * @param uri
     * @param values
     * @param selection
     * @param selectionArgs
     * @return
     */
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }


    private String getTableName(Uri uri) {
        String tableName = null;
        switch (mMatcher.match(uri)) {
            case User_Code:
                tableName = DBHelper.USER_TABLE_NAME;
                break;
        }
        return tableName;
    }
}
