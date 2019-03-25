
import java.util.Comparator;

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    File:     Team.java                               Date:   March 3, 2019
  Author:     Gian Esteves                             APCS Period 8, Hanley
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Team {

    //instance variables
    String name;
    String[] players = new String[5];
    String country;
    double winrate;
    int ranking;

    //constructor
    public Team(String team, String p1, String p2, String p3, String p4, String p5, String coun, double wr, int rank) {
        players[0] = p1;
        players[1] = p2;
        players[2] = p3;
        players[3] = p4;
        players[4] = p5;

        name = team;
        country = coun;
        winrate = wr;
        ranking = rank;
    }

    public Team(String team) {
        name = team;
        country = "";
        winrate = 0;
    }

    //methods
    public void setName(String nm) {
        name = nm;
    }

    public void setWinrate(double wr) {
        winrate = wr;
    }

    public void setPlayer(int x, String name) {
        players[x] = name;
    }

    public void setCountry(String coun) {
        country = coun;
    }

    public void setRanking(int rank) {
        ranking = rank;
    }

    //aaasdasd
    public String getName() {
        return name;
    }

    public double getWinrate() {
        return winrate;
    }

    public String getPlayer(int x) {
        return players[x];
    }

    public String getCountry() {
        return country;
    }

    public int getRanking() {
        return ranking;
    }

    //THE TO STRING
    public String toString() {
        return getName() + "|" + getPlayer(0) + "|" + getPlayer(1) + "|" + getPlayer(2) + "|" + getPlayer(3) + "|" + getPlayer(4);
    }
}

class Sortbyname implements Comparator<Team> {

    public int compare(Team a, Team b) {
        return a.name.compareTo(b.name);
    }
}

class Sortbycountry implements Comparator<Team> {

    public int compare(Team a, Team b) {
        return a.country.compareTo(b.country);
    }
}

class Sortbywinrate implements Comparator<Team> {

    public int compare(Team a, Team b) {

        if (a.getWinrate() < b.getWinrate()) {
            return 1;
        } else {
            return -1;
        }
    }
}

class Sortbyranking implements Comparator<Team> {

    public int compare(Team a, Team b) {
        if (a.getRanking() < b.getRanking()) {
            return -1;
        } else {
            return 1;
        }
    }
}
