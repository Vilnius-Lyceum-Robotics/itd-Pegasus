package org.firstinspires.ftc.teamcode.controls;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.helpers.controls.DriverControls;
import org.firstinspires.ftc.teamcode.helpers.controls.button.ButtonCtl;
//import org.firstinspires.ftc.teamcode.helpers.subsystems.VLRSubsystem;

/**
 * Abstraction for primary driver controls. All controls will be defined here.
 * For this to work well, all subsystems will be defined as singletons.
 */
public class PrimaryDriverTeleOpControls extends DriverControls {
    public PrimaryDriverTeleOpControls(Gamepad gamepad) {
        super(new GamepadEx(gamepad));

        CommandScheduler cs = CommandScheduler.getInstance();

        /*
        * Initialisation of each subsystem (claw example)
        ClawSubsystem claw = VLRSubsystem.getInstance(ClawSubsystem.class);
         */



        /*

        *[BUTTON NAMES]

        * Right side (no need for GamepadKeys.Button. ...):
        CROSS, CIRCLE, TRIANGLE, SQUARE

        * Left side:
        DPAD_UP, DPAD_DOWN, DPAD_LEFT, DPAD_RIGHT

        * Joystick buttons:
        LEFT_STICK_BUTTON, RIGHT_STICK_BUTTON

        * Bumpers:
        RIGHT_BUMPER, LEFT_BUMPER
        */



        /*
        * Both joystick set-up (chassis example)
        addBothSticksHandler(
                (Double leftY, Double leftX, Double rightY, Double rightX) -> {
                    chassis.drive(leftY, -leftX, -rightX);
                }
        );
        */

        /*
        * Button set-up eg. on the left pad(arrows)
        add(new ButtonCtl(GamepadKeys.Button.DPAD_DOWN, ButtonCtl.Trigger.WAS_JUST_PRESSED, true, (Boolean b) -> cs.schedule(new Action)));
        */

        /*
        * Adding vibration effect after an action
        addVibration(Variable::wasJustToggled);
         */

        /*
        * One joystick set-up
        addRightStickHandler((Double x, Double y) -> Command(y));
         */

    }
}
