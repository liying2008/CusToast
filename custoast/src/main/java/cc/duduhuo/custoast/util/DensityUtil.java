package cc.duduhuo.custoast.util;

import android.content.Context;

/**
 * ===========================================================<br>
 * Copyright: Copyright LiYing 2015-2016. All rights reserved.<br>
 * Author: liying<br>
 * Date: 2016/6/23 13:18<br>
 * Version: 1.0<br>
 * Description: dp -> sp <br>
 * Remarks: Calculation formula pixels = dips * (density / 160)<br>
 * ===========================================================<br>
 */
public class DensityUtil {
    /**
     * @param context context
     * @param dpValue dp value
     * @return dp to  px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
