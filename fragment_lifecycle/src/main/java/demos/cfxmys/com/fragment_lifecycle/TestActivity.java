package demos.cfxmys.com.fragment_lifecycle;

import android.app.Fragment;
import android.os.Bundle;
import demos.cfxmys.com.baselibrary.BaseActivity;

/**
 * Created by C on 2018/4/28.
 */

public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LifeCycleFragment fragment = LifeCycleFragment.getFragmentInstance("origin fragment");
        CommonUtils.addFragment(this, fragment, R.id.root, false);
    }

    @Override
    protected int initViewLayout() {
        return R.layout.activity_main;
    }

    public void addFragment(Fragment fragment) {
        CommonUtils.addFragment(this, fragment, R.id.root, false);
    }
}
