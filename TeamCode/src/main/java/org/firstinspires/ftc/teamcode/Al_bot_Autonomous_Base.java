package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.SwitchableLight;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by SB_Robotics on 10/30/2017.
 */

public class Al_bot_Autonomous_Base extends LinearOpMode {
    DcMotor leftdrivemotor;
    DcMotor rightdrivemotor;
    DcMotor armmotor;
    Servo jewelservo;
    boolean USEENCODERS = true;
    double JEWELUPPOSITION = 0.0;
    double JEWELDOWNPOSITION = 0.75;
    final double ARMSETPOINTLOW = 17;
    double ARMSETPOINTMEDIUMLOW = 350;
    NormalizedColorSensor colorSensor;
    Servo clawservo;


    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {

        clawservo = hardwareMap.servo.get("clawservo");
        clawservo.setPosition(0);
        leftdrivemotor = hardwareMap.dcMotor.get("leftdrivemotor");
        rightdrivemotor = hardwareMap.dcMotor.get("rightdrivemotor");
        jewelservo = hardwareMap.servo.get("jewelservo");
        jewelservo.setPosition(JEWELUPPOSITION);
        colorSensor = hardwareMap.get(NormalizedColorSensor.class, "sensor_color");
        rightdrivemotor.setDirection(DcMotorSimple.Direction.REVERSE);
        armmotor = hardwareMap.dcMotor.get("armmotor");
        armmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        if (USEENCODERS) {
            rightdrivemotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftdrivemotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            armmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightdrivemotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftdrivemotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        } else {
            rightdrivemotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            leftdrivemotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        }
        if (colorSensor instanceof SwitchableLight) {
            ((SwitchableLight) colorSensor).enableLight(true);
        }


    }

    public void drivexfeet(double feet) {
        if (USEENCODERS) {
            runtime.reset();
            double ticksperfeet = 1336;
            double targetpostion = feet * ticksperfeet;
            double lefttarget = leftdrivemotor.getCurrentPosition() + targetpostion;
            double righttarget = rightdrivemotor.getCurrentPosition() + targetpostion;
            leftdrivemotor.setTargetPosition((int) lefttarget);
            rightdrivemotor.setTargetPosition((int) righttarget);

            leftdrivemotor.setPower(0.5);
            rightdrivemotor.setPower(0.5);

            double expectedtimeperfoot = 2;
            double expectedtime = expectedtimeperfoot * Math.abs(feet);
            while (opModeIsActive() &&
                    (runtime.seconds() < expectedtime) &&
                    (leftdrivemotor.isBusy() && rightdrivemotor.isBusy())) {
                //do nonthing
            }
            leftdrivemotor.setPower(0);
            rightdrivemotor.setPower(0);
        } else {
            runtime.reset();
            if (feet > 0) {
                leftdrivemotor.setPower(0.5);
                rightdrivemotor.setPower(0.5);
            } else {
                leftdrivemotor.setPower(-0.5);
                rightdrivemotor.setPower(-0.5);
            }

            double secondsperfeet = 0.416;
            double secondstogo = Math.abs(feet) * secondsperfeet;
            while (opModeIsActive() && (runtime.seconds() < secondstogo)) {
                // donothing
            }
            leftdrivemotor.setPower(0);
            rightdrivemotor.setPower(0);


        }
    }

    public void turnndegrees(double degrees) {
        if (USEENCODERS) {
            runtime.reset();
            double ticksperdegree = 20;
            double targetpostion = degrees * ticksperdegree;
            double lefttarget = leftdrivemotor.getCurrentPosition() + targetpostion;
            double righttarget = rightdrivemotor.getCurrentPosition() - targetpostion;
            leftdrivemotor.setTargetPosition((int) lefttarget);
            rightdrivemotor.setTargetPosition((int) righttarget);
            leftdrivemotor.setPower(0.5);
            rightdrivemotor.setPower(0.5);
            double expectedtimeperdegree = 1.0 / 90;
            double expectedtime = expectedtimeperdegree * Math.abs(degrees);
            while (opModeIsActive() &&
                    (runtime.seconds() < expectedtime) &&
                    (leftdrivemotor.isBusy() && rightdrivemotor.isBusy())) {
                //do nonthing
            }
            leftdrivemotor.setPower(0);
            rightdrivemotor.setPower(0);
        } else {
            runtime.reset();
            if (degrees > 0) {
                leftdrivemotor.setPower(0.25);
                rightdrivemotor.setPower(-0.25);
            } else {
                leftdrivemotor.setPower(-0.25);
                rightdrivemotor.setPower(0.25);
            }

            double secondsperdegree = 2.0 / 90;
            double secondstogo = Math.abs(degrees) * secondsperdegree;
            while (opModeIsActive() && (runtime.seconds() < secondstogo)) {
                // donothing
            }
            leftdrivemotor.setPower(0);
            rightdrivemotor.setPower(0);


        }
    }

    public void hitjewel(boolean hitblue) {
        jewelarmdown();
        sleep(2000);
        //TODO HIT THE RIGHT JEWEL
        if (hitblue == isblue()) {
            hitforward();
            jewelarmup();
            hitback();
        } else {
            hitback();
            jewelarmup();
            hitforward();
        }

    }

    public void jewelarmdown() {
        jewelservo.setPosition(JEWELDOWNPOSITION);
        sleep(1000);
    }

    public void jewelarmup() {
        jewelservo.setPosition(JEWELUPPOSITION);
        sleep(1000);
    }

    public void hitforward() {
        turnndegrees(-20);

    }

    public void hitback() {
        turnndegrees(20);
    }

    public boolean isblue() {
        float[] hsvValues = new float[3];
        NormalizedRGBA colors = colorSensor.getNormalizedColors();
        Color.colorToHSV(colors.toColor(), hsvValues);
        return hsvValues[0] > 110 && hsvValues[0] < 260;

    }
    public void openclaw(){
        clawservo.setPosition(1);
    }
    public void closeclaw(){
        clawservo.setPosition(0);
    }
    public void armup(){
        double armtarget = ARMSETPOINTMEDIUMLOW;
        armmotor.setTargetPosition((int) armtarget);
        armmotor.setPower(0.3);
        sleep(500);
    }
    public void armdown(){
        double armtarget = ARMSETPOINTLOW;
        armmotor.setTargetPosition((int) armtarget);
        armmotor.setPower(0.3);
        sleep(1000);
    }
}


