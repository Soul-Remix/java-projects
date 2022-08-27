public class CustomTacoBox implements TacoBox {
    private int tacos;

    public CustomTacoBox() {
        tacos = 1;
    }

    @Override
    public int tacosRemaining() {
        return tacos;
    }

    @Override
    public void eat() {
        tacos -= 1;
    }
}
