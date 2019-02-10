/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.ManualDrive;
import frc.robot.commands.togglePiston;

public class Operator {

	private boolean xToggle = false;
	private boolean bToggle = false;
	private static Operator operator = null;

	public static Operator getOperator() {
		operator = operator == null ? new Operator() : operator;
		return operator;
	}

	public Controllers controller = new Controllers(0);

	public Operator() {
		// controller.buttonY.whenPressed(new LaunchCatapult("LaunchCatapult", 5));
		// //where we call time

		controller.buttonA.whenPressed(new togglePiston()); // solenoid command
	}

	/*public void updateDashboard() {
		controller.updateDashboard();
	}*/
}
