package LowLevelDesign.ParkingLot.Models;

import LowLevelDesign.ParkingLot.Enum.PaymentMode;
import LowLevelDesign.ParkingLot.Enum.PaymentStatus;

public class Payment extends BaseClass {
    private PaymentMode paymentMode;
    private int amount;
    private PaymentStatus paymentStatus;
    private String referenceId;
}
