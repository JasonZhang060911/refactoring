package theater;

/**
 * Calculator for Pastoral play performances.
 */
public class PastoralCalculator extends AbstractPerformanceCalculator {

    public PastoralCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public int amount() {
        int result = Constants.PASTORAL_BASE_AMOUNT;

        if (getPerformance().getAudience() > Constants.PASTORAL_AUDIENCE_THRESHOLD) {
            result += Constants.PASTORAL_OVER_BASE_CAPACITY_PER_PERSON
                    * (getPerformance().getAudience() - Constants.PASTORAL_AUDIENCE_THRESHOLD);
        }

        return result;
    }

    @Override
    public int volumeCredits() {
        final int base = super.volumeCredits();
        return base * 2;
    }
}
