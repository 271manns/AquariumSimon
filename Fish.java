public class Fish extends SeaCreature {

    private String symbol;

    public Fish(String name, int position, int speed, int direction, String symbol) throws InvalidCreatureException {
        super(name, position, speed, direction);
        this.symbol = symbol;
        hunger = 10; 
    }

    @Override
    public void move(int tankWidth) {
        if(hunger>0)
        {
            position += speed * direction;
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
}
