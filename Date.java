class Date {
    int hour, min, sec;
    int day, week, mon, yr;

    public String toString() {
        return (this.day + "/" + this.mon + "/" + this.yr + " - " + this.hour +
        ":" + this.min + ":" + this.sec + ", week " + this.week);
    }
}
