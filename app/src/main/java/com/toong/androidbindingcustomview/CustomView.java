package com.toong.androidbindingcustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomView extends LinearLayout {

    private ImageView imgImage;
    private TextView tvText;
    private OnCustomViewListener onCustomViewListener;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    private void init(AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.custom_layout, this, true);

        imgImage = (ImageView) findViewById(R.id.image);
        tvText = (TextView) findViewById(R.id.text);

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.CustomViewStyle);
        String text = ta.getString(R.styleable.CustomViewStyle_ib_text);

        Drawable drawable = ta.getDrawable(R.styleable.CustomViewStyle_image);

        ta.recycle();
        if (drawable != null) {
            imgImage.setBackground(drawable);
        }
        setIb_text(text);

        imgImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onCustomViewListener.onCustomViewListenerMethod(1);
            }
        });
    }

    public void setIbText(String text) {
        tvText.setText(text);
    }

    //    @BindingAdapter("setIb_text"
    public void setIb_text(String text) {
        tvText.setText(text);
    }


    public void setOnCustomViewListener(OnCustomViewListener onCustomViewListener) {
        this.onCustomViewListener = onCustomViewListener;
    }

    public interface OnCustomViewListener {

        void onCustomViewListenerMethod(int aNumber);

    }
}