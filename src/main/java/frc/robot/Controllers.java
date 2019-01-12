/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Controllers {
	private Joystick joystick;

	public JoystickButton buttonA;
	public JoystickButton buttonB;
	public JoystickButton buttonX;
	public JoystickButton buttonY;
	public JoystickButton leftBumper;
	public JoystickButton rightBumper;
	public JoystickButton leftJoyPress;
	public JoystickButton rightJoyPress;

	public JoystickAxis axisLeftX;
	public JoystickAxis axisRightX;
	public JoystickAxis axisLeftY;
	public JoystickAxis axisRightY;
	public JoystickAxis axisLeftTrigger;
	public JoystickAxis axisRightTrigger;

	public Controllers(int port) {
		
		// controller
		joystick = new Joystick(port);

		// buttons
		buttonA = new JoystickButton(joystick, 1);
		buttonB = new JoystickButton(joystick, 2);
		buttonX = new JoystickButton(joystick, 3);
		buttonY = new JoystickButton(joystick, 4);
		leftBumper = new JoystickButton(joystick, 5);
		rightBumper = new JoystickButton(joystick, 6);
		leftJoyPress = new JoystickButton(joystick, 9);
		rightJoyPress = new JoystickButton(joystick, 10);

		// Axes
		axisLeftX = new JoystickAxis(joystick, 0, 0.25);
		axisLeftY = new JoystickAxis(joystick, 1, 0);
		axisRightX = new JoystickAxis(joystick, 4, 0);
		axisRightY = new JoystickAxis(joystick, 5, 0);
		axisLeftTrigger = new JoystickAxis(joystick, 2, 0.25);
		axisRightTrigger = new JoystickAxis(joystick, 3, 0.25);
	}

	public void setRumble(double value) {
		joystick.setRumble(RumbleType.kLeftRumble, value);
		joystick.setRumble(RumbleType.kRightRumble, value);
	} 
	
	public void setRumble(double leftPower, double rightPower) {
		joystick.setRumble(RumbleType.kLeftRumble, leftPower);
		joystick.setRumble(RumbleType.kRightRumble, rightPower);
	}

	public class JoystickAxis {
		private Joystick joystick;
		private int axis;
		private double tolerance;

		public JoystickAxis(Joystick joystick, int axis, double tolerance) {
			this.axis = axis;
			this.joystick = joystick;
			this.tolerance = tolerance;
		}

		public double getAxisValue() {
			return Helpers.normalize(joystick.getRawAxis(axis), tolerance);
		}

	}

	/*public void updateDashboard() {
		SmartDashboard.putBoolean(Dashboard.IsButtonAPressed, buttonA.get());
		SmartDashboard.putBoolean(Dashboard.IsButtonBPressed, buttonB.get());
		SmartDashboard.putBoolean(Dashboard.IsButtonXPressed, buttonX.get());
		SmartDashboard.putBoolean(Dashboard.IsButtonYPressed, buttonY.get());
		SmartDashboard.putBoolean(Dashboard.IsLeftBumperPressed, leftBumper.get());
		SmartDashboard.putBoolean(Dashboard.IsRightBumperPressed, rightBumper.get());
		SmartDashboard.putNumber(Dashboard.LeftTriggerValue, axisLeftTrigger.getAxisValue());
		SmartDashboard.putNumber(Dashboard.RightTriggerValue, axisRightTrigger.getAxisValue());
		SmartDashboard.putNumber(Dashboard.AxisLeftXValue, axisLeftX.getAxisValue());
		SmartDashboard.putNumber(Dashboard.AxisLeftYValue, axisLeftY.getAxisValue());
		SmartDashboard.putNumber(Dashboard.AxisRightXValue, axisRightX.getAxisValue());
		SmartDashboard.putNumber(Dashboard.AxisRightYValue, axisRightY.getAxisValue());
    }*/
    // this is a single line comment
    /**
     * multi-line comment
     * 
     * 
     * 
     * 
     * 
     */
}