package tilegame.gfx;

import java.awt.image.BufferedImage;
//classa z polozeniem obiektow na siatce
public class Assets {

    public static BufferedImage ob1, ob2, ob3, ob4, ob5, ob6, ob7, ob8, ob9, ob10, ob11, ob12, ob13, ob14, ob15, ob16, ob17, ob18, ob19, ob20, ob21, ob22;
    public static BufferedImage pods_1;
    public static BufferedImage background;
    public static BufferedImage player;
    public static BufferedImage boss;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/pack.png"));
        ob1 = sheet.croop(0,0,64,64);
        ob2 = sheet.croop(64,0,64,64);

        ob3 = sheet.croop(0,64,64,64);
        ob4 = sheet.croop(64,64,64,64);

        ob5 = sheet.croop(0,64*2,64,64);
        ob6 = sheet.croop(64,64*2,64,64);

        ob7 = sheet.croop(0,64*3,64,64);
        ob8 = sheet.croop(64,64*3,64,64);

        ob9 = sheet.croop(0,64*4,64,64);
        ob10 = sheet.croop(64,256,64,32);
        ob11 = sheet.croop(64,288,64,32);

        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/pods_1.png"));

        pods_1 = sheet2.croop(0,0,210,58);

        SpriteSheet sheet_background = new SpriteSheet(ImageLoader.loadImage("/textures/background.png"));

        background = sheet_background.croop(0,0,1280,856);

        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));

        player = sheet3.croop(0,0,70,70);

        SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/dawid.png"));

        boss = sheet4.croop(0,0,100,100);
    }
}
