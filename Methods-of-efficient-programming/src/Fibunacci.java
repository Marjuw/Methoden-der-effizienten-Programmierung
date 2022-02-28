public class Fibunacci {

    static long spendTimeFibunacci;
    static long spendTimeFibunacciCaching;
    static long spendTimeFibunacciIterativ;

    static int sequenceOfFibunacci = 47; //that the time to call is bigger enough to measure


    static long fibunacci(int n) {  //ohne Caching

        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibunacci(n - 1) + fibunacci(n - 2);
        }

    }

    static long fibunacciIterative(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }
        int fib = 1;
        int prevFib = 1;

        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }


    static long fibunacciCaching(int n, long[] hashMap) {  //O(n) with Hashmap caching

        if (n == 1 || n == 2) {
            return 1;
        }

        if (hashMap[n] != 0) { //if the Hashmap saved something already
            return hashMap[n];
        } else {
            hashMap[n] = fibunacciCaching(n - 1, hashMap) + fibunacciCaching(n - 2, hashMap);
            return hashMap[n];
        }

    }


    static long callFibunacciCaching(int n) {

        return fibunacciCaching(n, new long[n + 1]);

    }


    static void measureTimeOfFibunacci() {

        long start = System.currentTimeMillis();

        long fibunacciResult = fibunacci(sequenceOfFibunacci);

        long end = System.currentTimeMillis();

        spendTimeFibunacci = end - start;

        System.out.println("Fibunacci Result: " + fibunacciResult);

    }

    static void measureTimeOfFibunacciCaching() {

        long start = System.currentTimeMillis();

        long fibunacciCachingResult = callFibunacciCaching(sequenceOfFibunacci);

        long end = System.currentTimeMillis();

        spendTimeFibunacciCaching = end - start;

        System.out.println("Fibunacci Caching Result: " + fibunacciCachingResult);

    }


    static void measureTimeOfFibunacciIterativ() {

        long start = System.currentTimeMillis();

        long fibunacciIterativResult = fibunacciIterative(sequenceOfFibunacci);

        long end = System.currentTimeMillis();

        spendTimeFibunacciCaching = end - start;

        System.out.println("Fibunacci Iterativ Result: " + fibunacciIterativResult);

    }

    public static void main(String[] args) {

        measureTimeOfFibunacci();
        measureTimeOfFibunacciCaching();
        measureTimeOfFibunacciIterativ();

        System.out.println("\nRuntime in MS by Fibunacci:  " + spendTimeFibunacci);
        System.out.println("Runtime in MS by Fibunacci with Caching:  " + spendTimeFibunacciCaching);
        System.out.println("Runtime in MS by Fibunacci iterativ:  " + spendTimeFibunacciIterativ);

    }

}




