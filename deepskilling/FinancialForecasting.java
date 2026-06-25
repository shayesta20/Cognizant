public class FinancialForecasting {
    public static double futureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return (1 + growthRate) * futureValue(presentValue, growthRate, years - 1);
    }

    public static double futureValueMemo(double presentValue, double growthRate, int years, double[] memo) {
        if (memo[years] >= 0) {
            return memo[years];
        }
        if (years == 0) {
            memo[years] = presentValue;
        } else {
            memo[years] = (1 + growthRate) * futureValueMemo(presentValue, growthRate, years - 1, memo);
        }
        return memo[years];
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05;
        int years = 5;

        System.out.println("Recursive future value: " + futureValue(presentValue, growthRate, years));

        double[] memo = new double[years + 1];
        for (int i = 0; i <= years; i++) {
            memo[i] = -1;
        }
        System.out.println("Memoized future value: " + futureValueMemo(presentValue, growthRate, years, memo));
    }
}
