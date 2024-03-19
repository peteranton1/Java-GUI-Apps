package org.example;

import javax.swing.*;

public class CalcFrame extends JFrame {

  CalcLayout calcLayout;

  CalcFrame() {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("My Calc Program");
    this.setSize(440, 350);

    calcLayout = new CalcLayout(this);

    int y = 0;
    calcLayout.textfield("value", 40, y);

    calcLayout.button("1", 0, y + 1);
    calcLayout.button("2", 1, y + 1);
    calcLayout.button("3", 2, y + 1);
    calcLayout.button("+", 3, y + 1);

    calcLayout.button("4", 0, y + 2);
    calcLayout.button("5", 1, y + 2);
    calcLayout.button("6", 2, y + 2);
    calcLayout.button("-", 3, y + 2);

    calcLayout.button("7", 0, y + 3);
    calcLayout.button("8", 1, y + 3);
    calcLayout.button("9", 2, y + 3);
    calcLayout.button("*", 3, y + 3);

    calcLayout.button("0", 0, y + 4);
    calcLayout.button(".", 1, y + 4);
    calcLayout.button("CE", 2, y + 4);
    calcLayout.button("/", 3, y + 4);

    calcLayout.button("Bin", 0, y + 5);
    calcLayout.button("Hex", 1, y + 5);
    calcLayout.button("Dec", 2, y + 5);
    calcLayout.button("=", 3, y + 5);

    this.setVisible(true);
  }
}
