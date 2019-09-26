package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class WashiClass
{

    HardwareMap map; //init command

    Gamepad gamepad1; //controller 1
    Gamepad gamepad2; //controller 2

    DcMotor linearActuator; //linear actuator

    DcMotor intakeArm; //intake arm
    DcMotor pulley; //pulley
    CRServo intake; //intake

    Servo playerMarker; //player marker dropper

    DigitalChannel actuatorTouch; //limit for the linear actuator
    BNO055IMU imu; //gyro sensor

    Orientation angles; //angles for the gyro

    double gyroAngle = 0; //current gyro angle
    double armUpSpeed = 0.5;
    double armDownSpeed = 0.5;

    public WashiClass(HardwareMap m, Gamepad g1, Gamepad g2, DcMotor lA, DcMotor iA, DcMotor p, CRServo i, Servo pM, DigitalChannel aT, BNO055IMU b, Orientation a)
    {

            map = m; //sets m to map

            gamepad1 = g1; //sets g1 to gamepad1
            gamepad2 = g2; //sets g2 to gamepad2

            linearActuator = lA; //sets lA to linearActuator

            intakeArm = iA; //sets iA to intakeArm
            pulley = p; //sets p to pulley
            intake = i; //sets i to intake

            playerMarker = pM; //sets pM to playerMarker

            actuatorTouch = aT; //sets aT to actuatorTouch
            imu = b; //sets b to imu

            angles = a; //sets a to angles

    }

    void initMotor (DcMotor motor, String name)
    {

        motor = map.dcMotor.get(name); //sets the motors to the motors
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); //Motors will be set to brake

    }

    void initCRServo (CRServo crServo, String name)
    {

        crServo = map.crservo.get(name); //sets the crservos to the crservos

    }

    void initServo (Servo servo, String name)
    {

        servo = map.servo.get(name); //sets the servos to the servos

    }

    void initTouch (DigitalChannel channel, String name)
    {

        channel = map.digitalChannel.get(name); //sets the channel to the channel

    }

    void initGyro (BNO055IMU imu, String name)
    {

        imu = map.get(BNO055IMU.class, name); //sets the imu to the imu

    }

    void power (DcMotor motor, double power)
    {

        motor.setPower(power); //sets speed of the motors

    }

    void stop ()
    {

        linearActuator.setPower(0);

        intakeArm.setPower(0);
        pulley.setPower(0);
        intake.setPower(0);

        playerMarker.setPosition(0.65);

    }

    void TeleOpPackage ()
    {

        if (gamepad1.right_bumper)
        {

            linearActuator.setPower(-1);

        } else if (gamepad1.left_bumper && actuatorTouch.getState() == true)
        {

            linearActuator.setPower(1);

        } else
        {

            linearActuator.setPower(0);

        }

        if (gamepad2.y)
        {

            armUpSpeed = -0.75;

        } else if (gamepad2.b)
        {

            armUpSpeed = -0.5;

        }

        if (gamepad2.dpad_up)
        {

            armDownSpeed = 0.4;

        } else if (gamepad2.dpad_down)
        {

            armDownSpeed = 0.1;

        }

        if (gamepad2.right_trigger != 0)
        {

            intakeArm.setPower(armUpSpeed);

        } else if (gamepad2.left_trigger != 0)
        {

            intakeArm.setPower(armDownSpeed);

        } else
        {

            intakeArm.setPower(-0.2);

        }

        if (gamepad2.right_bumper)
        {

            pulley.setPower(-1);

        } else if (gamepad2.left_bumper)
        {

            pulley.setPower(1);

        } else
        {


            pulley.setPower(0);

        }

        if (gamepad2.a)
        {

            intake.setPower(1);

        } else if (gamepad2.x)
        {

            intake.setPower(-1);

        } else
        {

            intake.setPower(0);

        }

    }

}
