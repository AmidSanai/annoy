package com.mamij.annoy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Annoy implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton button;
    JLabel label;
    JLabel triedTimesLabel;
    Random rand = new Random();
    int zeroToHundred;
    int randomNumber1;
    int randomNumber2;
    int triedTimes = 0;
    boolean isNotDone = true;

    public Annoy() {
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Amid\\Desktop\\haha\\Icons\\AnnoyingIcon.jpg");
        frame.setIconImage(icon);
        button = new JButton("Click to click!");
        button.setForeground(Color.cyan);
        button.setBackground(Color.GRAY);
        button.addActionListener(this);
        button.setFocusable(false);

        label = new JLabel("Click the button to win 10000 RIAL", SwingConstants.CENTER);
        label.setForeground(Color.cyan);

        triedTimesLabel = new JLabel(triedTimes + "/50", SwingConstants.CENTER);
        triedTimesLabel.setForeground(Color.cyan);

        panel.setBackground(Color.DARK_GRAY);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        panel.add(triedTimesLabel);

        if (isNotDone) {
            frame.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent me) {
                    triedTimes++;
                    triedTimesLabel.setText(triedTimes + "/50");
                    zeroToHundred = rand.nextInt(101);
                    if (zeroToHundred <= 97 && isNotDone) {
                        randomNumber1 = rand.nextInt(1730);
                        randomNumber2 = rand.nextInt(1000);
                        frame.setLocation(randomNumber1, randomNumber2);
                    } else if (zeroToHundred >= 98 && isNotDone) {
                        panel.setBackground(Color.red);
                        isNotDone = false;
                    }
                }
            });
        }
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(panel, "Center");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Annoying!");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Annoy();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.remove(button);
        panel.remove(triedTimesLabel);
        label.setText("YOU WIN!");
        isNotDone = false;
    }
}
