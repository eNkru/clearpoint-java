package nz.co.clearpoint.assessment;

import nz.co.clearpoint.assessment.utils.ClockCalculator;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Running the assessment" );
        if (args.length == 1) {
            final String result = new ClockCalculator().clocke(args[0]);
            System.out.println(result);
        } else {
            System.out.println("Only 1 argument is supported.");
        }
    }
}
