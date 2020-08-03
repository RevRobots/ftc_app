package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/* This is a class for Mecanum Wheel Drive Trains.
 * It includes TeleOp Control and Encoder and Time Control for autonomous.
 * It uses the Robot Config class for the hardware mapping.
 *
 *
 */

//TODO: make a separate toggle class in android studio to simplify program

public class MecanumDriveTrain {

    RobotConfig robCong = new RobotConfig();
    ElapsedTime elapsedTime = new ElapsedTime();
    ToggleClass toggleClass = new ToggleClass();

    HardwareMap hwMap;

    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;

    boolean isBrakeButtonPressed = false;
    boolean breakToggle;

    boolean isSpeedButtonPressed = false;
    int speedSetting = 2;

    //public List<DcMotor> motors = Arrays.asList(leftFront, leftBack, rightBack, rightFront);

    public double driveSpeedDivider = 2;

    public MecanumDriveTrain(DcMotor lF, DcMotor rF, DcMotor lB, DcMotor rB) {
        leftFront = lF;
        rightFront = rF;
        leftBack = lB;
        rightBack = rB;
    }

    public void mecanumArcadeDriveRightJoystickTurn(Gamepad gamepad1) {

        leftFront.setPower(((-gamepad1.left_stick_y)-(gamepad1.left_stick_x)-(gamepad1.right_stick_x))/driveSpeedDivider);
        rightFront.setPower((((gamepad1.left_stick_y))-(gamepad1.left_stick_x)-(gamepad1.right_stick_x))/driveSpeedDivider);
        leftBack.setPower(((-gamepad1.left_stick_y)+(gamepad1.left_stick_x)-(gamepad1.right_stick_x))/driveSpeedDivider);
        rightBack.setPower((((gamepad1.left_stick_y))+(gamepad1.left_stick_x)-(gamepad1.right_stick_x))/driveSpeedDivider);

        onOffToggle(gamepad1);
        //TODO: change this to toggleClass.onOffToggle

        if (breakToggle == true) {

            leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        } else if (breakToggle == false) {

            leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        }

        multiNumericToggle(1, 4, gamepad1);
        //TODO: change this to toggleClass.multiNumericToggle

        if (speedSetting == 1) {
            driveSpeedDivider = 4;
        } else if (speedSetting == 2) {
            driveSpeedDivider = 2;
        } else if (speedSetting == 3) {
            driveSpeedDivider = 1.5;
        } else if (speedSetting == 4) {
            driveSpeedDivider = 1;
        }

    }

    public void mecanumArcadeDriveTriggerTurn(Gamepad gamepad1) {

        leftFront.setPower(((-gamepad1.left_stick_y)-(gamepad1.left_stick_x)-(gamepad1.right_trigger)+(gamepad1.left_trigger))/driveSpeedDivider);
        rightFront.setPower((((gamepad1.left_stick_y))-(gamepad1.left_stick_x)-(gamepad1.right_trigger)+(gamepad1.left_trigger))/driveSpeedDivider);
        leftBack.setPower(((-gamepad1.left_stick_y)+(gamepad1.left_stick_x)-(gamepad1.right_trigger)+(gamepad1.left_trigger))/driveSpeedDivider);
        rightBack.setPower((((gamepad1.left_stick_y))+(gamepad1.left_stick_x)-(gamepad1.right_trigger)+(gamepad1.left_trigger))/driveSpeedDivider);

        onOffToggle(gamepad1);
        //TODO: change this to toggleClass.onOffToggle

        if (breakToggle == true) {

            leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        } else if (breakToggle == false) {

            leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        }

        multiNumericToggle(1, 4, gamepad1);
        //TODO: change this to toggleClass.multiNumericToggle

        if (speedSetting == 1) {
            driveSpeedDivider = 4;
        } else if (speedSetting == 2) {
            driveSpeedDivider = 2;
        } else if (speedSetting == 3) {
            driveSpeedDivider = 1.5;
        } else if (speedSetting == 4) {
            driveSpeedDivider = 1;
        }

    }

