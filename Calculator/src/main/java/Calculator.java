class Calculator {
    private final MatchParser parser = new MatchParser();
    private final DoubleRound rounding = new DoubleRound();

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.evaluate("(2+9)/3"));
    }

    public String evaluate(String statement) {
        try {
            return String.valueOf(statement + "=" + rounding.doubleRound(parser.parse(statement)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
