package pattern.part2.chapter5;

/**
 * Date: 2009-11-15
 * Time: 17:05:19
 */
public class PackageInfo implements Cloneable {
    private Long id;
    private String receiverName;
    private String receiverAddress;
    private String senderName;
    private String senderPhoneNo;

    //other fields, getters, setters and other methods...


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderPhoneNo() {
        return senderPhoneNo;
    }

    public void setSenderPhoneNo(String senderPhoneNo) {
        this.senderPhoneNo = senderPhoneNo;
    }

    public PackageInfo clone() {
        try {
            return (PackageInfo)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not allowed.");
            return null;
        }
    }


    public static PackageInfo clonePackage(String userName) {
        //load package as prototype data from db...
        PackageInfo prototype = loadPackageInfo(userName);

        //clone information...
        prototype = prototype.clone();

        //initialize copied data...
        prototype.setId(null);

        return prototype;
    }

    //Simulate loading data from database
    private static PackageInfo loadPackageInfo(String userName) {
        PackageInfo packageInfo = new PackageInfo();

        //create a String object in jvm heap not jvm string pool
        packageInfo.setId(100l);
        packageInfo.setReceiverName("John");
        packageInfo.setReceiverAddress("People Square,Shanghai");
        packageInfo.setSenderName("William");
        packageInfo.setSenderPhoneNo("12345678901");
        return packageInfo;
    }
}