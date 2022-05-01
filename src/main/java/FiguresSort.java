import java.util.Comparator;

public class FiguresSort implements Comparator<Figure> {

    @Override
    public int compare(Figure figure1, Figure figure2) {
        return (int) (-figure1.getDistance() + figure2.getDistance());
    }
}
