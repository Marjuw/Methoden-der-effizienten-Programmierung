import AntiPatternInnerClasses.DecoratorAntiPatternInnerclasses;
import AntiPatternSubclasses.DecoratorAntiPatternSubclasses;
import Pattern.*;


public class ComparePattern {


    static DecoratorPattern.Instrument instrumentDecoratorPattern; //Instrument from the Pattern
    static DecoratorAntiPatternInnerclasses.Instrument instrumentDecoratorAntiPatternInnerclasses;  //Instrument from the AntiPattern
    static DecoratorAntiPatternSubclasses.Instrument instrumentDecoratorAntiPatternSubclasses;  //Instrument from the AntiPattern


    static DecoratorPattern.Instrument instrumentDecoratorPatternWithCalculation; //Instrument from the Pattern
    static DecoratorAntiPatternInnerclasses.Instrument instrumentDecoratorAntiPatternInnerclassesWithCalculation;  //Instrument from the AntiPattern
    static DecoratorAntiPatternSubclasses.Instrument instrumentDecoratorAntiPatternSubclassesWithCalculation;  //Instrument from the AntiPattern


    public static final long runsOfFunction = 10000000l; //that the time to call is bigger enough to measure
    public static int sequenceOfFibunacci = 10; //that the time for Calculation to call is bigger enough to measure

    static long spendTimePattern;
    static long spendTimeAntiPatternInnerclasses;
    static long spendTimeAntiPatternSubclasses;

    static long spendTimePatternWithCalculatin;
    static long spendTimeAntiPatternInnerclassesWithCalculatin;
    static long spendTimeAntiPatternSubclassesWithCalculatin;


    public static void measureTimeOfPattern() {

        long start = System.currentTimeMillis();

        for (long i = 0; i < runsOfFunction; i++) {

            instrumentDecoratorPattern = new DecoratorPattern.Reverb(new DecoratorPattern.Flanger(new DecoratorPattern.GuitarAmp(new DecoratorPattern.Reverb
                    (new DecoratorPattern.Flanger(new DecoratorPattern.GuitarAmp(new DecoratorPattern.MoogSynthesizer()))))));

            //  instrumentDecoratorPattern = new DecoratorPattern.Equalizer(new DecoratorPattern.Flanger(new DecoratorPattern.GuitarAmp(new DecoratorPattern.Reverb
            //         (new DecoratorPattern.Flanger(new DecoratorPattern.GuitarAmp(new DecoratorPattern.MoogSynthesizer()))))));


        }

        long end = System.currentTimeMillis();

        spendTimePattern = end - start;

    }

    public static void measureTimeOfPatternWithCalculation() {

        long start = System.currentTimeMillis();

        for (long i = 0; i < runsOfFunction; i++) {


            instrumentDecoratorPatternWithCalculation = new DecoratorPattern.Reverb(new DecoratorPattern.Flanger(new DecoratorPattern.GuitarAmp(new DecoratorPattern.Reverb
                    (new DecoratorPattern.Flanger(new DecoratorPattern.GuitarAmp(new DecoratorPattern.Piano(sequenceOfFibunacci)))))));


        }

        long end = System.currentTimeMillis();

        spendTimePatternWithCalculatin = end - start;

    }

    static void measureTimeOfAntiPatternInnerclasses() { //try with inner klassen, Subclasses and Nested Classes and see the differences

        long start = System.currentTimeMillis();

        for (long i = 0; i < runsOfFunction; i++) {

            instrumentDecoratorAntiPatternInnerclasses = new DecoratorAntiPatternInnerclasses.MoogSynthesizer.GuitarAmp.Flange.Reverb.GuitarAmp2.
                    Flange2.Reverb2(new DecoratorAntiPatternInnerclasses.MoogSynthesizer());


            // instrumentDecoratorAntiPatternInnerclasses = new DecoratorAntiPatternInnerclasses.MoogSynthesizer.Equalize.Flange.Reverb.Equalize2.Flange2.Reverb2();

        }

        long end = System.currentTimeMillis();

        spendTimeAntiPatternInnerclasses = end - start;

    }

