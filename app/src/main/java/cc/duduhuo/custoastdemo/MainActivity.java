package cc.duduhuo.custoastdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

import cc.duduhuo.custoast.CusToast;
import cc.duduhuo.custoast.DToast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost = (TabHost) findViewById(R.id.th);

        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("normal")
                .setIndicator("普通样式").setContent(R.id.view1));
        tabHost.addTab(tabHost.newTabSpec("sub")
                .setIndicator("带次标题").setContent(R.id.view2));
        tabHost.addTab(tabHost.newTabSpec("icon")
                .setIndicator("带图标").setContent(R.id.view3));

        initView1();
        initView2();
        initView3();
    }

    /**
     * 普通样式的CusToast
     */
    private void initView1() {
        Button btnDefault1 = (Button) findViewById(R.id.btnDefault1);
        Button btnDefault2 = (Button) findViewById(R.id.btnDefault2);
        Button btnDefault3 = (Button) findViewById(R.id.btnDefault3);
        Button btnDefault4 = (Button) findViewById(R.id.btnDefault4);
        Button btnDefault5 = (Button) findViewById(R.id.btnDefault5);

        btnDefault1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CusToast.showToast("Toast 1");
            }
        });

        btnDefault2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CusToast.showToast(R.string.toast2, CusToast.Style.LIGHT_YELLOW);
            }
        });

        btnDefault3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CusToast.showToast("Toast 3", Toast.LENGTH_LONG, CusToast.Style.LIGHT_RED);
            }
        });

        btnDefault4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CusToast.showToast(R.string.toast4, Toast.LENGTH_SHORT);
            }
        });

        btnDefault5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DToast toast = CusToast.getToast("自定义Toast");
                toast.setCusToastGravity(Gravity.CENTER, 0, 0)
                        .setTextSize(16)
                        .setStyle(CusToast.Style.GRAY_1)
                        .setTextColor(Color.WHITE)
                        // .setBackground(R.mipmap.ic_launcher)
                        // .setBackgroundColor(0xffff3444)
                        .setCusToastDuration(Toast.LENGTH_SHORT)
                        .show();

            }
        });

    }

    /**
     * 带次标题的CusToast
     */
    private void initView2() {
        Button btnSub1 = (Button) findViewById(R.id.btnSub1);
        Button btnSub2 = (Button) findViewById(R.id.btnSub2);

        btnSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CusToast.getToastWithSub("主标题", "次标题").show();
            }
        });

        btnSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CusToast.getToastWithSub(R.string.main_text, R.string.sub_text)
                        .setCusToastDuration(Toast.LENGTH_LONG)
                        .setStyle(CusToast.Style.LIGHT_BLUE)
                        .setTextSize(16)
                        .setSubTextSize(12)
                        .setCusToastText("主标题主标题主标题主标题")
                        .setSubText("次标题次标题次标题次标题")
                        .setLineColor(Color.GREEN)
                        .show();
            }
        });

    }

    /**
     * 带图标的CusToast
     */
    private void initView3() {
        Button btnIcon1 = (Button) findViewById(R.id.btnIcon1);
        Button btnIcon2 = (Button) findViewById(R.id.btnIcon2);

        btnIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CusToast.getToastWithIcon("CusToast", R.mipmap.ic_launcher).show();
            }
        });

        btnIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CusToast.getToastWithIcon(R.string.toast2, R.mipmap.ic_launcher)
                        .setCusToastText("带图片的Toast")
                        .setStyle(CusToast.Style.LIGHT_BLUE)
                        .setTextColor(0xff67babf)
                        .setTextSize(20)
                        .setIconSize(40)
                        .setCusToastDuration(Toast.LENGTH_LONG)
                        .setIcon(R.drawable.icon_sample)
                        .show();
            }
        });

    }
}
