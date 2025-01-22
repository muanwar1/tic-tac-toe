public class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
//        if (symbol != 'X' && symbol != 'O') {
//            System.out.println("Invalid symbol!");
//        } else {
//            this.name = name;
//            this.symbol = symbol;
//        }


        try {
            if (symbol == 'X' || symbol == 'O') {
                this.name = name;
                this.symbol = symbol;
            }
        } catch (Exception e) {
            System.out.println("Player" + e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
