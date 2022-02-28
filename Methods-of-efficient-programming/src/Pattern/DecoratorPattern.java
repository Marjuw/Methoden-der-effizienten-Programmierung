package Pattern;

public class DecoratorPattern {


    public interface Instrument { // Component

        String sound();

    }

    public static class MoogSynthesizer implements Instrument {  // Conrete Component

        @Override
        public String sound() {
            return "Moog Synthesizer ";
        }

    }

    public static class Piano implements Instrument {  // Conrete Component

        static String pianosound = "Piano ";

        int sequenceOfFibunacci; //that the time to call is bigger enough to measure
        long fibunacciResult;

        public Piano(int sequenceOfFibunacci) {

            this.sequenceOfFibunacci = sequenceOfFibunacci;
            this.fibunacciResult = fibunacci(sequenceOfFibunacci);

        }

        public static long fibunacci(int n) {  //ohne Caching

            if (n == 1 || n == 2) {
                return 1;
            } else {
                return fibunacci(n - 1) + fibunacci(n - 2);
            }

        }

        @Override
        public String sound() {

            return "Piano " + "calculated Fibunacci: " + fibunacciResult;
        }

    }

    public static class guitar implements Instrument {  // Conrete Component

        @Override
        public String sound() {
            return "Guitar ";
        }
    }

    public static abstract class SoundEffect implements Instrument {  //Abstract Decorater: Decorated the Sound of an Instrument

        protected Instrument instrument;

        public SoundEffect(Instrument instrument) {
            this.instrument = instrument;
        }

        @Override
        public abstract String sound();

    }

    public static class GuitarAmp extends SoundEffect { //Concrete Decorator

        public GuitarAmp(Instrument instrument) {
            super(instrument);
        }

        @Override
        public String sound() {
            return "amplify " + instrument.sound();
        }
    }

    public static class Reverb extends SoundEffect { //Concrete Decorator

        public Reverb(Instrument instrument) {
            super(instrument);
        }

        @Override
        public String sound() {
            return "reverb " + instrument.sound();
        }
    }

    public static class Flanger extends SoundEffect { //Concrete Decorator

        public Flanger(Instrument instrument) {
            super(instrument);
        }

        @Override
        public String sound() {
            return "flange " + instrument.sound();
        }
    }

    public static class Equalizer extends SoundEffect { //Concrete Decorator

        public Equalizer(Instrument instrument) {
            super(instrument);
        }

        @Override
        public String sound() {
            return "equalize " + instrument.sound();
        }
    }

}

