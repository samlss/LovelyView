package com.iigo.library;

import android.view.View;

/**
 * @author SamLeung
 * @e-mail 729717222@qq.com
 * @github https://github.com/samlss
 * @csdn https://blog.csdn.net/Samlss
 * @description The element of the line {@link android.view.View}
 */
public class LineElement extends MarginElement {
    private View lineView;
    /**
     * The default is not to display.
     * */
    private boolean isDisplay = false;
    private int color;
    private int height;

    public LineElement(){

    }

    public View getLineView() {
        return lineView;
    }

    public void setLineView(View lineView) {
        this.lineView = lineView;
    }

    public boolean isDisplay() {
        return isDisplay;
    }

    public void setDisplay(boolean display) {
        isDisplay = display;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
