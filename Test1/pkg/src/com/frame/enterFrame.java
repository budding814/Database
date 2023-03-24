package com.frame;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.data.Constant.*;
public class enterFrame extends Frame implements Runnable{
    private static int menuIndex;
    public static int WINDOW_State;
    private void newWindow(){
        WINDOW_State=STATE_CONTENT;
    }

    private void initState(){
        WINDOW_State=STATE_MAIN;
    }

    public enterFrame(){
        initFrame();
        initEventLister();
        new Thread(this).start();
    }
    private void initFrame(){
        setTitle(WINDOW_TITLE);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setResizable(false);
        setLocation(FRAME_X,FRAME_Y);
        setVisible(true);
        repaint();
    }
    private void initEventLister(){
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                int KeyCode=e.getKeyCode();
                switch(WINDOW_State){
                    case STATE_MAIN:
                        keyEventmain(KeyCode);
                }
            }
        });
    }
    private void keyEventmain(int keyCode){
        switch(keyCode){
            case KeyEvent.VK_UP :
                menuIndex--;
                if(menuIndex<0){
                    menuIndex=STATE.length-1;
                }
                break;
            case KeyEvent.VK_DOWN:
                menuIndex++;
                if(menuIndex>STATE.length-1){
                    menuIndex=0;
                }
                break;
            case KeyEvent.VK_ENTER:
                newWindow();
                break;
        }
    }



    @Override
    public void update(Graphics g){
        g.setFont(All_FONT);
        switch (WINDOW_State){
            case STATE_MAIN :
                drawMain(g);
                break;
            case STATE_CONTENT:
                drawContent(g);
                break;
            case STATE_AUTHOR:
                drawAuthor(g);
                break;
        }
    }

    private void drawMain(Graphics g){
        g.setColor(Color.PINK);
        g.fillRect(0,0,FRAME_WIDTH,FRAME_HEIGHT);


        final int STR_WIDTH=100;//菜单宽度
        int x =FRAME_WIDTH-STR_WIDTH>>1;
        int y=FRAME_HEIGHT/3;
        final int DIS=100;
        for(int i=0;i<STATE.length;i++){
            if(i==menuIndex){
                g.setColor(Color.CYAN);
            }else{
                g.setColor(Color.WHITE);
            }
            g.drawString(STATE[i],x,y+DIS*i);
        }
    }
    private void drawContent(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(0,0,FRAME_WIDTH,FRAME_HEIGHT);


        final int STR_WIDTH=200;//菜单宽度
        int x =FRAME_WIDTH-STR_WIDTH>>1;
        int y=FRAME_HEIGHT/2;
        final int DIS=40;
        g.setColor(Color.WHITE);
        for(int i=0;i<STATE_Content.length;i++){
            g.drawString(STATE_Content[i],x,y+DIS*i);
        }
    }

    private void drawAuthor(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(0,0,FRAME_WIDTH,FRAME_HEIGHT);

        final int STR_WIDTH=200;//菜单宽度
        int x =FRAME_WIDTH-STR_WIDTH>>1;
        int y=FRAME_HEIGHT/2;
        final int DIS=50;
        g.setColor(Color.WHITE);
        for(int i=0;i<STATE_Content.length;i++){
            g.drawString(STATE_Content[i],x,y+DIS*i);
        }
    }
    @Override
    public void run(){
        //控制不断刷新
        while(true){
            repaint();
            try{
                Thread.sleep(REPAINT_INTERVAL);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
