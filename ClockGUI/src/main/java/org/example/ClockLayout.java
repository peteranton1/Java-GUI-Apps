package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ClockLayout {

  JFrame jFrame;
  java.util.List<ClockJLabel> clockJLabels = new ArrayList<>();

  ClockLayout(JFrame jFrame){
    this.jFrame = jFrame;
    jFrame.setLayout(new GridBagLayout());
  }

  public void setLabel(int size, int x, int y, String pattern){
    ClockJLabel clockJLabel = new ClockJLabel(size, pattern);
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.BOTH;
    c.insets = new Insets(0,0,0,0);
    c.ipadx = 40;
    c.ipady = 10;
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.gridx = x;
    c.gridy = y;
    jFrame.add(clockJLabel.getjLabel(),c);
    clockJLabels.add(clockJLabel);
  }

  void update(){
    Date date = Calendar.getInstance().getTime();
    for(ClockJLabel clockJLabel: clockJLabels){
      clockJLabel.update(date);
    }
  }

}

