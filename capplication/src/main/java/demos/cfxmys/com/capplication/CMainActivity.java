package demos.cfxmys.com.capplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;

/**
 * Created by C on 2018/4/23.
 */

public class CMainActivity extends BaseActivity {

    @BindView(R.id.standard)
    Button mStandardABtn;

    @BindView(R.id.singletask)
    Button mSingleTaskBtn;

    @BindView(R.id.singletop)
    Button mSingleTopBtn;

    @BindView(R.id.single_instance)
    Button mSingleInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mStandardABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = StandardA.getStandardAIntent("Standard", CMainActivity.this);
                startActivity(intent);
            }
        });

        mSingleTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SingleTaskA.getSingleTaskAIntent("SingleTask", CMainActivity.this);
                startActivity(intent);
            }
        });

        mSingleTopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SingleTopA.getSingleTopAIntent("SingleTop", CMainActivity.this);
                startActivity(intent);
            }
        });

        mSingleInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SingleInstanceA.getSingleInstanceAIntent("Single instance A", CMainActivity.this);
                startActivity(intent);
            }
        });

    }

    @Override
    protected int initViewLayout() {
        return R.layout.activity_main;
    }
}
