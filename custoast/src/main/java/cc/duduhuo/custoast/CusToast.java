package cc.duduhuo.custoast;


import android.app.Application;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.widget.Toast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

/**
 * ===========================================================<br>
 * Copyright: Copyright LiYing 2015-2016. All rights reserved.<br>
 * Author: liying<br>
 * Date: 2016/10/12 16:10<br>
 * Version: 1.0<br>
 * Description: Custom Toast<br>
 * Remarks: <br>
 * ===========================================================<br>
 */

public class CusToast {

    private static DToast toast = null;  // Global Toast
    static final String TAG = "CusToast";
    private static Application app;
    private static Style defStyle = Style.DEFAULT;


    /**
     * CusToast initialization.
     * @param application Application <br>
     *                    This initialization is done in the onCreate method of the corresponding Application class.<br>
     *                    <b>Do not forget to configure the android: name attribute under the application node of the AndroidManifest file.</b>
     */
    public static void init(Application application) {
        app = application;
    }

    /**
     * CusToast initialization.
     * @param application Application <br>
     *                    This initialization is done in the onCreate method of the corresponding Application class.<br>
     *                    <b>Do not forget to configure the android: name attribute under the application node of the AndroidManifest file.</b>
     * @param style the default style of CusToast.
     */
    public static void init(Application application, Style style) {
        app = application;
        defStyle = style;
    }


    /**
     * It is not allowed to instantiate this class.
     */
    private CusToast() {
        throw new Error("It is not allowed to instantiate CusToast class");
    }

