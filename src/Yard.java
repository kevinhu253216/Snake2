import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Yard extends Frame {

    private static final int ROWS = 50;
    private static final int COLS = 50;
    public static final int BLOCK_SIZES = 20;
    Image offScreenImage = null;
    Snake s =new Snake();

    public static void main(String[] args){
        new Yard().launchFrame();


    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.gray);
        g.fillRect(0, 0, COLS * BLOCK_SIZES, ROWS * BLOCK_SIZES);
        g.setColor(Color.DARK_GRAY);

        for(int i=0; i<ROWS-1; i++){
            g.drawLine(0, BLOCK_SIZES * i, COLS * BLOCK_SIZES, BLOCK_SIZES * i );
        }

        for(int i=0; i<COLS-1; i++){
            g.drawLine( BLOCK_SIZES * i, 0, BLOCK_SIZES*i, BLOCK_SIZES * ROWS);
        }
        s.draw(g);
    }

    public void launchFrame(){
        this.setSize(COLS * BLOCK_SIZES, ROWS * BLOCK_SIZES);
        this.setLocation(300 ,20);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }


}
