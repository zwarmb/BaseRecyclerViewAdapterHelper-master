package com.example.yida.contentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initProvider();

    }

    private void initProvider() {
        // 设置Uri
        Uri uri_user = Uri.parse("content://yida.com.provider/user");

        // 向表中插入数据
        ContentValues values = new ContentValues();
        values.put("_id", 2);
        values.put("name", "益达哥");
        values.put("token", "不愿再死心塌地来了");

        // 获取     ContentResolver
        ContentResolver resolver = getContentResolver();
        // 通过Resolver 向provider 中插入数据
        resolver.insert(uri_user, values);

        // 查询数据
        Cursor cursor = resolver.query(uri_user, new String[]{"_id", "name", "token"}, null, null, null);
        while (cursor.moveToNext()) {
            Log.e("ContentProvider", cursor.getString(cursor.getColumnIndex("_id"))
                    + "   " + cursor.getString(cursor.getColumnIndex("name"))
                    + "   " + cursor.getString(cursor.getColumnIndex("token")));
        }
        // 关闭游标
        cursor.close();




        // 对表2 进行数据操作
//        Uri uri_phone = Uri.parse("content://yida.com.provider/phone");

//        // 插入数据
//        ContentValues values1 = new ContentValues();
//        values1.put("_id", 2);
//        values1.put("name", "huawei");
//        values1.put("num", "6666666666666");

//        ContentResolver resolver1 = getContentResolver();
//        resolver1.insert(uri_phone, values1);

//        Cursor cursor1 = resolver1.query(uri_phone, new String[]{"_id", "name", "num"}, null, null, null);
//        while (cursor1.moveToNext()) {
//            Log.e("ContentProvider", cursor.getString(cursor.getColumnIndex("_id"))
//                    + "   " + cursor.getString(cursor.getColumnIndex("name"))
//                    + "   " + cursor.getString(cursor.getColumnIndex("phone")));
//
//        }
//        // 关闭游标
//        cursor1.close();
    }
}
