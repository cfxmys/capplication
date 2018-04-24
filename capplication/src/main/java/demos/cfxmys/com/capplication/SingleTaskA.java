package demos.cfxmys.com.capplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.TabStopSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;

/**
 * launch mode SingleTask A
 * Created by C on 2018/4/23.
 */

public class SingleTaskA extends BaseActivity {

    @BindView(R.id.singletask_text)
    TextView mContentTv;

    @BindView(R.id.single_task_again)
    Button mSingleTaskAgainBtn;

    @BindView(R.id.standard)
    Button mStandardBtn;

    private String mTitleStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        mContentTv.setText(mTitleStr);

        mStandardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = StandardA.getStandardAIntent("Standard", SingleTaskA.this);
                startActivity(intent);
            }
        });

        mSingleTaskAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getSingleTaskAIntent("Single Task again", SingleTaskA.this);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int initViewLayout() {
        return R.layout.activity_single_task;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            mTitleStr = intent.getStringExtra(Constants.TITLE);
            mContentTv.setText(mTitleStr);
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mTitleStr = intent.getStringExtra(Constants.TITLE);
        }
    }

    public static Intent getSingleTaskAIntent(String title, Context context) {
        Intent intent = new Intent(context, SingleTaskA.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.putExtra(Constants.TITLE, title);
        return intent;
    }
}
