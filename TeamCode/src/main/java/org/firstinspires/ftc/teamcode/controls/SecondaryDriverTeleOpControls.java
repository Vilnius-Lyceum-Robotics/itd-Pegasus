package org.firstinspires.ftc.teamcode.controls;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.helpers.controls.DriverControls;
import org.firstinspires.ftc.teamcode.helpers.controls.button.ButtonCtl;
//import org.firstinspires.ftc.teamcode.helpers.subsystems.VLRSubsystem;


/**
 * Abstraction for secondary driver controls. All controls will be defined here.
 * For this to work well, all subsystems will be defined as singletons.
 */
public class SecondaryDriverTeleOpControls extends DriverControls {

    long lastInterval = System.nanoTime();

    public SecondaryDriverTeleOpControls(Gamepad gamepad) {
        super(new GamepadEx(gamepad));

        CommandScheduler cs = CommandScheduler.getInstance();

        //Find code explanations and examples in PrimaryDriverTeleOpControls.java



    }


}
