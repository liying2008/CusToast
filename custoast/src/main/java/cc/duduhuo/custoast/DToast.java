package cc.duduhuo.custoast;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import cc.duduhuo.custoast.util.DensityUtil;

/**
 * ===========================================================<br>
 * Copyright: Copyright LiYing 2015-2016. All rights reserved.<br>
 * Author: liying<br>
 * Date: 2016/10/12 16:15<br>
 * Version: 0.2<br>
 * Description: Custom Toast<br>
 * Remarks: <br>
 * ===========================================================<br>
 */

public class DToast extends Toast {
    private WeakReference<Context> context;
    private View dView;
    private TextView dText;
    private TextView dSubText;
    private TextView dLine;
    private ImageView dIcon;

    private static final String TAG = "DToast";

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public DToast(Context context) {
        super(context);
        this.context = new WeakReference<Context>(context);
    }

    /**
     * Add a view to CusToast.
     *
     * @param application this application.
     * @param style       the style of CusToast.
     * @return current instance.
     */
    public DToast setView(Application application, CusToast.Style style) {
        dView = View.inflate(application, R.layout.ddh_cus_toast, null);
        dText = (TextView) dView.findViewById(R.id.dText);
        setStyle(style);
        super.setView(dView);
        return this;
    }

    /**
     * Add a view to CusToast.
     *
     * @param application this application.
     * @param style       the style of CusToast.
     * @return current instance.
     */
    public DToast setSubView(Application application, CusToast.Style style) {
        dView = View.inflate(application, R.layout.ddh_cus_toast_with_sub, null);
        dText = (TextView) dView.findViewById(R.id.dText);
        dSubText = (TextView) dView.findViewById(R.id.dSubText);
        dLine = (TextView) dView.findViewById(R.id.dLine);
        setStyle(style);
        super.setView(dView);
        return this;
    }

    /**
     * Add a view to CusToast.
     *
     * @param application this application.
     * @param style       the style of CusToast.
     * @return current instance.
     */
    public DToast setIconView(Application application, CusToast.Style style) {
        dView = View.inflate(application, R.layout.ddh_cus_toast_with_icon, null);
        dText = (TextView) dView.findViewById(R.id.dText);
        dIcon = (ImageView) dView.findViewById(R.id.dIcon);
        setStyle(style);
        super.setView(dView);
        return this;
    }

    @Override
    public View getView() {
        return dView;
    }

    /**
     * Get the Toast display text.
     *
     * @return the text.
     */
    public String getText() {
        if (dText != null) {
            return dText.getText().toString();
        } else {
            Log.e(TAG, "getText(): Call the setView method first.");
            return "";
        }
    }

    /**
     * Set the text to display in CusToast.
     *
     * @param text text.
     */
    @Override
    public void setText(@StringRes int text) {
        if (dText != null) {
            dText.setText(text);
        } else {
            Log.e(TAG, "Call the setView method first.");
        }
    }

    /**
     * Set the text to display in CusToast.
     *
     * @param text text.
     */
    @Override
    public void setText(@Nullable CharSequence text) {
        if (dText != null) {
            dText.setText(text);
        } else {
            Log.e(TAG, "Call the setView method first");
        }
    }

    /**
     * Set the text displayed on the button.
     *
     * @param subText subtitle text.
     * @return current instance.
     */
    public DToast setSubText(@StringRes int subText) {
        if (dSubText != null) {
            dSubText.setText(subText);
        } else {
            Log.e(TAG, "Call the setSubView method first.");
        }
        return this;
    }

    /**
     * Set the text displayed on the button.
     *
     * @param subText subtitle text.
     * @return current instance.
     */
    public DToast setSubText(CharSequence subText) {
        if (dSubText != null) {
            dSubText.setText(subText);
        } else {
            Log.e(TAG, "Call the setSubView method first.");
        }
        return this;
    }

    /**
     * Set the CusToast icon.
     * @param icon CusToast icon.
     * @return current instance.
     */
    public DToast setIcon(@DrawableRes int icon) {
        if (dIcon != null) {
            dIcon.setImageResource(icon);
        } else {
            Log.e(TAG, "Call the setIconView method first.");
        }
        return this;
    }

    /**
     * Set the CusToast icon.
     * @param bitmap CusToast icon.
     * @return current instance.
     */
    public DToast setIcon(Bitmap bitmap) {
        if (dIcon != null) {
            dIcon.setImageBitmap(bitmap);
        } else {
            Log.e(TAG, "Call the setIconView method first.");
        }
        return this;
    }

