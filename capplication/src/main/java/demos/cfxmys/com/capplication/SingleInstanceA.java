package demos.cfxmys.com.capplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;

/**
 * launch mode SingleInstance A
 * 当前Activity 在应用中只有一个实例，从当前Activity 打开的其他页面，如果是 非single instance 的启动模式，都在 前一个任务中打开
 * 如果当前页面为single instance，则按下返回键时，会返回到 上一个single instance 实例，再次返回 回到 最初的task实例
 * 如果当前页面为 非 single innstance， 则按下返回键时，会先把最初的任务栈情况，然后再次按下返回键时，按照后进先出的规则，反序销毁 single instance 实例
 * Created by C on 2018/4/23.
 */

public class SingleInstanceA extends BaseActivity {

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
                Intent intent =
                        SingleInstanceB.getSingleInstanceBIntent("single instance again B ", SingleInstanceA.this);
                startActivity(intent);
            }
        });

        mStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = StandardA.getStandardAIntent("standard from single instance", SingleInstanceA.this);
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

    public static Intent getSingleInstanceAIntent(String title, Context context) {
        Intent intent = new Intent(context, SingleInstanceA.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.putExtra(Constants.TITLE, title);
        return intent;
    }
}
