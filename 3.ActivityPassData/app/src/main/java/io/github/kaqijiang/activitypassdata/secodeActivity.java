package io.github.kaqijiang.activitypassdata;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secodeActivity extends AppCompatActivity {

    private static final String EXTRA_SECOND_ACTIVITY_KEY = "EXTRA_SECOND_ACTIVITY_KEY";
    private static final String EXTRA_SECOND_RESULT_KEY = "EXTRA_SECOD_RESULT_KEY";

    public static Intent newIntent(Context context, String content)
    {
        Intent intent = new Intent(context, secodeActivity.class);
        intent.putExtra(EXTRA_SECOND_ACTIVITY_KEY, content);

        return intent;
    }

    public static String getExtraString(Intent result){
        return  result.getStringExtra(EXTRA_SECOND_RESULT_KEY);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secode);

        TextView textView = findViewById(R.id.second_content);
        textView.setText(getIntent().getStringExtra(EXTRA_SECOND_ACTIVITY_KEY));

        //返回按钮。 //返回的时候把需要传过去的数据返回去
        Button btn = findViewById(R.id.back);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){

                Intent data = new Intent();
                data.putExtra(EXTRA_SECOND_RESULT_KEY,"I'am secondActivity datas");
                setResult(RESULT_OK,data);
                finish();
                /**
                 * setResult(RESULT_OK,data);
                 * 第一个参数 是一个常量，可以用来返回判断比如按钮，确定取消等。。。
                 *
                 *  public static final int RESULT_CANCELED = 0;
                 *
                 *  public static final int RESULT_OK = -1;
                 *
                 *  public static final int RESULT_FIRST_USER = 1;
                 *
                 */
            }
        });

    }
}
