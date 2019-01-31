/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private Joystick m_leftStick;
  private TalonSRX leftFrontTalon, rightFrontTalon, leftBackTalon, rightBackTalon;

  @Override
  public void robotInit(){
    leftFrontTalon = new TalonSRX(4);
    leftBackTalon = new TalonSRX(3);
    rightFrontTalon = new TalonSRX(2);
    rightBackTalon = new TalonSRX(1);
    m_leftStick = new Joystick(0);

  }

  @Override
  public void teleopInit() {
    leftFrontTalon.set(ControlMode.PercentOutput, 0);
    leftBackTalon.set(ControlMode.PercentOutput, 0);
    rightFrontTalon.set(ControlMode.PercentOutput, 0);
    rightBackTalon.set(ControlMode.PercentOutput, 0);
  }

  //Base code
  @Override
  public void teleopPeriodic() {
    double rightTank =  m_leftStick.getRawAxis(5)* -1;
    double leftTank =  m_leftStick.getRawAxis(1);


    rightFrontTalon.set(ControlMode.PercentOutput, rightTank);
    rightBackTalon.set(ControlMode.PercentOutput, rightTank);
    leftFrontTalon.set(ControlMode.PercentOutput, leftTank);
    leftBackTalon.set(ControlMode.PercentOutput, leftTank);



    }

  }


