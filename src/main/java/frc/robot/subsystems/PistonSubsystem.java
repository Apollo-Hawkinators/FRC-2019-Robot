/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.TogglePiston;

/**
 * Add your docs here.
 */
public class PistonSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Solenoid piston = new Solenoid(0);
  private boolean isSolenoidOn = false;

  @Override
  public void initDefaultCommand() {
  }

  public void setPiston() {
    isSolenoidOn = !isSolenoidOn;
    piston.set(isSolenoidOn);
  }

}
