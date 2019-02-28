package com.example.contentprovider2;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 获取contentprovider 这个app里面共享出来的数据

        initData();

    }

    public void initData() {

        // 对user表进行数据操作
        Uri uri_user = Uri.parse("content://yida.com.provider/user");


        // 获取contentResolver
        ContentResolver resolver = getContentResolver();
        // 向表中插入数据

        ContentValues values = new ContentValues();
        values.put("_id", "3");
        values.put("name", "小张");
        values.put("token", "wwwwwasdasdasdasdasdasd");
        // 通过contentResolver 向contentprovider中插入数据
        resolver.insert(uri_user, values);

        // 通过contentResolver 向contentprovider中查询数据
        Cursor cursor = resolver.query(uri_user, new String[]{"_id", "name", "token"}, null, null, null);
        while (cursor != null && cursor.moveToNext()) {
            Log.e("接收数据", "id    " + cursor.getString(cursor.getColumnIndex("_id"))
                    + "name   " + cursor.getString(cursor.getColumnIndex("name"))
                    + "token     " + cursor.getString(cursor.getColumnIndex("token")));
        }
        cursor.close();

    }
}
