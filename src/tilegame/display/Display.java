package tilegame.display;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private String title;
    private int width, height;
    private Canvas canvas;

    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame(title);
        //ustalamy wysokosc i szerokosc okna
        frame.setSize(width, height);
        //po zamknieciu okna program zamtrzyma prace wutomatycznie
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ustawiamy oteranie sie okna na srodku ekranu
        frame.setLocationRelativeTo(null);
        //okno w domyslnym trybie jest nie widoczne ustawiamy na widoczne
        frame.setVisible(true);

        canvas = new Canvas();
        //ustalamy rozmiar siatki na ktorej bedziemy rysowac
        canvas.setPreferredSize(new Dimension(width, height));
        //upewniemy sie ze canvas zawsze bedzie mial ten sam rozmiar
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        //czytanie movmentu
        canvas.setFocusable(false);

        //dodajemy cavas do JFrame
        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return  frame;
    }
}
