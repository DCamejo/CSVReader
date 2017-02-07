import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringJoiner;

public class StraightAs {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            /* Violation: over 80 characters */
            System.out.println("Welcome to Java. "
                + "Are you ready to take on the challenge?"
                + "\n" + "Make sure you read and fully understand the "
                + "provided instructions and the comments in this file "
                + "to ensure you get full credit for your work.");

        } else if (args.length == 3) {
            processGradesFromFile(args[0], args[1], args[2]);
        }
    }


    /**
     * This method will create a grade histogram from a given csv file.
     *
     * @param filename      the filename of the CSV file to read and process
     *                      data from
     * @param separator     the CSV file's given data separator. 
     *
     * @param displayMode   the type of output your program should show. We
     *                      define three modes: TABLE, HIST, and BOTH. 
     */
    public static void processGradesFromFile(
        String filename, String separator, String displayMode)
        throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = "";
        int[] gradeCounter = new int[10];

        if (displayMode.equals("TABLE")) {
            while ((line = reader.readLine()) != null) {
                String[] segment = line.split(separator);
                segment[0] = segment[0].replace(" ", "");
                segment[1] = segment[1].replace(" ", "");
                System.out.printf("%-10s%4s\n", segment[0], segment[1]);
            }
        } else if (displayMode.equals("HIST")) {
            String[] label = new String[10]; //Holds labels for histogram
            label[0] = " 1- 10";
            label[1] = "11- 20";
            label[2] = "21- 30";
            label[3] = "31- 40";
            label[4] = "41- 50";
            label[5] = "51- 60";
            label[6] = "61- 70";
            label[7] = "71- 80";
            label[8] = "81- 90";
            label[9] = "91-100";

            while ((line = reader.readLine()) != null) {
                String[] segment = line.split(separator);
                segment[0] = segment[0].replace(" ", "");
                segment[1] = segment[1].replace(" ", "");
                int x = Integer.parseInt(segment[1]);
                //Histogram analysis block
                if (x > 0 && x <= 10) {
                    gradeCounter[0] += 1;
                } else if (x > 10 && x <= 20) {
                    gradeCounter[1] += 1;
                } else if (x > 20 && x <= 30) {
                    gradeCounter[2] += 1;
                } else if (x > 30 && x <= 40) {
                    gradeCounter[3] += 1;
                } else if (x > 40 && x <= 50) {
                    gradeCounter[4] += 1;
                } else if (x > 50 && x <= 60) {
                    gradeCounter[5] += 1;
                } else if (x > 60 && x <= 70) {
                    gradeCounter[6] += 1;
                } else if (x > 70 && x <= 80) {
                    gradeCounter[7] += 1;
                } else if (x > 80 && x <= 90) {
                    gradeCounter[8] += 1;
                } else if (x > 90 && x <= 100) {
                    gradeCounter[9] += 1;
                }
            }
            for (int i = 9; i >= 0; i--) {
                System.out.printf("%-6s | %-1s\n",
                    label[i], addPip(gradeCounter[i]));
            }
        } else if (displayMode.equals("BOTH")) {
            String[] label = new String[10]; //Holds labels for histogram
            label[0] = "1 - 10";
            label[1] = "11 - 20";
            label[2] = "21 - 30";
            label[3] = "31 - 40";
            label[4] = "41 - 50";
            label[5] = "51 - 60";
            label[6] = "61 - 70";
            label[7] = "71 - 80";
            label[8] = "81 - 90";
            label[9] = "91 - 100";

            while ((line = reader.readLine()) != null) {
                String[] segment = line.split(separator);
                segment[0] = segment[0].replace(" ", "");
                segment[1] = segment[1].replace(" ", "");
                System.out.printf("%-10s%4s\n", segment[0], segment[1]);
                int x = Integer.parseInt(segment[1]);
                //Histogram analysis block
                if (x > 0 && x <= 10) {
                    gradeCounter[0] += 1;
                } else if (x > 10 && x <= 20) {
                    gradeCounter[1] += 1;
                } else if (x > 20 && x <= 30) {
                    gradeCounter[2] += 1;
                } else if (x > 30 && x <= 40) {
                    gradeCounter[3] += 1;
                } else if (x > 40 && x <= 50) {
                    gradeCounter[4] += 1;
                } else if (x > 50 && x <= 60) {
                    gradeCounter[5] += 1;
                } else if (x > 60 && x <= 70) {
                    gradeCounter[6] += 1;
                } else if (x > 70 && x <= 80) {
                    gradeCounter[7] += 1;
                } else if (x > 80 && x <= 90) {
                    gradeCounter[8] += 1;
                } else if (x > 90 && x <= 100) {
                    gradeCounter[9] += 1;
                }
            }
            for (int i = 9; i >= 0; i--) {
                System.out.printf("%-6s | %-1s\n",
                    label[i], addPip(gradeCounter[i]));
            }
        }


    }

    /**
    *Adds a pip to the histogram whenever called. Mostly a helper function.
    *
    *@param integer, number of pips to be added
    *
    *@return string, or the pip.
    */
    public static String addPip(int count) {
        StringJoiner graph = new StringJoiner("");

        for (int i = 0; i < count; i++) {
            graph.add("[]");
        }

        String result = graph.toString();
        return result;
    }
}

