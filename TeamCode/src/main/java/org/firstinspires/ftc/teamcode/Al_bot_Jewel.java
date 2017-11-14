package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;

/**
 * Created by SB_Robotics on 10/30/2017.
 */
@Autonomous(name = "Jewel", group = "al_bot")
public class Al_bot_Jewel extends LinearOpMode {

    NormalizedColorSensor colorSensor;

    @Override
    public void runOpMode() throws InterruptedException {

        colorSensor = hardwareMap.get(NormalizedColorSensor.class, "sensor_color");
        float[] hsvValues = new float[3];
        if ( colorSensor instanceof SwitchableLight) {
            ((SwitchableLight)colorSensor).enableLight(true);
        }

        waitForStart();
        while (opModeIsActive()){

            NormalizedRGBA colors = colorSensor.getNormalizedColors();
            Color.colorToHSV(colors.toColor(),hsvValues);
            //telemetry.addData("H","%.3f", hsvValues[0]);
            telemetry.addData("H", "" +  hsvValues[0]);
            telemetry.update();
        }

    }
}



