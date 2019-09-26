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

        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");

        linearActuator = hardwareMap.dcMotor.get("linearActuator");

        intakeArm = hardwareMap.dcMotor.get("intakeArm");
        pulley = hardwareMap.dcMotor.get("pulley");
        intake = hardwareMap.crservo.get("intake");

        playerMarker = hardwareMap.servo.get("playerMarker");

        actuatorTouch = hardwareMap.get(DigitalChannel.class, "actuatorTouch");

        dT = new DriveTrain (hardwareMap, gamepad1, leftFront, rightFront, leftBack, rightBack);
        wC = new WashiClass (hardwareMap, gamepad1, gamepad2, linearActuator, intakeArm, pulley, intake, playerMarker, actuatorTouch, imu, angles);

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

    }

    @Override
    public void start ()
    {

        dT.stop();
        wC.stop();

    }

    @Override
    public void loop ()
    {

        dT.TeleOpDrive(gamepad1);
        wC.TeleOpPackage();

    }

    public void stop ()
    {

        dT.stop();
        wC.stop();

    }

}
