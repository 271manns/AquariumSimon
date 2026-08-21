public class Crab extends SeaCreature {

    private String symbol;

    public Crab(String name, int position, int speed, int direction, String symbol) {
        super(name, position, speed, direction);
        this.symbol = symbol;
    }

    @Override
    public void move(int tankWidth) {
        position += speed * direction;
        keepInsideTank(tankWidth);
        turnAround();
    }
    public void turnAround(){
        if(Math.random()<.3 )
        {
            direction *=-1;
            reverseSymbol(symbol);
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
