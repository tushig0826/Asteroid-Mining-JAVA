package src.AsteroidMining;
import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
    protected static final String game = null;
    protected static JFrame frame;

    public Window(int width, int height, String title, Game game){
        frame = new JFrame(title);
        setFrame(frame,width, height);

        frame.add(game);
        frame.setVisible(true);
        frame.setFocusable(true);
        game.start();

    }


    public void setFrame(JFrame frame, int width, int height) {
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }


}
