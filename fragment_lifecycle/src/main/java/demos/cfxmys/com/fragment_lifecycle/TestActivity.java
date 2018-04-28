package demos.cfxmys.com.fragment_lifecycle;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import demos.cfxmys.com.baselibrary.BaseActivity;

/**
 * Created by C on 2018/4/28.
 */

public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LifeCycleFragment fragment = LifeCycleFragment.getFragmentInstance();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.root, fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected int initViewLayout() {
        return R.layout.activity_main;
    }
}
