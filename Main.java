import java.util.*;
/**
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 * Создать множество ноутбуков.
 * Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
 * отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
 * 	“Введите цифру, соответствующую необходимому критерию:
 * 	1 - ОЗУ
 * 	2 - Объем ЖД
 * 	3 - Операционная система
 * 	4 - Цвет …
 * Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
 * Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */
public class Main {
    public static void main(String[] args) {
        Laptop laptop01 = new Laptop("HP", "15-bs589ur", "Win10", "Intel",
                "Pentium N3710", 1.6, 4,4, 15.6, "1920x1080",
                "Intel HD Graphics 405", "черный",23000);
        laptop01.addStorageDevice(new StorageDevice("HDD", "500"));
        laptop01.addStorageDevice(new StorageDevice("SSD", "250"));
        laptop01.addInterface(new Interface("USB 2.0"));
        laptop01.addInterface(new Interface("WiFi"));
        laptop01.addInterface(new Interface("LAN"));
        laptop01.addInterface(new Interface("HDMI"));

        Laptop laptop02 = new Laptop("HP", "OMEN 15-ce074ur", "Win10", "Intel",
                "Core i5 7300HQ", 2.5, 4, 8, 15.6, "1920x1080",
                "NVIDIA GeForce GTX 1060 6 ГБ", "серебро", 75000);
        laptop02.addStorageDevice(new StorageDevice("HDD", "500"));
        laptop02.addStorageDevice(new StorageDevice("SSD", "500"));
        laptop02.addInterface(new Interface("USB 3.0"));
        laptop02.addInterface(new Interface("WiFi"));
        laptop02.addInterface(new Interface("LAN"));
        laptop02.addInterface(new Interface("HDMI"));
        laptop02.addInterface(new Interface("Bluetooth"));

        Laptop laptop03 = new Laptop("HP", "Chromebook x36011", "Chrome OS",
                "Intel", "Celeron N3350", 1.1, 2, 8, 11.6,
                "1366x768", "Intel HD Graphics 500 SMA", "черный", 30000);
        laptop03.addStorageDevice(new StorageDevice("eMMC", "64"));
        laptop03.addInterface(new Interface("USB 3.0"));
        laptop03.addInterface(new Interface("WiFi"));
        laptop03.addInterface(new Interface("LAN"));
        laptop03.addInterface(new Interface("HDMI"));

        Laptop laptop04 = new Laptop("Apple", "MacBook Air 13", "MacOS", "Apple",
                "M1", 3.2, 8, 8, 13.3, "2560x1600",
                "Apple M1", "золото", 80900);
        laptop04.addStorageDevice(new StorageDevice("SSD", "256"));
        laptop04.addInterface(new Interface("USB 3.1"));
        laptop04.addInterface(new Interface("WiFi"));
        laptop04.addInterface(new Interface("DVI"));
        laptop04.addInterface(new Interface("HDMI"));
        laptop04.addInterface(new Interface("Bluetooth"));

        Laptop laptop05 = new Laptop("HUAWEI", "53013ERR(BoD-WDH9)", "Win11",
                "Intel", "Core i5-1135G7", 4.2, 4, 8, 15.6,
                "1920x1080", "Intel Iris Xe Graphics", "серебро", 50000);
        laptop05.addStorageDevice(new StorageDevice("SSD", "512"));
        laptop05.addInterface(new Interface("USB 3.2"));
        laptop05.addInterface(new Interface("USB 2.0"));
        laptop05.addInterface(new Interface("WiFi"));
        laptop05.addInterface(new Interface("Type-C"));
        laptop05.addInterface(new Interface("HDMI"));
        laptop05.addInterface(new Interface("Bluetooth"));

        Laptop laptop06 = new Laptop("Honor", "MagicBook 16 R5", "DOS", "AMD",
                "Ryzen 5 5600H", 4.2, 6, 16, 16.1,
                "1920x1080", "AMD Radeon Graphics", "серый", 59000);
        laptop06.addStorageDevice(new StorageDevice("SSD", "512"));
        laptop06.addInterface(new Interface("USB 3.2"));
        laptop06.addInterface(new Interface("USB 2.0"));
        laptop06.addInterface(new Interface("WiFi"));
        laptop06.addInterface(new Interface("Type-C"));
        laptop06.addInterface(new Interface("HDMI"));
        laptop06.addInterface(new Interface("Bluetooth"));

        Laptop laptop07 = new Laptop("ASUS", "TUF F15 FX506HCB-US51", "Win11Home",
                "Intel",  "Core i5-11400H", 4.5, 6, 8, 15.6,
                "1920x1080", "NVIDIA GeForce RTX 3050 4 ГБ", "серый", 70000);
        laptop07.addStorageDevice(new StorageDevice("SSD", "512"));
        laptop07.addInterface(new Interface("USB 3.2"));
        laptop07.addInterface(new Interface("USB 2.0"));
        laptop07.addInterface(new Interface("WiFi"));
        laptop07.addInterface(new Interface("Type-C"));
        laptop07.addInterface(new Interface("HDMI"));
        laptop07.addInterface(new Interface("Bluetooth"));

        HashSet<Laptop> laptops = new HashSet<>(Arrays.asList(laptop01, laptop02, laptop03, laptop04, laptop05,
                laptop06, laptop07));
        System.out.println("***************В КАТАЛОГЕ МАГАЗИНА ПРЕДСТАВЛЕНО " + laptops.size() + " МОДЕЛЕЙ НОУТБУКОВ***" +
                "************\n" +
                "------------------------------------------------------------------------------------------------------" +
                "--------------------------------------------------------------------------");
        laptops.forEach(System.out::println); //краткая запись foreach ввиде лямбды, еще удобнее стало)))

        try {
            HashSet<Laptop> filterSet = userFilter(laptops);
            System.out.println("ВЫБОРКА, СОГЛАСНО ЗАДАННОМУ ФИЛЬТРУ\n--------------------------------------------------" +
                    "--------------------------------------------------------------------------------------------------" +
                    "------------------------------");
            printSet(filterSet);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    static HashSet<Laptop> userFilter(HashSet<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> userMapFilter = new HashMap<>();
        HashMap<Integer, String> viewFilter = new HashMap<>();
        viewFilter.put(1, "Производитель ноутбука (по вхождению строки)");
        viewFilter.put(2, "Модель ноутбука (по вхождению строки)");
        viewFilter.put(3, "Операционная система (по вхождению строки)");
        viewFilter.put(4, "Производитель процессора (по вхождению строки)");
        viewFilter.put(5, "Модель процессора (по вхождению строки)");
        viewFilter.put(6, "Тактовая частота, ГГц");
        viewFilter.put(7, "Количество ядер");
        viewFilter.put(8, "Объем оперативной памяти RAM");
        viewFilter.put(9, "Накопитель (тип SSD или объем 512): ");
        viewFilter.put(10, "Диагональ экрана в дюймах");
        viewFilter.put(11, "Разрешение экрана (по вхождению строки)");
        viewFilter.put(12, "Видеокарта (по вхождению строки)");
        viewFilter.put(13, "Интерфейсы (USB 3.0, HDMI, DVI и т.д.)");
        viewFilter.put(14, "Цвет (по вхождению строки)");
        viewFilter.put(15, "Цена, рублей");

        System.out.println("ЗАДАЙТЕ КРИТЕРИИ ОТБОРА ЧИСЛАМИ ОТ 1 до 15, СОГЛАСНО СПИСКУ:\n*****************************" +
                "*******************************");
        for (Map.Entry<Integer, String> el : viewFilter.entrySet()) {
            System.out.printf("%-3d=> %s\n", el.getKey(), el.getValue());
        }
        System.out.println("************************************************************");
        System.out.print("ВВЕДИТЕ ЧИСЛО ИЛИ НЕСКОЛЬКО ЧИСЕЛ ЧЕРЕЗ ЗАПЯТУЮ: ");
        if (scanner.hasNext()){
            String input = scanner.next();
            ArrayList<Integer> userChoice = new ArrayList<>();
            if (isDigit(input) && viewFilter.containsKey(Integer.parseInt(input))) userChoice.add(Integer.parseInt(input));
            else {
                for (String str: input.split(",")) {
                    if (viewFilter.containsKey(Integer.parseInt(str))){
                        userChoice.add(Integer.parseInt(str));
                    }
                }
            }
            if (!userChoice.isEmpty()){
                for (Integer item:userChoice) {
                    System.out.print("ВВЕДИТЕ ЗНАЧЕНИЕ ПО КРИТЕРИЮ \"" + viewFilter.get(item) + "\": ");
                    if (scanner.hasNext()){
                        input = scanner.next();
                        userMapFilter.put(item, input);
                    }
                }
            } else System.out.println("Некорректный ввод");
        }
        scanner.close();
        System.out.println("ЗАДАН ФИЛЬТР:");
        for (Map.Entry<Integer, String> entry : userMapFilter.entrySet()) {
            System.out.printf("%-3d=> %s\n", entry.getKey(), entry.getValue());
        }
        HashSet<Laptop> tmpLaptops = new HashSet<>(laptops);

        for (Map.Entry<Integer, String> entry:userMapFilter.entrySet()) {
            tmpLaptops.removeIf(laptop -> !laptop.checkUserFilter(entry.getKey(), entry.getValue()));
        }
        return tmpLaptops;
    }
    static void printSet(HashSet<Laptop> lap){
        for (Laptop laptop : lap) {
            if (laptop != null){
                System.out.println(laptop);
            }
        }
    }
    static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}