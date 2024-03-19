package org.example;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalcJLabel {

  SimpleDateFormat simpleDateFormat;
  JLabel jLabel;

  CalcJLabel(int size, String pattern) {
    simpleDateFormat = new SimpleDateFormat(pattern);
    jLabel = new JLabel();
    jLabel.setFont(new Font("Verdena", Font.PLAIN, size));
    jLabel.setForeground(new Color(0x00FF00));
    jLabel.setBackground(Color.blue);
    jLabel.setOpaque(true);
  }

  void update(Date date) {
    jLabel.setText(simpleDateFormat.format(date));
  }

  JLabel getjLabel() {
    return jLabel;
  }
}
