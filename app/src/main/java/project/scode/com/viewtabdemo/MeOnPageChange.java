package project.scode.com.viewtabdemo;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;

import static android.support.v4.view.ViewPager.SCROLL_STATE_SETTLING;

/**
 * Created by Administrator on 2018/8/18.
 */

public class MeOnPageChange implements ViewPager.OnPageChangeListener {
    MeDynamic dynamic;
    ViewPager viewPager;
    private int WindowWidth;
    int ItemWidth;
    int ItemSize=3;
    int lastPos=0;//记录上一个下标值


    public MeOnPageChange(Context context, MeDynamic dynamic, ViewPager viewPager) {
        this.dynamic = dynamic;
        this.viewPager = viewPager;
        WindowWidth = getScreenWidth((Activity) context);
        ItemWidth = WindowWidth / ItemSize;//item长度
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d("PosOffset", "onPageScrolled: "+positionOffset);
        if (lastPos > position) {
            dynamic.updateView((position + positionOffset) * ItemWidth,(lastPos+1) * ItemWidth);
        }else {
            dynamic.updateView(lastPos * ItemWidth, (position + positionOffset+1) * ItemWidth);
        }
    }

    @Override
    public void onPageSelected(int position) {
        //回调viewpage的当前position
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == SCROLL_STATE_SETTLING) {
            lastPos = viewPager.getCurrentItem();
        }
    }

    public int getScreenWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
