package io.github.kaqijiang.activitypassdata;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.security.PrivateKey;

public class firstActivity extends AppCompatActivity {

    private Button resultBtn;
    private Button backBtn;

    private static final String EXTRA_FIRST_ACTIVITY_KEY = "IO.GITHUB.KAQIJIANG.ACTIVITY.FIRSTACTIVITY";


    //封装起来  这样外边就不需要知道 EXTRA_FIRST_ACTIVITY_KEY 直接传入对应的内容就行了。
    public static Intent newIntent(Context packageContext, String content)
    {
        Intent intent = new Intent(packageContext, firstActivity.class);
        intent.putExtra(EXTRA_FIRST_ACTIVITY_KEY, content);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //直接取到自己对应的内容就ok 了
        String contentStr = getIntent().getStringExtra(EXTRA_FIRST_ACTIVITY_KEY);
        resultBtn = findViewById(R.id.contents);
        resultBtn.setText(contentStr);

        backBtn = findViewById(R.id.activity_first_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
