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
 * launch mode SingleTop A
 * 只有在 当前Activity 已经在栈顶的情况，才不会重新创建实例
 * 如果当前Activity 已经不在栈顶了，那么再次调用这个页面时，会重新创建实例
 * Created by C on 2018/4/23.
 */

public class SingleTopA extends BaseActivity {

    @BindView(R.id.singletop_text)
    TextView mContentTv;

    @BindView(R.id.single_top_again)
    Button mSingleTopAgain;

    @BindView(R.id.standard)
    Button mStandard;

    private String mTitleStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        mContentTv.setText(mTitleStr);

        mSingleTopAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getSingleTopAIntent("single top again", SingleTopA.this);
                startActivity(intent);
            }
        });

        mStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = StandardA.getStandardAIntent("standard from single top", SingleTopA.this);
                startActivity(intent);
            }
        });

    }

    @Override
    protected int initViewLayout() {
        return R.layout.activity_single_top;
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

    public static Intent getSingleTopAIntent(String title, Context context) {
        Intent intent = new Intent(context, SingleTopA.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.putExtra(Constants.TITLE, title);
        return intent;
    }
}
