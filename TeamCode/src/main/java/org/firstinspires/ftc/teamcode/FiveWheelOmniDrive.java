package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class FiveWheelOmniDrive {

    //TODO: Test this on a real robot due to the virtual robot not having this drive

    RobotConfig robCong = new RobotConfig();
    ElapsedTime elapsedTime = new ElapsedTime();
    ToggleClass toggleClass = new ToggleClass();

    HardwareMap hwMap;

    public DcMotor leftWheel;
    public DcMotor rightWheel;
    public DcMotor middleWheel;

    boolean isBrakeButtonPressed = false;
    boolean breakToggle;

    boolean isSpeedButtonPressed = false;
    int speedSetting = 2;

    public double driveSpeedDivider = 2;

    public FiveWheelOmniDrive (DcMotor lW, DcMotor rW, DcMotor mW, Boolean isMiddleWheelReversed) {

        leftWheel = lW;
        rightWheel = rW;
        middleWheel = mW;

        rightWheel.setDirection(DcMotorSimple.Direction.REVERSE);

        if (isMiddleWheelReversed) {
            middleWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        }

    }

    public void omniArcadeDriveRightJoystickTurn (Gamepad gamepad1) {

        leftWheel.setPower(gamepad1.left_stick_y + gamepad1.left_stick_y + gamepad1.right_stick_x);
        rightWheel.setPower(gamepad1.left_stick_y + gamepad1.left_stick_y + gamepad1.right_stick_x);

    }

}