    public void mecanumTankDriveTriggerStrafe(Gamepad gamepad1) {

        leftFront.setPower(((-gamepad1.right_stick_y) + (gamepad1.left_trigger) - (gamepad1.right_trigger)) / driveSpeedDivider);
        rightFront.setPower(((gamepad1.left_stick_y) + (gamepad1.left_trigger) - (gamepad1.right_trigger)) / driveSpeedDivider);
        leftBack.setPower(((-gamepad1.right_stick_y) - (gamepad1.left_trigger) + (gamepad1.right_trigger)) / driveSpeedDivider);
        rightBack.setPower(((gamepad1.left_stick_y) - (gamepad1.left_trigger) + (gamepad1.right_trigger)) / driveSpeedDivider);

        onOffToggle(gamepad1);
        //TODO: change this to toggleClass.onOffToggle

        if (breakToggle == true) {

            leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        } else if (breakToggle == false) {

            leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        }

        multiNumericToggle(1, 4, gamepad1);
        //TODO: change this to toggleClass.multiNumericToggle

        if (speedSetting == 1) {
            driveSpeedDivider = 4;
        } else if (speedSetting == 2) {
            driveSpeedDivider = 2;
        } else if (speedSetting == 3) {
            driveSpeedDivider = 1.5;
        } else if (speedSetting == 4) {
            driveSpeedDivider = 1;
        }

    }

