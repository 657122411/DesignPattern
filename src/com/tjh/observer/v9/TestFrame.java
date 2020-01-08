package com.tjh.observer.v9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame extends Frame {
    public void launch() {
        Button b = new Button("press me");
        b.addActionListener(new MyActionListener());
        b.addActionListener(new MyActionListener2());
        this.add(b);
        this.pack();
        //this.addWindowListener((WindowAdapter) {System.exit(0)});
        this.setLocation(400, 400);
        this.setVisible(true);
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button1 pressed!");
        }
    }

    private class MyActionListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button2 pressed!");
        }
    }

    public static void main(String[] args) {
        new TestFrame().launch();
    }
}
