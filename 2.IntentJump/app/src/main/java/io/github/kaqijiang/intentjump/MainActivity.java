package io.github.kaqijiang.intentjump;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button explicitBtn;//显式
    private Button implicit;//隐式
    private Button implicitCategory;//隐式category
    private Button brower;//浏览器
    private Button others;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //显式
        explicitBtn = findViewById(R.id.explicit);
        explicitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                intent.putExtra("EXTRA_MESSAGE","main的内容");
                startActivity(intent);
            }
        });

        //隐式
        implicit = findViewById(R.id.implicit);
        implicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //根据manifest intent action 和category 去隐式跳转 默认category为default
                Intent intent = new Intent("android.intent.action.second");
                startActivity(intent);
            }
        });

        //隐式根据category跳转
        implicitCategory = findViewById(R.id.implicitCategory);
        implicitCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //根据 intent cation && category jump  需要在原有<intent-filter> category 中增加一个THIRDCATEGORY
                Intent intent = new Intent("android.intent.action.thirdActivity");
                intent.addCategory("android.intent.category.THIRDCATEGORY");
                startActivity(intent);
            }
        });
        //跳转浏览器
        brower = findViewById(R.id.goBrower);
        brower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        //不跳转浏览器
        others = findViewById(R.id.otherss);
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.otherActivity");
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        //电话
        Button tellBtn = findViewById(R.id.tel);
        tellBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

    }
}
