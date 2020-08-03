package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

public class ControllerClass {

    public Gamepad gamepad1;
    public Gamepad gamepad2;

    public double gamepad1LeftStickYDeadZone = 0;

    public double gamepad1LeftStickXDeadZone = 0;

    public double gamepad1RightStickYDeadZone = 0;

    public double gamepad1RightStickXDeadZone = 0;

    public double gamepad1LeftStickYUnmodified;
    public double gamepad1LeftStickYModified;

    public double gamepad1LeftStickXUnmodified;
    public double gamepad1LeftStickXModified;

    public double gamepad1RightStickYUnmodified;
    public double gamepad1RightStickYModified;

    public double gamepad1RightStickXUnmodified;
    public double gamepad1RightStickXModified;

    public ControllerClass() {}

    public void setGamepad1LeftStickYDeadZone (double deadZoneInput) {
        gamepad1LeftStickYDeadZone = deadZoneInput;
    }

    public void setGamepad1LeftStickXDeadZone (double deadZoneInput) {
        gamepad1LeftStickXDeadZone = deadZoneInput;
    }

    public void setGamepad1RightStickYDeadZone (double deadZoneInput) {
        gamepad1RightStickYDeadZone = deadZoneInput;
    }

    public void setGamepad1RightStickXDeadZone (double deadZoneInput) {
        gamepad1RightStickXDeadZone = deadZoneInput;
    }

    public double getGamepad1LeftStickYModified () {

        gamepad1LeftStickYUnmodified = gamepad1.left_stick_y;

        if (gamepad1LeftStickYUnmodified < gamepad1LeftStickYDeadZone) {
            gamepad1LeftStickYModified = 0;
        } else if (gamepad1LeftStickYUnmodified >= gamepad1LeftStickYDeadZone) {
            gamepad1LeftStickYModified = gamepad1.left_stick_y;
        }

        return gamepad1LeftStickYModified;

    }

    public double getGamepad1LeftStickXModified () {

        gamepad1LeftStickXUnmodified = gamepad1.left_stick_x;

        if (gamepad1LeftStickXUnmodified < gamepad1LeftStickXDeadZone) {
            gamepad1LeftStickXModified = 0;
        } else if (gamepad1LeftStickXUnmodified >= gamepad1LeftStickXDeadZone) {
            gamepad1LeftStickXModified = gamepad1.left_stick_x;
        }

        return gamepad1LeftStickXModified;

    }

    public double getGamepad1RightStickYModified () {

        gamepad1RightStickYUnmodified = gamepad1.right_stick_y;

        if (gamepad1RightStickYUnmodified < gamepad1RightStickYDeadZone) {
            gamepad1RightStickYModified = 0;
        } else if (gamepad1RightStickYUnmodified >= gamepad1RightStickYDeadZone) {
            gamepad1RightStickYModified = gamepad1.right_stick_y;
        }

        return gamepad1RightStickYModified;

    }

    public double getGamepad1RightStickXModified () {

        gamepad1RightStickXUnmodified = gamepad1.right_stick_x;

        if (gamepad1RightStickXUnmodified < gamepad1RightStickXDeadZone) {
            gamepad1RightStickXModified = 0;
        } else if (gamepad1RightStickXUnmodified >= gamepad1RightStickXDeadZone) {
            gamepad1RightStickXModified = gamepad1.right_stick_x;
        }

        return gamepad1RightStickXModified;

    }

}