package demos.cfxmys.com.fragment_lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class CommonUtils {

    public static void addFragment(Activity activity, Fragment fragment, int fragmentLayoutRes, boolean
            addToBackStack) {
        if (activity == null) {
            return ;
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(fragmentLayoutRes, fragment);
            if (addToBackStack) {
                // 如果添加到了回退栈，则在按下返回按钮时，会先出栈当前的这个fragment，一直按返回键，直到把栈内的fragment实例都出栈
                // 如果没有添加到回退栈，按下返回按钮时，会直接推出当前应用
                // 只针对当前demo 中涉及的例子
                fragmentTransaction.addToBackStack(null);
            }
            fragmentTransaction.commit();
        }
    }
}