    /**
     * Set the CusToast icon.
     * @param drawable CusToast icon.
     * @return current instance.
     */
    public DToast setIcon(Drawable drawable) {
        if (dIcon != null) {
            dIcon.setImageDrawable(drawable);
        } else {
            Log.e(TAG, "Call the setIconView method first.");
        }
        return this;
    }

    /**
     * Set the text size.
     *
     * @param sp text size(unit: sp).
     * @return current instance.
     */
    public DToast setTextSize(int sp) {
        if (dText != null) {
            dText.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp);
        } else {
            Log.e(TAG, "Call the setView method first.");
        }
        return this;
    }

    /**
     * Set the size of the icon.
     * @param dp icon size(unit: dp).
     * @return current instance.
     */
    public DToast setIconSize(int dp) {
        if (dIcon != null) {
            int width = DensityUtil.dip2px(context.get(), dp);
            int height = width;
            dIcon.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        }
        return this;
    }

    /**
     * Set the button text size.
     *
     * @param sp text size(unit: sp).
     * @return current instance.
     */
    public DToast setSubTextSize(int sp) {
        if (dSubText != null) {
            dSubText.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp);
        } else {
            Log.e(TAG, "Call the setSubView method first.");
        }
        return this;
    }

    /**
     * Set the text color.
     *
     * @param color text color.
     * @return current instance.
     */
    public DToast setTextColor(int color) {
        if (dText != null) {
            dText.setTextColor(color);
        } else {
            Log.e(TAG, "Call the setView method first.");
        }
        return this;
    }

    /**
     * Set the button text color.
     *
     * @param color button text color.
     * @return current instance.
     */
    public DToast setSubTextColor(int color) {
        if (dSubText != null) {
            dSubText.setTextColor(color);
        } else {
            Log.e(TAG, "Call the setSubView method first.");
        }
        return this;
    }

    /**
     * Set the style of toast.
     *
     * @param style CusToast Style.
     * @return current instance.
     */
    public DToast setStyle(CusToast.Style style) {
        if (style == CusToast.Style.DEFAULT) {
            // default style
            dView.setBackgroundResource(R.drawable.ddh_cus_bg_def);
            dText.setTextColor(Color.WHITE);
            if (dSubText != null) {
                dSubText.setTextColor(0xffdddddd);
                dLine.setBackgroundColor(Color.WHITE);
            }
        } else if (style == CusToast.Style.LIGHT_BLUE) {
            dView.setBackgroundResource(R.drawable.ddh_cus_bg_light_blue);
            dText.setTextColor(Const.LIGHT_BLUE_COLOR);
            if (dSubText != null) {
                dSubText.setTextColor(Const.LIGHT_BLUE_SUB_COLOR);
                dLine.setBackgroundColor(Const.LIGHT_BLUE_COLOR);
            }
        } else if (style == CusToast.Style.BLUE) {
            dView.setBackgroundResource(R.drawable.ddh_cus_bg_blue);
            dText.setTextColor(Const.BLUE_COLOR);
            if (dSubText != null) {
                dSubText.setTextColor(Const.BLUE_SUB_COLOR);
                dLine.setBackgroundColor(Const.BLUE_COLOR);
            }
        } else if (style == CusToast.Style.RED) {
            dView.setBackgroundResource(R.drawable.ddh_cus_bg_red);
            dText.setTextColor(Const.RED_COLOR);
            if (dSubText != null) {
                dSubText.setTextColor(Const.RED_SUB_COLOR);
                dLine.setBackgroundColor(Const.RED_COLOR);
            }
        } else if (style == CusToast.Style.LIGHT_RED) {
            dView.setBackgroundResource(R.drawable.ddh_cus_bg_light_red);
            dText.setTextColor(Const.LIGHT_RED_COLOR);
            if (dSubText != null) {
                dSubText.setTextColor(Const.LIGHT_RED_SUB_COLOR);
                dLine.setBackgroundColor(Const.LIGHT_RED_COLOR);
            }
        } else if (style == CusToast.Style.GREEN) {
            dView.setBackgroundResource(R.drawable.ddh_cus_bg_green);
            dText.setTextColor(Const.GREEN_COLOR);
            if (dSubText != null) {
                dSubText.setTextColor(Const.GREEN_SUB_COLOR);
                dLine.setBackgroundColor(Const.GREEN_COLOR);
            }
        } else if (style == CusToast.Style.LIGHT_GREEN) {
            dView.setBackgroundResource(R.drawable.ddh_cus_bg_light_green);
            dText.setTextColor(Const.LIGHT_GREEN_COLOR);
            if (dSubText != null) {
                dSubText.setTextColor(Const.LIGHT_GREEN_SUB_COLOR);
                dLine.setBackgroundColor(Const.LIGHT_GREEN_COLOR);
            }
        } else if (style == CusToast.Style.YELLOW) {
            dView.setBackgroundResource(R.drawable.ddh_cus_bg_yellow);
            dText.setTextColor(Const.YELLOW_COLOR);
            if (dSubText != null) {
                dSubText.setTextColor(Const.YELLOW_SUB_COLOR);
                dLine.setBackgroundColor(Const.YELLOW_COLOR);
            }
        } else if (style == CusToast.Style.LIGHT_YELLOW) {
            dView.setBackgroundResource(R.drawable.ddh_cus_bg_light_yellow);
            dText.setTextColor(Const.LIGHT_YELLOW_COLOR);
            if (dSubText != null) {
                dSubText.setTextColor(Const.LIGHT_YELLOW_SUB_COLOR);
                dLine.setBackgroundColor(Const.LIGHT_YELLOW_COLOR);
            }
        } else if (style == CusToast.Style.GRAY_1) {
            dView.setBackgroundResource(R.drawable.ddh_cus_bg_gray_1);
            dText.setTextColor(Const.GRAY_COLOR_1);
            if (dSubText != null) {
                dSubText.setTextColor(Const.GRAY_SUB_COLOR_1);
                dLine.setBackgroundColor(Const.GRAY_COLOR_1);
            }
        }
        return this;
    }

    /**
     * Set the text background.
     *
     * @param resId DrawableRes id.
     * @return current instance.
     */
    public DToast setBackground(@DrawableRes int resId) {
        if (dView != null) {
            dView.setBackgroundResource(resId);
        } else {
            Log.e(TAG, "Call the setView method first.");
        }
        return this;
    }

    /**
     * Set the text background.
     *
     * @param color background color.
     * @return current instance.
     */
    public DToast setBackgroundColor(int color) {
        if (dView != null) {
            dView.setBackgroundColor(color);
        } else {
            Log.e(TAG, "Call the setView method first.");
        }
        return this;
    }

    /**
     * Set the text background.
     *
     * @param drawable background drawable.
     * @return current instance.
     */
    public DToast setBackground(Drawable drawable) {
        if (dView != null) {
            dView.setBackgroundDrawable(drawable);
        } else {
            Log.e(TAG, "Call the setView method first.");
        }
        return this;
    }

    /**
     * Set the color of CusToast line.
     * @param color line color.
     * @return current instance.
     */
    public DToast setLineColor(int color) {
        if (dLine != null) {
            dLine.setBackgroundColor(color);
        } else {
            Log.e(TAG, "Call the setSubView method first.");
        }
        return this;
    }

    /**
     * Set the Toast display duration.
     * @param duration set how long to show the view for.
     * @see #LENGTH_SHORT
     * @see #LENGTH_LONG
     * @return current instance.
     */
    public DToast setCusToastDuration(@CusToast.Duration int duration) {
        super.setDuration(duration);
        return this;
    }

    /**
     * * Set the location at which the notification should appear on the screen.
     * @see android.view.Gravity
     * @see #getGravity
     *
     * @param gravity gravity
     * @param xOffset xOffset
     * @param yOffset yOffset
     * @return current instance.
     */
    public DToast setCusToastGravity(int gravity, int xOffset, int yOffset) {
        super.setGravity(gravity, xOffset, yOffset);
        return this;
    }

    /**
     * Set the margins of the view.
     *
     * @param horizontalMargin The horizontal margin, in percentage of the
     *        container width, between the container's edges and the
     *        notification
     * @param verticalMargin The vertical margin, in percentage of the
     *        container height, between the container's edges and the
     *        notification
     * @return current instance.
     */
    public DToast setCusToastMargin(float horizontalMargin, float verticalMargin) {
        super.setMargin(horizontalMargin, verticalMargin);
        return this;
    }

    /**
     * Set the text to display in CusToast.
     * @param text The new text for the CusToast.
     * @return current instance.
     */
    public DToast setCusToastText(@StringRes int text) {
        setText(text);
        return this;
    }

    /**
     * Set the text to display in CusToast.
     * @param text The new text for the CusToast.
     * @return current instance.
     */
    public DToast setCusToastText(@NonNull CharSequence text) {
        setText(text);
        return this;
    }
}
