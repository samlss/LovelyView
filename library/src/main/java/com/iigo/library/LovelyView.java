package com.iigo.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author SamLeung
 * @e-mail 729717222@qq.com
 * @github https://github.com/samlss
 * @csdn https://blog.csdn.net/Samlss
 * @description A lovely view, can display combined information.
 */
public class LovelyView extends RelativeLayout {
    /**
     * The default color.
     * */
    private final static int DEFAULT_COLOR = Color.parseColor("#8a000000");

    /**
     * Refer the default text size of {@link android.widget.TextView}
     * */
    private final static int DEFAULT_TEXT_SIZE = 15;

    /**
     * The default line height is 1px.
     * */
    private final static int DEFAULT_LINE_HEIGHT = 1;

    private static final ImageView.ScaleType[] sScaleTypeArray = {
            ImageView.ScaleType.MATRIX,
            ImageView.ScaleType.FIT_XY,
            ImageView.ScaleType.FIT_START,
            ImageView.ScaleType.FIT_CENTER,
            ImageView.ScaleType.FIT_END,
            ImageView.ScaleType.CENTER,
            ImageView.ScaleType.CENTER_CROP,
            ImageView.ScaleType.CENTER_INSIDE
    };

    private TextElement leftTextElement;
    private TextElement leftTopTextElement;
    private TextElement leftBottomTextElement;

    private TextElement rightTextElement;
    private TextElement rightTopTextElement;
    private TextElement rightBottomTextElement;

    private TextElement centerTextElement;

    private ImageElement leftImageElement;
    private ImageElement rightImageElement;

    private LineElement topLineElement;
    private LineElement bottomLineElement;

    public LovelyView(Context context) {
        this(context, null);
    }

    public LovelyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LovelyView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LovelyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(AttributeSet attrs){
        initElements();
        parseAttrs(attrs);
    }

    @Override
    protected void onFinishInflate() {
        initLayout();
        requestLayout();
        invalidate();

        super.onFinishInflate();
    }

    /**
     * To construct the elements.
     * */
    private void initElements(){
        leftImageElement  = new ImageElement();
        leftImageElement.setImageView(createImageView());

        rightImageElement = new ImageElement();
        rightImageElement.setImageView(createImageView());

        centerTextElement       = new TextElement();
        rightTextElement        = new TextElement();
        rightTopTextElement     = new TextElement();
        rightBottomTextElement  = new TextElement();
        leftTextElement         = new TextElement();
        leftTopTextElement      = new TextElement();
        leftBottomTextElement   = new TextElement();

        centerTextElement.setTextView(createTextView());
        rightTextElement.setTextView(createTextView());
        rightTopTextElement.setTextView(createTextView());
        rightBottomTextElement.setTextView(createTextView());
        leftTextElement.setTextView(createTextView());
        leftTopTextElement.setTextView(createTextView());
        leftBottomTextElement.setTextView(createTextView());

        topLineElement    = new LineElement();
        topLineElement.setLineView(createLineView());

        bottomLineElement = new LineElement();
        bottomLineElement.setLineView(createLineView());
    }

    /**
     * To create a new {@link ImageView}.
     * */
    private ImageView createImageView(){
        return new ImageView(getContext());
    }

    /**
     * To create a new {@link TextView}.
     * */
    private TextView createTextView(){
        TextView textView = new TextView(getContext());
        textView.setGravity(Gravity.CENTER | Gravity.LEFT);

        return textView;
    }

    /**
     * To create a new line {@link View}.
     * */
    private View createLineView(){
        return new View(getContext());
    }

    /**
     * To parse the attrs of current view.
     * */
    private void parseAttrs(AttributeSet attrs){
        if (attrs == null){
            return;
        }

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.LovelyView);
        parseLeftTextAttr(typedArray);
        parseLeftTopTextAttr(typedArray);
        parseLeftBottomTextAttr(typedArray);

        parseCenterTextAttr(typedArray);

        parseRightTextAttr(typedArray);
        parseRightTopTextAttr(typedArray);
        parseRightBottomTextAttr(typedArray);

