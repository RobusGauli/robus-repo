package com.bex.recycler;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
public class MyImageView extends ImageView
{

    public MyImageView(final Context context)
    {
        super(context);
    }

    public MyImageView(final Context context, final AttributeSet attrs)
    {
        super(context, attrs);
    }

    public MyImageView(final Context context, final AttributeSet attrs, final int defStyle)
    {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec)
    {
        final int width = getDefaultSize(getSuggestedMinimumWidth(),widthMeasureSpec);
        setMeasuredDimension(width, width);
    }

    @Override
    protected void onSizeChanged(final int w, final int h, final int oldw, final int oldh)
    {
        super.onSizeChanged(w, w, oldw, oldh);
    }
}