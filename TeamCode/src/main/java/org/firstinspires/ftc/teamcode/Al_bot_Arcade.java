
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Al_bot_Arcade", group = "Iterative Opmode")
public class Al_bot_Arcade extends Al_bot_base {


    protected void drive() {

        double turn;
        double speed;
        speed = gamepad1.left_stick_y * -1;
        turn = gamepad1.left_stick_x;

        double leftspeed;
        leftspeed = speed + turn;

        double rightspeed;
        rightspeed = speed - turn;

        setdrivespeed(leftspeed, rightspeed);

    }
}
