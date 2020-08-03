package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotConfig {

    // If the drive uses only two wheels the front wheels will be used
    /*
     *    Fill out the config and it will be applied to the class that you choose to use
     */
    public static final String leftFrontWheel = "front_left_motor";
    public static final String rightFrontWheel = "front_right_motor";
    public static final String leftBackWheel = "back_left_motor";
    public static final String rightBackWheel = "back_right_motor";

    public static final String extraMotorOne = "";
    public static final String extraMotorTwo = "";
    public static final String extraMotorThree = "";
    public static final String extraMotorFour = "";

    public static final String servoOne = "";
    public static final String servoTwo = "";
    public static final String servoThree = "";
    public static final String servoFour = "";
    public static final String servoFive = "";
    public static final String servoSix = "";
    public static final String servoSeven = "";
    public static final String servoEight = "";
    public static final String servoNine = "";
    public static final String servoTen = "";
    public static final String servoEleven = "";
    public static final String servoTwelve = "";

    //public static final String

    public RobotConfig () {}

    public String getLeftFrontWheel() {
        return leftFrontWheel;
    }

    public String getRightFrontWheel() {
        return  rightFrontWheel;
    }

    public String getLeftBackWheel () {
        return leftBackWheel;
    }

    public String getRightBackWheel () {
        return rightBackWheel;
    }

}
