package HW_1;

public class Main {
    public static void main(String[] args) {
        HotDrinkMachine Machine = new HotDrinkMachine();

        HotDrink HotDrink1 = Machine.getProduct("Чай", 200);
        System.out.println("Название: " + HotDrink1.getDrinkName());
        System.out.println("Объем: " + HotDrink1.getvolume());

        DrinkTemp HotDrink2 = Machine.getProduct("Кофе", 300, 80);
        System.out.println("Название: " + HotDrink2.getDrinkName());
        System.out.println("Объем: " + HotDrink2.getvolume());
        System.out.println("Температура: " + HotDrink2.gettemp());
    }
}
