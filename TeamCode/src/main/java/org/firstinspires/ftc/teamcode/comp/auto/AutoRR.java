package org.firstinspires.ftc.teamcode.comp.auto;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.shared.GlobalConfig;
import org.firstinspires.ftc.teamcode.shared.GlobalConfig.ALLIANCE_POS;
import org.firstinspires.ftc.teamcode.shared.GlobalConfig.ALLIANCE_COL;
import org.firstinspires.ftc.teamcode.shared.MotionHardware;
import org.firstinspires.ftc.teamcode.shared.MotionHardware.Direction;
import org.firstinspires.ftc.teamcode.shared.VisionHardware;
import org.firstinspires.ftc.teamcode.shared.VisionHardware.PropPosition;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

@Config
@Autonomous(name = "Auto - RA Right", group = "Auto")
public class AutoRR extends LinearOpMode {

    public ALLIANCE_POS alliancePos = ALLIANCE_POS.RIGHT;
    public ALLIANCE_COL allianceCol = ALLIANCE_COL.RED;
    public GlobalConfig globalConfig = new GlobalConfig(GlobalConfig.AUTONOMOUS_DELIVERY_MODES.DROPPER);

    private static int DESIRED_TAG_ID = 0;

    private static int DESIRED_DISTANCE = 6;

    private AprilTagDetection desiredTag = null;
    MotionHardware robot = new MotionHardware(this, globalConfig);
    VisionHardware vision = new VisionHardware(this, alliancePos);
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init();
        vision.init();

        robot.moveArm(.5, 5, 5);

        waitForStart();

        //TODO In parking code, drop arms to TeleOp pickup position

        // Center Strike Line
        // - Forward: 31.75
        // - Reverse: -44.75
        while(opModeIsActive()) {
            vision.resetExposure();
            PropPosition propPosition = vision.detectProp();
            // Left = 4, Middle = 5, Right = 6

            switch(propPosition) {
                case MIDDLE:
                    // Dropper Mode
                    robot.moveRobot(.5, -24, 10);
                    robot.dropPixel();
                    sleep(1000);
                    robot.moveRobot(.5, 3, 10);
                    robot.turnRobot(Direction.RIGHT, 20, .5, 10);
                    robot.moveRobot(.5, -28, 10);
                    robot.moveArmMotorToPosition(-5000, 10);
                    robot.dropPixelBackBoard();
                    robot.moveRobot(.5, 4, 10);
                    robot.strafeWithTime(.5, 270, 2);
                    robot.moveArmMotorToPosition(0, 1);
                    break;
                case RIGHT:
                    //Dropper Mode
                    robot.moveRobot(.5, -16, 10);
                    robot.turnRobot(Direction.RIGHT, 6, .5, 10);
                    robot.moveRobot(.5, -4, 10);
                    robot.dropPixel();
                    robot.moveRobot(.5, 4, 10);

                    robot.turnRobot(Direction.RIGHT, 17, .5, 10);
                    robot.moveRobot(.5, -15, 10);
                    robot.turnRobot(Direction.LEFT, 4, .5, 10);
                    robot.moveRobot(.5, -11, 10);
                    robot.moveArmMotorToPosition(-5000, 10);
                    robot.dropPixelBackBoard();
                    robot.moveRobot(.9, 4, 10);
                    robot.strafeWithTime(.9, 270, .8);
                    robot.moveRobot(.9, -2, 10);
                    robot.moveArmMotorToPosition(0, 10);
                    break;
                default:
                    //Dropper Mode
                    robot.moveRobot(.9, -16, 10);
                    robot.turnRobot(Direction.LEFT, 10, .8, 10);
                    robot.moveRobot(.9, -8, 10);
                    robot.dropPixel();
                    robot.moveRobot(.9, 6, 10);
                    robot.turnRobot(Direction.RIGHT, 20, .8, 10);
                    robot.moveRobot(.9, -10, 10);
                    robot.turnRobot(Direction.RIGHT, 11, .8, 10);
                    robot.moveRobot(.9, -22, 10);
                    //iniital position -4520
                    robot.moveArmMotorToPosition(-5000, 10);
                    robot.dropPixelBackBoard();
                    robot.moveRobot(.9, 4, 10);
                    robot.strafeWithTime(.9, 270, 1.5);
                    robot.moveRobot(.9, -2, 10);
                    robot.moveArmMotorToPosition(0, 10);
                    break;
            }

            sleep(20);
            break;
        }
    }
}
