package methods;

import model.Info;

public class Tabulation extends Method {

    public Tabulation(Info info, boolean time) {
        super(info, time);
    }
    
    @Override
    public void Start() {
        System.out.println("Starting Tabulation...");
        System.out.println("Board Size: " + size + "x" + size + " Steps: " + steps);
        System.out.println("Initial position: " + startX + ", " + startY);
        start = System.currentTimeMillis();
        Met();
        finish = System.currentTimeMillis();
        System.out.println("Tabulation Finished");
        ShowResult();
    }

    @Override
    void Met() {
        if(!IsInside(startX, startY)){
            prob = 0;
            return;
        }
        prob = FindProb(startX, startY, steps);
    }
    
    double FindProb(int X, int Y, int st){
        double[][][] tab = new double[size][size][steps + 1];

        for (int i = 0; i < size; ++i){
            for (int j = 0; j < size; ++j){
                tab[i][j][0] = 1;
            }
        }
        
        for (int s = 1; s <= steps; ++s) {
            for (int x = 0; x < size; ++x) {
                for (int y = 0; y < size; ++y) {
                    double pr = 0.0;
                    
                    for (int i = 0; i < 8; ++i) {
                        int nx = x + moveX[i];
                        int ny = y + moveY[i];
                        
                        if (IsInside(nx, ny)){
                            pr += tab[nx][ny][s - 1] / 8.0;
                        }
                    }
                    tab[x][y][s] = pr;
                }
            }
        }
        return tab[X][Y][steps];
    }
}
