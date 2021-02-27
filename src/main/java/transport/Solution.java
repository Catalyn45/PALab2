package transport;

import java.util.Objects;

/**
 * Clasa folosita la calcularea solutiei unei probleme
 */
public class Solution {
    /**
     * Problema ce va fi rezolvata
     */
    private final Problem problem;
    public Solution(Problem problem) {
        this.problem = problem;
    }

    /**
     * Functia ce rezolva si afiseaza problema
     */
    public void solve() {
        int currentSourceIndex = 0;
        int total_cost = 0;

        System.out.println("Rezolvarea problemei: ");
        while(!problem.satisfied()) {
            int currentDestinationIndex = -1;
            int minCost = Integer.MAX_VALUE;

            for(int i = 0; i < problem.getDestinationsCount(); i++) {
                int cost = problem.getCost(currentSourceIndex, i);

                if(cost < minCost && problem.getDestination(i).getDemand() > 0) {
                    minCost = cost;
                    currentDestinationIndex = i;
                }
            }

            Source currentSource = problem.getSource(currentSourceIndex);
            Destination currentDestination = problem.getDestination(currentDestinationIndex);

            int supply = currentSource.getSupply();
            int demand = currentDestination.getDemand();

            if(supply > demand) {
                System.out.println(currentSource.getName() + " -" + demand + "-> " + currentDestination.getName());
                total_cost += minCost * demand;
                currentSource.setSupply(supply - demand);
                currentDestination.setDemand(0);
            }
            else if(demand > supply) {
                System.out.println(currentSource.getName() + " -" + supply + "-> " + currentDestination.getName());
                total_cost += minCost * supply;
                currentDestination.setDemand(demand - supply);
                currentSource.setSupply(0);
                currentSourceIndex++;
            }
            else {
                System.out.println(currentSource.getName() + " -" + supply + "-> " + currentDestination.getName());
                total_cost += minCost * supply;
                currentSource.setSupply(0);
                currentDestination.setDemand(0);
                currentSourceIndex++;
            }
        }

        System.out.println("Total cost: " + total_cost);
    }

    @Override
    public String toString() {
        return "Solution{" +
                "problem=" + problem +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(problem, solution.problem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(problem);
    }
}
