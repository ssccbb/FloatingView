package com.sung.floatingview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FloatingActivity extends AppCompatActivity implements View.OnClickListener{
    private FloatingView mFloatingView;
    private TextView mShowWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating);
        getSupportActionBar().hide();

        mShowWindow = (TextView) findViewById(R.id.tv_show_tips_window);
        mShowWindow.setOnClickListener(this);

        initFloatingView();
    }

    private void initFloatingView() {
        mFloatingView = new FloatingView(this);
        mFloatingView.show();
    }


    @Override
    public void onClick(View view) {
        if (view == mShowWindow){
            if (mFloatingView != null){
                mFloatingView.show();
            }else {
                initFloatingView();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mFloatingView!=null) {
            mFloatingView.dismiss();
            mFloatingView = null;
        }
    }

}