        parseLeftImageAttr(typedArray);
        parseRightImageAttr(typedArray);

        parseTopLineAttr(typedArray);
        parseBottomLineAttr(typedArray);

        typedArray.recycle();
    }

    /**
     * Parse the right image attr.
     * */
    private void parseRightImageAttr(TypedArray typedArray) {
        rightImageElement.setDrawable(typedArray.getDrawable(R.styleable.LovelyView_rightImage));
        rightImageElement.setWidth(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightImageWidth, 0));
        rightImageElement.setHeight(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightImageHeight, 0));

        final int scaleTypeIndex = typedArray.getInt(R.styleable.LovelyView_rightImageScaleType, -1);
        if (scaleTypeIndex >= 0) {
            rightImageElement.setScaleType(sScaleTypeArray[scaleTypeIndex]);
        }

        rightImageElement.setMarginLeft(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightImageMarginLeft, 0));
        rightImageElement.setMarginRight(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightImageMarginRight, 0));
        rightImageElement.setMarginTop(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightImageMarginTop, 0));
        rightImageElement.setMarginBottom(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightImageMarginBottom, 0));
    }

    /**
     * Parse the left image attr.
     * */
    private void parseLeftImageAttr(TypedArray typedArray) {
        leftImageElement.setDrawable(typedArray.getDrawable(R.styleable.LovelyView_leftImage));
        leftImageElement.setWidth(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftImageWidth, 0));
        leftImageElement.setHeight(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftImageHeight, 0));

        final int scaleTypeIndex = typedArray.getInt(R.styleable.LovelyView_leftImageScaleType, -1);
        if (scaleTypeIndex >= 0) {
            leftImageElement.setScaleType(sScaleTypeArray[scaleTypeIndex]);
        }

        leftImageElement.setMarginLeft(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftImageMarginLeft, 0));
        leftImageElement.setMarginRight(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftImageMarginRight, 0));
        leftImageElement.setMarginTop(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftImageMarginTop, 0));
        leftImageElement.setMarginBottom(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftImageMarginBottom, 0));
    }

    /**
     * Parse the right text attr.
     * */
    private void parseRightTextAttr(TypedArray typedArray) {
        rightTextElement.setTextString(typedArray.getString(R.styleable.LovelyView_rightText));
        rightTextElement.setTextColor(typedArray.getColor(R.styleable.LovelyView_rightTextColor, DEFAULT_COLOR));
        rightTextElement.setTextSize(typedArray.getDimensionPixelSize(R.styleable.LovelyView_rightTextSize, DEFAULT_TEXT_SIZE));
        rightTextElement.setMarginLeft(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightTextMarginLeft, 0));
        rightTextElement.setMarginRight(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightTextMarginRight, 0));
        rightTextElement.setMarginTop(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightTextMarginTop, 0));
        rightTextElement.setMarginBottom(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightTextMarginBottom, 0));
    }

    /**
     * Parse the right text attr.
     * */
    private void parseRightTopTextAttr(TypedArray typedArray) {
        rightTopTextElement.setTextString(typedArray.getString(R.styleable.LovelyView_rightTopText));
        rightTopTextElement.setTextColor(typedArray.getColor(R.styleable.LovelyView_rightTopTextColor, DEFAULT_COLOR));
        rightTopTextElement.setTextSize(typedArray.getDimensionPixelSize(R.styleable.LovelyView_rightTopTextSize, DEFAULT_TEXT_SIZE));
        rightTopTextElement.setMarginLeft(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightTopTextMarginLeft, 0));
        rightTopTextElement.setMarginRight(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightTopTextMarginRight, 0));
        rightTopTextElement.setMarginTop(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightTopTextMarginTop, 0));
        rightTopTextElement.setMarginBottom(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightTopTextMarginBottom, 0));
    }

    /**
     * Parse the right text attr.
     * */
    private void parseRightBottomTextAttr(TypedArray typedArray) {
        rightBottomTextElement.setTextString(typedArray.getString(R.styleable.LovelyView_rightBottomText));
        rightBottomTextElement.setTextColor(typedArray.getColor(R.styleable.LovelyView_rightBottomTextColor, DEFAULT_COLOR));
        rightBottomTextElement.setTextSize(typedArray.getDimensionPixelSize(R.styleable.LovelyView_rightBottomTextSize, DEFAULT_TEXT_SIZE));
        rightBottomTextElement.setMarginLeft(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightBottomTextMarginLeft, 0));
        rightBottomTextElement.setMarginRight(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightBottomTextMarginRight, 0));
        rightBottomTextElement.setMarginTop(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightBottomTextMarginTop, 0));
        rightBottomTextElement.setMarginBottom(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_rightBottomTextMarginBottom, 0));
    }

    /**
     * Parse the center text attr.
     * */
    private void parseCenterTextAttr(TypedArray typedArray) {
        centerTextElement.setTextString(typedArray.getString(R.styleable.LovelyView_centerText));
        centerTextElement.setTextColor(typedArray.getColor(R.styleable.LovelyView_centerTextColor, DEFAULT_COLOR));
        centerTextElement.setTextSize(typedArray.getDimensionPixelSize(R.styleable.LovelyView_centerTextSize, DEFAULT_TEXT_SIZE));
    }

    /**
     * Parse the left text attr.
     * */
    private void parseLeftTextAttr(TypedArray typedArray){
        leftTextElement.setTextString(typedArray.getString(R.styleable.LovelyView_leftText));
        leftTextElement.setTextColor(typedArray.getColor(R.styleable.LovelyView_leftTextColor, DEFAULT_COLOR));
        leftTextElement.setTextSize(typedArray.getDimensionPixelSize(R.styleable.LovelyView_leftTextSize, DEFAULT_TEXT_SIZE));
        leftTextElement.setMarginLeft(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftTextMarginLeft, 0));
        leftTextElement.setMarginRight(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftTextMarginRight, 0));
        leftTextElement.setMarginTop(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftTextMarginTop, 0));
        leftTextElement.setMarginBottom(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftTextMarginBottom, 0));
    }

    /**
     * Parse the left top text attr.
     * */
    private void parseLeftTopTextAttr(TypedArray typedArray){
        leftTopTextElement.setTextString(typedArray.getString(R.styleable.LovelyView_leftTopText));
        leftTopTextElement.setTextColor(typedArray.getColor(R.styleable.LovelyView_leftTopTextColor, DEFAULT_COLOR));
        leftTopTextElement.setTextSize(typedArray.getDimensionPixelSize(R.styleable.LovelyView_leftTopTextSize, DEFAULT_TEXT_SIZE));
        leftTopTextElement.setMarginLeft(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftTopTextMarginLeft, 0));
        leftTopTextElement.setMarginRight(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftTopTextMarginRight, 0));
        leftTopTextElement.setMarginTop(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftTopTextMarginTop, 0));
        leftTopTextElement.setMarginBottom(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftTopTextMarginBottom, 0));
    }

    /**
     * Parse the left bottom text attr.
     * */
    private void parseLeftBottomTextAttr(TypedArray typedArray){
        leftBottomTextElement.setTextString(typedArray.getString(R.styleable.LovelyView_leftBottomText));
        leftBottomTextElement.setTextColor(typedArray.getColor(R.styleable.LovelyView_leftBottomTextColor, DEFAULT_COLOR));
        leftBottomTextElement.setTextSize(typedArray.getDimensionPixelSize(R.styleable.LovelyView_leftBottomTextSize, DEFAULT_TEXT_SIZE));
        leftBottomTextElement.setMarginLeft(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftBottomTextMarginLeft, 0));
        leftBottomTextElement.setMarginRight(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftBottomTextMarginRight, 0));
        leftBottomTextElement.setMarginTop(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftBottomTextMarginTop, 0));
        leftBottomTextElement.setMarginBottom(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_leftBottomTextMarginBottom, 0));
    }

    /**
     * Parse the top line attr.
     * */
    private void parseTopLineAttr(TypedArray typedArray){
        topLineElement.setColor(typedArray.getColor(R.styleable.LovelyView_topLineColor, DEFAULT_COLOR));
        topLineElement.setDisplay(typedArray.getBoolean(R.styleable.LovelyView_topLineDisplay, false));
        topLineElement.setHeight(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_topLineHeight, DEFAULT_LINE_HEIGHT));
        topLineElement.setMarginLeft(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_topLineMarginLeft, 0));
        topLineElement.setMarginRight(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_topLineMarginRight, 0));
        topLineElement.setMarginTop(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_topLineMarginTop, 0));
        topLineElement.setMarginBottom(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_topLineMarginBottom, 0));
    }

    /**
     * Parse the bottom line attr.
     * */
    private void parseBottomLineAttr(TypedArray typedArray){
        bottomLineElement.setColor(typedArray.getColor(R.styleable.LovelyView_bottomLineColor, DEFAULT_COLOR));
        bottomLineElement.setDisplay(typedArray.getBoolean(R.styleable.LovelyView_bottomLineDisplay, false));
        bottomLineElement.setHeight(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_bottomLineHeight, DEFAULT_LINE_HEIGHT));
        bottomLineElement.setMarginLeft(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_bottomLineMarginLeft, 0));
        bottomLineElement.setMarginRight(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_bottomLineMarginRight, 0));
        bottomLineElement.setMarginTop(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_bottomLineMarginTop, 0));
        bottomLineElement.setMarginBottom(typedArray.getDimensionPixelOffset(R.styleable.LovelyView_bottomLineMarginBottom, 0));
    }

    /**
     * Init all the view of the elements.
     * */
    private void initLayout(){
        setupImageView(leftImageElement, IDS.ID_LEFT_IMAGE);
        setupImageView(rightImageElement, IDS.ID_RIGHT_IMAGE);

        setupTextView(leftTopTextElement, IDS.ID_LEFT_TOP_TEXT);
        setupTextView(leftTextElement, IDS.ID_LEFT_TEXT);
        setupTextView(leftBottomTextElement, IDS.ID_LEFT_BOTTOM_TEXT);

        setupTextView(centerTextElement, IDS.ID_CENTER_TEXT);

        setupTextView(rightTopTextElement, IDS.ID_RIGHT_TOP_TEXT);
        setupTextView(rightTextElement, IDS.ID_RIGHT_TEXT);
        setupTextView(rightBottomTextElement, IDS.ID_RIGHT_BOTTOM_TEXT);

        setupLineView(topLineElement, true);
        setupLineView(bottomLineElement, false);
    }

    /**
     * Set the attrs of {@link ImageView}
     *
     * @param imageElement The element of left or right image.
     * @param id The id of {@link ImageView},from {@link IDS}.
     * */
    private void setupImageView(ImageElement imageElement, int id){
        if (imageElement == null) {
            return;
        }

        ImageView imageView = imageElement.getImageView();

        int width = imageElement.getWidth() != 0 ? imageElement.getWidth() : LayoutParams.WRAP_CONTENT;
        int height = imageElement.getHeight() != 0 ? imageElement.getHeight() : LayoutParams.WRAP_CONTENT;

        boolean isLeftImage = IDS.ID_LEFT_IMAGE == id;

        LayoutParams layoutParams = new LayoutParams(width, height);
        layoutParams.addRule(isLeftImage ? ALIGN_PARENT_LEFT : ALIGN_PARENT_RIGHT, TRUE);
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        layoutParams.setMargins(imageElement.getMarginLeft(), imageElement.getMarginTop(),
                imageElement.getMarginRight(), imageElement.getMarginBottom());

        if (imageElement.getScaleType() != null) {
            imageView.setScaleType(imageElement.getScaleType());
        }

        imageView.setId(id);
        imageView.setImageDrawable(imageElement.getDrawable());

        addViewInLayout(imageView, -1, layoutParams);
    }

    /**
     * Set the attrs of  {@link TextView}
     *
     * @param textElement The element of left, center or right text.
     * @param id The id of {@link TextView}, from {@link IDS}.
     * */
    private void setupTextView(TextElement textElement, int id){
        if (textElement == null){
            return;
        }

        TextView textView = textElement.getTextView();

        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        layoutParams.setMargins(textElement.getMarginLeft(), textElement.getMarginTop(),
                textElement.getMarginRight(), textElement.getMarginBottom());

        textView.setTextColor(textElement.getTextColor());
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textElement.getTextSize());
        textView.setText(textElement.getTextString());
        textView.setId(id);

        switch (id){
            case IDS.ID_LEFT_TOP_TEXT:
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, TRUE);
                layoutParams.addRule(RelativeLayout.RIGHT_OF, IDS.ID_LEFT_IMAGE);
                break;

            case IDS.ID_LEFT_TEXT:
                layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
                layoutParams.addRule(RelativeLayout.RIGHT_OF, IDS.ID_LEFT_IMAGE);
                break;

            case IDS.ID_LEFT_BOTTOM_TEXT:
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, TRUE);
                layoutParams.addRule(RelativeLayout.RIGHT_OF, IDS.ID_LEFT_IMAGE);
                break;

            case IDS.ID_CENTER_TEXT:
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
                break;

            case IDS.ID_RIGHT_TOP_TEXT:
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, TRUE);
                layoutParams.addRule(RelativeLayout.LEFT_OF, IDS.ID_RIGHT_IMAGE);
                break;

            case IDS.ID_RIGHT_TEXT:
                layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
                layoutParams.addRule(RelativeLayout.LEFT_OF, IDS.ID_RIGHT_IMAGE);
                break;

            case IDS.ID_RIGHT_BOTTOM_TEXT:
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, TRUE);
                layoutParams.addRule(RelativeLayout.LEFT_OF, IDS.ID_RIGHT_IMAGE);
                break;

            default:break;
        }

        addViewInLayout(textView, -1, layoutParams);
    }

    /**
     * Set the attrs of line{@link android.view.View}
     *
     * @param lineElement The element of top or bottom line .
     * @param isTopLine True it is top line, otherwise it is bottom line
     * */
    private void setupLineView(LineElement lineElement, boolean isTopLine){
        if (lineElement == null){
            return;
        }

        View lineView = lineElement.getLineView();

        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, lineElement.getHeight());
        layoutParams.addRule(isTopLine ? RelativeLayout.ALIGN_PARENT_TOP : RelativeLayout.ALIGN_PARENT_BOTTOM, TRUE);
        layoutParams.setMargins(lineElement.getMarginLeft(), lineElement.getMarginTop(),
                lineElement.getMarginRight(), lineElement.getMarginBottom());

        lineView.setBackgroundColor(lineElement.getColor());
        lineView.setVisibility(lineElement.isDisplay() ? VISIBLE : INVISIBLE);

        addViewInLayout(lineView, -1, layoutParams);
    }

    public ImageView getLeftImageView(){
        return leftImageElement.getImageView();
    }

    public ImageView getRightImageView(){
        return rightImageElement.getImageView();
    }

    public TextView getLeftTextView(){
        return leftTextElement.getTextView();
    }

    public TextView getLeftTopTextView(){
        return leftTopTextElement.getTextView();
    }

    public TextView getLeftBottomTextView(){
        return leftBottomTextElement.getTextView();
    }

    public TextView getRightTextView(){
        return rightTextElement.getTextView();
    }

    public TextView getRightTopTextView(){
        return rightTopTextElement.getTextView();
    }

    public TextView getRightBottomTextView(){
        return rightBottomTextElement.getTextView();
    }

    public TextView getCenterTextView(){
        return centerTextElement.getTextView();
    }

    public View getTopLineView(){
        return topLineElement.getLineView();
    }

    public View getBottomLineView(){
        return bottomLineElement.getLineView();
    }
}
