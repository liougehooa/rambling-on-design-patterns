package pattern.part2.chapter5;

/**
 * Date: Mar 9, 2011
 * Time: 4:06:24 PM
 *|| */
public class DeepCopyBeanTestDrive {
    public static void main(String[] args) {
        DeepCopyBean originalBean = new DeepCopyBean();

        //create a String object in jvm heap not jvm string pool
        originalBean.setObjectField(new String("123456"));
        originalBean.setPrimitiveField(2);

        //clone this bean
        DeepCopyBean newBean = originalBean.deepCopy();

        System.out.println("Primitive ==? " + (newBean.getPrimitiveField() == originalBean.getPrimitiveField()));
        System.out.println("Object ==? " + (newBean.getObjectField() == originalBean.getObjectField()));
        System.out.println("Object equal? " + (newBean.getObjectField().equals(originalBean.getObjectField())));
    }
}
