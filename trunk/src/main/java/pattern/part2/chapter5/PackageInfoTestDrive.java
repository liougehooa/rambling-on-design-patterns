package pattern.part2.chapter5;

/**
 * Date: Mar 9, 2011
 * Time: 4:06:40 PM
 *|| */
public class PackageInfoTestDrive {
    public static void main(String[] args) {
        PackageInfo currentInfo = PackageInfo.clonePackage("John");
        System.out.println("Original package information:");
        display(currentInfo);

        currentInfo.setId(10000l);
        currentInfo.setReceiverName("Ryan");
        currentInfo.setReceiverAddress("People Square, Shanghai");

        System.out.println("\nNew package information:");
        display(currentInfo);
    }

    private static void display(PackageInfo currentInfo) {
        System.out.println("Package id: " + currentInfo.getId());
        System.out.println("Receiver name: " + currentInfo.getReceiverName());
        System.out.println("Receiver address: " + currentInfo.getReceiverAddress());
        System.out.println("Sender name: " + currentInfo.getSenderName());
        System.out.println("Sender Phone No.: " + currentInfo.getSenderPhoneNo());
    }
}