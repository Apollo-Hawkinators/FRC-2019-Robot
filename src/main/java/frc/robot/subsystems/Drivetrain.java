/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.ConstantAccelerationCalculator;
import frc.robot.Prefs;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands. 
  private static Drivetrain drivetrain = null;

  static Prefs prefs = Prefs.getPrefs();

  private Victor frontLeftDrive = new Victor(0);
  private Victor frontRightDrive = new Victor(0);
  private Victor backLeftDrive = new Victor(1);
  private Victor backRightDrive =new Victor(1);

  private SpeedControllerGroup leftGroup = new SpeedControllerGroup(frontLeftDrive, backLeftDrive);
  private SpeedControllerGroup rightGroup = new SpeedControllerGroup(frontRightDrive, backRightDrive);

  private ConstantAccelerationCalculator ramp = new ConstantAccelerationCalculator(prefs.getRamp_C());

  private DifferentialDrive drive = new DifferentialDrive(leftGroup, rightGroup);

  public static Drivetrain getDrivetrain() {
    drivetrain = drivetrain == null ? new Drivetrain() : drivetrain;
    return drivetrain;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void drive(double move, double turn) {
    drive.arcadeDrive(move, turn);
  }

  protected void usePIDOutput(double output) {
    // Performs a ramping calculation on PID output
    double rampedOutput = ramp.getNextDataPoint(output);

    this.leftGroup.pidWrite(rampedOutput);
    this.rightGroup.pidWrite(rampedOutput);
  }
}
