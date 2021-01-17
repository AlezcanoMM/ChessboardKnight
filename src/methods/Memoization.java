package methods;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Info;

public class Memoization extends Method {

    private final Map<List<Integer>, Double> table = new HashMap<>();
    
    public Memoization(Info info, boolean time) {
        super(info, time);
    }

    @Override
    public void Start() {
        System.out.println("Starting Memoization...");
        System.out.println("Board Size: " + size + "x" + size + " Steps: " + steps);
        System.out.println("Initial position: " + startX + ", " + startY);
        start = System.currentTimeMillis();
        Met();
        finish = System.currentTimeMillis();
        System.out.println("Memoization Finished");
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

/*
fp(x,y,s) = 0       x < 0 || y < 0 || x >= size || y >= size
            1       s == 0
            fp(x+moveX[0],y+moveY[0],s-1)/8 + ... + fp(x+moveX[7],y+moveY[7],s-1)/8
*/
    double FindProb(int X, int Y, int st){
        if(table.containsKey(Arrays.asList(X, Y, st))){
            return table.get(Arrays.asList(X, Y, st));
        }
        if(!IsInside(X, Y)){
            table.put(Arrays.asList(X, Y, st), 0.0);
            return 0.0;
        }
        if(st == 0){
            table.put(Arrays.asList(X, Y, st), 1.0);
            return 1.0;
        }
        double pr = 0.0;
        for(int i = 0; i < 8; i++){
            pr += FindProb(X + moveX[i], Y + moveY[i], st - 1) / 8.0;
        }
        table.put(Arrays.asList(X, Y, st), pr);
        return pr;
    }
}
