package com.liang.lelogo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.liang.lelogo.R;

/**
 * Created by ASUS on 2017/12/1.
 */

public class DividerDecoration extends RecyclerView.ItemDecoration{
    private int dividerHeight;
    private Paint paint;

    public DividerDecoration(Context context){
        dividerHeight= (int) context.getResources().getDimension(R.dimen.divider_height);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(ContextCompat.getColor(context,R.color.dividerGray));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0,0,0,dividerHeight);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int left=parent.getPaddingLeft();
        int right=parent.getWidth()-parent.getPaddingRight();

        int count=parent.getChildCount();
        for(int i=0;i<count;i++){
            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();
            int top=child.getBottom()+params.bottomMargin;
            int bottom=top+dividerHeight;
            c.drawRect(left,top,right,bottom,paint);
        }
    }
}
