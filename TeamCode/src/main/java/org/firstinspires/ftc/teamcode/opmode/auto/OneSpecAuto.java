package org.firstinspires.ftc.teamcode.opmode.auto;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.pedropathing.follower.Follower;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.ParallelCommandGroup;
import com.seattlesolvers.solverslib.command.RunCommand;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitCommand;
import com.seattlesolvers.solverslib.command.WaitUntilCommand;
import com.seattlesolvers.solverslib.pedroCommand.FollowPathCommand;

import org.firstinspires.ftc.teamcode.config.commands.Park;
import org.firstinspires.ftc.teamcode.config.commands.PrepareChamber;
import org.firstinspires.ftc.teamcode.config.commands.ScoreChamber;
import org.firstinspires.ftc.teamcode.config.core.paths.OneSpec;
import org.firstinspires.ftc.teamcode.config.pedropathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.config.pedropathing.constants.LConstants;
import org.firstinspires.ftc.teamcode.config.subsystems.Claw;
import org.firstinspires.ftc.teamcode.config.subsystems.HorizontalArm;
import org.firstinspires.ftc.teamcode.config.subsystems.Linkage;
import org.firstinspires.ftc.teamcode.config.subsystems.OuttakeSubsystem;

import java.util.List;

@Autonomous(name = "One Specimen Auto", group = "!")
public class OneSpecAuto extends CommandOpMode {
    private Follower follower;
    private OuttakeSubsystem outtakeSubsystem;
    private Linkage linkageSubsystem;
    private Claw clawSubsystem;
    private HorizontalArm horizontalArmSubsystem;

    @Override
    public void initialize(){
        // DO NOT REMOVE! Resetting FTCLib Command Scheduler
        super.reset();

        // Bulk reads
        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }

        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        follower = new Follower(hardwareMap, FConstants.class, LConstants.class);
        outtakeSubsystem = new OuttakeSubsystem(hardwareMap, telemetry);
        linkageSubsystem = new Linkage(hardwareMap, telemetry);
        horizontalArmSubsystem = new HorizontalArm(hardwareMap, telemetry);
        clawSubsystem = new Claw(hardwareMap, telemetry);

        schedule(
                new RunCommand(() -> follower.update()),

                new SequentialCommandGroup(
                        new ParallelCommandGroup(
                                new FollowPathCommand(follower, OneSpec.score1()),
                                new PrepareChamber(outtakeSubsystem)
                        ),
                        new WaitUntilCommand(() -> !follower.isBusy()), // Correct?
                        new ScoreChamber(outtakeSubsystem),
                        new FollowPathCommand(follower, OneSpec.park())
                )
        );
    }

    @Override
    public void run(){
        super.run(); // DO NOT REMOVE! Runs FTCLib Command Scheduler

        linkageSubsystem.telemetry();
        horizontalArmSubsystem.telemetry();
        clawSubsystem.telemetry();
        outtakeSubsystem.telemetry();

        telemetry.update(); // DO NOT REMOVE! Needed for telemetry
    }
}
