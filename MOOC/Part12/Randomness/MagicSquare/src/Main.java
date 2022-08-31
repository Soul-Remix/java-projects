public class Main {
    public static void main(String[] args) {
        MagicSquareFactory factory = new MagicSquareFactory();
        int[][] square = factory.createMagicSquare(3);

        MagicSquare magicSquare = new MagicSquare(square);
        System.out.println(magicSquare.sumsOfRows());
        System.out.println("   ---   ");
        System.out.println(magicSquare.sumsOfColumns());
        System.out.println("   ---   ");
        System.out.println(magicSquare.sumsOfDiagonals());

        System.out.println("   New   ");

        int[][] square2 = factory.createMagicSquare(9);

        MagicSquare magicSquare2 = new MagicSquare(square2);
        System.out.println(magicSquare2.sumsOfRows());
        System.out.println("   ---   ");
        System.out.println(magicSquare2.sumsOfColumns());
        System.out.println("   ---   ");
        System.out.println(magicSquare2.sumsOfDiagonals());
    }
}