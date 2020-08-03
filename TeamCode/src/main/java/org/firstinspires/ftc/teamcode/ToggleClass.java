package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

public class ToggleClass {

    public boolean isOnOffButtonPressed;
    public boolean onOfFlag;

    public boolean isMultiNumericTogglePressed;
    public int multiNumericCounter;

    public boolean onOffToggle (Gamepad gamepad1, Character buttonLetter) {

        //Letter Button Toggles
        if (buttonLetter == 'a') {

            if (gamepad1.a) {

                isOnOffButtonPressed = true;

            } else if (!gamepad1.a && isOnOffButtonPressed == true) {

                isOnOffButtonPressed = false;

                if (onOfFlag == false) {
                    onOfFlag = true;
                } else {
                    onOfFlag = false;
                }

            }

        }
        else if (buttonLetter == 'b') {

            if (gamepad1.b) {

                isOnOffButtonPressed = true;

            } else if (!gamepad1.b && isOnOffButtonPressed == true) {

                isOnOffButtonPressed = false;

                if (onOfFlag == false) {
                    onOfFlag = true;
                } else {
                    onOfFlag = false;
                }

            }

        }
        else if (buttonLetter == 'x') {

            if (gamepad1.x) {

                isOnOffButtonPressed = true;

            } else if (!gamepad1.x && isOnOffButtonPressed == true) {

                isOnOffButtonPressed = false;

                if (onOfFlag == false) {
                    onOfFlag = true;
                } else {
                    onOfFlag = false;
                }

            }

        }
        else if (buttonLetter == 'y') {

            if (gamepad1.y) {

                isOnOffButtonPressed = true;

            } else if (!gamepad1.y && isOnOffButtonPressed == true) {

                isOnOffButtonPressed = false;

                if (onOfFlag == false) {
                    onOfFlag = true;
                } else {
                    onOfFlag = false;
                }

            }

        }

        //DPad Toggles
        if (buttonLetter == 'u') {

            if (gamepad1.dpad_up) {

                isOnOffButtonPressed = true;

            } else if (!gamepad1.dpad_up && isOnOffButtonPressed == true) {

                isOnOffButtonPressed = false;

                if (onOfFlag == false) {
                    onOfFlag = true;
                } else {
                    onOfFlag = false;
                }

            }

        }
        else if (buttonLetter == 'd') {

            if (gamepad1.dpad_down) {

                isOnOffButtonPressed = true;

            } else if (!gamepad1.dpad_down && isOnOffButtonPressed == true) {

                isOnOffButtonPressed = false;

                if (onOfFlag == false) {
                    onOfFlag = true;
                } else {
                    onOfFlag = false;
                }

            }

        }
        else if (buttonLetter == 'r') {

            if (gamepad1.dpad_right) {

                isOnOffButtonPressed = true;

            } else if (!gamepad1.dpad_right && isOnOffButtonPressed == true) {

                isOnOffButtonPressed = false;

                if (onOfFlag == false) {
                    onOfFlag = true;
                } else {
                    onOfFlag = false;
                }

            }

        }
        else if (buttonLetter == 'l') {

            if (gamepad1.dpad_left) {

                isOnOffButtonPressed = true;

            } else if (!gamepad1.dpad_left && isOnOffButtonPressed == true) {

                isOnOffButtonPressed = false;

                if (onOfFlag == false) {
                    onOfFlag = true;
                } else {
                    onOfFlag = false;
                }

            }

        }

        return onOfFlag;

    }

    public int multiNumericToggle (int minimumNumber, int maximumNumber, Gamepad gamepad1, Character buttonLetter) {

        //Letter Button Toggles
        if (buttonLetter == 'a') {

            if (gamepad1.a) {
                isMultiNumericTogglePressed = true;
            } else if (!gamepad1.a && isMultiNumericTogglePressed == true) {

                isMultiNumericTogglePressed = false;

                multiNumericCounter++;

                if (multiNumericCounter >= maximumNumber + 1) {
                    multiNumericCounter = minimumNumber;
                }

            }

        }
        else if (buttonLetter == 'b') {

            if (gamepad1.b) {
                isMultiNumericTogglePressed = true;
            } else if (!gamepad1.a && isMultiNumericTogglePressed == true) {

                isMultiNumericTogglePressed = false;

                multiNumericCounter++;

                if (multiNumericCounter >= maximumNumber + 1) {
                    multiNumericCounter = minimumNumber;
                }

            }

        }
        else if (buttonLetter == 'x') {

            if (gamepad1.x) {
                isMultiNumericTogglePressed = true;
            } else if (!gamepad1.a && isMultiNumericTogglePressed == true) {

                isMultiNumericTogglePressed = false;

                multiNumericCounter++;

                if (multiNumericCounter >= maximumNumber + 1) {
                    multiNumericCounter = minimumNumber;
                }

            }

        }
        else if (buttonLetter == 'y') {

            if (gamepad1.y) {
                isMultiNumericTogglePressed = true;
            } else if (!gamepad1.a && isMultiNumericTogglePressed == true) {

                isMultiNumericTogglePressed = false;

                multiNumericCounter++;

                if (multiNumericCounter >= maximumNumber + 1) {
                    multiNumericCounter = minimumNumber;
                }

            }

        }

        //DPad Toggles
        if (buttonLetter == 'u') {

            if (gamepad1.dpad_up) {
                isMultiNumericTogglePressed = true;
            } else if (!gamepad1.a && isMultiNumericTogglePressed == true) {

                isMultiNumericTogglePressed = false;

                multiNumericCounter++;

                if (multiNumericCounter >= maximumNumber + 1) {
                    multiNumericCounter = minimumNumber;
                }

            }

        }
        else if (buttonLetter == 'd') {

            if (gamepad1.dpad_down) {
                isMultiNumericTogglePressed = true;
            } else if (!gamepad1.a && isMultiNumericTogglePressed == true) {

                isMultiNumericTogglePressed = false;

                multiNumericCounter++;

                if (multiNumericCounter >= maximumNumber + 1) {
                    multiNumericCounter = minimumNumber;
                }

            }

        }
        else if (buttonLetter == 'r') {

            if (gamepad1.dpad_right) {
                isMultiNumericTogglePressed = true;
            } else if (!gamepad1.a && isMultiNumericTogglePressed == true) {

                isMultiNumericTogglePressed = false;

                multiNumericCounter++;

                if (multiNumericCounter >= maximumNumber + 1) {
                    multiNumericCounter = minimumNumber;
                }

            }

        }
        else if (buttonLetter == 'l') {

            if (gamepad1.dpad_left) {
                isMultiNumericTogglePressed = true;
            } else if (!gamepad1.a && isMultiNumericTogglePressed == true) {

                isMultiNumericTogglePressed = false;

                multiNumericCounter++;

                if (multiNumericCounter >= maximumNumber + 1) {
                    multiNumericCounter = minimumNumber;
                }

            }

        }

        return multiNumericCounter;

    }

}