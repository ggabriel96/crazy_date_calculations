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

        //System.out.println("date: " + d);
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
            case 0: return d.toSeconds();
            case 1: return d.toMinutes();
            case 2: return d.toHours();
            case 3: return d.toDays();
            case 4: return d.toWeeks();
            case 5: return d.toMonths();
            case 6: return d.toYears();
        }
        return 0;
    }
}