/*---Previous versions---*/

   // V.1 - Using arrays to store information, then print said arrays
        /*
        Scanner sc = new Scanner(new File(filename));
        sc.useDelimiter(separator);

        if (displayMode.equals("TABLE")) {
            String[] stringArray = new String[100];
            String[] intArray = new String[100];
            int counter = 0;

            while(sc.hasNext()) {
                counter++;

                stringArray[counter] = sc.next();
                intArray[counter] = sc.next();

                System.out.printf("%-10s %3s",
                    stringArray[counter], intArray[counter]);
            }
        } else if (displayMode.equals("HIST")) {
            while(sc.hasNext()) {
                int data = sc.nextInt();
                System.out.println(data);

            }
        }

        sc.close();
        */

    // V.2 - Using buckets, counters, and int parsses to try to extract ints
        /*
        Scanner sc = new Scanner(new File(filename));
        String[] intArray = new String[500];

        //Bucket arrays. Number represents which margin they represent.
        String[] trash = new String[500];
        int trashCounter = 0;

        //Counters for each bucket.
        int counter110 = 0;
        int counter1120 = 0;
        int counter2130 = 0;
        int counter3140 = 0;
        int counter4150 = 0;
        int counter5160 = 0;
        int counter6170 = 0;
        int counter7180 = 0;
        int counter8190 = 0;
        int counter91100 = 0;

        int counter = 0;
        sc.useDelimiter(separator);

        if (displayMode.equals("TABLE")) {
            while(sc.hasNext()) {
                System.out.printf("%-15s", sc.next());
            }
        } else if (displayMode.equals("HIST")) {
            while(sc.hasNext()) {
                intArray[counter] = sc.next();
                counter++;
                System.out.println(intArray[counter]);

                for (int i = 0; i < counter; i++) {
                    int parsedInt = Integer.parseInt(intArray[i]);

                    if (parsedInt < 10) {
                        counter110++;
                    } else if (parsedInt > 11 && parsedInt < 20) {
                        counter1120++;
                    } else if (parsedInt > 21 && parsedInt < 30) {
                        counter2130++;
                    } else if (parsedInt > 31 && parsedInt < 40) {
                        counter3140++;
                    } else if (parsedInt > 41 && parsedInt < 50) {
                        counter4150++;
                    } else if (parsedInt > 51 && parsedInt < 60) {
                        counter5160++;
                    } else if (parsedInt > 61 && parsedInt < 70) {
                        counter6170++;
                    } else if (parsedInt > 71 && parsedInt < 80) {
                        counter7180++;
                    } else if (parsedInt > 81 && parsedInt < 90) {
                        counter8190++;
                    } else if (parsedInt > 91 && parsedInt < 100) {
                        counter91100++;
                    }
                }
            System.out.println(counter110);
            System.out.println(counter1120);
            System.out.println(counter2130);
            System.out.println(counter3140);
            System.out.println(counter4150);
            System.out.println(counter5160);
            System.out.println(counter6170);
            System.out.println(counter7180);
            System.out.println(counter8190);
            System.out.println(counter91100);

            }



        }
        */

    // V.3 - Trying again, using BufferedReader (Thanks StackOverflow + API!).
    //          Also, histogram stores data using counters.