    public void moveForwardsUsingEncoders (int tick, double power) {

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setTargetPosition(-tick);
        rightFront.setTargetPosition(tick);
        leftBack.setTargetPosition(-tick);
        rightBack.setTargetPosition(tick);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFront.setPower(power);
        rightFront.setPower(power);
        leftBack.setPower(power);
        rightBack.setPower(power);

        while (leftFront.isBusy() && rightFront.isBusy() && leftBack.isBusy() && rightBack.isBusy())

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void moveBackwardsUsingEncoders (int tick, double power, boolean deceleration) {

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setTargetPosition(tick);
        rightFront.setTargetPosition(-tick);
        leftBack.setTargetPosition(tick);
        rightBack.setTargetPosition(-tick);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (deceleration == true) {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(decelerate(tick, leftFront.getCurrentPosition()));
                rightFront.setPower(decelerate(tick, rightFront.getCurrentPosition()));
                leftBack.setPower(decelerate(tick, leftBack.getCurrentPosition()));
                rightBack.setPower(decelerate(tick, rightBack.getCurrentPosition()));

            }

        } else {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(power);
                rightFront.setPower(power);
                leftBack.setPower(power);
                rightBack.setPower(power);

            }

        }

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void moveRightUsingEncoders (int tick, double power, boolean deceleration) {

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setTargetPosition(-tick);
        rightFront.setTargetPosition(-tick);
        leftBack.setTargetPosition(tick);
        rightBack.setTargetPosition(tick);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (deceleration == true) {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(decelerate(tick, leftFront.getCurrentPosition()));
                rightFront.setPower(decelerate(tick, rightFront.getCurrentPosition()));
                leftBack.setPower(decelerate(tick, leftBack.getCurrentPosition()));
                rightBack.setPower(decelerate(tick, rightBack.getCurrentPosition()));

            }

        } else {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(power);
                rightFront.setPower(power);
                leftBack.setPower(power);
                rightBack.setPower(power);

            }

        }

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void moveLeftUsingEncoders (int tick, double power, boolean deceleration) {

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setTargetPosition(tick);
        rightFront.setTargetPosition(tick);
        leftBack.setTargetPosition(-tick);
        rightBack.setTargetPosition(-tick);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (deceleration == true) {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(decelerate(tick, leftFront.getCurrentPosition()));
                rightFront.setPower(decelerate(tick, rightFront.getCurrentPosition()));
                leftBack.setPower(decelerate(tick, leftBack.getCurrentPosition()));
                rightBack.setPower(decelerate(tick, rightBack.getCurrentPosition()));

            }

        } else {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(power);
                rightFront.setPower(power);
                leftBack.setPower(power);
                rightBack.setPower(power);

            }

        }

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void turnRightUsingEncoders (int tick, double power, boolean deceleration) {

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setTargetPosition(-tick);
        rightFront.setTargetPosition(-tick);
        leftBack.setTargetPosition(-tick);
        rightBack.setTargetPosition(-tick);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (deceleration == true) {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(decelerate(tick, leftFront.getCurrentPosition()));
                rightFront.setPower(decelerate(tick, rightFront.getCurrentPosition()));
                leftBack.setPower(decelerate(tick, leftBack.getCurrentPosition()));
                rightBack.setPower(decelerate(tick, rightBack.getCurrentPosition()));

            }

        } else {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(power);
                rightFront.setPower(power);
                leftBack.setPower(power);
                rightBack.setPower(power);

            }

        }

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void turnLeftUsingEncoders (int tick, double power, boolean deceleration) {

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setTargetPosition(tick);
        rightFront.setTargetPosition(tick);
        leftBack.setTargetPosition(tick);
        rightBack.setTargetPosition(tick);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (deceleration == true) {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(decelerate(tick, leftFront.getCurrentPosition()));
                rightFront.setPower(decelerate(tick, rightFront.getCurrentPosition()));
                leftBack.setPower(decelerate(tick, leftBack.getCurrentPosition()));
                rightBack.setPower(decelerate(tick, rightBack.getCurrentPosition()));

            }

        } else {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(power);
                rightFront.setPower(power);
                leftBack.setPower(power);
                rightBack.setPower(power);

            }

        }

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void moveForwardsUsingTime (int milliseconds, double power) {

        elapsedTime.reset();

        leftFront.setPower(power);
        rightFront.setPower(-power);
        leftBack.setPower(power);
        rightBack.setPower(-power);

        while (elapsedTime.milliseconds() < milliseconds);

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

        elapsedTime.reset();

    }

    public void moveBackwardsUsingTime (int milliseconds, double power) {

        elapsedTime.reset();

        leftFront.setPower(-power);
        rightFront.setPower(power);
        leftBack.setPower(-power);
        rightBack.setPower(power);

        while (elapsedTime.milliseconds() < milliseconds);

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

    }

    public void moveRightUsingTime (int milliseconds, double power) {

        elapsedTime.reset();

        leftFront.setPower(-power);
        rightFront.setPower(-power);
        leftBack.setPower(power);
        rightBack.setPower(power);

        while (elapsedTime.milliseconds() < milliseconds);

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

    }

    public void moveLeftUsingTime (int milliseconds, double power) {

        elapsedTime.reset();

        leftFront.setPower(power);
        rightFront.setPower(power);
        leftBack.setPower(-power);
        rightBack.setPower(-power);

        while (elapsedTime.milliseconds() < milliseconds);

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

    }

    public void turnRightUsingTime (int milliseconds, double power) {

        elapsedTime.reset();

        leftFront.setPower(-power);
        rightFront.setPower(-power);
        leftBack.setPower(-power);
        rightBack.setPower(-power);

        while (elapsedTime.milliseconds() < milliseconds);

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
    }

    public void turnLeftUsingTime (int milliseconds, double power) {

        elapsedTime.reset();

        leftFront.setPower(power);
        rightFront.setPower(power);
        leftBack.setPower(power);
        rightBack.setPower(power);

        while (elapsedTime.milliseconds() < milliseconds);

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

    }

    public double decelerate (int tick, int currentTick) {

        return (((tick - currentTick) * .0005) + .04);

    }

    public void onOffToggle (Gamepad gamepad1) {

        if (gamepad1.b) {

            isBrakeButtonPressed = true;

        } else if (!gamepad1.b && isBrakeButtonPressed == true) {

            isBrakeButtonPressed = false;

            if (breakToggle == false) {
                breakToggle = true;
            } else {
                breakToggle = false;
            }

        }

    }

    public void multiNumericToggle (int minimumNumber, int maximumNumber, Gamepad gamepad1) {

        if (gamepad1.a) {
            isSpeedButtonPressed = true;
        } else if (!gamepad1.a && isSpeedButtonPressed == true) {

            isSpeedButtonPressed = false;

            speedSetting++;

            if (speedSetting >= maximumNumber + 1) {
                speedSetting = minimumNumber;
            }

        }

    }

}