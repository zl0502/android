package edu.niit.android.myapplication;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private TextView tvVersion;//控件对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //1.获取需要的控件
        tvVersion=findViewById(R.id.tv_version);
        //2.获取活设置控件的值
        String version=tvVersion.getText().toString(  );
        try {
            PackageInfo info= getPackageManager().getPackageInfo(getPackageName(),0);
            tvVersion.setText("版本号："+info.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        tvVersion.setText("");
        //3.不带数据的跳转界面
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                    Intent intent=new Intent(SplashActivity.this,loginActivity.class);
                    startActivity(intent);
            }
        };
        timer.schedule(task,5000);


    }
}
