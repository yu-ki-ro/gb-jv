package HW_1;
public class HotDrink {
    private String DrinkName;
    private int volume;

    public HotDrink(String DrinkName, int volume) {
        this.DrinkName = DrinkName;
        this.volume = volume;
    }

    public String getDrinkName() {
        return DrinkName;
    }

    public int getvolume() {
        return volume;
    }
}