package org.example;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockJLabel {

  SimpleDateFormat simpleDateFormat;
  JLabel jLabel;

  ClockJLabel(int size, String pattern) {
    simpleDateFormat = new SimpleDateFormat(pattern);
    jLabel = new JLabel();
    jLabel.setFont(new Font("SansSerif", Font.PLAIN, size));
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
