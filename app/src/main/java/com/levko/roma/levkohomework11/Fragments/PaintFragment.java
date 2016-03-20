package com.levko.roma.levkohomework11.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.levko.roma.levkohomework11.R;
import com.levko.roma.levkohomework11.View.PaintView;

/**
 * Created by User on 20.03.2016.
 */
public class PaintFragment extends Fragment implements View.OnClickListener {
    private PaintView mPaintView;
    private Button btn_black,
            btn_blue,
            btn_red;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.paint_fragment, container, false);

        findViews(view);
        setListeners();
        return view;
    }

    private void findViews(View v) {
        btn_black = (Button) v.findViewById(R.id.btn_color_black_PF);
        btn_blue = (Button) v.findViewById(R.id.btn_color_blue_PF);
        btn_red = (Button) v.findViewById(R.id.btn_color_red_PF);
        mPaintView = (PaintView) v.findViewById(R.id.paint_view_PF);
    }

    private void setListeners() {
        btn_black.setOnClickListener(this);
        btn_blue.setOnClickListener(this);
        btn_red.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_color_black_PF:
                mPaintView.setPaintColor(Color.BLACK);
                break;
            case R.id.btn_color_blue_PF:
                mPaintView.setPaintColor(Color.BLUE);
                break;
            case R.id.btn_color_red_PF:
                mPaintView.setPaintColor(Color.RED);
                break;
        }
    }
}
