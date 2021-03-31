package pl;

public class User implements Comparable<User> {
    String nick;
    int wynik;
    public User(String nick, int wynik) {
        this.nick = nick;
        this.wynik = wynik;
    }

    @Override
    public String toString() {
        return nick  +
                " :::: " + wynik;
    }

    @Override
    public int compareTo(User o) {
        if(o.wynik > this.wynik) {
            return 1;
        }
        else if(o.wynik < this.wynik) {
            return -1;
        }
        else
            return 0;
    }
}

