public class CalcTaxService {
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int taxErnSpend = (earnings - spendings) * 15 / 100;
        if (taxErnSpend >= 0) {
            return taxErnSpend;
        } else {
            return 0;
        }
    }

    public static int taxEarningsSixPercent(int earnings) {
        int taxEarning = earnings * 6 / 100;
        return taxEarning;
    }
}
