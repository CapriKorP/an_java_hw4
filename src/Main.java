import java.util.Scanner;

public class Main {

    static int earnings = 0;
    static int spendings = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Добро пожаловать в налоговый калькулятор!");
        System.out.println();
        Thread.sleep(1000);
        System.out.println("Для добавления дохода нажмите \"1\"");
        System.out.println("Для добавления расхода нажмите \"2\"");
        System.out.println("Для выбора системы налогообложения нажмите \"3\"");
        System.out.println("Для завершение работы введите \"end\"");
        System.out.println();
        Thread.sleep(1000);

        while (true) {
            System.out.println("Выберите операцию: ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);
            int x = CalcTaxService.taxEarningsMinusSpendings(earnings, spendings);
            int y = CalcTaxService.taxEarningsSixPercent(earnings);

            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода: ");
                    String incomeStr = scanner.nextLine();
                    int income = Integer.parseInt(incomeStr);
                    earnings += income;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода: ");
                    String outgoStr = scanner.nextLine();
                    int outgo = Integer.parseInt(outgoStr);
                    spendings += outgo;
                    break;
                case 3:
                    if (x > y) {
                        System.out.println(">>> Мы предлагаем Вам перейти на УСН Доход");
                        System.out.println("Ваш налог составил: " + y + " руб.");
                        System.out.println("Налог по УСН ДоходРасход составил: " + x + " руб.");
                        System.out.println("Ваша экономия составила: " + (x - y) + " руб.");
                        System.out.println();
                    } else if (x == y) {
                        System.out.println(">>> Вы можете выбрать любую систему налогообложения");
                        System.out.println();
                    } else {
                        System.out.println(">>> Мы предлагаем Вам перейти на УСН ДоходРасход");
                        System.out.println("Ваш налог составил: " + x + " руб.");
                        System.out.println("Налог по УСН Доход составил: " + y + " руб.");
                        System.out.println("Ваша экономия составила: " + (y - x) + " руб.");
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println("Такой операции не существует");
            }
        }

    }
}
