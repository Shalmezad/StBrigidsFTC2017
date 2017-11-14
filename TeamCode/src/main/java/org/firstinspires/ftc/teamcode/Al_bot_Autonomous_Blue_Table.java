package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by SB_Robotics on 10/30/2017.
 */
@Autonomous(name = "Blue Table", group = "al_bot")
public class Al_bot_Autonomous_Blue_Table extends Al_bot_Autonomous_Base {

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();

        waitForStart();
        closeclaw();
        hitjewel(false);
        armup();
        drivexfeet(-2.3);
        turnndegrees(130);
        drivexfeet(-1.20);
        turnndegrees(52);
        drivexfeet(1);
        //armdown();
        openclaw();
        sleep(2000);

    }
}



