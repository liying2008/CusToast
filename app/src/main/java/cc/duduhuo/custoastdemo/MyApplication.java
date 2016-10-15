package cc.duduhuo.custoastdemo;

import android.app.Application;

import cc.duduhuo.custoast.CusToast;

/**
 * =======================================================
 * 版权：©Copyright LiYing 2015-2016. All rights reserved.
 * 作者：liying
 * 日期：2016/10/10 21:22
 * 版本：1.0
 * 描述：应用的Application类
 * 备注：
 * =======================================================
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化CusToast库（两种方式选其一）
        // 方式1：初始化同时指定CusToast的默认显示样式
        CusToast.init(this, CusToast.Style.RED);
        // 方式2：初始化，使用默认显示样式
        // CusToast.init(this);
    }
}
