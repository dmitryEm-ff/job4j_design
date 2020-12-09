package ru.job4j.applet;

import java.awt.*;
import java.applet.*;

/*
<applet code="SimpleApplet" width=200 height=60>
</applet>
 */

public class SimpleApplet extends Applet {
    public void paint(Graphics graphics) {
        graphics.drawString("Простейший аплет", 20, 20);
    }
}