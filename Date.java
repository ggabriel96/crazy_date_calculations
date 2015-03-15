class Date {
    int hour, min, seg;
    int day, week, mon, yr;

    public String toString() {
        return (this.day + "/" + this.mon + "/" + this.yr + " - " + this.hour +
        ":" + this.min + ":" + this.seg + ", week " + this.week);
    }
}
