public class Main {
    public static void main(String[] args) {
        final int DISKS = 3; //Disk amount
        final int FROM = 1; //Origin rod
        final int TO = 2; //Target rod
        System.out.println("Solve recursion");
        Solve.solveRec(FROM, TO, DISKS);
        System.out.println();

        System.out.println("Solve iterative");
        Solve.solveIte(FROM, TO, DISKS);
    }
}