    /**
     * @see java.lang.annotation.Annotation
     */
    @IntDef({LENGTH_SHORT, LENGTH_LONG})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    /**
     * Display Toast.
     *
     * @param text The resource id of the string resource to use.  Can be formatted text.
     */
    public static void showToast(@StringRes int text) {
        clearToast();
        toast = new DToast(app);
        toast.setView(app, defStyle);
        toast.setText(text);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Display Toast.
     *
     * @param text The text to show.  Can be formatted text.
     */
    public static void showToast(@NonNull CharSequence text) {
        clearToast();
        toast = new DToast(app);
        toast.setView(app, defStyle);
        toast.setText(text);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Get a CusToast instance. <br>
     * Need to call show() method to be displayed.
     *
     * @param mainText The resource id of the string resource to use.  Can be formatted text.
     * @param subText StringRes id. set CusToast button text.
     * @return Get a CusToast instance.
     */
    public static DToast getToastWithSub(@StringRes int mainText, @StringRes int subText) {
        clearToast();
        toast = new DToast(app);
        toast.setSubView(app, defStyle);
        toast.setText(mainText);
        toast.setSubText(subText);
        toast.setDuration(Toast.LENGTH_SHORT);
        return toast;
    }

    /**
     * Get a CusToast instance. <br>
     * Need to call show() method to be displayed.
     *
     * @param mainText The text to show.  Can be formatted text.
     * @param subText StringRes id. set CusToast button text.
     * @return Get a CusToast instance.
     */
    public static DToast getToastWithSub(@NonNull CharSequence mainText, @StringRes int subText) {
        clearToast();
        toast = new DToast(app);
        toast.setSubView(app, defStyle);
        toast.setText(mainText);
        toast.setSubText(subText);
        toast.setDuration(Toast.LENGTH_SHORT);
        return toast;
    }

    /**
     * Get a CusToast instance. <br>
     * Need to call show() method to be displayed.
     *
     * @param mainText The resource id of the string resource to use.  Can be formatted text.
     * @param subText The text displayed on the button.
     * @return Get a CusToast instance.
     */
    public static DToast getToastWithSub(@StringRes int mainText, @NonNull CharSequence subText) {
        clearToast();
        toast = new DToast(app);
        toast.setSubView(app, defStyle);
        toast.setText(mainText);
        toast.setSubText(subText);
        toast.setDuration(Toast.LENGTH_SHORT);
        return toast;
    }

    /**
     * Get a CusToast instance. <br>
     * Need to call show() method to be displayed.
     *
     * @param mainText The text to show.  Can be formatted text.
     * @param subText The text displayed on the button.
     * @return Get a CusToast instance.
     */
    public static DToast getToastWithSub(@NonNull CharSequence mainText, @NonNull CharSequence subText) {
        clearToast();
        toast = new DToast(app);
        toast.setSubView(app, defStyle);
        toast.setText(mainText);
        toast.setSubText(subText);
        toast.setDuration(Toast.LENGTH_SHORT);
        return toast;
    }

    /**
     * Get a CusToast instance. <br>
     * Need to call show() method to be displayed.
     *
     * @param text The text to show.  Can be formatted text.
     * @param icon The resource id of the drawable resource to use.
     * @return Get a CusToast instance.
     */
    public static DToast getToastWithIcon(@NonNull CharSequence text, @DrawableRes int icon) {
        clearToast();
        toast = new DToast(app);
        toast.setIconView(app, defStyle);
        toast.setText(text);
        toast.setIcon(icon);
        toast.setDuration(Toast.LENGTH_SHORT);
        return toast;
    }

    /**
     * Get a CusToast instance. <br>
     * Need to call show() method to be displayed.
     *
     * @param text The resource id of the string resource to use.  Can be formatted text.
     * @param icon The resource id of the drawable resource to use.
     * @return Get a CusToast instance.
     */
    public static DToast getToastWithIcon(@StringRes int text, @DrawableRes int icon) {
        clearToast();
        toast = new DToast(app);
        toast.setIconView(app, defStyle);
        toast.setText(text);
        toast.setIcon(icon);
        toast.setDuration(Toast.LENGTH_SHORT);
        return toast;
    }

    /**
     * Display Toast.
     *
     * @param text The resource id of the string resource to use.  Can be formatted text.
     * @param style the style of CusToast.
     */
    public static void showToast(@StringRes int text, Style style) {
        clearToast();
        toast = new DToast(app);
        toast.setView(app, style);
        toast.setText(text);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Display Toast.
     *
     * @param text The text to show.  Can be formatted text.
     * @param style the style of CusToast.
     */
    public static void showToast(@NonNull CharSequence text, Style style) {
        clearToast();
        toast = new DToast(app);
        toast.setView(app, style);
        toast.setText(text);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Display Toast.
     *
     * @param text    The resource id of the string resource to use.  Can be formatted text.
     * @param duration How long to display the message. Either {@link  android.widget.Toast#LENGTH_SHORT} or
     *                 {@link android.widget.Toast#LENGTH_LONG}
     */
    public static void showToast(@StringRes int text, @Duration int duration) {
        clearToast();
        toast = new DToast(app);
        toast.setView(app, defStyle);
        toast.setText(text);
        toast.setDuration(duration);
        toast.show();
    }

    /**
     * Display Toast.
     *
     * @param text      The text to show.  Can be formatted text.
     * @param duration How long to display the message. Either {@link  android.widget.Toast#LENGTH_SHORT} or
     *                 {@link android.widget.Toast#LENGTH_LONG}
     */
    public static void showToast(@NonNull CharSequence text, @Duration int duration) {
        clearToast();
        toast = new DToast(app);
        toast.setView(app, defStyle);
        toast.setText(text);
        toast.setDuration(duration);
        toast.show();
    }


    /**
     * Display Toast.
     *
     * @param text    The resource id of the string resource to use.  Can be formatted text.
     * @param duration How long to display the message. Either {@link  android.widget.Toast#LENGTH_SHORT} or
     *                 {@link android.widget.Toast#LENGTH_LONG}
     * @param style the style of CusToast.
     */
    public static void showToast(@StringRes int text, @Duration int duration, Style style) {
        clearToast();
        toast = new DToast(app);
        toast.setView(app, style);
        toast.setText(text);
        toast.setDuration(duration);
        toast.show();
    }

    /**
     * Display Toast.
     *
     * @param text      The text to show.  Can be formatted text.
     * @param duration How long to display the message. Either {@link  android.widget.Toast#LENGTH_SHORT} or
     *                 {@link android.widget.Toast#LENGTH_LONG}
     * @param style the style of CusToast.
     */
    public static void showToast(@NonNull CharSequence text, @Duration int duration, Style style) {
        clearToast();
        toast = new DToast(app);
        toast.setView(app, style);
        toast.setText(text);
        toast.setDuration(duration);
        toast.show();
    }

    /**
     * Get a Toast object <br>
     * Need to call show() method to be displayed
     *
     * @param text The text to show.  Can be formatted text.
     * @return a DToast instance.
     */
    public static DToast getToast(@NonNull CharSequence text) {
        clearToast();
        toast = new DToast(app);
        toast.setView(app, defStyle);
        toast.setText(text);
        toast.setDuration(Toast.LENGTH_SHORT);
        return toast;
    }

    /**
     * Get a CusToast instance. <br>
     * Need to call show() method to be displayed.
     *
     * @param text The text to show.  Can be formatted text.
     * @return a DToast instance.
     */
    public static DToast getToast(@StringRes int text) {
        clearToast();
        toast = new DToast(app);
        toast.setView(app, defStyle);
        toast.setText(text);
        toast.setDuration(Toast.LENGTH_SHORT);
        return toast;
    }

    /**
     * Clear an existing CusToast.
     */
    private static void clearToast() {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
    }

    /**
     * Get a global Application
     *
     * @return global Application
     */
    public static Application getApplication() {
        return app;
    }

    /**
     * Style list.
     */
    public enum Style {
        DEFAULT,
        LIGHT_BLUE,
        BLUE,
        LIGHT_RED,
        RED,
        LIGHT_GREEN,
        GREEN,
        LIGHT_YELLOW,
        YELLOW,
        GRAY_1
    }
}
