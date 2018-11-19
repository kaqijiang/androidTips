package io.github.kaqijiang.activitypassdata;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.channels.InterruptedByTimeoutException;

public class MainActivity extends AppCompatActivity {


    private Button firstBtn;
    private Button secondBtn;
    private TextView resultTextView;
    private static final int RESULT_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //传值
        firstBtn = findViewById(R.id.firstBtn);
        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,firstActivity.class);
//                intent.putExtra("123","传过去了");
//                startActivity(intent);

                //封装修改不需要知道传入需要设置的 extra key
                Intent intent = firstActivity.newIntent(MainActivity.this,"看看是传过去了么");
                startActivity(intent);
            }
        });

        //传值且需要返回值
        secondBtn = findViewById(R.id.secondBtn);
        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = secodeActivity.newIntent(MainActivity.this, "嗖嗖的过去了");
                startActivityForResult(intent,RESULT_CODE);
                //RESULT_CODE 也想相当于是个tag，页面多的话，可以区分页面。
                //resultCode可以是以下任意一个预定义常量。Activity.RESULT_OK Activity.RESULT_CANCELED
                //可以根据不同值进行判断，比如取消确认按钮区分。
                //这样就传过去了，secodeActivity 那边处理具体

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode != Activity.RESULT_OK)return;//这里判断了下resultCode 需要的话可以做对应处理。

        if (requestCode == RESULT_CODE)//判断是不是secondActivity传过来的。
        {
            if (data != null)
            {
                resultTextView = findViewById(R.id.MainActivity_resultTextView);
                resultTextView.setText(secodeActivity.getExtraString(data));//传输过去，哪里使用key哪里解开key.
            }
        }
    }
}
