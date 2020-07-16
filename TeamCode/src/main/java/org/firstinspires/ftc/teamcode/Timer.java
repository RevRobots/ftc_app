package org.firstinspires.ftc.teamcode;

public class Timer {

    public double flippedTime;
    public double unfixedMinutes;
    public int fixedMinutes;
    public double seconds;

    public Timer () {}

    public double flipTime (double currentTime, double totalTime) {
        flippedTime = totalTime - currentTime;
        return flippedTime;
    }

    public int getMinutes (double currentTime) {
        unfixedMinutes = currentTime/60;
        fixedMinutes = (int)unfixedMinutes;
        return fixedMinutes;
    }

    public double getSeconds (double currentTime) {
        seconds = currentTime % 60;
        return seconds;
    }

}
