/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonspritemap;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Ngoc Bich
 */
public class PokemonSpriteMap {
   private static final int col=2;
   private static final int row=2;
   public static void join(String inputPath, String outputPath) throws IOException{
       File directory = new File(inputPath);//mo thu muc, tham chieu directory giu thu muc
        File[] files = directory.listFiles();//lay tap tin trong thu muc

        //doc 1 sprite
        BufferedImage sprite = ImageIO.read(files[0]);//lay 1 hinh anh dai dien de lay kich thuoc
        //kt cuar 1 sprite
        int width = sprite.getWidth() * files.length;
        int height = sprite.getHeight();

        //tao moi sprietmap la 1 tam anh                            //he mau
        BufferedImage spritemap = new BufferedImage(width, height*row, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = spritemap.createGraphics();//ve la spritemap

        int x = sprite.getWidth();//vi tri hoanh do ve sprite tiep theo
        int y=sprite.getHeight();
        int v=0;
        
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                sprite=ImageIO.read(files[v]);
                g2d.drawImage(sprite,null,x*j,y*i);
                v++;
 
            }
            
        }
  
        ImageIO.write(spritemap, "png", new File(outputPath));//lay hinh ra
    }                            //dinh dang  //duong dan muon luu
   
    public static void main(String[] args) {
         try {
            PokemonSpriteMap.join("F:\\Hoc tap\\Lap trinh\\java\\PokemonSpriteMap\\pokemon", "F:\\Hoc tap\\Lap trinh\\java\\PokemonSpriteMap\\pokemonsprite");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
