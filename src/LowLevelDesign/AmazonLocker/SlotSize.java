package LowLevelDesign.AmazonLocker;

import lombok.Data;

@Data
public class SlotSize {
    private double length;
    private double width;
    private double height;

    public SlotSize(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public boolean canFit(Package pkg) {
        return this.length >= pkg.getSize().getLength()
                && this.width >= pkg.getSize().getWidth()
                && this.height >= pkg.getSize().getHeight();
    }
}
