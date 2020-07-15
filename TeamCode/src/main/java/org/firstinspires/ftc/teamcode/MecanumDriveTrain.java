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

public class MecanumDriveTrain {

    RobotConfig robCong = new RobotConfig();
    ElapsedTime elapsedTime = new ElapsedTime();
    ControllerClass gamepadClass = new ControllerClass();

    HardwareMap hwMap;

    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;

    //public List<DcMotor> motors = Arrays.asList(leftFront, leftBack, rightBack, rightFront);

    public double driveSpeedDivider = 2;

    public MecanumDriveTrain(DcMotor lF, DcMotor rF, DcMotor lB, DcMotor rB) {
        leftFront = lF;
        rightFront = rF;
        leftBack = lB;
        rightBack = rB;
    }

    public void setDeadzones (double leftStickYDeadZone, double leftStickXDeadZone, double rightStickYDeadZone, double rightStickXDeadZone) {

        gamepadClass.setGamepad1LeftStickYDeadZone(leftStickYDeadZone);
        gamepadClass.setGamepad1LeftStickXDeadZone(leftStickXDeadZone);
        gamepadClass.setGamepad1RightStickYDeadZone(rightStickYDeadZone);
        gamepadClass.setGamepad1RightStickXDeadZone(rightStickXDeadZone);

    }

    public void mecanumDriveRightJoystickTurn (Gamepad gamepad1) {

        leftFront.setPower(((-gamepadClass.getGamepad1LeftStickYModified())-(gamepadClass.getGamepad1LeftStickXModified())-(gamepadClass.getGamepad1RightStickXModified()))/driveSpeedDivider);
        rightFront.setPower((((gamepadClass.getGamepad1LeftStickYModified()))-(gamepadClass.getGamepad1LeftStickXModified())-(gamepadClass.getGamepad1RightStickXModified()))/driveSpeedDivider);
        leftBack.setPower(((-gamepadClass.getGamepad1LeftStickYModified())+(gamepadClass.getGamepad1LeftStickXModified())-(gamepadClass.getGamepad1RightStickXModified()))/driveSpeedDivider);
        rightBack.setPower((((gamepadClass.getGamepad1LeftStickYModified()))+(gamepadClass.getGamepad1LeftStickXModified())-(gamepadClass.getGamepad1RightStickXModified()))/driveSpeedDivider);

        if (gamepad1.b) {
            driveSpeedDivider = 4;
        } else if (gamepad1.a) {
            driveSpeedDivider = 2;
        } else if (gamepad1.x) {
            driveSpeedDivider = 1.5;
        } else if (gamepad1.y) {
            driveSpeedDivider = 1;
        }

    }

    public void mecanumDriveTriggerTurn (Gamepad gamepad1) {

        leftFront.setPower(((-gamepad1.left_stick_y)-(gamepad1.left_stick_x)-(gamepad1.right_trigger)+(gamepad1.left_trigger))/driveSpeedDivider);
        rightFront.setPower((((gamepad1.left_stick_y))-(gamepad1.left_stick_x)-(gamepad1.right_trigger)+(gamepad1.left_trigger))/driveSpeedDivider);
        leftBack.setPower(((-gamepad1.left_stick_y)+(gamepad1.left_stick_x)-(gamepad1.right_trigger)+(gamepad1.left_trigger))/driveSpeedDivider);
        rightBack.setPower((((gamepad1.left_stick_y))+(gamepad1.left_stick_x)-(gamepad1.right_trigger)+(gamepad1.left_trigger))/driveSpeedDivider);

        if (gamepad1.b) {
            driveSpeedDivider = 4;
        } else if (gamepad1.a) {
            driveSpeedDivider = 2;
        } else if (gamepad1.x) {
            driveSpeedDivider = 1.5;
        } else if (gamepad1.y) {
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

    /*public void setMode(DcMotor.RunMode runMode) {

        for (DcMotor motor : motors) {
            motor.setMode(runMode);
        }

    }

    public void setTargetPostition (int ticks) {

        for (DcMotor motor : motors) {
            motor.setTargetPosition(ticks);
        }

    }

    public void setPower (double power) {

        for (DcMotor motor : motors) {
            motor.setPower(power);
        }

    }*/

    public double decelerate (int tick, int currentTick) {

        return (((tick - currentTick) * .0005) + .04);

    }

}