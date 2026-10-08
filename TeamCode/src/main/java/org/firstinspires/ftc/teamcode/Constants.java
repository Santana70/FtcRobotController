package org.firstinspires.ftc.teamcode;

public final class Constants {

    private Constants() {}

    // =========================
    // DRIVE
    // =========================

    public static final double DRIVE_SPEED = 1.0;
    public static final double SLOW_SPEED = 0.45;


    // =========================
    // SHOOTER
    // =========================

    // REV HD encoder
    public static final double SHOOTER_TICKS_PER_MOTOR_REV = 28.0;

    // 5:6 speed gearing
    public static final double SHOOTER_GEAR_RATIO = 5.0 / 6.0;

    // Starting shooter target
    public static final double SHOOTER_TARGET_RPM = 6000.0;

    // Shooter controller
    public static final double SHOOTER_KP = 0.0008;
    public static final double SHOOTER_KI = 0.0;
    public static final double SHOOTER_KD = 0.0;
    public static final double SHOOTER_KF = 0.00020;


    // =========================
    // INTAKE
    // =========================

    public static final double INTAKE_POWER = 0.30;


    // =========================
    // AUTONOMOUS
    // =========================

    public static final long AUTO_DRIVE_MS = 1800;
    public static final long AUTO_SHOOT_SPINUP_MS = 1500;
    public static final long AUTO_FEED_MS = 2500;
    public static final long AUTO_PARK_MS = 1200;
}