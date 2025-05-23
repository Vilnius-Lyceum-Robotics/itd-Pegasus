package org.firstinspires.ftc.teamcode.config.commands;

import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.ParallelCommandGroup;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitCommand;
import com.seattlesolvers.solverslib.command.WaitUntilCommand;

//import org.firstinspires.ftc.teamcode.config.subsystems.IntakeSubsystem;
//import org.firstinspires.ftc.teamcode.config.subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.config.subsystems.OuttakeSubsystem;

public class PrepareWall extends SequentialCommandGroup {
    public PrepareWall(OuttakeSubsystem outtakeSubsystem){
        addCommands(
                new InstantCommand(outtakeSubsystem::toHuman)
        );
        addRequirements(outtakeSubsystem);
    }
}
