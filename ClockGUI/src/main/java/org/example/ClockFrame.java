package org.example;

import javax.swing.*;
import java.awt.*;

public class ClockFrame extends JFrame {

  ClockLayout clockLayout;

  ClockFrame() {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("My Clock Program");
    this.setSize(440, 350);

    clockLayout = new ClockLayout(this);

    clockLayout.setLabel(80, 0, 0, "HH:mm:ss");
    clockLayout.setLabel(80, 0, 1, "EEEEE");
    clockLayout.setLabel(50, 0, 2, "dd MMMMM yyyy");

    this.setVisible(true);

    setTime();
  }

  public void setTime() {
    while (true) {
      clockLayout.update();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // Do nothing
      }
    }
  }
}

