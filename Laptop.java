import java.util.Objects;

/**Класс "Ноутбук"*/
public class Laptop {
    private String companyName;
    private String modelName;
    private String os;
    private String companyCPU;
    private String modelCPU;
    private double frequencyCPU;
    private int numberCores;
    private int ram;
    private double displaySize;
    private String displayResolution;
    private String videoCard;
    private String caseColor;
    private int price;
    private StringBuilder interfaces = new StringBuilder();
    private StringBuilder storageDevices = new StringBuilder();

    /**Конструктор класса "Ноутбук" для создания объекта этого класса
     * @param companyName производитель ноутбука
     * @param modelName модель ноутбука
     * @param os установленная операционная система
     * @param companyCPU производитель процессора
     * @param modelCPU модель процессора
     * @param frequencyCPU тактовая частота процессора
     * @param numberCores количество ядер
     * @param ram объем оперативно памяти
     * @param displaySize размер экрана в дюймах
     * @param displayResolution разрешение экрана
     * @param videoCard параметры видеокарты
     * @param caseColor цвет корпуса
     * @param price цена ноутбука
     * */
    public Laptop(String companyName, String modelName, String os, String companyCPU, String modelCPU,
                  double frequencyCPU, int numberCores, int ram, double displaySize, String displayResolution,
                  String videoCard, String caseColor, int price) {
        this.companyName = companyName;
        this.modelName = modelName;
        this.os = os;
        this.companyCPU = companyCPU;
        this.modelCPU = modelCPU;
        this.frequencyCPU = frequencyCPU;
        this.numberCores = numberCores;
        this.ram = ram;
        this.displaySize = displaySize;
        this.displayResolution = displayResolution;
        this.videoCard = videoCard;
        this.caseColor = caseColor;
        this.price = price;

    }

    public String getCompanyName() {
        return companyName;
    }
    public String getModelName() {
        return modelName;
    }
    public String getOs() {
        return os;
    }
    public String getCompanyCPU() {
        return companyCPU;
    }
    public String getModelCPU() {
        return modelCPU;
    }
    public int getNumberCores() {
        return numberCores;
    }
    public double getFrequencyCPU() {
        return frequencyCPU;
    }
    public int getRam() {
        return ram;
    }
    public double getDisplaySize() {
        return displaySize;
    }
    public String getDisplayResolution() {
        return displayResolution;
    }
    public String getVideoCard() {
        return videoCard;
    }
    public String getCaseColor() {
        return caseColor;
    }
    public int getPrice() {
        return price;
    }

    /**
     * Метод добавления интерфейса
     * @param interfaceType тип интерфейса
     */
    public  void addInterface(Interface interfaceType){
        this.interfaces.append(interfaceType).append(", ");
    }

    /**
     * Метод добавления накопителя
     * @param storageDevice тип и объем накопителя
     */
    public void addStorageDevice(StorageDevice storageDevice){
        this.storageDevices.append(storageDevice).append(", ");
    }

    @Override
    public String toString() {
        return "{компания:" + companyName + ", модель:" + modelName + ", ОС:" + os + ", процессор:" + companyCPU +
                " " + modelCPU + " " + frequencyCPU + " ГГц, количество ядер:" + numberCores + ", ОЗУ:" + ram + " ГБ" +
                ", экран:" + displaySize + " дюймов, разрешение:" + displayResolution + "," + "\n" + "видеокарта:" +
                videoCard + ", накопитель:" + storageDevices + "цвет корпуса:" + caseColor + ", интерфейсы:" +
                interfaces + "цена:" + price + " руб." + '}' + "\n" + "-----------------------------------------------" +
                "------------------------------------------------------------------------------------------------------" +
                "-----------------------------";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop laptop)) return false;
        return Double.compare(laptop.getFrequencyCPU(), getFrequencyCPU()) == 0 &&
                getNumberCores() == laptop.getNumberCores() && getRam() == laptop.getRam() &&
                Double.compare(laptop.getDisplaySize(), getDisplaySize()) == 0 && getPrice() == laptop.getPrice() &&
                Objects.equals(getCompanyName(), laptop.getCompanyName()) && Objects.equals(getModelName(),
                laptop.getModelName()) && Objects.equals(getOs(), laptop.getOs()) && Objects.equals(getCompanyCPU(),
                laptop.getCompanyCPU()) && Objects.equals(getModelCPU(), laptop.getModelCPU()) &&
                Objects.equals(getDisplayResolution(), laptop.getDisplayResolution()) && Objects.equals(getVideoCard(),
                laptop.getVideoCard()) && Objects.equals(getCaseColor(), laptop.getCaseColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompanyName(), getModelName(), getOs(), getCompanyCPU(), getModelCPU(),
                getFrequencyCPU(), getNumberCores(), getRam(), getDisplaySize(), getDisplayResolution(), getVideoCard(),
                getCaseColor(), getPrice());
    }

    /**
     * Метод проверки прользовательского фильтра
     * @param key ключ переключателя
     * @param filter заданный пользователем фильтр
     * @return
     */
    public boolean checkUserFilter(int key, String filter)
    {switch (key) {
        case 1 -> {return this.companyName.toLowerCase().contains(filter.toLowerCase());}
        case 2 -> {return this.modelName.toLowerCase().contains(filter.toLowerCase());}
        case 3 -> {return this.os.toLowerCase().contains(filter.toLowerCase());}
        case 4 -> {return this.companyCPU.toLowerCase().contains((filter.toLowerCase()));}
        case 5 -> {return this.modelCPU.toLowerCase().contains(filter.toLowerCase());}
        case 6 -> {return this.frequencyCPU == Double.parseDouble(filter);}
        case 7 -> {return this.numberCores == Integer.parseInt(filter);}
        case 8 -> {return this.ram == Integer.parseInt(filter);}
        case 9 -> {return this.storageDevices.toString().toLowerCase().contains((filter.toLowerCase()));}
        case 10 -> {return this.displaySize >= Double.parseDouble(filter) &&
                           this.displaySize < Double.parseDouble(filter) + 1;}
        case 11 -> {return this.displayResolution.toLowerCase().contains(filter.toLowerCase());}
        case 12 -> {return this.videoCard.toLowerCase().contains(filter.toLowerCase());}
        case 13 -> {return this.interfaces.toString().toLowerCase().contains(filter.toLowerCase());}
        case 14 -> {return this.caseColor.toLowerCase().contains(filter.toLowerCase());}
        case 15 -> {return this.price >= Integer.parseInt(filter) && this.price < Integer.parseInt(filter) + 1000;}
    }
        return false;
    }
}


