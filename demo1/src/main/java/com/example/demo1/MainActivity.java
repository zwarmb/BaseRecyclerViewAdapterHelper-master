package com.example.demo1;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.demo1.adapter.Recycleview1Adapter;
import com.example.demo1.view.SectionDecoration;
import com.example.demo1.view.SimpleDraweeView.SimpleDraweeViewActivity;
import com.example.demo1.view.beisaier_quxian.BeiSaierActivity;
import com.example.demo1.view.fang_qq_space.ShadeActivity;
import com.example.demo1.view.glide.GlideTestActivity;
import com.example.demo1.view.huaweishichang_search.HuaWeiActivity;
import com.example.demo1.view.leida.LeidaActivity;
import com.example.demo1.view.pai_xu.PaiXuActivity;
import com.example.demo1.view.toast.ToastActivity;
import com.example.demo1.view.viewpager.ViewPagerActivity;
import com.example.demo1.view.zhe_die_lan.ZhedieActivity;
import com.example.demo1.view.zidinyi_view_dianxianmian.ZiDinYiViewActivity;
import com.example.demo1.view.zidinyi_view_huabu.ZiDinYi_HuaBuActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportActivity;

public class MainActivity extends SupportActivity {

    private List<rvBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        if (Build.VERSION.SDK_INT >= 21) {
//            View view = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
//            view.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//            getWindow().setNavigationBarColor(Color.TRANSPARENT);
//        }
//        // 去掉toolbar
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
        setContentView(R.layout.main3);

        init1();

        initRightLinear();

    }

