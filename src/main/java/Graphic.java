import javax.swing.*;
import java.awt.*;

public class Graphic extends JPanel {

    private transient Observer observer;

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1000, 700);
        observer.paint(g);
        g.setColor(Color.white);
        g.fillRect(1001, 1, 200, 699);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 25));
        g.drawString("Legenda:", 1010, 30);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        g.drawString("Poruszać się strzałkami", 1010, 50);
        g.drawString("Góra: U", 1010, 70);
        g.drawString("Dół: D", 1010, 90);
        g.drawString("Pochylić do przodu: F", 1010, 110);
        g.drawString("Pochylić do tyłu: B", 1010, 130);
        g.drawString("Obrócić w prawo: R", 1010, 150);
        g.drawString("Obrócić w lewo: L", 1010, 170);
        g.drawString("Przekręcić w prawo: M", 1010, 190);
        g.drawString("Przekręcić w lewo: N", 1010, 210);
        repaint();
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }
}
