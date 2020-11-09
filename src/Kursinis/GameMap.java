package Kursinis;

public class GameMap {

    private int model[][] = new int[][]{
            {7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
            {7, 0, 1, 0, 1, 0, 1, 0, 1, 7},
            {7, 1, 0, 1, 0, 1, 0, 1, 0, 7},
            {7, 0, 1, 0, 1, 0, 1, 0, 1, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7,-1, 0,-1, 0,-1, 0,-1, 0, 7},
            {7, 0,-1, 0,-1, 0,-1, 0,-1, 7},
            {7,-1, 0,-1, 0,-1, 0,-1, 0, 7},
            {7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
    };

    //FOR TESTING Game OVER
    /* private int model[][] = new int[][]{
            {7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 1, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 1, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, -1, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {7, 0, 0, 0, 0, 0, -1, 0, 0, 7},
            {7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
    }; */


    public void draw(boolean turn) {

        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                System.out.print("   ");
            } else {
                System.out.printf("%3d", i);
            }
        }
        System.out.println("\n" + "     ----------------------");
        for (int i = 1; i < model.length-1; i++) {
            if (turn) {
                System.out.printf("%2d", i);
            } else {
                System.out.printf("%2d", model.length - i-1);
            }
            System.out.print("|");
            for (int j = 1; j < model.length-1; j++) {
                System.out.printf("%3d", model[i][j]);
            }
            System.out.println();
        }
    }

    public boolean isValid(int a, int b, boolean turn) {
        if (turn && (model[a][b] == 1 || model[a][b] == 2)) {
            return true;
        }
        if (!turn && (model[a][b] == -1 || model[a][b] == -2)) {
            return true;
        }
        return false;
    }

    public String isHit(int key0, int key1, boolean turn) {
        if (turn) {
            if (model[key0 + 1][key1 - 1] == -1 && model[key0 + 2][key1 - 2] == 0) {
                return "HitL";
            }
            if (model[key0 + 1][key1 + 1] == -1 && model[key0 + 2][key1 + 2] == 0) {
                return "HitR";
            }
        }
        if (!turn) {
            if (model[key0 - 1][key1 - 1] == 1 && model[key0 - 2][key1 - 2] == 0) {
                return "HitL";
            }
            if (model[key0 - 1][key1 + 1] == 1 && model[key0 - 2][key1 + 2] == 0) {
                return "HitR";
            }
        }
        return "";
    }

    public boolean checkLeft(int key0, int key1, boolean turn) {
        return model[key0 + 1][key1 - 1] == 0 && turn || (!turn && model[key0 - 1][key1 - 1] == 0);
    }

    public boolean checkRight(int key0, int key1, boolean turn) {
        return !turn && (model[key0 - 1][key1 + 1] == 0);
    }

    public void moveEnemyMap(int key0, int key1, char t) {
        if (t == 'l') {
            model[key0 - 1][key1 - 1] = -1;
        } else {
            model[key0 - 1][key1 + 1] = -1;
        }

    }

    public void moveFriendlyMap(int key0, int key1, char t) {
        if (t == 'l') {
            model[key0 + 1][key1 - 1] = 1;
        } else {
            model[key0 + 1][key1 + 1] = 1;
        }
    }

    public void setNone(int key0, int key1) {
        model[key0][key1] = 0;
    }

    public boolean checkIsHittableLeft(int key0, int key1, boolean turn)
    {
        if (turn){
            return (model[key0 + 1][key1 - 1] == -1 && model[key0 + 2][key1 - 2] == 0);
        }
        else{

            return model[key0 - 1][key1 - 1] == 1 && model[key0 - 2][key1 - 2] == 0;
        }
    }
    public boolean checkIsHittableRight(int key0, int key1, boolean turn) {
        if (turn){
            return (model[key0 + 1][key1 + 1] == -1 && model[key0 + 2][key1 + 2] == 0);
        }
        else{
            return (model[key0 - 1][key1 + 1] == 1 && model[key0 - 2][key1 + 2] == 0);
        }
    }


    public void hitFriendly(int key0, int key1, char t) {
        if (t == 'l') {
            model[key0 + 2][key1 - 2] = 1;
            model[key0 + 1][key1 - 1] = 0;
        } else {
            model[key0 + 2][key1 + 2] = 1;
            model[key0 + 1][key1 + 1] = 0;
        }
    }
    public void hitEnemy(int key0, int key1, char t){
        if (t == 'l') {
            model[key0 - 2][key1 - 2] = -1;
            model[key0 - 1][key1 - 1] = 0;
        } else {
            model[key0 - 2][key1 + 2] = -1;
            model[key0 - 1][key1 + 1] = 0;
        }
    }
}
