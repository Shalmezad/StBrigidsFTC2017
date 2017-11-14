
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Al_bot_test", group = "Iterative Opmode")
public class Al_bot_test extends OpMode {
    DcMotor leftdrivemotor;
    DcMotor rightdrivemotor;
    DcMotor armmotor;

    @Override
    public void init() {

        leftdrivemotor = hardwareMap.dcMotor.get("leftdrivemotor");
        rightdrivemotor = hardwareMap.dcMotor.get("rightdrivemotor");
        armmotor = hardwareMap.dcMotor.get("armmotor");
    }

    @Override
    public void loop() {
        //leftdrivemotor.setPower(1);
        rightdrivemotor.setPower(1);
        telemetry.addData("Armposition", armmotor.getCurrentPosition());
    }
}
