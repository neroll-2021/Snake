package main.constant;

/**
 * 程序中用到的常量
 * @author Neroll
 * @version 0.1.0 2022-05-08
 */
public class Constants {

    public static final int NODE_LENGTH = 25; // 一个格子的长度

    public static final int WINDOW_WIDTH = 900; // 游戏窗口的宽度

    public static final int WINDOW_HEIGHT = 600; // 游戏窗口的高度

    public static final int GAME_WIDTH = 600; // 游戏画面的宽度

    public static final int GAME_HEIGHT = 600; // 游戏画面的高度

    public static final int INITIAL_POS_X = 10; // 蛇头的起始X坐标

    public static final int INITIAL_POS_Y = 18; // 蛇头的起始Y坐标

    public static final int INITIAL_LENGTH = 3; // 蛇的起始长度

    public static final int INIT_ROUND_INTERVAL = 500; // 开始时游戏每帧的间隔时间，单位为毫秒
    public static final int SLOW_ROUND_INTERVAL = 450; // 蛇的运动速度加快，下同
    public static final int NORM_ROUND_INTERVAL = 400;
    public static final int FASTER_ROUND_INTERVAL = 350;
    public static final int FAST_ROUND_INTERVAL = 300;

    public static final int INIT_SCORE = 60; // 当分数超过该值时，蛇的速度加快，即帧的间隔变短，下同
    public static final int SLOW_SCORE = 150;
    public static final int NORM_SCORE = 250;
    public static final int FAST_SCORE = 390;

    public static final int GAME_OVER_X = 6; // 游戏结束文字的X坐标
    public static final int GAME_OVER_Y = 8; // 游戏结束文字的Y坐标

    public static final int SCORE_INCREMENT = 10; // 吃到食物时分数的增加量
}
