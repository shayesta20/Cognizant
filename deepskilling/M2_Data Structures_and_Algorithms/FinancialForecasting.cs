using System;

public class FinancialForecasting
{
    // Recursive method to calculate future value
    public static double FutureValue(double presentValue, double growthRate, int years)
    {
        if (years == 0)
        {
            return presentValue;
        }
        return (1 + growthRate) * FutureValue(presentValue, growthRate, years - 1);
    }

    // Memoized recursive method to calculate future value
    public static double FutureValueMemo(double presentValue, double growthRate, int years, double[] memo)
    {
        if (memo[years] >= 0)
        {
            return memo[years];
        }

        if (years == 0)
        {
            memo[years] = presentValue;
        }
        else
        {
            memo[years] = (1 + growthRate) * FutureValueMemo(presentValue, growthRate, years - 1, memo);
        }

        return memo[years];
    }

    public static void Main(string[] args)
    {
        double presentValue = 1000.0;
        double growthRate = 0.05;
        int years = 5;

        // 1. Clean Recursive Approach
        Console.WriteLine("Recursive future value: " + FutureValue(presentValue, growthRate, years));

        // 2. Memoized Approach
        double[] memo = new double[years + 1];
        for (int i = 0; i <= years; i++)
        {
            memo[i] = -1; // Initialize memoization array with -1
        }

        Console.WriteLine("Memoized future value: " + FutureValueMemo(presentValue, growthRate, years, memo));
    }
}
