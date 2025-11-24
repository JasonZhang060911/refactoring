package theater;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Class representing the data needed to generate a statement for a customer.
 */
public class StatementData {
    private final String customer;
    private final List<PerformanceData> performances;

    public StatementData(Invoice invoice, Map<String, Play> plays) {
        this.customer = invoice.getCustomer();
        this.performances = new ArrayList<>();

        for (Performance performance : invoice.getPerformances()) {
            final Play play = plays.get(performance.getPlayID());
            performances.add(new PerformanceData(performance, play, createCalculator(performance, play)));
        }
    }

    private AbstractPerformanceCalculator createCalculator(Performance performance, Play play) {
        switch (play.getType()) {
            case "tragedy":
                return new TragedyCalculator(performance, play);
            case "comedy":
                return new ComedyCalculator(performance, play);
            case "history":
                return new HistoryCalculator(performance, play);
            case "pastoral":
                return new PastoralCalculator(performance, play);
            default:
                throw new RuntimeException("unknown type: " + play.getType());
        }
    }

    public String getCustomer() {
        return customer;
    }

    public List<PerformanceData> getPerformances() {
        return Collections.unmodifiableList(performances);
    }

    /**
     * Returns the total amount owed for all performances.
     *
     * @return the total amount
     */
    public int totalAmount() {
        int result = 0;
        for (PerformanceData perfData : performances) {
            result += perfData.amountFor();
        }
        return result;
    }

    /**
     * Returns the total volume credits earned for all performances.
     *
     * @return the total volume credits
     */
    public int volumeCredits() {
        int result = 0;
        for (PerformanceData perfData : performances) {
            result += perfData.volumeCredits();
        }
        return result;
    }
}
