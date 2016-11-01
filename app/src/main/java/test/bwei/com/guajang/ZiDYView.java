package test.bwei.com.guajang;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by zhangjie on 2016/11/1.
 */
public class ZiDYView extends View {
    private int sweepAngle;
    private int startAngle;
    private String text;
    private float textSize;
    private int textColor;
    private int arcColor;
    private Context context;
    private int mCircleXY;
    private float mRadius;
    private Paint mCirclePaint;
    private int circleColor;
    private RectF mRectF;
    private Paint mArcPaint;
    private Paint mTextPaint;

    public ZiDYView(Context context) {
        super(context);
    }

    public ZiDYView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.ZiDYView);
        if (ta != null) {
            circleColor = ta.getColor(R.styleable.ZiDYView_circleColor, 0);
            arcColor = ta.getColor(R.styleable.ZiDYView_arcColor, 0);
            textColor = ta.getColor(R.styleable.ZiDYView_textColor, 0);
            textSize = ta.getDimension(R.styleable.ZiDYView_textSize, 50);
            text = ta.getString(R.styleable.ZiDYView_text);
            startAngle = ta.getInt(R.styleable.ZiDYView_startAngle, 0);
            sweepAngle = ta.getInt(R.styleable.ZiDYView_sweepAngle, 270);
            ta.recycle();
        }
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init(w,h);
    }

    private void init(int w, int h) {
        int length = Math.min(w, h);
        mCircleXY = length / 2;
        mRadius = length * 0.5f / 2;
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setColor(Color.BLUE);
        mRectF = new RectF(length * 0.1f, length * 0.1f, length * 0.9f,
                length * 0.9f);

        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setColor(Color.GREEN);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth((w * 0.1f));

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(textSize);
        mTextPaint.setColor(Color.LTGRAY);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSth(canvas);
    }

    private void drawSth(Canvas canvas) {
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        canvas.drawArc(mRectF, startAngle, sweepAngle, false, mArcPaint);
        canvas.drawText("sad", mCircleXY, mCircleXY + textSize
                / 4, mTextPaint);
    }
}
