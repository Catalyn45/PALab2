package transport;

import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

/**
 * Clasa are ca rezolvarea problemei transportului
 */
public class Problem {
    /**
     * Lista ce contine sursele
     */
    Vector<Source> sources;
    /**
     * Lista ce contine destinatiile
     */
    Vector<Destination> destinations;
    /**
     * Matricea de costuri
     */
    int[][] costMatrix;

    public Problem() {
        sources = new Vector<>();
        destinations = new Vector<>();
        costMatrix = null;
    }

    /**
     * Adauga o sursa in lista de surse
     * @param source Sursa ce va fi adauga
     * @return true in cazul in care a fost adaugata cu succes si false in caz contrar
     */
    public boolean addSource(Source source) {
        for (Source s : sources) {
            // validam sursa deoarece nu puteam avea doua surse identice
            if (s == source)
                return false;
        }

        sources.add(source);
        return true;
    }

    /**
     * Ia un cost din matricea de costuri
     * @param i linia din maticea de costuri
     * @param j coloana din matricea de costuri
     * @return costul corespunzator
     */
    public int getCost(int i, int j) {
        if (i < 0 || i >= costMatrix.length)
            return -1;

        if(j < 0 || j >= costMatrix[0].length)
            return -1;

        return costMatrix[i][j];
    }

    /**
     * Ia o sursa din lista de surse
     * @param i index-ul sursei
     * @return sursa corespunzatoare
     */
    public Source getSource(int i) {
        if (i < 0 || i >= sources.size())
            return null;

        return sources.get(i);
    }

    /**
     * Ia destinatia din lista de destinatii
     * @param i index-ul destinatiei
     * @return destinatia corespunzatoare
     */
    public Destination getDestination(int i) {
        if (i < 0 || i >= destinations.size())
            return null;

        return destinations.get(i);
    }

    /**
     * Verifica daca problema este satisfacuta
     * @return true in caz ca este satisfacuta si false in caz contrar
     */
    public boolean satisfied() {
        for(Source s : sources) {
            if(s.getSupply() > 0)
                return false;
        }

        for(Destination d : destinations) {
            if(d.getDemand() > 0)
                return false;
        }

        return true;
    }

    /**
     * Ia numarul de surse
     * @return numarul de surse
     */
    public int getSourcesCount() {
        return sources.size();
    }

    /**
     * Ia numarul de destinatii
     * @return numarul de destinatii
     */
    public int getDestinationsCount() {
        return destinations.size();
    }

    /**
     * Adauga o destinatie in lista de destinatii
     * @param destination destinatia ce va fi adaugata
     * @return true in caz ca este adaugata cu succes si false in caz contrar
     */
    public boolean addDestination(Destination destination) {
        for (Destination d : destinations) {
            // validam destinatia deoarece nu puteam avea doua destinatii identice
            if (d == destination)
                return false;
        }

        destinations.add(destination);
        return true;
    }

    /**
     * Seteaza matricea de costuri
     * @param costMatrix matricea de costuri ce va fi setata
     * @return true in caz de succes si false in caz contrar
     */
    public boolean setCostMatrix(int[][] costMatrix) {
        if (costMatrix == null)
            return false;

        // verificam dimensiunile matricii
        if (costMatrix.length != sources.size())
            return false;

        if (costMatrix[0].length != destinations.size())
            return false;

        this.costMatrix = costMatrix;
        return true;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "sources=" + sources +
                ", destinations=" + destinations +
                ", costMatrix=" + Arrays.toString(costMatrix) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return Objects.equals(sources, problem.sources) && Objects.equals(destinations, problem.destinations) && Arrays.equals(costMatrix, problem.costMatrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(sources, destinations);
        result = 31 * result + Arrays.hashCode(costMatrix);
        return result;
    }

    /**
     * Reseteaza problema
     */
    public void clear() {
        sources.clear();
        destinations.clear();
        costMatrix = null;
    }

    /**
     * Afiseaza datele problemei
     */
    public void printProblem() {
        System.out.println("Datele problemei: ");
        System.out.println("Supply :");

        for (Source s : sources) {
            System.out.println(s.getName() + " : " + s.getSupply());
        }

        System.out.println("Demands: ");

        for (Destination d : destinations) {
            System.out.println(d.getName() + " : " + d.getDemand());
        }

        System.out.println("Costs: ");

        for (int i = 0; i < costMatrix.length; i++) {
            for (int j = 0; j < costMatrix[0].length; j++) {
                System.out.println(sources.get(i).getName() + " -> " + destinations.get(i).getName() + " : " + costMatrix[i][j]);
            }
        }

        System.out.println();
    }
}
