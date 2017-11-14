package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by SB_Robotics on 10/30/2017.
 */
@Autonomous(name = "Aunton Test", group = "al_bot")
public class Auton_Test extends Al_bot_Autonomous_Base {

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();

        waitForStart();
        turnndegrees(-90);

    }
}



