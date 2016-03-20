package com.levko.roma.levkohomework11.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.levko.roma.levkohomework11.R;

/**
 * Created by User on 20.03.2016.
 */
public class MoveFragment extends Fragment implements View.OnClickListener, View.OnTouchListener {
    private static final float SIZE_TEXT = 20.0f;
    private static final int PARAMS = 250;

    private ViewGroup mViewGroup;
    private RelativeLayout rlField;
    private View mCurrentView;
    private Button btnNewButton, btnNewTextView, btnNewImage;
    private int xPos, yPos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.move_fragment, container, false);
        mViewGroup = container;
        findViews(view);
        setListeners();
        return view;
    }

    private void setListeners() {
        btnNewButton.setOnClickListener(this);
        btnNewTextView.setOnClickListener(this);
        btnNewImage.setOnClickListener(this);
    }

    private void findViews(View v) {
        btnNewButton = (Button) v.findViewById(R.id.btn_new_btn_MF);
        btnNewTextView = (Button) v.findViewById(R.id.btn_new_text_view_MF);
        btnNewImage = (Button) v.findViewById(R.id.btn_new_image_MF);
        rlField = (RelativeLayout) v.findViewById(R.id.rl_field_MF);
    }

    @Override
    public void onClick(View v) {
        if (mCurrentView != null) rlField.removeView(mCurrentView);

        switch (v.getId()) {
            case R.id.btn_new_btn_MF:
                Button btn = new Button(mViewGroup.getContext());
                btn.setText(getString(R.string.created_btn));
                btn.setTextColor(getResources().getColor(R.color.colorBlue));
                mCurrentView = btn;
                btn.setOnTouchListener(this);
                rlField.addView(btn);
                break;
            case R.id.btn_new_text_view_MF:
                TextView tv = new TextView(mViewGroup.getContext());
                tv.setText(getString(R.string.created_tv));
                tv.setTextColor(getResources().getColor(R.color.colorRed));
                tv.setTextSize(SIZE_TEXT);
                mCurrentView = tv;
                tv.setOnTouchListener(this);
                rlField.addView(tv);
                break;
            case R.id.btn_new_image_MF:
                ImageView iv = new ImageView(mViewGroup.getContext());
                iv.setImageResource(R.drawable.ic_move);
                mCurrentView = iv;
                iv.setOnTouchListener(this);
                rlField.addView(iv);
            default:
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                        v.getLayoutParams();
                xPos = X - lParams.leftMargin;
                yPos = Y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)
                        v.getLayoutParams();
                layoutParams.leftMargin = X - xPos;
                layoutParams.topMargin = Y - yPos;
                layoutParams.rightMargin = -PARAMS;
                layoutParams.bottomMargin = -PARAMS;
                v.setLayoutParams(layoutParams);
                break;
        }
        rlField.invalidate();
        return true;
    }
}
