/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    File:     ListManager.java                         Date:   March 3, 2019
  Author:     Gian Esteves                             APCS Period 8, Hanley
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Collections;

public class ListManager {

    public static Scanner input = new Scanner(System.in);

    // Create an ArrayList object
    public static ArrayList<Team> teams = new ArrayList<Team>();

    public static void main(String[] args) throws IOException {
        run();
    }

    public static void run() throws IOException {
        int choice;

        read();

        System.out.println("----------------------------------------");
        System.out.println("Welcome to the Counter-Strike Global Offensive Team List");
        System.out.println("----------------------------------------");

        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Make a selection");
            System.out.println("----------------------------------------");
            System.out.println("1 - Display");
            System.out.println("2 - Add Team");
            System.out.println("3 - Remove Team");
            System.out.println("4 - Edit");
            System.out.println("5 - Sort");
            System.out.println("6 - Save");
            System.out.println("7 - Exit");
            System.out.println("----------------------------------------");

            choice = input.nextInt();

            if (choice == 1) {
                display(teams);
                System.out.println("");
            } else if (choice == 2) {
                teams.add(add());
            } else if (choice == 3) {
                remove();
            } else if (choice == 4) {
                edit();
            } else if (choice == 5) {
                sort();
            } else if (choice == 6) {
                save();
            } else if (choice == 7) {
                exit();
            }

        }
    }

    public static void read() throws IOException {
        String tname;
        String p1;
        String p2;
        String p3;
        String p4;
        String p5;
        String country;
        double wr;
        int rank;

        try {
            BufferedReader input = new BufferedReader(new FileReader("teams.txt"));

            String line;
            //Attempt to read from the file
            line = input.readLine();
            while (line != null) //goes to the end of file
            {
                StringTokenizer st = new StringTokenizer(line, "|"); //| is the delimiter
                //Now break up the line
                tname = st.nextToken();
                p1 = st.nextToken();
                p2 = st.nextToken();
                p3 = st.nextToken();
                p4 = st.nextToken();
                p5 = st.nextToken();
                country = st.nextToken();
                wr = Double.parseDouble(st.nextToken());
                rank = Integer.parseInt(st.nextToken());

                Team t = new Team(tname, p1, p2, p3, p4, p5, country, wr, rank);
                teams.add(t);
                line = input.readLine();
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public static void display(ArrayList<Team> teams) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                                  CSGO TEAMS");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.format("%-20s", "Team");
        System.out.format("%-20s", "Player 1");
        System.out.format("%-20s", "Player 2");
        System.out.format("%-20s", "Player 3");
        System.out.format("%-20s", "Player 4");
        System.out.format("%-20s", "Player 5");
        System.out.format("%-20s", "Country");
        System.out.format("%-20s", "Winrate");
        System.out.format("%-20s", "Rank");
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------");

        for (Team t : teams) {
            System.out.println("");
            System.out.format("%-20s", t.getName());

            for (int i = 0; i < 5; i++) {
                System.out.format("%-20s", t.getPlayer(i));
            }

            System.out.format("%-20s", t.getCountry());
            System.out.format("%-20s", t.getWinrate());
            System.out.format("%-20s", t.getRanking());
        }
    }

    public static Team add() {
        Scanner input = new Scanner(System.in);

        String tname;
        String p1;
        String p2;
        String p3;
        String p4;
        String p5;
        String country;
        double wr;
        int rank;

        System.out.println("Please insert the team name");
        tname = input.nextLine();
        System.out.println("Please input the first player");
        p1 = input.nextLine();
        System.out.println("Please input the second player");
        p2 = input.nextLine();
        System.out.println("Please input the third player");
        p3 = input.nextLine();
        System.out.println("Please input the fourth player");
        p4 = input.nextLine();
        System.out.println("Please input the fifth player");
        p5 = input.nextLine();
        System.out.println("Please input the country/region");
        country = input.nextLine();
        System.out.println("Please input the winrate");
        wr = input.nextDouble();
        System.out.println("Please input the ranking");
        rank = input.nextInt();

        Team t = new Team(tname, p1, p2, p3, p4, p5, country, wr, rank);

        return t;

    }

    public static void remove() {
        int i;

        System.out.println("Which team would you like to remove?");
        i = input.nextInt() - 1;

        teams.remove(i);

        System.out.println("Team succesfully removed");

        backup();
    }

    public static void edit() {
        int x;
        int y;

        String edit = "";

        System.out.println("What team would you like to edit?");

        x = input.nextInt() - 1;

        System.out.format("%-20s", "Team");
        System.out.format("%-20s", "Player 1");
        System.out.format("%-20s", "Player 2");
        System.out.format("%-20s", "Player 3");
        System.out.format("%-20s", "Player 4");
        System.out.format("%-20s", "Player 5");
        System.out.format("%-20s", "Country");
        System.out.format("%-20s", "Winrate");
        System.out.format("%-20s", "Ranking");
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.format("%-20s", teams.get(x).getName());

        for (int i = 0; i < 5; i++) {
            System.out.format("%-20s", teams.get(x).getPlayer(i));
        }

        System.out.format("%-20s", teams.get(x).getCountry());
        System.out.format("%-20s", teams.get(x).getWinrate());
        System.out.format("%-20s", teams.get(x).getRanking());

        System.out.println("");

        System.out.println("Which column would you like to edit?");

        y = input.nextInt();

        if (y == 1) {
            System.out.println("Edit team name");

            edit = input.next();

            teams.get(x).setName(edit);
        } else if (y == 2) {
            System.out.println("Edit player 1");

            edit = input.next();

            teams.get(x).setPlayer(0, edit);
        } else if (y == 3) {
            System.out.println("Edit player 2");

            edit = input.next();

            teams.get(x).setPlayer(1, edit);
        } else if (y == 4) {
            System.out.println("Edit player 3");

            edit = input.next();

            teams.get(x).setPlayer(2, edit);
        } else if (y == 5) {
            System.out.println("Edit player 4");

            edit = input.next();

            teams.get(x).setPlayer(3, edit);
        } else if (y == 6) {
            System.out.println("Edit player 5");

            edit = input.next();

            teams.get(x).setPlayer(4, edit);
        } else if (y == 7) {
            System.out.println("Edit country");

            edit = input.next();

            teams.get(x).setCountry(edit);
        } else if (y == 8) {
            System.out.println("Edit winrate");

            edit = input.next();

            int editdb = Integer.parseInt(edit);

            teams.get(x).setWinrate(editdb);
        } else if (y == 9) {
            System.out.println("Edit ranking");

            edit = input.next();

            int editint = Integer.parseInt(edit);

            teams.get(x).setRanking(editint);
        }
        backup();
    }

    public static void sort() {
        int choice;

        System.out.println("How would you like to sort your list?");
        System.out.println("----------------------------------------");
        System.out.println("1 - Team Name");
        System.out.println("2 - Country");
        System.out.println("3 - Winrate");
        System.out.println("4 - Ranking");
        System.out.println("----------------------------------------");

        choice = input.nextInt();

        if (choice == 1) {
            sortByName();
            System.out.println("Sorted successfully");
        } else if (choice == 2) {
            sortByCountry();
            System.out.println("Sorted successfully");

        } else if (choice == 3) {
            sortByWinrate();
            System.out.println("Sorted successfully");

        } else if (choice == 4) {
            sortByRanking();
            System.out.println("Sorted successfully");

        }

    }

    public static void sortByName() {
        Collections.sort(teams, new Sortbyname());
        backup();
    }

    public static void sortByCountry() {
        Collections.sort(teams, new Sortbycountry());
        backup();
    }

    public static void sortByWinrate() {
        Collections.sort(teams, new Sortbywinrate());
        backup();
    }

    public static void sortByRanking() {
        Collections.sort(teams, new Sortbyranking());
        backup();
    }

    public static void save() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("teams.txt"));

            for (Team t : teams) {
                pw.print(t.getName() + "|");

                for (int i = 0; i < 5; i++) {
                    pw.print(t.getPlayer(i) + "|");
                }

                pw.print(t.getCountry() + "|");
                pw.print(t.getWinrate() + "|");
                pw.print(t.getRanking() + "|");
                pw.println("");
            }

            pw.close();

            backup();

            System.out.println("Saved successfully!");

        } catch (IOException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static void backup() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("backup.txt"));

            for (Team t : teams) {
                pw.print(t.getName() + "|");

                for (int i = 0; i < 5; i++) {
                    pw.print(t.getPlayer(i) + "|");
                }

                pw.print(t.getCountry() + "|");
                pw.print(t.getWinrate() + "|");
                pw.print(t.getRanking() + "|");
                pw.println("");
            }

            pw.close();

        } catch (IOException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static void exit() throws FileNotFoundException, IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader("teams.txt"));

        BufferedReader reader2 = new BufferedReader(new FileReader("backup.txt"));

        String line1 = reader1.readLine();

        String line2 = reader2.readLine();

        boolean areEqual = true;

        int lineNum = 1;

        while (line1 != null || line2 != null) {
            if (line1 == null || line2 == null) {
                areEqual = false;

                break;
            } else if (!line1.equalsIgnoreCase(line2)) {
                areEqual = false;

                break;
            }

            line1 = reader1.readLine();

            line2 = reader2.readLine();

            lineNum++;
        }

        if (areEqual) {
            System.out.println("System exit successful");
            System.exit(0);
        } else {
            System.out.println("Your backup and save files are different. They differ at line " + lineNum);

            System.out.println("teams.txt has " + line1 + " and backup.txt has " + line2 + " at line " + lineNum);

            System.out.println("Would you like to save now?");
            System.out.println("0 or 1");

            int choice;

            choice = input.nextInt();

            if (choice == 1) {
                save();
                exit();
            } else {
                System.exit(0);
            }
        }
    }
}
