
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

//@TeleOp(name = "Al_bot_Tank", group = "Iterative Opmode")
public class Al_bot_base extends OpMode {
    DcMotor leftdrivemotor;
    DcMotor rightdrivemotor;
    DcMotor armmotor;
    Servo clawservo;
    double desiredarmposition;
    final double ARMSPEEDMULTIPLIER = 10;
    final double ARMSETPOINTLOW = 17;
    final double ARMSETPOINTMEDIUMLOW = 582;
    final double ARMSETPOINTMEDIUMHIGH = 1031;
    final double ARMSETPOINTHIGH = 1068;

    @Override
    public void init() {

        Servo jewelservo;
        double JEWELUPPOSITION = 0.0;
        jewelservo = hardwareMap.servo.get("jewelservo");
        jewelservo.setPosition(JEWELUPPOSITION);

        leftdrivemotor = hardwareMap.dcMotor.get("leftdrivemotor");
        rightdrivemotor = hardwareMap.dcMotor.get("rightdrivemotor");
        clawservo = hardwareMap.servo.get("clawservo");
        clawservo.setPosition(0);
        armmotor = hardwareMap.dcMotor.get("armmotor");
        armmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightdrivemotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightdrivemotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftdrivemotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightdrivemotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftdrivemotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        armmotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        desiredarmposition = 0;
    }


    @Override
    public void loop() {

        Servo jewelservo;
        double JEWELUPPOSITION = 0.0;
        jewelservo = hardwareMap.servo.get("jewelservo");
        jewelservo.setPosition(JEWELUPPOSITION);

        telemetry.addData("Armposition", armmotor.getCurrentPosition());
        drive();
        claw();

        arm();


    }

    private void arm() {
        double armspeed;
        armspeed = gamepad2.right_stick_y;
        armspeed = armspeed * 0.5;
        armmotor.setPower(armspeed);

    }

    private void claw() {
        boolean closeclaw;
        boolean openclaw;
        closeclaw = gamepad2.right_bumper;
        openclaw = gamepad2.left_bumper;
        if (closeclaw) {
            clawservo.setPosition(1);
        }
        if (openclaw) {
            clawservo.setPosition(0);
        }
    }

    protected void drive() {


    }

    public void setdrivespeed(double leftspeed, double rightspeed) {

        boolean halfspeed;
        halfspeed = gamepad1.right_bumper;
        if (halfspeed) {
            leftspeed = leftspeed * 0.5;
            rightspeed = rightspeed * 0.5;
        }
        boolean quarterspeed;
        quarterspeed = gamepad1.left_bumper;
        if (quarterspeed){
            leftspeed = leftspeed * 0.25;
            rightspeed = rightspeed * 0.25;
        }

        leftdrivemotor.setPower(leftspeed);
        rightdrivemotor.setPower(rightspeed);

    }

}
