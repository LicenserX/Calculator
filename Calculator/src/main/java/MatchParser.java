class MatchParser {
    public MatchParser() {
    }

    public double parse(String s) throws Exception {
        Result result = plusMinus(s);
        if (!result.rest.isEmpty()) {
            System.err.println("Error: can't full parse");
            System.err.println("Rest: " + result.rest);
        }
        return result.currentCalc;
    }

    private Result plusMinus(String s) throws Exception {
        Result current = mulDiv(s);
        double acc = current.currentCalc;

        while (current.rest.length() > 0) {
            if (!(current.rest.charAt(0) == '+' || current.rest.charAt(0) == '-')) break;

            char sign = current.rest.charAt(0);
            String next = current.rest.substring(1);

            current = mulDiv(next);
            if (sign == '+') {
                acc += current.currentCalc;
            } else {
                acc -= current.currentCalc;
            }
        }
        return new Result(acc, current.rest);
    }

    private Result bracket(String s) throws Exception {
        char zeroChar = s.charAt(0);
        if (zeroChar == '(') {
            Result r = plusMinus(s.substring(1));
            if (!r.rest.isEmpty() && r.rest.charAt(0) == ')') {
                r.rest = r.rest.substring(1);
            } else {
                System.err.println("Error: not close bracket");
            }
            return r;
        }
        return num(s);
    }

    private Result mulDiv(String s) throws Exception {
        Result current = bracket(s);

        double acc = current.currentCalc;
        while (true) {
            if (current.rest.length() == 0) {
                return current;
            }
            char sign = current.rest.charAt(0);
            if ((sign != '*' && sign != '/')) return current;

            String next = current.rest.substring(1);
            Result right = bracket(next);

            if (sign == '*') {
                acc *= right.currentCalc;
            } else {
                acc /= right.currentCalc;
            }

            current = new Result(acc, right.rest);
        }
    }

    private Result num(String s) throws Exception {
        int i = 0;
        int dot_cnt = 0;
        boolean negative = false;
//        The number can be negative (begins with -)
        if (s.charAt(0) == '-') {
            negative = true;
            s = s.substring(1);
        }

//        Cycle while resolve only numbers and a point, after which there is also a number, as well as check for a char
        while ((i < s.length()) && (Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))
                || (s.charAt(i) == '.'))) {

//            If char is a true throw new Exception
            if (Character.isLetter(s.charAt(i))) {
                throw new Exception("not valid number, expect number, find letter '" + s.substring(0, i + 1) + "'");
            }

//            If after the point is't a number throw new Exception
            if ((s.charAt(i) == '.' && (!(Character.isDigit(s.charAt(i + 1)))) && (!(Character.isLetter(s.charAt(i + 1)))))) {
                throw new Exception("not valid number, expect double, find '" + s.substring(0, i + 3) + "'");
            }

//            Check that expression have only one point
            if (s.charAt(i) == '.' && ++dot_cnt > 1) {
                throw new Exception("not valid number '" + s.substring(0, i + 1) + "'");
            }
            i++;
        }
        if (i == 0) {
//            If the number wasn't found throw new Exception
            throw new Exception("can't get valid number in '" + s + "'");
        }

        double dPart = Double.parseDouble(s.substring(0, i));
        if (negative) dPart = -dPart;
        String restPart = s.substring(i);

        return new Result(dPart, restPart);

    }

}