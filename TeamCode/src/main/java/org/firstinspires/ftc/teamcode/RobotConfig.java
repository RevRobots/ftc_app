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

    HardwareMap hwMap;

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
