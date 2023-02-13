import java.util.Objects;

/**Класс "Накопитель"*/
public class StorageDevice {
    private String type;
    private String capacity;

    /**Конструктор класса "Накопитель"
     * @param type Тип накопителя
     * @param capacity Объем накопителя
     * */
    public StorageDevice(String type, String capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return type + " " + capacity + " ГБ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StorageDevice that)) return false;
        return getCapacity() == that.getCapacity() && getType().equals(that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getCapacity());
    }
}
