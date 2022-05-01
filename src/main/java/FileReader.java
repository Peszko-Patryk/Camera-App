import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    private ArrayList<Line> lines;

    public FileReader(String path) {
        lines = new ArrayList<>();
        readFile(path);
    }

    public void readFile(String path) {
        File file = new File(path);
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                extractDataFromLine(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can not find file: " + path);
        }
    }

    private void extractDataFromLine(String nextLine) {
        String[] parts = nextLine.split(" ");
        Point a = new Point(Float.parseFloat(parts[0]), Float.parseFloat(parts[1]), Float.parseFloat(parts[2]));
        Point b = new Point(Float.parseFloat(parts[3]), Float.parseFloat(parts[4]), Float.parseFloat(parts[5]));
        lines.add(new Line(a, b));
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public ArrayList<Figure> getFigures() {
        ArrayList<Figure> figures = new ArrayList<>();
        for (int i = 0; i < lines.size() - 1; i += 4) {
            figures.add(new Figure(lines.subList(i, i + 4)));
        }
        return figures;
    }
}
