package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by SB_Robotics on 10/30/2017.
 */
@Autonomous(name = "Blue Audience", group = "al_bot")
public class Al_bot_Autonomous_Blue_Audience extends Al_bot_Autonomous_Base {

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();

        waitForStart();
        closeclaw();
        hitjewel(false);
        armup();
        drivexfeet(-2.5);
        turnndegrees(90);
        drivexfeet(1.25);
        armdown();
        openclaw();

    }
}



