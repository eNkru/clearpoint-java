package nz.co.clearpoint.assessment.utils;

public class ClockCalculator {
    private static final double MINUTE_HAND_DEGREES_PER_MINUTE = (double) 360 / 60;
    private static final double HOUR_HAND_DEGREES_PER_HOUR = (double) 360 / 12;
    private static final double HOUR_HAND_DEGREES_PER_MINUTE = (double) 360 / 12 / 60;

    public String clocke(String timeString) {
        if (timeString == null) {
            throw new IllegalArgumentException("timeString can not be null.");
        }
        if (timeString.length() != 4) {
            throw new IllegalArgumentException("timeString need to be 4 digits.");
        }

        try {
            int timeInteger = Integer.parseInt(timeString);

            if (timeInteger > 2359) {
                throw new IllegalArgumentException("timeString format is not valid");
            }

            int hourIntegerValue = timeInteger / 100 % 12;
            int minuteIntegerValue = timeInteger % 100;

            if (minuteIntegerValue > 59) {
                throw new IllegalArgumentException("timeString format is not valid");
            }

            double hourHandDegrees = hourIntegerValue * HOUR_HAND_DEGREES_PER_HOUR + minuteIntegerValue * HOUR_HAND_DEGREES_PER_MINUTE;
            double minuteHandDegrees = minuteIntegerValue * MINUTE_HAND_DEGREES_PER_MINUTE;
            double result = minuteHandDegrees - hourHandDegrees;
            if (result < 0) {
                result += 360;
            }
            return convertResult(result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("timeString need to be a number value.");
        }
    }

    private String convertResult(double result) {
        String resultString;
        final int castInt = (int) result;
        if (castInt == result) {
            resultString = String.valueOf(castInt);
        } else {
            resultString = String.valueOf(result);
        }
        return resultString;
    }
}
