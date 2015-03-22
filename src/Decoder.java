/*
 * This file is part of crazy_time_calculations.
 *
 *  crazy_time_calculations is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  crazy_time_calculations is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with crazy_time_calculations. If not, see <http://www.gnu.org/licenses/>.
 */

class Decoder {

    private static final String[] options =
    {"segundo", "minuto", "hora", "dia", "semana", "mes", "ano"};

    private static boolean equiv(String r, String s) {
        return r.regionMatches(true, 0, s, 0, s.length());
    }

    public double answer(String s, boolean print) {
        String[] query = s.split(" ");
        int op = this.select(query);
        Time d = this.detect(query);
        double answ = this.convert(op, d);

        System.out.println("date: " + d + ", op: " + op);
        if (op >= 0 && print) {
            System.out.print(answ);
            System.out.print(" " + options[op]);
            if (Double.compare(answ, 1.0) != 0) {
                if (op == 5) System.out.println("es");
                else System.out.println("s");
            }
            else System.out.println();
        }
        else if (print) {
            System.out.println("# Invalid input.");
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
                else i++;
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
                if (!first && Decoder.equiv(s[i], op) && s[i - 1].matches(fpRegex)) {
                    switch (op) {
                        case "segundo":
                            d.sec += Double.parseDouble(s[i - 1]);
                            break;
                        case "minuto":
                            d.min += Double.parseDouble(s[i - 1]);
                            break;
                        case "hora":
                            d.hour += Double.parseDouble(s[i - 1]);
                            break;
                        case "dia":
                            d.day += Double.parseDouble(s[i - 1]);
                            break;
                        case "semana":
                            d.week += Double.parseDouble(s[i - 1]);
                            break;
                        case "mes":
                            d.mon += Double.parseDouble(s[i - 1]);
                            break;
                        case "ano":
                            d.yr += Double.parseDouble(s[i - 1]);
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

    /* Floating-point regex taken from: http://docs.oracle.com/javase/8/docs/api/java/lang/Double.html#valueOf-java.lang.String- */
    final String Digits     = "(\\p{Digit}+)";
    final String HexDigits  = "(\\p{XDigit}+)";
    // an exponent is 'e' or 'E' followed by an optionally
    // signed decimal integer.
    final String Exp        = "[eE][+-]?"+Digits;
    public final String fpRegex    =
        ("[\\x00-\\x20]*"+  // Optional leading "whitespace"
        "[+-]?(" + // Optional sign character
        "NaN|" +           // "NaN" string
        "Infinity|" +      // "Infinity" string

        // A decimal floating-point string representing a finite positive
        // number without a leading sign has at most five basic pieces:
        // Digits . Digits ExponentPart FloatTypeSuffix
        //
        // Since this method allows integer-only strings as input
        // in addition to strings of floating-point literals, the
        // two sub-patterns below are simplifications of the grammar
        // productions from section 3.10.2 of
        // The Java Language Specification.

        // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
        "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+

        // . Digits ExponentPart_opt FloatTypeSuffix_opt
        "(\\.("+Digits+")("+Exp+")?)|"+

        // Hexadecimal strings
        "((" +
        // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
        "(0[xX]" + HexDigits + "(\\.)?)|" +

        // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
        "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

        ")[pP][+-]?" + Digits + "))" +
        "[fFdD]?))" +
        "[\\x00-\\x20]*");// Optional trailing "whitespace"
}
