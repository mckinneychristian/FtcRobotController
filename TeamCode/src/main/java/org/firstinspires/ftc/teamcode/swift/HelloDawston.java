package org.firstinspires.ftc.teamcode.swift;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous()
@Disabled

public class HelloDawston extends OpMode {
    @Override
    public void init() {
        telemetry.addData("Hello","Dawston");
    }
    public void loop(){
    }
}