class Decoder {

    private static String[] options =
    {"segundo", "minuto", "hora", "dia", "semana", "mes", "ano"};

    private static boolean equiv(String r, String s) {
        int len = Math.min(r.length(), s.length());
        return r.regionMatches(true, 0, s, 0, len);
    }

    public double answer(String s, boolean print) {
        String[] query = s.split(" ");
        int op = this.select(query);
        Time d = this.detect(query);
        double answ = this.convert(op, d);

        //System.out.println("op: " + op + " | date: " + d);
        if (print) {
            System.out.print(answ);
            System.out.print(" " + options[op]);
            if (Double.compare(answ, 1.0) != 0) {
                if (op == 5) System.out.println("es");
                else System.out.println("s");
            }
            else System.out.println();
        }

        return answ;
    }

    // selects what conversion the decoder should do
    private int select(String[] s) {
        int i;
        for (String subs: s) {
            i = 0;
            for (String op: options) {
                if (Decoder.equiv(subs, op)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    // detects from what to convert from
    private Time detect(String[] s) {
        boolean first = true;
        Time d = new Time();
        for (int i = 0; i < s.length; i++) {
            for (String op: options) {
                if (!first && Decoder.equiv(s[i], op) && s[i - 1].matches("[0-9]+")) {
                    switch (op) {
                        case "segundo":
                            d.sec += Integer.parseInt(s[i - 1]);
                            break;
                        case "minuto":
                            d.min += Integer.parseInt(s[i - 1]);
                            break;
                        case "hora":
                            d.hour += Integer.parseInt(s[i - 1]);
                            break;
                        case "dia":
                            d.day += Integer.parseInt(s[i - 1]);
                            break;
                        case "semana":
                            d.week += Integer.parseInt(s[i - 1]);
                            break;
                        case "mes":
                            d.mon += Integer.parseInt(s[i - 1]);
                            break;
                        case "ano":
                            d.yr += Integer.parseInt(s[i - 1]);
                            break;
                    }
                }
                else if (first && Decoder.equiv(s[i], op)) {
                    first = false;
                }
            }
        }
        return d;
    }

    private double convert(int op, Time d) {
        switch (op) {
            case 0: return this.seconds(d);
            case 1: return this.minutes(d);
            case 2: return this.hours(d);
            case 3: return this.days(d);
            case 4: return this.weeks(d);
            case 5: return this.months(d);
            case 6: return this.years(d);
        }
        return 0;
    }

    private int seconds(Time d) {
        int s = 0;
        s += d.yr * 365 * 24 * 60 * 60;
        s += d.mon * 30 * 24 * 60 * 60;
        s += d.week * 7 * 24 * 60 * 60;
        s += d.day * 24 * 60 * 60;
        s += d.hour * 60 * 60;
        s += d.min * 60;
        s += d.sec;
        return s;
    }

    private double minutes(Time d) {
        double m = 0.0;
        m += d.yr * 365 * 24 * 60;
        m += d.mon * 30 * 24 * 60;
        m += d.week * 7 * 24 * 60;
        m += d.day * 24 * 60;
        m += d.hour * 60;
        m += d.min;
        m += d.sec / 60.0;
        return m;
    }

    private double hours(Time d) {
        double h = 0.0;
        h += d.yr * 365 * 24;
        h += d.mon * 30 * 24;
        h += d.week * 7 * 24;
        h += d.day * 24;
        h += d.hour;
        h += d.min / 60.0;
        h += d.sec / 60.0 / 60.0;
        return h;
    }

    private double days(Time d) {
        double b = 0.0;
        b += d.yr * 365;
        b += d.mon * 30;
        b += d.week * 7;
        b += d.day;
        b += d.hour / 24.0;
        b += d.min / 60.0 / 24.0;
        b += d.sec / 60.0 / 60.0 / 24.0;
        return b;
    }

    private double weeks(Time d) {
        double w = 0.0;
        w += d.yr * 12 * 4;
        w += d.mon * 4;
        w += d.week;
        w += d.day / 7.0;
        w += d.hour / 24.0 / 7.0;
        w += d.min / 60.0 / 24.0 / 7.0;
        w += d.sec / 60.0 / 60.0 / 24.0 / 7.0;
        return w;
    }

    private double months(Time d) {
        double m = 0.0;
        m += d.yr * 12;
        m += d.mon;
        m += d.week / 4.0;
        m += d.day / 30.0;
        m += d.hour / 24.0 / 30.0;
        m += d.min / 60.0 / 24.0 / 30.0;
        m += d.sec / 60.0 / 60.0 / 24.0 / 30.0;
        return m;
    }

    private double years(Time d) {
        double y = 0.0;
        y += d.yr;
        y += d.mon / 12.0;
        y += d.week / 4.0 / 12.0;
        y += d.day / 30.0 / 12.0;
        y += d.hour / 24.0 / 30.0 / 12.0;
        y += d.min / 60.0 / 24.0 / 30.0 / 12.0;
        y += d.sec / 60.0 / 60.0 / 24.0 / 30.0 / 12.0;
        return y;
    }
}
