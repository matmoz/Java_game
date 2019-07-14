package tilegame.entiy.creature;

import tilegame.Game;
import tilegame.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y);
        this.game = game;
    }

    @Override
    public void tick() {
        if (game.getKeyManage().up){
            y -= 3;
        }
        if (game.getKeyManage().down){
            y += 3;
        }
        if (game.getKeyManage().left){
            x -= 3;
        }
        if (game.getKeyManage().right){
            x += 3;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int)x, (int)y,null);
    }
}
