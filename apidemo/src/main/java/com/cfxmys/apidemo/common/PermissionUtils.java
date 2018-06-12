package com.cfxmys.apidemo.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * 权限检查工具
 * Created by cw on 2018/6/12.
 */

public class PermissionUtils {

    public static boolean checkFeature(Context context, String feature) {
        if (context == null || TextUtils.isEmpty(feature)) {
            return false;
        }
        if (context.getPackageManager().hasSystemFeature(feature)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkCameraFeature(Context context) {
        return checkFeature(context, PackageManager.FEATURE_CAMERA);
    }

//    public static boolean checkCameraFeature(Context context) {
//        if (context == null) {
//            return false;
//        }
//
//        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
//            return true;
//        } else {
//            return false;
//        }
//    }

}
