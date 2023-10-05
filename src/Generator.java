import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Generator {
    private static final short shadowOffset = 3;

    public static void generateMeme(GeneratorSettings gs){
        BufferedImage img;

        try {
            img = ImageIO.read(new File(gs.getFileName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Graphics g = img.getGraphics();
        try {
            g.setFont(Font.createFont(Font.PLAIN, new File("Fonts/Impact_Regular.ttf")).deriveFont(Font.PLAIN, gs.getFontSize()));
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        Point p = calculateTextStartPoint(img, g, gs);

        if(gs.getShadow()){
            g.setColor(Color.BLACK);
            g.drawString(gs.getMemeText(), p.x + shadowOffset, p.y + shadowOffset);
        }

        g.setColor(Color.WHITE);
        g.drawString(gs.getMemeText(), p.x, p.y);
        g.dispose();

        try {
            ImageIO.write(img, gs.getFileExtension(), new File("meme-" + gs.getFileName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Point calculateTextStartPoint(BufferedImage img, Graphics g, GeneratorSettings gs){
        int x = img.getWidth() / 2 - (g.getFontMetrics().stringWidth(gs.getMemeText()) / 2);
        int y = 0;
        int textHeight = (int)(g.getFontMetrics(g.getFont()).getStringBounds(gs.getMemeText(), g).getMaxY());

        if(gs.getTextPosition().equals(GeneratorSettings.Position.TOP)){
            y = textHeight * 3 + (int) (img.getHeight() * .05);
        } else if(gs.getTextPosition().equals(GeneratorSettings.Position.CENTER)){
            y = (textHeight / 2) + (img.getHeight() / 2);
        } else if(gs.getTextPosition().equals(GeneratorSettings.Position.BOTTOM)){
            y = img.getHeight() - textHeight - (int) (img.getHeight() * .05);
        }

        return new Point(x, y);
    }
}
