package tilegame.state;

import tilegame.Game;
import tilegame.entiy.creature.Player;
import tilegame.gfx.Assets;
import java.awt.*;

public class GameState extends State{

    private int pods1 = 300;
    private int boss1 = 500;
    private boolean checkpoint = true;
    private boolean checkpoint2 = true;
    private int width = 1600;
    private int height = 800;
    private int box = 64;
    private Player pleyer;



    public GameState(Game game){
        super(game);
        pleyer = new Player(game, 100,607);
    }

    @Override
    public void tick() {
        pleyer.tick();
        //poruszanie sie platformy
        if(checkpoint){
            if(pods1 <= 500){
                pods1++;
            }else
                checkpoint = false;
        }else {
            if (pods1 >= 300){
                pods1--;
            }else {
                checkpoint = true;
            }
        }
        //poruszanie sie platformy
        if(checkpoint2){
            if(boss1 <= 550){
                boss1++;
            }else
                checkpoint2 = false;
        }else {
            if (boss1 >= 400){
                boss1--;
            }else {
                checkpoint2 = true;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        //rysowanie tla
        g.drawImage(Assets.background, 0, 0, null);
        g.drawImage(Assets.background, 1279, 0, null);
        //rysowanie podloza
        for (int i = 0;i < width;i = i + 64){
            g.drawImage(Assets.ob1, i, height-box, null);
            g.drawImage(Assets.ob4, i, height-2*box, null);
        }

        g.drawImage(Assets.pods_1, pods1, 400, null);
        g.drawImage(Assets.boss, 1000, boss1, null);

        pleyer.render(g);
    }
}
