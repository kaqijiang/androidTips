package io.github.kaqijiang.helloword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AppCompatActivity 是Activity子类，MainActivi继承自AppCompatActivity。
        //重写了OnCreate方法， 使用setContentView加载布局文件。
        //代码中加载布局文件R.layout.xxx 加载字符串资源使用 R.string.xxx
        //
    }
}