    // 处理右边的操作
    private void initRightLinear() {
        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GlideTestActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String s = getHttpCode("https://www.jianshu.com/p/8c738cbd48ed");
                String s = getCodee("https://www.jianshu.com/p/8c738cbd48ed");
//                urlConnectionPost();

                Log.e("TAG", s + "      错误码");
            }
        });
    }

    public String getHttpCode(String url) {
        String code = null;
        try {
            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            HttpURLConnection huc = (HttpURLConnection) uc;
            code = new Integer(huc.getResponseCode()).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }


    public String getCodee(String url1) {
        try {
            // surl="http://www.baidu.com";
            URL url = new URL(url1);
            URLConnection rulConnection   = url.openConnection();
            HttpURLConnection httpUrlConnection  =  (HttpURLConnection) rulConnection;
            httpUrlConnection.setConnectTimeout(300000);
            httpUrlConnection.setReadTimeout(300000);
            httpUrlConnection.connect();
            String code = new Integer(httpUrlConnection.getResponseCode()).toString();
            String message = httpUrlConnection.getResponseMessage();
            System.out.println("getResponseCode code ="+ code);
            System.out.println("getResponseMessage message ="+ message);
            if(!code.startsWith("2")){
                throw new Exception("ResponseCode is not begin with 2,code="+code);
            }
//            System.out.println(getCurDateTime()+"连接"+surl+"正常");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return "";
    }



    public String getCode(String url) {


        new AsyncTask<String, String, String>() {

            @Override
            protected String doInBackground(String... strings) {
//                return null;
//                try {
//                    URL u = new URL("http://10.1.2.8:8080/fqz/page/qizha/pros_add.jsp");
//                    try {
//                        HttpURLConnection uConnection = (HttpURLConnection) u.openConnection();
//                        try {
//                            uConnection.connect();
//                            Log.e("TAG", uConnection.getResponseCode() + "");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            Log.e("TAG", "connect failed         " + e);
//                        }
//
//                    } catch (IOException e) {
//                        Log.e("TAG", "build failed");
//                        e.printStackTrace();
//                    }
//
//                } catch (MalformedURLException e) {
//                    Log.e("TAG", "build url failed");
//                    e.printStackTrace();
//                }


                try {
                    URL u = new URL(url);
                    HttpURLConnection huc = (HttpURLConnection) u.openConnection();

                    huc.connect();
                    Log.e("tag", huc.getResponseCode() + "    状态码");
                } catch (Exception e) {
                    Log.e("tag", "错误异常");
                }


                return "";
            }
        };


        return "";
    }





    private static void urlConnectionPost() {
        StringBuilder responseBuilder = null;
        BufferedReader reader = null;
        OutputStreamWriter wr = null;
        URL url;
        try {
            url = new URL("http://www.poorren.com");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            Log.e("aaa", conn.getResponseCode()+ "");
            conn.setConnectTimeout(1000 * 5);
            wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write("");
            wr.flush();
            // Get the response
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            responseBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line + "\n");
            }
            wr.close();
            reader.close();
            System.out.println(responseBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





















    private void init1() {
        RecyclerView recyclerView = findViewById(R.id.rv_demo1_1);
        initData1();

        final Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent));
        Recycleview1Adapter recycleview1Adapter = new Recycleview1Adapter(R.layout.rv_demo1_item1, mList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.bottom = 2;
            }

            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
                int childCount = parent.getChildCount();
                int left = parent.getLeft();
                int right = parent.getRight();

                for (int i = 0; i < childCount - 1; i++) {
                    View view = parent.getChildAt(i);
                    float top = view.getBottom();
                    float bottom = view.getBottom() + 2;
                    c.drawRect(left, top, right, bottom, paint);
                }
            }
        });

        recyclerView.addItemDecoration(new SectionDecoration(new SectionDecoration.DecorationCallback() {
            @Override
            public long getGroupId(int position) {
                return Character.toUpperCase(mList.get(position).getStr().charAt(0));
            }

            @Override
            public String getGroupFirstLine(int position) {
                return mList.get(position).getStr().substring(0, 1).toUpperCase();
            }
        }, this));

        recycleview1Adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                switch (position) {
                    case 0:
                        // 点击进入main2
                        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(), Fragment1.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(), LeidaActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getApplicationContext(), SimpleDraweeViewActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getApplicationContext(), ViewPagerActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getApplicationContext(), ShadeActivity.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getApplicationContext(), PaiXuActivity.class);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(getApplicationContext(), HuaWeiActivity.class);
                        startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(getApplicationContext(), ZhedieActivity.class);
                        startActivity(intent8);
                        break;
                    case 9:
                        Intent intent9 = new Intent(getApplicationContext(), ZiDinYiViewActivity.class);
                        startActivity(intent9);
                        break;
                    case 10:
                        Intent intent10 = new Intent(getApplicationContext(), ZiDinYi_HuaBuActivity.class);
                        startActivity(intent10);
                        break;
                    case 11:
                        Intent intent11 = new Intent(getApplicationContext(), ToastActivity.class);
                        startActivity(intent11);
                        break;
                    case 12:
                        Intent intent12 = new Intent(getApplicationContext(), BeiSaierActivity.class);
                        startActivity(intent12);
                        break;
                }
            }
        });
        recyclerView.setAdapter(recycleview1Adapter);
    }

    private void initData1() {
        mList = new ArrayList<>();
        String[] strings = {"仿网易广告滚动显示", "条目滚动", "雷达属性", "glide", "轮播图", "仿QQ空间广告显示", "排序", "仿华为应用市场搜索", "折叠栏", "自定义View",
                "自定义_画布", "Toast时长", "贝塞尔曲线"};

        for (int i = 0; i < /*strings.length*/ 100; i++) {
            rvBean rvBean = new rvBean();
//            for (int j = 0; j < strings.length; j++) {
//                rvBean.setStr(strings[j]);
//
//            }
            if (strings.length > i) {
                rvBean.setName(strings[i]);
            } else {
                rvBean.setName("大爷的");
            }
            rvBean.setStr(i + "");
            rvBean.setContent(99 - i + "");
            mList.add(rvBean);
        }


//        mList.addAll(rvBean.setStr(""), rvBean.setContent(""));
//        mList.addAll(new rvBean("", ""));
    }


    @Override
    public void onBackPressedSupport() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            super.onBackPressedSupport();
        } else {
//            if ((System.currentTimeMillis() - mExitTime) > 2000) {
//                Toasty.normal(this, "再按一次退出程序").show();
//                mExitTime = System.currentTimeMillis();
//            } else {
            finish();
            //System.exit(0);
//            }
        }
    }


    public static class rvBean {
        String str;
        String content;
        String name;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
