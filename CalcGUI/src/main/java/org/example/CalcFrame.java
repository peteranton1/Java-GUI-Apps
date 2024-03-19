package org.example;

import javax.swing.*;

public class CalcFrame extends JFrame {

  CalcLayout calcLayout;

  CalcFrame() {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("My Calc Program");
    this.setSize(440, 350);

    calcLayout = new CalcLayout(this);

    calcLayout.setLabel(80, 0, 0, "HH:mm:ss");
    calcLayout.setLabel(80, 0, 1, "EEEEE");
    calcLayout.setLabel(50, 0, 2, "dd MMMMM yyyy");

    this.setVisible(true);

    setTime();
  }

  public void setTime() {
    while (true) {
      calcLayout.update();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // Do nothing
      }
    }
  }
}
