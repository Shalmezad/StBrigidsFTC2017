
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Al_bot_Tank", group = "Iterative Opmode")
public class Al_bot_tank extends Al_bot_base {


    protected void drive() {
        double leftspeed;
        leftspeed = gamepad1.left_stick_y * -1;

        double rightspeed;
        rightspeed = gamepad1.right_stick_y * -1;
        setdrivespeed(leftspeed, rightspeed);

    }
}