    static void measureTimeOfAntiPatternInnerclassesWithCalculation() { //try with inner klassen, Subclasses and Nested Classes and see the differences

        long start = System.currentTimeMillis();

        for (long i = 0; i < runsOfFunction; i++) {

            instrumentDecoratorAntiPatternInnerclassesWithCalculation = new DecoratorAntiPatternInnerclasses.Piano.GuitarAmp.Flange.Reverb.GuitarAmp2.Flange2.Reverb2(new DecoratorAntiPatternInnerclasses.Piano(sequenceOfFibunacci));

        }

        long end = System.currentTimeMillis();

        spendTimeAntiPatternInnerclassesWithCalculatin = end - start;

    }

    static void measureTimeOfAntiPatternSubclasses() { //try with inner klassen, Subclasses and Nested Classes and see the differences

        long start = System.currentTimeMillis();

        for (long i = 0; i < runsOfFunction; i++) {

            instrumentDecoratorAntiPatternSubclasses = new DecoratorAntiPatternSubclasses.GuitarAmpFlangerReverbGuitarAmpFlangerReverb(new DecoratorAntiPatternSubclasses.MoogSynthesizer());

        }

        long end = System.currentTimeMillis();

        spendTimeAntiPatternSubclasses = end - start;

    }

    static void measureTimeOfAntiPatternSubclassesWithCalculation() { //try with inner klassen, Subclasses and Nested Classes and see the differences

        long start = System.currentTimeMillis();

        for (long i = 0; i < runsOfFunction; i++) {

            instrumentDecoratorAntiPatternSubclassesWithCalculation = new DecoratorAntiPatternSubclasses.GuitarAmpFlangerReverbGuitarAmpFlangerReverb(new DecoratorAntiPatternSubclasses.Piano(sequenceOfFibunacci));

        }

        long end = System.currentTimeMillis();

        spendTimeAntiPatternSubclassesWithCalculatin = end - start;

    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            measureTimeOfPattern();
            measureTimeOfAntiPatternInnerclasses();
            measureTimeOfAntiPatternSubclasses();

            System.out.println("Runtime by the call of Pattern in MS:                  " + spendTimePattern);
            System.out.println("Runtime by the call of AntiPattern Innerclass in MS:   " + spendTimeAntiPatternInnerclasses);
            System.out.println("Runtime by the call of AntiPattern Subclass in MS:     " + spendTimeAntiPatternSubclasses + "\n");

        }

        System.out.println("Result from the Decoration of Pattern:                 " + instrumentDecoratorPattern.sound());
        System.out.println("Result from the Decoration of AntiPattern Innerclass:  " + instrumentDecoratorAntiPatternInnerclasses.sound());
        System.out.println("Result from the Decoration of AntiPattern Subclass:    " + instrumentDecoratorAntiPatternSubclasses.sound() + "\n_______________\n");

        for (int i = 0; i < 10; i++) {

            measureTimeOfPatternWithCalculation();
            measureTimeOfAntiPatternInnerclassesWithCalculation();
            measureTimeOfAntiPatternSubclassesWithCalculation();

            System.out.println("Runtime by the call of Pattern With Calculation in MS:                  " + spendTimePatternWithCalculatin);
            System.out.println("Runtime by the call of AntiPattern Innerclass With Calculation in MS:   " + spendTimeAntiPatternInnerclassesWithCalculatin);
            System.out.println("Runtime by the call of AntiPattern Subclass With Calculation in MS:     " + spendTimeAntiPatternSubclassesWithCalculatin + "\n");

        }

        System.out.println("Result from the Decoration of Pattern with Calculation:                 " + instrumentDecoratorPatternWithCalculation.sound());
        System.out.println("Result from the Decoration of AntiPattern Innerclass with Calculation:  " + instrumentDecoratorAntiPatternInnerclassesWithCalculation.sound());
        System.out.println("Result from the Decoration of AntiPattern Subclass with Calculation:    " + instrumentDecoratorAntiPatternSubclassesWithCalculation.sound());


    }


}
