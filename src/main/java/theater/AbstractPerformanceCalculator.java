package theater;

/**
 * Abstract class for calculating performance amounts and volume credits.
 */
public abstract class AbstractPerformanceCalculator {

    private final Performance performance;
    private final Play play;

    public AbstractPerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public Performance getPerformance() {
        return performance;
    }

    public Play getPlay() {
        return play;
    }

    /**
     * Calculate the amount owed for this performance.
     *
     * @return the calculated amount
     */
    public abstract int amount();

    /**
     * Calculate volume credits for this performance.
     *
     * @return the calculated volume credits
     */
    public int volumeCredits() {
        return Math.max(
                getPerformance().getAudience() - Constants.BASE_VOLUME_CREDIT_THRESHOLD,
                0);
    }
}
