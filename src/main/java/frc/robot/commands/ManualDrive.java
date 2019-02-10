/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import frc.robot.ConstantAccelerationCalculator;
import frc.robot.Operator;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.subsystems.Drivetrain;

public class ManualDrive extends Command {

	private Operator operator = Operator.getOperator();
	private Drivetrain drivetrain;

	private Solenoid intakeSolenoid = new Solenoid(0);
	private boolean isSolenoidOn = false;
	//private ConstantAccelerationCalculator moveAcceleration = new ConstantAccelerationCalculator(0.0005);
	//private ConstantAccelerationCalculator turnAcceleration = new ConstantAccelerationCalculator(0.0005);
	
	public ManualDrive() {
		super("RampDrive");

		requires(this.drivetrain = Drivetrain.getDrivetrain());
	}

	protected void initialize() {
	}

	protected void execute() {

		double move = operator.controller.axisLeftY.getAxisValue();
		double rotate = operator.controller.axisRightX.getAxisValue();

		this.drivetrain.drive(move, rotate);

		SmartDashboard.putNumber("move value", move);
		SmartDashboard.putNumber("rotate value", rotate);
		SmartDashboard.updateValues();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		drivetrain.drive(0, 0);
	}

	protected void interrupted() {
		end();
	}
}