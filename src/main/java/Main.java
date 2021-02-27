import transport.*;


public class Main {
    public static void main(String[] args) {

        int[][] costMatrix = new int[][] {
            {2, 3, 1},
            {5, 4, 8},
            {5, 6, 8}
        };

        Warehouse s1 = new Warehouse("S1", 10);
        Warehouse s2 = new Warehouse("S2", 35);
        Factory s3 = new Factory("S3", 25);


        Destination d1 = new Destination("D1", 20);
        Destination d2 = new Destination("D2", 25);
        Destination d3 = new Destination("D3", 25);


        Problem p = new Problem();

        p.addSource(s1);
        p.addSource(s2);
        p.addSource(s3);

        p.addDestination(d1);
        p.addDestination(d2);
        p.addDestination(d3);

        p.setCostMatrix(costMatrix);

        p.printProblem();

        Solution sol = new Solution(p);
        sol.solve();
    }
}
