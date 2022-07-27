package simple_drawing_board;

import java.util.ArrayList;

public class Canvas {
    private ArrayList<String> canvas;
    private final ArrayList<int[]> rectangleCords;
    private final int width;
    private final int height;

    private int[] rectangleCordsInUse;
    StringBuilder transitiveStringBuilder;

    public Canvas(int width, int height) {
        this.height = height;
        this.width = width;
        rectangleCords = new ArrayList<>();
        transitiveStringBuilder = new StringBuilder();
        drawEmptyCanvas();
    }

    public Canvas draw(int x1, int y1, int x2, int y2) {
        if (y1 == y2){
            drawHLine(x1, x2, y1, 'x');
        } else if (x1 == x2) {
            drawVLine(y1, y2, x1);
        } else {
            drawRectangle(x1, y1, x2, y2);
        }
        return this;
    }

    public Canvas fill(int x, int y, char ch) {
        if (isCordInsideARectangle(x, y)){
            for (int index = rectangleCordsInUse[2] + 1; index < rectangleCordsInUse[3]; index++) {
                drawHLine(rectangleCordsInUse[0] + 1,rectangleCordsInUse[1] - 1,index, ch);
            }
        }
        return this;
    }

    public String drawCanvas() {
        StringBuilder canvasInLine = new StringBuilder();

        String aux;

        for (String row:
             canvas) {
             aux = "|" + row + "|\n";
            canvasInLine.append(aux);
        }

        canvasInLine.insert(0, "-".repeat(width + 2) + "\n");
        canvasInLine.append("-".repeat(width + 2));

        return canvasInLine.toString();
    }

    private char[] getCharArray(int index){
        return canvas.get(index).toCharArray();
    }

    private void drawHLine(int x1, int x2, int rowNumber, char ch){
        char[] row = getCharArray(rowNumber);

        for (int index = x1; index <= x2; index++) {
            row[index] = ch;
        }
        saveToCanvas(row, rowNumber);
    }

    private void drawVLine(int y1, int y2, int columnNumber){
        for (int index = y1; index <= y2; index++) {
            char[] rowNumber = getCharArray(index);
            rowNumber[columnNumber] = 'x';
            saveToCanvas(rowNumber, index);
        }
    }

    private void drawRectangle(int x1, int y1, int x2, int y2){
        drawHLine(x1, x2, y1, 'x');
        drawVLine(y1, y2, x1);
        drawHLine(x1, x2, y2, 'x');
        drawVLine(y1, y2, x2);
        recordCoords(x1, x2, y1, y2);
    }

    private boolean isCordInsideARectangle(int xPos, int yPos){
        boolean evaluation = false;
        for (int[] rectangleRange:
             rectangleCords) {
            if (rectangleRange[0] <= xPos && rectangleRange[1] >= xPos &&
                rectangleRange[2] <= yPos && rectangleRange[3] >= yPos){
                evaluation = true;
                rectangleCordsInUse = rectangleRange;
            }
        }
        return evaluation;
    }

    private void recordCoords(int x1, int x2, int y1, int y2){
        int[] coords = new int[4];
        coords[0] = x1;
        coords[1] = x2;
        coords[2] = y1;
        coords[3] = y2;
        rectangleCords.add(coords);
    }

    private void saveToCanvas(char[] row, int yPos){
        transitiveStringBuilder.append(row);
        canvas.remove(yPos);
        canvas.add(yPos, transitiveStringBuilder.toString());
        transitiveStringBuilder.delete(0, width);
    }

    private void drawEmptyCanvas(){
        canvas = new ArrayList<>(height);
        for (int index = 0; index < height; index++) {
            canvas.add(" ".repeat(width));
        }
    }
}
