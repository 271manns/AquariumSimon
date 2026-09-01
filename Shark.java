public class Shark extends SeaCreature {

    private String symbol;

    public Shark(String name, int position, int speed, int direction, String symbol) throws InvalidCreatureException {
        super(name, position, speed, direction);
        this.symbol = symbol;
        hunger = 10; 
    }

    @Override
    public void move(int tankWidth) {
        if(hunger>0)
        {
            position += speed * direction * 2;
            keepInsideTank(tankWidth);
            hunger--;
        }

    }

    @Override
    public String getSymbol() {
        return direction >= 0 ? symbol : reverseSymbol(symbol);
    }

    private String reverseSymbol(String text) {
        return new StringBuilder(text).reverse().toString();
    }
    public void feed()
    {
        super.feed();
        super.feed();
    }
}
