package com.data;

import java.awt.*;

public class Constant {
    public static final String WINDOW_TITLE="窗口window";
    public static final int FRAME_WIDTH=900;
    public static final int FRAME_HEIGHT=700;
    public static final int FRAME_X=1920-FRAME_WIDTH>>1;
    public static final int FRAME_Y=1080-FRAME_HEIGHT>>1;

    public static final int STATE_MAIN=0;//主窗口
    public static final int STATE_CONTENT=1;//
    public static final int STATE_AUTHOR=2;
    public static final String[] STATE={
            "内容",
            "作者"
    };
    public static final String[] STATE_Content={
            "java 窗口制作",
            "刘锦鹏"
    };
    //字体
    public static final Font All_FONT=new Font("华文彩云",Font.BOLD,30);
    public static final int REPAINT_INTERVAL=100;

}
