package com.example.bilibilidemo1.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.bilibilidemo1.R;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;

import java.io.File;

/**
 * Created by yida on 2018/5/8.
 */

public class DownloadDialog extends Dialog {


    private String mSavePath;

    public static class bundil {
        Context mContext;
        String downUrl;
        View.OnClickListener mOnClickListener;

        public bundil(Context context) {
            mContext = context;
        }

        public bundil setDownUrl(String url) {
            this.downUrl = url;
            return this;
        }

        public DownloadDialog build() {
            return new DownloadDialog(this);
        }

        public bundil setOnclickListener(View.OnClickListener onclickListener) {
            this.mOnClickListener = onclickListener;
            return this;
        }
    }

    private SeekBar seekBar;
    private TextView textView;
    private bundil mBundil;
    private TextView mInstall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        setContentView(R.layout.dialog_download);

        textView = this.findViewById(R.id.textView);
        seekBar = this.findViewById(R.id.seekBar);
        TextView cancel = this.findViewById(R.id.textView2);
        mInstall = this.findViewById(R.id.textView3);

        mInstall.setEnabled(false);
        onDown(mBundil.downUrl);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        mInstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 安装
                onInstall();
            }
        });
    }

    private void onInstall() {
        if (mSavePath == null && mSavePath.isEmpty()) {
            return;
        }
        File file = new File(mSavePath);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        getContext().startActivity(intent);

//        if (file == null) {
//            return;
//        }
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        Uri data;
//        String type = "application/vnd.android.package-archive";
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
//            data = Uri.fromFile(file);
//        } else {
//            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            data = FileProvider.getUriForFile(getContext(), "com.example.bilibilidemo1.provader", file);
//        }
//        intent.setDataAndType(data, type);
//
//        getContext().startActivity(intent);
    }

    public void setSeekBar(int max, int progress) {
        seekBar.setMax(max);
        seekBar.setProgress(progress);
    }

    public DownloadDialog(@NonNull bundil bundil) {
        super(bundil.mContext);
        this.mBundil = bundil;
    }

    public void onDown(String url) {
        mSavePath = getContext().getFilesDir().getAbsolutePath() + "LL.apk";
        File file = new File(mSavePath);
        if (file.exists()) {
            file.delete();
        }
        onDownLoad(url);
    }

    public void onDownLoad(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                FileDownloader.setup(getContext());
                FileDownloader.getImpl().create(url)
                        .setPath(mSavePath)
                        .setListener(new FileDownloadListener() {
                            @Override
                            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                                // 加入任务队列
                                Log.e("qq", task.getFilename());
                            }

                            @Override
                            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                                // 下载进度
                                Log.e("qq", soFarBytes + "    " + totalBytes);

                                int sofar = soFarBytes/1000;
                                int total = totalBytes/1000;

                                textView.setText(sofar + "k / " + total + "k");

                                // 设置下载显示进度条
                                setSeekBar(totalBytes, soFarBytes);
                            }

                            @Override
                            protected void completed(BaseDownloadTask task) {
                                // 下载完成
                                textView.setText(task.getSoFarBytes()/1000 + "k / " + task.getTotalBytes()/1000 + "k");
                                Log.e("qq", "下载完成" + task.getSoFarBytes());
                                // 下载完成时安装按钮才可以点击
                                mInstall.setEnabled(true);
                            }

                            @Override
                            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                                // 下载暂停

                            }

                            @Override
                            protected void error(BaseDownloadTask task, Throwable e) {
                                // 下载错误

                            }

                            @Override
                            protected void warn(BaseDownloadTask task) {
                                // 通知警告

                            }
                        }).start();
            }
        }).start();
    }
}
