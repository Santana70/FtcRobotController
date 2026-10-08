package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Competition TeleOp", group = "Competition")
public class CompetitionTeleOp extends OpMode {

    private RobotHardware hardware;
    private MecanumDrive drive;
    private Shooter shooter;
    private Intake intake;

    private boolean shooterEnabled = false;


    @Override
    public void init() {

        hardware = new RobotHardware();
        hardware.init(hardwareMap);

        drive = new MecanumDrive(hardware);
        shooter = new Shooter(hardware.shooter);
        intake = new Intake(hardware.intake);

        telemetry.addLine("COMPETITION TELEOP READY");
        telemetry.update();
    }


    @Override
    public void loop() {

        // ==========================================
        // DRIVER 1 - MECANUM
        // ==========================================

        double forward =
                -gamepad1.left_stick_y;

        double strafe =
                gamepad1.left_stick_x;

        double turn =
                gamepad1.right_stick_x;


        // Hold left bumper for slow mode
        double speed =
                gamepad1.left_bumper
                        ? Constants.SLOW_SPEED
                        : Constants.DRIVE_SPEED;


        drive.drive(
                forward,
                strafe,
                turn,
                speed
        );


        // ==========================================
        // DRIVER 2 - INTAKE
        // ==========================================

        if (gamepad2.a) {

            intake.forward();

        } else if (gamepad2.b) {

            intake.reverse();

        } else {

            intake.stop();
        }


        // ==========================================
        // DRIVER 2 - SHOOTER
        // ==========================================

        // X = shooter ON
        if (gamepad2.x) {

            shooterEnabled = true;

            shooter.setTargetRPM(
                    Constants.SHOOTER_TARGET_RPM
            );
        }


        // Y = shooter OFF
        if (gamepad2.y) {

            shooterEnabled = false;

            shooter.stop();
        }


        // Keep shooter at target RPM
        if (shooterEnabled) {

            shooter.update();
        }


        // ==========================================
        // TELEMETRY
        // ==========================================

        telemetry.addData(
                "Shooter Target RPM",
                "%.0f",
                shooter.getTargetRPM()
        );

        telemetry.addData(
                "Shooter RPM",
                "%.0f",
                shooter.getRPM()
        );

        telemetry.addData(
                "Shooter Power",
                "%.2f",
                shooter.getPower()
        );

        telemetry.addData(
                "Shooter At Speed",
                shooter.atSpeed(50)
        );

        telemetry.addData(
                "Intake Power",
                "%.2f",
                intake.getPower()
        );

        telemetry.update();
    }


    @Override
    public void stop() {

        hardware.stopAll();
    }
}