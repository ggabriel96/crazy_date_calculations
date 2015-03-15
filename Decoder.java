class Decoder {

    private static String[] options = {"segundo", "minuto", "hora", "dia", "semana", "mes", "ano"};

    // selects what conversion the decoder should do
    private int select(String[] s) {
        int i = 0;
        for (String op: options) {
            for (int j = 0; j < 3; j++) {
                if (s[j].contains(op)) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    // detects from what to convert from
    private Date detect(String[] s) {
        Date d = new Date();
        for (String op: options) {
            for (int j = 3; j < s.length; j++) {
                if (s[j].contains(op) && s[j - 1].matches("[0-9]+")) {
                    switch (op) {
                        case "segundo":
                            d.sec += Integer.parseInt(s[j - 1]);
                            break;
                        case "minuto":
                            d.min += Integer.parseInt(s[j - 1]);
                            break;
                        case "hora":
                            d.hour += Integer.parseInt(s[j - 1]);
                            break;
                        case "dia":
                            d.day += Integer.parseInt(s[j - 1]);
                            break;
                        case "semana":
                            d.week += Integer.parseInt(s[j - 1]);
                            break;
                        case "mes":
                            d.mon += Integer.parseInt(s[j - 1]);
                            break;
                        case "ano":
                            d.yr += Integer.parseInt(s[j - 1]);
                            break;
                    }
                }
            }
        }
        return d;
    }

    private double convert(int op, Date d) {
        switch (op) {
            case 0: return this.seconds(d);
            case 1: return this.minutes(d);
            case 2: return this.hours(d);
            case 3: return this.days(d);
            case 4: // semanas
                //return this.weeks(d);
                break;
            case 5: // meses
                //return this.months(d);
                break;
            case 6: // anos
                //return this.years(d);
                break;
        }
        return 0;
    }

    public int answer(String s) {
        String[] query = s.split(" ");
        int op = this.select(query);
        Date d = this.detect(query);
        double answ = this.convert(op, d);

        System.out.println("op: " + op + " | date: " + d);
        System.out.println("Answer: " + answ);

        return 0;
    }

    private int seconds(Date d) {
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

    private double minutes(Date d) {
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

    private double hours(Date d) {
        double h = 0.0;
        h += d.yr * 365 * 24;
        h += d.mon * 30 * 24;
        h += d.week * 7 * 24;
        h += d.day * 24;
        h += d.hour;
        h += d.min / 60.0;
        h += d.sec / 3600.0;
        return h;
    }

    private double days(Date d) {
        double b = 0.0;
        b += d.yr * 365;
        b += d.mon * 30;
        b += d.week * 7;
        b += d.day;
        b += d.hour / 24.0;
        b += d.min / 1440.0;
        b += d.sec / 86400.0;
        return b;
    }
}
