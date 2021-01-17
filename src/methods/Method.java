package methods;

import model.Info;

public abstract class Method {
    protected final int size;
    protected final int steps;
    protected int startX;
    protected int startY;
    
    protected final boolean time;
    
    protected long start = 0;
    protected long finish = 0;
    
    protected int moveX[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
    protected int moveY[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    
    protected double prob;

    public Method(Info info, boolean time) {
        this.size = info.getSize();
        this.steps = info.getSteps();
        this.startX = info.getStartX();
        this.startY = info.getStartY();
        this.time = time;
    }
    
    public abstract void Start();
    
    abstract void Met();
    
    protected void ShowResult(){
        System.out.println("The probability is " + prob);
        if(time){
            System.out.println("Time = " + (double)(finish - start)/1000 + " seconds");
        }
        System.out.println("");
    }
    
    protected boolean IsInside(int x, int y){
        return (x >= 0 && x < size && y >= 0 && y < size);
    }
    
    public double GetProb(){
        return prob;
    }
}
