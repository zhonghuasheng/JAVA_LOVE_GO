package com.zhonghuasheng.spring4.autowiringusingxml.constructor;

public class Performer {

    private Instrument instrument;

    public Performer(Instrument instrument) {
        this.instrument = instrument;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public String toString() {
        return "Performer [instrument=" + instrument + "]";
    }
}
