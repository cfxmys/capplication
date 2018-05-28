package demos.cfxmys.com.fragment_lifecycle;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import demos.cfxmys.com.baselibrary.BaseFragment;

/**
 * Fragment 生命周期测试
 * Created by C on 2018/4/28.
 */

public class LifeCycleFragment extends BaseFragment {

    @BindView(R.id.add_fragment)
    TextView mAddFragment;

    @BindView(R.id.fragment_label)
    TextView mFragmentTitleTv;

    private String mFragmentTitle;

    private void getData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            mFragmentTitle = bundle.getString(Constants.KEY_FRAGMENT_TITLE);
        }
    }

    public static LifeCycleFragment getFragmentInstance(String name) {
        LifeCycleFragment fragment = new LifeCycleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_FRAGMENT_TITLE, name);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getFragmentLayoutRes() {
        return R.layout.fragment_main;
    }

    @Override
    protected void createFragmentView(View rootView) {
        getData();

        mFragmentTitleTv = rootView.findViewById(R.id.fragment_label);
        mFragmentTitleTv.setText(mFragmentTitle);

        mAddFragment = rootView.findViewById(R.id.add_fragment);
        mAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = getFragmentInstance("second fragment");
                if (getActivity() instanceof TestActivity) {
                    ((TestActivity) getActivity()).addFragment(fragment);
                }
            }
        });
    }
}
