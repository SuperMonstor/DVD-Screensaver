/*
    Program to replicate the DVD screensaver
    Sudarshan S
    reqd files: dvd2.png
 */

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame obj = new JFrame();
        moveLogo logo = new moveLogo();
        obj.setBounds(10, 10, 800, 600);
        obj.setTitle("DVD Logo Screensaver");
        obj.setResizable(false);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(logo);
        obj.setVisible(true);
    }
}
