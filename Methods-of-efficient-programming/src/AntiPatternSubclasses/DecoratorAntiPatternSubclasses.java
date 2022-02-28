package AntiPatternSubclasses;

public class DecoratorAntiPatternSubclasses {


    public interface Instrument { // Component

        String sound();

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

    public static class MoogSynthesizer implements Instrument {  // Conrete Component

        static String moogsound = "Moog Synthesizer ";

        @Override
        public String sound() {
            return moogsound;
        }

    }

    public static class GuitarAmp implements Instrument { //Subclass to decorate an MoogSynthesizer

        protected Instrument instrument;

        public GuitarAmp(Instrument instrument) {
            this.instrument = instrument;
        }

        @Override
        public String sound() {
            return "amplify " + instrument.sound();
        }

    }

    public static class GuitarAmpFlanger extends GuitarAmp { //Subclass to decorate an MoogSynthesizer

        public GuitarAmpFlanger(Instrument instrument) {
            super(instrument);
        }

        protected Instrument instrument;

        @Override
        public String sound() {
            return "flange " + super.sound();
        }

    }

    public static class GuitarAmpFlangerReverb extends GuitarAmpFlanger { //Subclass to decorate an MoogSynthesizer

        public GuitarAmpFlangerReverb(Instrument instrument) {
            super(instrument);
        }

        protected Instrument instrument;

        @Override
        public String sound() {
            return "reverb " + super.sound();
        }

    }

    public static class GuitarAmpFlangerReverbGuitarAmp extends GuitarAmpFlangerReverb { //Subclass to decorate an MoogSynthesizer

        public GuitarAmpFlangerReverbGuitarAmp(Instrument instrument) {
            super(instrument);
        }

        protected Instrument instrument;

        @Override
        public String sound() {
            return "amplify " + super.sound();
        }

    }

    public static class GuitarAmpFlangerReverbGuitarAmpFlanger extends GuitarAmpFlangerReverbGuitarAmp { //Subclass to decorate an MoogSynthesizer

        public GuitarAmpFlangerReverbGuitarAmpFlanger(Instrument instrument) {
            super(instrument);
        }

        protected Instrument instrument;

        @Override
        public String sound() {
            return "flange " + super.sound();
        }

    }

    public static class GuitarAmpFlangerReverbGuitarAmpFlangerReverb extends GuitarAmpFlangerReverbGuitarAmpFlanger { //Subclass to decorate an MoogSynthesizer

        public GuitarAmpFlangerReverbGuitarAmpFlangerReverb(Instrument instrument) {
            super(instrument);
        }

        protected Instrument instrument;

        @Override
        public String sound() {
            return "reverb " + super.sound();
        }

    }


}

