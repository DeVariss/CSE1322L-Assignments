package assignment5;

import javax.swing.*;
import java.awt.*;

public class dnaFrame extends JFrame {
    public dnaFrame() {
        this.setTitle("DNA Lab");
        this.setVisible(true);
        this.setSize(600, 600);
        ImageIcon iconImage = new ImageIcon("src\\greg.png");
        this.setIconImage(iconImage.getImage());
        this.setBackground(
                new Color(175, 5, 241));
    }
}