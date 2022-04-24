import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyOperations implements KeyListener {

    private Observer observer;

    public KeyOperations(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                observer.linesBackward();
                break;
            case KeyEvent.VK_DOWN:
                observer.linesForward();
                break;
            case KeyEvent.VK_RIGHT:
                observer.linesLeft();
                break;
            case KeyEvent.VK_LEFT:
                observer.linesRight();
                break;
            case KeyEvent.VK_U:
                observer.linesDown();
                break;
            case KeyEvent.VK_D:
                observer.linesUp();
                break;
            case KeyEvent.VK_I:
                observer.zoomIn();
                break;
            case KeyEvent.VK_O:
                observer.zoomOut();
                break;
            case KeyEvent.VK_N:
                observer.turnRightZ();
                break;
            case KeyEvent.VK_M:
                observer.turnLeftZ();
                break;
            case KeyEvent.VK_R:
                observer.turnLeftY();
                break;
            case KeyEvent.VK_L:
                observer.turnRightY();
                break;
            case KeyEvent.VK_F:
                observer.turnUpX();
                break;
            case KeyEvent.VK_B:
                observer.turnDownX();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
