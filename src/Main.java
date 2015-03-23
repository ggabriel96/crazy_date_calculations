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

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        boolean exit = false;
        Scanner s = new Scanner(System.in);
        Decoder dec = new Decoder();
        String query;

        System.out.println("Type 'exit', 'quit' or 'q' to terminate the program.");

        while (!exit) {
            System.out.print("\n> ");
            query = s.nextLine();
            if (query.equalsIgnoreCase("exit") ||
                query.equalsIgnoreCase("quit") ||
                query.equalsIgnoreCase("q"))
            {
                exit = true;
            }
            else dec.answer(query, true);
        }
        s.close();
    }
}
