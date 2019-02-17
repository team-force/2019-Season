/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.sun.jdi.event.Event;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.TableEntryListener;


/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private NetworkTable table;
  private NetworkTable subtable;
  private double[] defaultValued = {0.0};

  @Override
  public void robotInit() {
    table = NetworkTableInstance.getDefault().getTable("GRIP");
    subtable = table.getSubTable("myContoursReport");
    NetworkTableInstance.getDefault().startClientTeam(4707);

  }
  @Override
  public void teleopInit() {
    
  }

  @Override
  public void teleopPeriodic() {
    double[] ctYdArray = subtable.getEntry("centerY").getDoubleArray(defaultValued);
    double[] ctXdArray = subtable.getEntry("centerX").getDoubleArray(defaultValued);
    double[] ctHeightdArray = subtable.getEntry("height").getDoubleArray(defaultValued);
    double[] ctWidthdArray = subtable.getEntry("width").getDoubleArray(defaultValued);
    double[] ctAreadArray = subtable.getEntry("area").getDoubleArray(defaultValued);
    double[] ctSolidityArray = subtable.getEntry("solidity").getDoubleArray(defaultValued);

    System.out.println("centerY: " + ctYdArray[0]);
    System.out.println("CenterX: " + ctXdArray[0]);
    System.out.println("Area: " + ctAreadArray[0]);
    System.out.println("Width: " + ctWidthdArray[0]);
    System.out.println("Height: " + ctHeightdArray[0]);
    System.out.println("Solidity: " + ctSolidityArray[0]);

    SmartDashboard.putNumber("centerY", ctYdArray[0]); 
    
    // NetworkTableEntry yEntry = subtable.getEntry("centerY");

  //   yEntry.addListener(event -> {
  //     System.out.println("centerY changed value: " + event.value.toString());
  //     // testArea = (double)event.value.getValue();
  //     // DriverStation.reportWarning("centerY " + event.value.getValue().toString(), true);
  //     // SmartDashboard.putNumber("centerY", testArea); 
  //     // System.out.println("centerY: " + event.value.getValue().toString());
  //       }, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);
  }
}
