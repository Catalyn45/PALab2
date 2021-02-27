package transport;

import java.util.Objects;

/**
 * Clasa ce reprezinta o destinatie pentru problema transportului
 */
public class Destination {
    /**
     * Numele destinatiei
     */
    private String name;
    /**
     * Numarul de marfuri necesare destinatiei
     */
    private int demand;

    /**
     * @param name Numele destinatiei
     * @param demand Numarul de marfuri necesare
     */
    public Destination(String name, int demand) {
        this.name = name;
        this.demand = demand;
    }

    /**
     * Seteaza numele destinatiei
     * @param name Numele ce va fi setat
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Ia numele destinatiei
     * @return numele destinatiei
     */
    public String getName() {
        return name;
    }

    /**
     * Seteaza numarul de marfuri necesare
     * @param demand numarul de marfuri necesare
     */
    public void setDemand(int demand) {
        this.demand = demand;
    }

    /**
     * Ia numarul de marfuri necesare
     * @return numarul de marfuri necesare
     */
    public int getDemand() {
        return demand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return demand == that.demand && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, demand);
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", demand=" + demand +
                '}';
    }
}
