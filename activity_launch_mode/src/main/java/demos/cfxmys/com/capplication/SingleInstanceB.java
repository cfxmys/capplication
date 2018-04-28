package demos.cfxmys.com.capplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import demos.cfxmys.com.baselibrary.BaseActivity;

/**
 * launch mode SingleInstance B
 * 当前Activity 在应用中只有一个实例，从当前Activity 打开的其他页面，如果是 非single instance 的启动模式，都在 前一个任务中打开
 * Created by C on 2018/4/23.
 */

public class SingleInstanceB extends BaseActivity {

    @BindView(R.id.single_instance_text)
    TextView mContentTv;

    @BindView(R.id.single_instance_again)
    Button mSingleInstanceAgain;

    @BindView(R.id.standard)
    Button mStandard;

    private String mTitleStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        mContentTv.setText(mTitleStr);

        mSingleInstanceAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getSingleInstanceBIntent("single instance again ", SingleInstanceB.this);
                startActivity(intent);
            }
        });

        mStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = StandardA.getStandardAIntent("standard from single instance B", SingleInstanceB.this);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int initViewLayout() {
        return R.layout.activity_single_instance;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            String title = intent.getStringExtra(Constants.TITLE);
            mContentTv.setText(title);
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mTitleStr = intent.getStringExtra(Constants.TITLE);
        }
    }

    public static Intent getSingleInstanceBIntent(String title, Context context) {
        Intent intent = new Intent(context, SingleInstanceB.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.putExtra(Constants.TITLE, title);
        return intent;
    }
}
