import java.util.*;

public class Solve {
    //Recursion solution
    public static void solveRec(int from, int to, int disks){
        if(disks == 1){
            System.out.println(from + " -> " + to);
            return;
        }

        int other = 6 - to - from; //Get the other(neither from nor to) rod

        solveRec(from, other, disks - 1);
        solveRec(from, to, 1);
        solveRec(other, to, disks-1);
    }

    //Iterative solution
    public static void solveIte(int from, int to, int disks){
        byte shift = (byte) ((disks & 1) == 1 ? -1 : 1);
        shift *= Math.abs(from-to) == 1 ? -1 : 1;
        ArrayList<Stack<Integer>> rod = new ArrayList<>();

        for(int i = 0; i < 3; i++) rod.add(new Stack<>()); //Add 3 rods

        for(Stack<Integer> c : rod) c.push(Integer.MAX_VALUE);

        for(int i = 0; i < disks; i++) rod.get(from-1).push(disks-i); //Set up the disk on the first rod

        byte smallest = (byte) (from - 1); //Store the smallest disk's rod location
        byte mid; //Store the non-smallest and non-largest (mid) disk's rod location

        for(int i = 0; i < Math.pow(2, disks) - 1; i++){

            if((i & 1) == 0){
                System.out.print(smallest + 1);

                rod.get(smallest).pop();
                smallest += shift;
                smallest = (byte) (smallest < 0 ? smallest + 3 : smallest);
                smallest %= 3;

                rod.get(smallest).push(1);
                System.out.println(" -> " + (smallest + 1));

                continue;
            }



            mid = (byte) (rod.get((smallest + 1) % 3).peek() < rod.get((smallest + 2) % 3).peek() ? (smallest + 1) % 3 : (smallest + 2) % 3);

            int e = rod.get(mid).pop(); //Store the mid-disk size

            int other = 3 - mid - smallest;
            rod.get(other).push(e);
            System.out.println((mid + 1) + " -> " + (other + 1));
        }
    }
}