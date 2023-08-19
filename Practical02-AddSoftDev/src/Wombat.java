public class Wombat implements Comparable<Wombat> {
    private String name;
    private int severity;
    private double time;

    public Wombat(String name, int severity, double time) throws SeverityOutOfBoundsException {
        if (severity < 1 || severity > 10)
            throw new SeverityOutOfBoundsException();
        this.name = name;
        this.severity = severity;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public int compareTo(Wombat o) {
        if (this.severity == o.getSeverity())
            return (int) ((this.time - o.getTime()) * 10);
        else
            return o.getSeverity() - this.severity;
    }

    @Override
    public String toString() {
        return name + ", " + severity + ", " + time;
    }
}
