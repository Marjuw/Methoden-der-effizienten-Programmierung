public class Inlining {

    static long runs = 999999999l; //that the time to call is bigger enough to measure
    static int firstnumber = 5;
    static int secondnumber = 6;

    static long spendTimeInlining;
    static long spendTimeAntiInlining;


    static int quadrat(int x) {
        return x * x;
    }

    static int antiinline(int a, int b) {
        return quadrat(a) + quadrat(b);
    }

    static int inline(int a, int b) {
        return a * a + b * b;
    }


    static void measureTimeOfAntiInlining() {

        long start = System.currentTimeMillis();

        for (long i = 0; i < runs; i++) {
            antiinline(firstnumber, secondnumber);
        }

        long end = System.currentTimeMillis();

        spendTimeAntiInlining = end - start;

    }

    static void measureTimeOfInlining() {

        long start = System.currentTimeMillis();

        for (long i = 0; i < runs; i++) {
            inline(firstnumber, secondnumber);
        }

        long end = System.currentTimeMillis();

        spendTimeInlining = end - start;

    }


    public static void main(String[] args) {

        // System.out.println("Result:");
        for (int i = 0; i < 10; i++) {


            measureTimeOfInlining();
            measureTimeOfAntiInlining();

            System.out.println("\nRuntime from Anti-Inlining in MS:  " + spendTimeAntiInlining);
            System.out.println("Runtime from Inlining in MS:       " + spendTimeInlining);

        }

    }
}
