/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.PistonOff;
import frc.robot.commands.PistonOn;
import frc.robot.commands.PistonReverse;

public class Operator {

	private boolean xToggle = false;
	private boolean bToggle = false;

	public Controllers controller = new Controllers(0);

	public Operator() {
		// controller.buttonY.whenPressed(new LaunchCatapult("LaunchCatapult", 5));
		// //where we call time
		controller.buttonX.whenPressed(new PistonOn());
		controller.buttonY.whenPressed(new PistonOff());
		controller.buttonB.whenPressed(new PistonReverse());
	}

	/*public void updateDashboard() {
		controller.updateDashboard();
	}*/
}
