import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return scanValues(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return scanValues(amount + amount * yearRate * depositPeriod, 2);
    }

    double scanValues(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe)
                / ScaLe;
    }

    void printMenu() {
        int period;
        int action;

        Scanner abcdef = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = abcdef.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = abcdef.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = abcdef.nextInt();
        double outVar = 0;
        if (action == 1){
            outVar = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outVar = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outVar);
    }

    public static void main(String[] args){
        new DepositCalculator().printMenu();
    }
}