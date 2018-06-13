package com.example.tlq.jsontest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button btn_1;
    private TextView tv_1;
    public static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPression();
        initView();
    }

    private void initPression() {
        if (Build.VERSION.SDK_INT >= 23) {
            int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
            if (permission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);

                Toast.makeText(getApplicationContext(), "请在设置中授予权限！", Toast.LENGTH_SHORT).show();
            } else {
                InitData();
            }
        } else {
            InitData();
        }
    }
    private void initView() {
        btn_1=findViewById(R.id.btn_1);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataInfoToDBUtil dataInfoToDBUtil=new DataInfoToDBUtil();
                dataInfoToDBUtil.insertToDB();


            }
        });

    }

    private void InitData() {
        //将数据文件存放到指定目录

        boolean sdCardExist= Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (sdCardExist){
            //判断数据文件是否存在

            //将数据文件存放到指定目录
            FileUtil.getInstance(MyApplication.getContext().getApplicationContext()).copyAssetsToSD("META-INFO", "stemEink/META-INFO");
        }else{
            Toast.makeText(getApplication(),"请插入SD卡！",Toast.LENGTH_SHORT).show();
        }

    }
}
