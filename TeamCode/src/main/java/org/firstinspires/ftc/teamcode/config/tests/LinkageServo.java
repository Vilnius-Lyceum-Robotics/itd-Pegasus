package org.firstinspires.ftc.teamcode.config.tests;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import static org.firstinspires.ftc.teamcode.config.core.RobotConstants.*;

public class LinkageServo extends SubsystemBase {

    private Telemetry telemetry;
    private Servo sadLittleServo;
    private double pos = 0.1;

    public LinkageServo(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        sadLittleServo = hardwareMap.get(Servo.class, "rightLinkage");
        sadLittleServo.setDirection(Servo.Direction.REVERSE);

        setTarget(this.pos);
    }

    public void setTarget(double target) {
        if (target >= 0) {
            this.pos = target;
            sadLittleServo.setPosition(target);
        }
    }

    public double getPos() {
        return pos;
    }

    public void telemetry() {
        telemetry.addData("Linkage servo position: ", getPos());
    }

    public void increment(double increment) {
        setTarget(this.pos + increment);
    }
    public void extend() {
        setTarget(LINKAGE_FULL);
    }

    public void retract() {
        setTarget(LINKAGE_ZERO);
    }


}
