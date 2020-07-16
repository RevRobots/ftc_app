package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "mecanumTest")
public class Test extends OpMode {

    MecanumDriveTrain driveTrain;
    RobotConfig robCong;
    ControllerClass gamepadClass;

    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;

    @Override
    public void init () {

        robCong = new RobotConfig();

        leftFront = hardwareMap.dcMotor.get(robCong.getMotorOne());
        rightFront = hardwareMap.dcMotor.get(robCong.getMotorTwo());
        leftBack = hardwareMap.dcMotor.get(robCong.getMotorThree());
        rightBack = hardwareMap.dcMotor.get(robCong.getMotorFour());

        driveTrain = new MecanumDriveTrain(rightFront, leftFront, rightBack, leftBack,
                0.01, 0.01, 0.01, 0.01);

    }

    @Override
    public void start () {

        driveTrain.moveForwardsUsingTime(1000, 1);
        driveTrain.moveBackwardsUsingTime(1000, 1);
        driveTrain.moveRightUsingTime(1000, 1);
        driveTrain.moveLeftUsingTime(1000, 1);
        driveTrain.turnRightUsingTime(1000, 1);
        driveTrain.turnLeftUsingTime(1000, 1);

    }

    @Override
    public void loop () {

        driveTrain.mecanumDriveRightJoystickTurn(gamepad1);

    }

    @Override
    public void stop () {



    }

}