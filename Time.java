class Time {
    int hour, min, sec;
    int day, week, mon, yr;

    public String toString() {
        return "{" + this.yr + "y, " + this.mon + "m, " + this.week + "w, " +
        + this.day + "d, " + this.hour + "h, " + this.min + "m, " +
        + this.sec + "s" + "}";
    }

    public int toSeconds() {
        int s = 0;
        s += this.yr * 365 * 24 * 60 * 60;
        s += this.mon * 30 * 24 * 60 * 60;
        s += this.week * 7 * 24 * 60 * 60;
        s += this.day * 24 * 60 * 60;
        s += this.hour * 60 * 60;
        s += this.min * 60;
        s += this.sec;
        return s;
    }

    public double toMinutes() {
        double m = 0.0;
        m += this.yr * 365 * 24 * 60;
        m += this.mon * 30 * 24 * 60;
        m += this.week * 7 * 24 * 60;
        m += this.day * 24 * 60;
        m += this.hour * 60;
        m += this.min;
        m += this.sec / 60.0;
        return m;
    }

    public double toHours() {
        double h = 0.0;
        h += this.yr * 365 * 24;
        h += this.mon * 30 * 24;
        h += this.week * 7 * 24;
        h += this.day * 24;
        h += this.hour;
        h += this.min / 60.0;
        h += this.sec / 60.0 / 60.0;
        return h;
    }

    public double toDays() {
        double d = 0.0;
        d += this.yr * 365;
        d += this.mon * 30;
        d += this.week * 7;
        d += this.day;
        d += this.hour / 24.0;
        d += this.min / 60.0 / 24.0;
        d += this.sec / 60.0 / 60.0 / 24.0;
        return d;
    }

    public double toWeeks() {
        double w = 0.0;
        w += this.yr * 12 * 4;
        w += this.mon * 4;
        w += this.week;
        w += this.day / 7.0;
        w += this.hour / 24.0 / 7.0;
        w += this.min / 60.0 / 24.0 / 7.0;
        w += this.sec / 60.0 / 60.0 / 24.0 / 7.0;
        return w;
    }

    public double toMonths() {
        double m = 0.0;
        m += this.yr * 12;
        m += this.mon;
        m += this.week / 4.0;
        m += this.day / 30.0;
        m += this.hour / 24.0 / 30.0;
        m += this.min / 60.0 / 24.0 / 30.0;
        m += this.sec / 60.0 / 60.0 / 24.0 / 30.0;
        return m;
    }

    public double toYears() {
        double y = 0.0;
        y += this.yr;
        y += this.mon / 12.0;
        y += this.week / 4.0 / 12.0;
        y += this.day / 30.0 / 12.0;
        y += this.hour / 24.0 / 30.0 / 12.0;
        y += this.min / 60.0 / 24.0 / 30.0 / 12.0;
        y += this.sec / 60.0 / 60.0 / 24.0 / 30.0 / 12.0;
        return y;
    }
}
