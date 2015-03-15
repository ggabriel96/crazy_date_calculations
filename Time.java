class Time {
    int hour, min, sec;
    int day, week, mon, yr;

    public String toString() {
        return ("(" + this.week + "w) " + this.day + "/" + this.mon + "/" + this.yr +
        " - " + this.hour + ":" + this.min + ":" + this.sec);
    }
}
