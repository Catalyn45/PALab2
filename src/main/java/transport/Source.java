package transport;

import java.util.Objects;

/**
 * Clasa ce reprezinta o sursa pentru problema transportului
 */
public abstract class Source {
    /**
     * Numele sursei
     */
    protected String name;
    /**
     * Numarul de marfuri de care dispune sursa
     */
    protected int supply;

    /**
     * @param name Numele sursei
     * @param supply Numarul de marfuri de care dispune sursa
     */
    public Source(String name, int supply) {
        this.name = name;
        this.supply = supply;
    }

    /**
     * Seteaza un numa diferit pentru sursa
     * @param name numele ce va fi setat
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Ia numele sursei
     * @return numele sursei
     */
    public String getName() {
        return name;
    }

    /**
     * Seteaaza numarul de marfuri
     * @param supply numaruld e marfuri ce va fi setat
     */
    public void setSupply(int supply) {
        this.supply = supply;
    }

    /**
     * Ia numarul de marfuri
     * @return numarul de marfuri
     */
    public int getSupply() {
        return supply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return supply == source.supply && Objects.equals(name, source.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, supply);
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", supply=" + supply +
                '}';
    }
}
