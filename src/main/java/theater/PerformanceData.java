package theater;

/**
 * Class representing performance data, including methods to calculate.
 */
public class PerformanceData {
    private final Performance performance;
    private final Play play;
    private final AbstractPerformanceCalculator calculator;

    public PerformanceData(Performance performance, Play play, AbstractPerformanceCalculator calculator) {
        this.performance = performance;
        this.play = play;
        this.calculator = calculator;
    }

    public String getName() {
        return play.getName();
    }

    public int getAudience() {
        return performance.getAudience();
    }

    public String getType() {
        return play.getType();
    }

    /**
     * Returns the amount owed for this performance.
     *
     * @return the performance cost
     * @throws RuntimeException if one of the play types is not known
     */
    public int amountFor() {
        return calculator.amount();
    }

    /**
     * Returns the volume credits earned for this performance.
     *
     * @return the volume credits
     */
    public int volumeCredits() {
        return calculator.volumeCredits();
    }

}
