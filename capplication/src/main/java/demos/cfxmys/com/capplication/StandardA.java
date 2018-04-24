package demos.cfxmys.com.capplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;

/**
 * launch mode Standard A
 * Created by C on 2018/4/23.
 */

public class StandardA extends BaseActivity {

    @BindView(R.id.standard_text)
    TextView mContentTv;

    @BindView(R.id.singletask)
    Button mSingleTaskBtn;

    @BindView(R.id.singletop)
    Button mSingleTopBtn;

    @BindView(R.id.single_instance)
    Button mSingleInstance;

    private String mTitleStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        mContentTv.setText(mTitleStr);

        mSingleTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SingleTaskA.getSingleTaskAIntent("SingleTask again", StandardA.this);
                startActivity(intent);
            }
        });

        mSingleTopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SingleTopA.getSingleTopAIntent("SingleTop again", StandardA.this);
                startActivity(intent);
            }
        });

        mSingleInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SingleInstanceA.getSingleInstanceAIntent("Single intance again", StandardA.this);
                startActivity(intent);
            }
        });

    }

    @Override
    protected int initViewLayout() {
        return R.layout.activity_standard;
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mTitleStr = intent.getStringExtra(Constants.TITLE);
        }
    }

    public static Intent getStandardAIntent(String title, Context context) {
        Intent intent = new Intent(context, StandardA.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.putExtra(Constants.TITLE, title);
        return intent;
    }
}
