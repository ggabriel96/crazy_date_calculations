class Decoder {

    static String[] options = {"segundo", "minuto", "hora", "dia", "semana", "mes", "ano"};

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
                            d.seg += Integer.parseInt(s[j - 1]);
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

    public int answer(String s) {
        String[] query = s.split(" ");
        int op = this.select(query);
        Date d = this.detect(query);

        System.out.println(op + " " + d);

        return 0;
    }
}
