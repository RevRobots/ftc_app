package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain
{

    HardwareMap map; //init command

    Gamepad g1; // controller 1

    DcMotor leftFront; //left front wheel
    DcMotor rightFront; //right front wheel
    DcMotor leftBack; // left back wheel
    DcMotor rightBack; // right back wheel

    int contSpd = 2; // speed control

    public DriveTrain (HardwareMap m, Gamepad g, DcMotor lF, DcMotor rF, DcMotor lB, DcMotor rB) //class constructor
    {

        map = m; //set m to the map

        g1 = g; //sets g to the game pad

        leftFront = lF; //sets lF to the left front wheel
        rightFront = rF; //sets rF to the right front wheel
        leftBack = lB; //sets lB to the left back wheel
        rightBack = rB; // sets rB to the right back wheel

    }

    /*void init (DcMotor motor, String name, boolean reversed)
    {

        motor = map.dcMotor.get(name); //sets the motors to the motors

        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); //motors will be set to brake

        if (reversed == true);
        motor.setDirection(DcMotorSimple.Direction.REVERSE); //sets direction of the motor to reverse

    }

    void power (DcMotor motor, double power)
    {

        motor.setPower(power); //sets speed of the motors

    }*/

    void stop ()
    {

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

    }

    void forward (double speed, int tic)
    {

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setTargetPosition(tic);
        rightFront.setTargetPosition(tic);
        leftBack.setTargetPosition(tic);
        rightBack.setTargetPosition(tic);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFront.setPower(speed);
        rightFront.setPower(speed);
        leftBack.setPower(speed);
        rightBack.setPower(speed);

        while (leftFront.isBusy() && rightFront.isBusy() && leftBack.isBusy() && rightBack.isBusy());

        stop();

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    void backwards (double speed, int tic)
    {

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setTargetPosition(-tic);
        rightFront.setTargetPosition(-tic);
        leftBack.setTargetPosition(-tic);
        rightBack.setTargetPosition(-tic);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFront.setPower(speed);
        rightFront.setPower(speed);
        leftBack.setPower(speed);
        rightBack.setPower(speed);

        while (leftFront.isBusy() && rightFront.isBusy() && leftBack.isBusy() && rightBack.isBusy());

        stop();

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    void TeleOpDrive (Gamepad gamepad1)
    {

        leftFront.setPower((-(gamepad1.left_stick_y)+(gamepad1.right_stick_x))/contSpd);
        rightFront.setPower(((gamepad1.left_stick_y)+(gamepad1.right_stick_x))/contSpd);
        leftBack.setPower((-(gamepad1.left_stick_y)+(gamepad1.right_stick_x))/contSpd);
        rightBack.setPower(((gamepad1.left_stick_y)+(gamepad1.right_stick_x))/contSpd);

        //forwards and backwards movements w/ turns

        if (g1.right_trigger != 0)
        {

            leftFront.setPower(1);
            rightFront.setPower(1);
            leftBack.setPower(-1);
            rightBack.setPower(-1);

        } else if (g1.left_trigger != 0)
        {

            leftFront.setPower(-1);
            rightFront.setPower(-1);
            leftBack.setPower(1);
            rightBack.setPower(1);

        }

        //sideways movement

        if (g1.a)
        {

            contSpd = 4; //sets speed to 1/4 of normal speed

        } else if (g1.b)
        {

            contSpd = 2; //sets speed to 1/2 of normal speed

        } else if (g1.x)
        {

            contSpd = 4/3; //sets speed to 3/4 of normal speed

        } else if (g1.y)
        {

            contSpd = 1; //sets speed to full speed

        }

    }

}