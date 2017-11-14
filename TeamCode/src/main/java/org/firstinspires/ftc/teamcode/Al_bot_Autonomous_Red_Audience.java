package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by SB_Robotics on 10/30/2017.
 */
@Autonomous(name = "Red Audience", group = "al_bot")
public class Al_bot_Autonomous_Red_Audience extends Al_bot_Autonomous_Base {

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();

        waitForStart();
        closeclaw();
        hitjewel(true);
        //armup();
        drivexfeet(3);
        turnndegrees(90);
        drivexfeet(1);
        //armdown();
        openclaw();

    }
}