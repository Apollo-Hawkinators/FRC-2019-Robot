/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Camera extends Subsystem {

    private static Camera camera = null;

    public static Camera getCamera() {
        camera = camera == null ? new Camera() : camera;
        return camera;
    }

    private UsbCamera camera1;
    private int width1 = 150;
    private int height1 = 100;

    public void startCaptur() {
        camera1 = CameraServer.getInstance().startAutomaticCapture("camera1", 0);
        camera1.setResolution(width1, height1);
        camera1.setFPS(30);
        if (camera1.isConnected() == false) {
            camera1.free();
        }
    }

    public void initDefaultCommand() {

    }
}
