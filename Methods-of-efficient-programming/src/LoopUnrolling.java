public class LoopUnrolling {

    static long runsOfFunction = 99999999l; //that the time to call is bigger enough to measure
    static long i;

    static long spendTimeLoop;
    static long spendTimeLoopUnrolling;

    static int[] loopArray = new int[5];
    static int[] loopUnrollingArray = new int[5];
    static int currentValue = 1;

    static void loop() {

        for (int i = 0; i <= 4; i++) {
            loopArray[i] = currentValue;
        }

    }

    static void loopUnrolling() {

        loopUnrollingArray[0] = currentValue;
        loopUnrollingArray[1] = currentValue;
        loopUnrollingArray[2] = currentValue;
        loopUnrollingArray[3] = currentValue;
        loopUnrollingArray[4] = currentValue;

    }

    static void measureTimeOfLoop() {

        long start = System.currentTimeMillis();

        for (i = 0; i < runsOfFunction; i++) {
            loop();
        }

        long end = System.currentTimeMillis();

        spendTimeLoop = end - start;


    }

    static void measureTimeOfLoopUnrolling() {

        long start = System.currentTimeMillis();

        for (i = 0; i < runsOfFunction; i++) {
            loopUnrolling();
        }

        long end = System.currentTimeMillis();

        spendTimeLoopUnrolling = end - start;

    }


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            measureTimeOfLoop();
            measureTimeOfLoopUnrolling();

            System.out.println("\nRuntime in MS by Loop Rolling:   " + spendTimeLoop);
            System.out.println("Runtime in MS by Loop Unrolling: " + spendTimeLoopUnrolling);

        }

    }
}
