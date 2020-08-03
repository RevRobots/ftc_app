package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "mecanumTest")
public class Test extends OpMode {

    MecanumDriveTrain driveTrain;
    RobotConfig robCong;

    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;

    @Override
    public void init () {

        robCong = new RobotConfig();

        leftFront = hardwareMap.dcMotor.get(robCong.getLeftFrontWheel());
        rightFront = hardwareMap.dcMotor.get(robCong.getRightFrontWheel());
        leftBack = hardwareMap.dcMotor.get(robCong.getLeftBackWheel());
        rightBack = hardwareMap.dcMotor.get(robCong.getRightBackWheel());

        driveTrain = new MecanumDriveTrain(rightFront, leftFront, rightBack, leftBack);

    }

    @Override
    public void start () {

        /*
        driveTrain.moveForwardsUsingTime(1000, 1);
        driveTrain.moveBackwardsUsingTime(1000, 1);
        driveTrain.moveRightUsingTime(1000, 1);
        driveTrain.moveLeftUsingTime(1000, 1);
        driveTrain.turnRightUsingTime(1000, 1);
        driveTrain.turnLeftUsingTime(1000, 1);
         */

    }

    @Override
    public void loop () {

        driveTrain.mecanumArcadeDriveRightJoystickTurn(gamepad1);

    }

    @Override
    public void stop () {



    }

}