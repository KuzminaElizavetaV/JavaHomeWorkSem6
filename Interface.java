import java.util.Objects;

public class Interface {
    private String interfaceType;

    public Interface(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    @Override
    public String toString() {
        return interfaceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interface that)) return false;
        return getInterfaceType().equals(that.getInterfaceType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInterfaceType());
    }
}
