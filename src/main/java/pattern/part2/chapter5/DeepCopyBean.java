package pattern.part2.chapter5;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Date: Nov 16, 2010
 * Time: 3:57:35 PM
 *|| */
public class DeepCopyBean implements Serializable {
    private String objectField;
    private int primitiveField;

    public String getObjectField() {
        return objectField;
    }

    public void setObjectField(String objectField) {
        this.objectField = objectField;
    }

    public int getPrimitiveField() {
        return primitiveField;
    }

    public void setPrimitiveField(int primitiveField) {
        this.primitiveField = primitiveField;
    }

    public DeepCopyBean deepCopy() {
        try {
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            ObjectOutputStream o = new ObjectOutputStream(buf);
            o.writeObject(this);

            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
            return (DeepCopyBean) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
