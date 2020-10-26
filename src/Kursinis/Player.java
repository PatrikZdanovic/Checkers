package Kursinis;

public class Player {
    private int[] pieces;

    public Player(String type) {
        if (type == "friend"){
            int[] friend={0,1,2,3,4,5,6,7,8,9,10,11,12};
            pieces=friend;
        }
        else{
            int[] friend={0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12};
            pieces=friend;
        }
    }
}
