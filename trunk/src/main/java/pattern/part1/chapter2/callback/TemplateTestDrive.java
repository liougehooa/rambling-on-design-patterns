package pattern.part1.chapter2.callback;

import java.sql.ResultSet;

import static pattern.Asserts.assertTrue;

/**
 * Date: 2009-11-22
 * Time: 12:54:32
 */
public class TemplateTestDrive {

    public void testTemplate() {
        boolean called = new SimpleJdbcQueryTemplate().
                query("select * from db",
                        new ResultSetHandler<Boolean>() {
                            public Boolean handle(ResultSet rs) {
                                //logical to resolve query result...
                                return Boolean.TRUE;
                            }
                        });

        //to verify result...
        assertTrue(called);
    }

    public static void main(String[] args) {
        new TemplateTestDrive().testTemplate();
    }
}