package tilegame.gfx;
import java.awt.image.BufferedImage;


//classa wczytujaca nam wybrana grafike z siatki polaczonych obrazow
public class SpriteSheet {
    public BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }

    public BufferedImage croop(int x, int y, int width, int height){
        return sheet.getSubimage(x, y, width, height);
    }
}
