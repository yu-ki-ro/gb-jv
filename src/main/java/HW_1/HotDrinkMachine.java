package HW_1;

public class HotDrinkMachine implements TradingMachine {
    @Override
    public HotDrink getProduct(String DrinkName, int volume) {
        return new HotDrink(DrinkName, volume);
    }

    @Override
    public DrinkTemp getProduct(String DrinkName, int volume, int temp) {
        return new DrinkTemp(DrinkName, volume, temp);
    }
}