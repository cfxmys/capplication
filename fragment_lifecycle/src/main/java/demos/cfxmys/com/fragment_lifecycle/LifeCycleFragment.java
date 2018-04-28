package demos.cfxmys.com.fragment_lifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import demos.cfxmys.com.baselibrary.BaseFragment;

/**
 * Fragment 生命周期测试
 * Created by C on 2018/4/28.
 */

public class LifeCycleFragment extends BaseFragment {
    @Override
    protected View createFragmentView(LayoutInflater inflater, @Nullable ViewGroup container,
                                      Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        return rootView;
    }

    public static LifeCycleFragment getFragmentInstance() {
        LifeCycleFragment fragment = new LifeCycleFragment();
        return fragment;
    }
}
