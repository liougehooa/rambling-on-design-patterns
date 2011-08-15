package pattern.part3.chapter7;

import pattern.part3.chapter7.domain.GenericRepository;
import pattern.part3.chapter7.domain.Loggable;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import static pattern.part3.chapter7.CopyUtils.copyOf;

/**
 * Date: 2009-12-1
 * Time: 21:44:42
 */
public class LogRepository<T> implements GenericRepository<T> {
    private static final String logEntityPacakgeName = "pattern.part3.chapter7.domain";
    private static final String logEntitySuffix = "Log";
    private GenericRepository genericRepository;

    public LogRepository(GenericRepository genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Override
    public void save(T o) {
        genericRepository.save(o);
        saveLog(o);//log this entity's sate
    }

    @Override
    public void update(T o) {
        genericRepository.update(o);
        saveLog(o); //log this entity's sate
    }

    @Override
    public T get(Class<T> clazz, Serializable id) {
        return (T)genericRepository.get(clazz, id);
    }

    @Override
    public void delete(T o) {
        genericRepository.delete(o);
    }

    @Override
    public List query(String qlString) {
        return genericRepository.query(qlString);
    }

    private void saveLog(T o) {
        if (o == null) {
            return;
        }

        String clazzName = o.getClass().getName();
        Object logObj = populateLogEntity(o, clazzName);

        genericRepository.save(logObj);
    }

    private Object populateLogEntity(T o, String clazzName) {
        if (!clazzName.endsWith("Log")) {
            String logClazzName = getLogEntityName(clazzName);
            if (logClazzName != null) {
                try {
                    Object logObj = Thread.currentThread().
                                           getContextClassLoader().
                                           loadClass(logClazzName).newInstance();
                    populateFields(o, logObj);
                    return logObj;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("Can not save log record for entity : " + logClazzName, e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Can not save log record for entity : " + logClazzName, e);
                } catch (InstantiationException e) {
                    throw new RuntimeException("Can not save log record for entity : " + logClazzName, e);
                }
            }
        }

        return null;
    }

    private static String getLogEntityName(String name) {
        if (name != null && name.length() > 0 && name.startsWith(logEntityPacakgeName)) {
            return name + logEntitySuffix;
        }
        return null;
    }

    private static void populateFields(Object srcObj, Object logObj) {
        copyOf(srcObj, logObj);
        populateLogTime(logObj);
    }

    private static void populateLogTime(Object logObj) {
        if (logObj instanceof Loggable) {
            Loggable logEntity = (Loggable) logObj;
            logEntity.setLogTime(new Timestamp(System.currentTimeMillis()));//set a current date
        }
    }

    //other methods...
}
