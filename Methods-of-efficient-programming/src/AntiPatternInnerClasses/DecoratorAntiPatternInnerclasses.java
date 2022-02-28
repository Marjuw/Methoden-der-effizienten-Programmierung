package AntiPatternInnerClasses;

public class DecoratorAntiPatternInnerclasses {


    public static interface Instrument { // Component

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

        public static class GuitarAmp implements Instrument { //Inner Class to decorate an MoogSynthesizer

            protected Instrument instrument;

            public GuitarAmp(Instrument instrument) {
                this.instrument = instrument;
            }

            static String guitarsound = "amplify ";

            @Override
            public String sound() {
                return guitarsound + instrument.sound();
            }

            public static class Flange extends MoogSynthesizer.GuitarAmp { // Inner Class of an Inner Class to decorate the decorator of an MoogSynthesizer

                public Flange(Instrument instrument) {
                    super(instrument);
                }

                static String flangesound = "flange ";

                @Override
                public String sound() {
                    return flangesound + super.sound();
                }

                public static class Reverb extends Flange {

                    public Reverb(Instrument instrument) {
                        super(instrument);
                    }

                    static String reverbsound = "reverb ";

                    @Override
                    public String sound() {
                        return reverbsound + super.sound();
                    }

                    public static class GuitarAmp2 extends Reverb { //Inner Class to decorate an MoogSynthesizer

                        public GuitarAmp2(Instrument instrument) {
                            super(instrument);
                        }

                        static String guitarsound_2 = "amplify ";

                        @Override
                        public String sound() {
                            return guitarsound_2 + super.sound();
                        }

                        public static class Flange2 extends GuitarAmp2 { // Inner Class of an Inner Class to decorate the decorator of an MoogSynthesizer

                            public Flange2(Instrument instrument) {
                                super(instrument);
                            }

                            static String flangesound_2 = "flange ";

                            @Override
                            public String sound() {
                                return flangesound_2 + super.sound();
                            }

                            public static class Reverb2 extends Flange2 {

                                public Reverb2(Instrument instrument) {
                                    super(instrument);
                                }

                                static String reverbsound_2 = "reverb ";

                                @Override
                                public String sound() {
                                    return reverbsound_2 + super.sound();
                                }

                            }
                        }
                    }

                }

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

        public static class GuitarAmp implements Instrument { //Inner Class to decorate an MoogSynthesizer

            protected Instrument instrument;

            public GuitarAmp(Instrument instrument) {
                this.instrument = instrument;
            }

            static String guitarsound = "amplify ";

            @Override
            public String sound() {
                return guitarsound + instrument.sound();
            }

            public static class Flange extends GuitarAmp { // Inner Class of an Inner Class to decorate the decorator of an MoogSynthesizer

                public Flange(Instrument instrument) {
                    super(instrument);
                }

                static String flangesound = "flange ";

                @Override
                public String sound() {
                    return flangesound + super.sound();
                }

                public static class Reverb extends Flange {

                    public Reverb(Instrument instrument) {
                        super(instrument);
                    }

                    static String reverbsound = "reverb ";

                    @Override
                    public String sound() {
                        return reverbsound + super.sound();
                    }

                    public static class GuitarAmp2 extends Reverb { //Inner Class to decorate an MoogSynthesizer

                        public GuitarAmp2(Instrument instrument) {
                            super(instrument);
                        }

                        static String guitarsound_2 = "amplify ";

                        @Override
                        public String sound() {
                            return guitarsound_2 + super.sound();
                        }

                        public static class Flange2 extends GuitarAmp2 { // Inner Class of an Inner Class to decorate the decorator of an MoogSynthesizer

                            public Flange2(Instrument instrument) {
                                super(instrument);
                            }

                            static String flangesound_2 = "flange ";

                            @Override
                            public String sound() {
                                return flangesound_2 + super.sound();
                            }

                            public static class Reverb2 extends Flange2 {

                                public Reverb2(Instrument instrument) {
                                    super(instrument);
                                }

                                static String reverbsound_2 = "reverb ";

                                @Override
                                public String sound() {
                                    return reverbsound_2 + super.sound();
                                }

                            }
                        }
                    }

                }

            }
        }

        public static class Equalize implements Instrument { //Inner Class to decorate an MoogSynthesizer

            protected Instrument instrument;

            public Equalize(Instrument instrument) {
                this.instrument = instrument;
            }

            static String equalize = "equalize ";

            @Override
            public String sound() {
                return equalize + instrument.sound();
            }

            public static class Flange extends Equalize { // Inner Class of an Inner Class to decorate the decorator of an MoogSynthesizer

                public Flange(Instrument instrument) {
                    super(instrument);
                }


                static String flangesound = "flange ";

                @Override
                public String sound() {
                    return flangesound + super.sound();
                }

                public static class Reverb extends Flange {

                    public Reverb(Instrument instrument) {
                        super(instrument);
                    }

                    static String reverbsound = "reverb ";

                    @Override
                    public String sound() {
                        return reverbsound + super.sound();
                    }

                    public static class Equalize2 extends Reverb { //Inner Class to decorate an MoogSynthesizer

                        public Equalize2(Instrument instrument) {
                            super(instrument);
                        }

                        static String equalize_2 = "equalize ";

                        @Override
                        public String sound() {
                            return equalize_2 + super.sound();
                        }

                        public static class Flange2 extends Equalize2 { // Inner Class of an Inner Class to decorate the decorator of an MoogSynthesizer

                            public Flange2(Instrument instrument) {
                                super(instrument);
                            }

                            static String flangesound_2 = "flange ";

                            @Override
                            public String sound() {
                                return flangesound_2 + super.sound();
                            }

                            public static class Reverb2 extends Flange2 {

                                public Reverb2(Instrument instrument) {
                                    super(instrument);
                                }

                                static String reverbsound_2 = "reverb ";

                                @Override
                                public String sound() {
                                    return reverbsound_2 + super.sound();
                                }

                            }
                        }
                    }

                }

            }
        }

        @Override
        public String sound() {
            return moogsound;
        }

    }

}

