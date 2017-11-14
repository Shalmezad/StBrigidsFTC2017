package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by SB_Robotics on 10/30/2017.
 */
@Autonomous(name = "Red Table", group = "al_bot")
public class Al_bot_Autonomous_Red_Table extends Al_bot_Autonomous_Base {

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();

        waitForStart();
        closeclaw();
        hitjewel(true);
        //armup();
        drivexfeet(2);
        turnndegrees(-20);
        drivexfeet(1.4);
        //armdown();
        openclaw();

    }
}



