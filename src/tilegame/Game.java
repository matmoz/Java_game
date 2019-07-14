package tilegame;

import java.awt.*;
import java.awt.image.BufferStrategy;

import tilegame.input.*;
import tilegame.state.*;
import tilegame.display.Display;
import tilegame.gfx.Assets;

import javax.net.ssl.KeyManager;


public class Game implements Runnable{

    private Display display;

    public int width, height;
    public String title;

    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    //private BufferedImage background;

    //States tworzymy zakladki gry
    private State gameState;
//    private State memuState;
//    private State settingsState;

    //input
    private KeyManage keyManage;


    public Game(String title, int width, int height){
       this.width = width;
       this.height = height;
       this.title = title;
       keyManage = new KeyManage();
    }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManage);
        Assets.init();

        //memuState = new MenuState();
        gameState = new GameState(this);

        State.setCurrentState(gameState);
    }

    private void tick(){
        keyManage.tick();

        if(State.getCurrentState() != null){
            State.getCurrentState().tick();
        }
    }

    private void render(){
        //tworzymy bufor uplynniajacy wyswietlanie obiektow
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //czyszczenie obrazu przed rysowaniem
        g.clearRect(0, 0, width, height);

        //w tym miejsu zaczynamy rysowanie
        //State sprawdzamy tryb gry
        if(State.getCurrentState() != null){
            State.getCurrentState().render(g);
        }
        //zakonczenie rysowania
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();
        //ustawiamy predkosc wyswietlania na 60 klatek/sekunde
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lasTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        //tworzymy petle gry ktora bedzie odswierzac wszytsko
        while (running){
            now = System.nanoTime();
            delta += (now - lasTime) / timePerTick;
            timer += now - lasTime;
            lasTime = now;

            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            //mozemy wyswietlic nasze fps
            if (timer >= 1000000000){
                //System.out.println("Fps: "+ ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public KeyManage getKeyManage(){
        return keyManage;
    }

    //metoda startujaca gre
    public synchronized void start(){
        if (running)return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    //metoda stopujaca gre
    public synchronized void stop(){
        if (!running)return;
        running = false;
        try {
            thread.join();
        }catch (InterruptedException e){
         e.printStackTrace();
        }
    }
}
