package model;

public class Info {
    
    private final int size;
    private final int steps;
    private final int startX;
    private final int startY;

    public Info(int size, int steps){
        this.size = size;
        this.steps = steps;
        this.startX = 0;
        this.startY = 0;
    }
    
    public Info(int size, int steps, int startX, int startY){
        this.size = size;
        this.steps = steps;
        this.startX = startX;
        this.startY = startY;
    }

    public int getSize() {
        return size;
    }

    public int getSteps() {
        return steps;
    }
    
    public int getStartX() {
        return startX;
    }
    
    public int getStartY() {
        return startY;
    }
}
