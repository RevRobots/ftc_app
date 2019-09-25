package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@TeleOp (name = "Right Hand Man", group = "Drive")

public class Drive extends OpMode
{

    HardwareMap map; //init command

    Gamepad g1; // controller 1
    Gamepad g2; // controller 2

    DcMotor leftFront; //left front wheel
    DcMotor rightFront; //right front wheel
    DcMotor leftBack; // left back wheel
    DcMotor rightBack; // right back wheel

    DcMotor linearActuator; //linear actuator

    DcMotor intakeArm; //intake arm
    DcMotor pulley; //pulley
    CRServo intake; //intake

    Servo playerMarker; //player marker dropper

    DigitalChannel actuatorTouch; //limit for the linear actuator
    BNO055IMU imu; //gyro sensor

    Orientation angles; //angles for the gyro

    DriveTrain dT; //Drive Train Class
    WashiClass wC; //Washi Class

    public void init ()
    {

        dT = new DriveTrain (map, g1, leftFront, rightFront, leftBack, rightBack);
        wC = new WashiClass (map, g1, g2, linearActuator, intakeArm, pulley, intake, playerMarker, actuatorTouch, imu, angles);

        dT.init(leftFront, "leftFront", true);
        dT.init(rightFront, "rightFront", false);
        dT.init(leftBack, "leftBack", true);
        dT.init(rightBack, "rightBack", false);

        wC.initMotor(linearActuator, "linearActuator");

        wC.initMotor(intakeArm, "intakeArm");
        wC.initMotor(pulley, "pulley");
        wC.initCRServo(intake, "intake");

        wC.initServo(playerMarker, "playerMarker");

        wC.initTouch(actuatorTouch, "actuatorTouch");
        wC.initGyro(imu, "imu");

        dT.stop();
        wC.stop();

    }

    public void start ()
    {

        dT.stop();
        wC.stop();

    }

    public void loop ()
    {

        dT.TeleOpDrive();
        wC.TeleOpPackage();

    }

    public void stop ()
    {

        dT.stop();
        wC.stop();

    }

}
