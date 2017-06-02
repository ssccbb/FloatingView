package com.sung.floatingview;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by sung on 2017/6/2.
 */

public class FloatingView extends BaseFloatingView implements View.OnClickListener{
    private Context mContext;
    private ImageView img;
    private View root;

    public FloatingView(Context context) {
        super(context);
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context){
        this.mContext = context;
        root = View.inflate(context, R.layout.layout_custom_view,null);

        img = (ImageView) root.findViewById(R.id.iv_img);
        img.setOnClickListener(this);
    }

    public static int dip2px(Context context, float dipValue) {

        final float scale = context.getResources().getDisplayMetrics().density;

        return (int) (dipValue * scale + 0.5f);
    }

    public boolean show(){
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.width = dip2px(mContext, 160);
        lp.height = dip2px(mContext, 90);

        if (root.getParent() == null)
            addView(root, lp);
        super.showView(this);
        return true;
    }

    public void dismiss() {
        super.hideView();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        dismiss();
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view == img){
            Toast.makeText(mContext, "imgview click!", Toast.LENGTH_SHORT).show();
        }
    }
}
