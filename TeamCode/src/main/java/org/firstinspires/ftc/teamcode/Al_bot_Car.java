
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Al_bot_Car", group = "Iterative Opmode")
public class Al_bot_Car extends Al_bot_base {


    protected void drive() {

        double turn;
        double speed;
        speed = gamepad1.right_trigger - gamepad1.left_trigger;
        turn = gamepad1.left_trigger;

        double leftspeed;
        leftspeed = speed + turn;

        double rightspeed;
        rightspeed = speed - turn;

        setdrivespeed(leftspeed, rightspeed);
    }
}
