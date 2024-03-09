package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class SnakePanel
  extends JPanel implements ActionListener {

  static final int SCREEN_WIDTH = 600;
  static final int SCREEN_HEIGHT = 600;
  static final int UNIT_SIZE = 50;
  static final int GAME_UNITS =
    (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
  static final int DELAY = 175;
  final int[] x = new int[GAME_UNITS];
  final int[] y = new int[GAME_UNITS];
  int bodyParts;
  int applesEaten;
  int gamesPlayed;
  int appleX;
  int appleY;
  char direction = 'R';
  boolean running = false;
  Timer timer;
  Random random;
  Font gameOverFont =
    new Font("Chilanka", Font.PLAIN, 75);
  Font startGameFont =
    new Font("Chilanka", Font.PLAIN, 25);
  Font scoreFont =
    new Font("Chilanka", Font.PLAIN, 40);

  SnakePanel() {
    random = new Random();
    this.setPreferredSize(
      new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    this.setBackground(Color.black);
    this.setFocusable(true);
    this.addKeyListener(new MyKeyAdapter());
    timer = new Timer(DELAY, this);
    gamesPlayed=0;
    startGame();
  }

  private static void drawGrid(Graphics g) {
    for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
      g.drawLine(i * UNIT_SIZE, 0,
        i * UNIT_SIZE, SCREEN_HEIGHT);
      g.drawLine(0, i * UNIT_SIZE,
        SCREEN_WIDTH, i * UNIT_SIZE);
    }
  }

  public void startGame() {
    running = true;
    initScores();
    timer.restart();
  }

  private void initScores() {
    applesEaten = 0;
    bodyParts = 5;
    direction = 'R';
    for (int i = 0; i < x.length; i++) {
      x[i] = 0;
      y[i] = 0;
    }
    newApple();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    draw(g);
  }

  public void draw(Graphics g) {
    drawGrid(g);
    drawApple(g);
    drawSnake(g);
    writeScore(g);
    if (!running) {
      writeGameOver(g);
      writeHelp(g);
    }
  }

  private void drawApple(Graphics g) {
    g.setColor(Color.red);
    g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
  }

  private void drawSnake(Graphics g) {
    for (int i = 0; i < bodyParts; i++) {
      Color snakeColor = new Color(45, 100, 0);
      g.setColor(snakeColor);
      g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
    }
  }

  public void newApple() {
    appleX = random
      .nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
    appleY = random
      .nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;

  }

  public void move() {

    for (int i = bodyParts; i > 0; i--) {
      x[i] = x[i - 1];
      y[i] = y[i - 1];
    }
    switch (direction) {
      case 'U' -> y[0] -= UNIT_SIZE;
      case 'D' -> y[0] += UNIT_SIZE;
      case 'L' -> x[0] -= UNIT_SIZE;
      case 'R' -> x[0] += UNIT_SIZE;
    }
  }

  public void checkApple() {
    if ((x[0] == appleX) && (y[0] == appleY)) {
      bodyParts++;
      applesEaten++;
      newApple();
    }
  }

  public void checkCollisions() {
    for (int i = bodyParts; i > 0 && running; i--) {
      // check if head touches body
      if ((x[0] == x[i]) && (y[0] == y[i])) {
        running = false;
      }
      // check if head touches border LEFT
      if (x[0] < 0) {
        running = false;
      }
      // check if head touches border RIGHT
      if (x[0] > SCREEN_WIDTH) {
        running = false;
      }
      // check if head touches border TOP
      if (y[0] < 0) {
        running = false;
      }
      // check if head touches border BOTTOM
      if (y[0] > SCREEN_HEIGHT) {
        running = false;
      }
    }
    if(!running){
      gamesPlayed++;
      timer.stop();
    }
  }

  public void writeGameOver(Graphics g) {
    String message = "Game Over";
    g.setColor(Color.red);
    g.setFont(gameOverFont);
    FontMetrics metrics = getFontMetrics(g.getFont());
    int x = (SCREEN_WIDTH -
      metrics.stringWidth(message)) / 2;
    int y = (SCREEN_HEIGHT) / 2;
    g.drawString(message, x, y);
  }

  public void writeHelp(Graphics g) {
    String message = "Press SPACE To Start Game";
    g.setColor(Color.red);
    g.setFont(startGameFont);
    FontMetrics metrics = getFontMetrics(g.getFont());
    int x = (SCREEN_WIDTH -
      metrics.stringWidth(message)) / 2;
    int delta = g.getFont().getSize();
    int y = (SCREEN_HEIGHT) / 2 + delta;
    g.drawString(message, x, y);
  }

  private void writeScore(Graphics g) {
    int score = applesEaten;
    String message = "Score : " + score + ", Tries: " + gamesPlayed;
    g.setColor(Color.red);
    g.setFont(scoreFont);
    FontMetrics metrics = getFontMetrics(g.getFont());
    int x = (SCREEN_WIDTH -
      metrics.stringWidth(message)) / 2;
    int y = g.getFont().getSize();
    g.drawString(message, x, y);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (running) {
      move();
      checkApple();
      checkCollisions();
    }
    repaint();
  }

  public class MyKeyAdapter extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
      switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
          if (direction != 'R') {
            direction = 'L';
          }
          break;
        case KeyEvent.VK_RIGHT:
          if (direction != 'L') {
            direction = 'R';
          }
          break;
        case KeyEvent.VK_UP:
          if (direction != 'D') {
            direction = 'U';
          }
          break;
        case KeyEvent.VK_DOWN:
          if (direction != 'U') {
            direction = 'D';
          }
          break;
        case KeyEvent.VK_SPACE:
          startGame();
          break;
      }
    }
  }
}
