package org.example;

import javax.swing.*;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.util.HashMap;

public class CalcLayout {

  JFrame jFrame;
  HashMap<String, JComponent> buttons = new HashMap<>();

  CalcLayout(JFrame jFrame){
    this.jFrame = jFrame;
    jFrame.setLayout(new GridBagLayout());
  }

  private GridBagConstraints constraints() {
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.BOTH;
    c.insets = new Insets(0,0,0,0);
    c.ipadx = 40;
    c.ipady = 10;
    c.weightx = 1.0;
    c.weighty = 1.0;
    return c;
  }

  private String text_large(String label) {
    return "<html><font size=40>%s</font></html>"
      .formatted(label);
  }

  public void textfield(String label, int width, int y) {
    GridBagConstraints c = constraints();
    c.gridwidth = 4;
    c.gridx = 0;
    c.gridy = y;
    JTextField textField = new JTextField(width);
    textField.setHorizontalAlignment(JTextField.RIGHT);
    textField.setFont(new Font("SansSerif", Font.PLAIN, 40));
    textField.setText("3.1415");
    buttons.put(label, textField);
    jFrame.add(buttons.get(label),c);
  }

  public void button(String label, int x, int y) {
    GridBagConstraints c = constraints();
    c.gridx = x;
    c.gridy = y;
    buttons.put(label, new JButton(text_large(label)));
    jFrame.add(buttons.get(label),c);
  }
}
