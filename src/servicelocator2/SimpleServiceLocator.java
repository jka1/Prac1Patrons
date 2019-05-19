package servicelocator2;

import java.util.HashMap;
import java.util.Map;

public class SimpleServiceLocator implements ServiceLocator {
    private Map<Class, Factory> factoryHashMap = new HashMap<>();
    private Map<Class, Object> constantHashMap = new HashMap<>();

    @Override
    public <T> void setService(Class<T> klass, Factory<T> factory) throws LocatorError {
        if (factoryHashMap.containsKey(klass) || constantHashMap.containsKey(klass)) {
            throw new LocatorError("Name allready in use");
        } else {
            factoryHashMap.put(klass, factory);
        }
    }

    @Override
    public <T> void setConstant(Class<T> klass, T value) throws LocatorError {
        if (constantHashMap.containsKey(klass) || constantHashMap.containsKey(klass)) {
            throw new LocatorError("Name allready in use");
        } else {
            constantHashMap.put(klass, value);
        }
    }

    @Override
    public <T> T getObject(Class<T> klass) throws LocatorError {
        if (factoryHashMap.containsKey(klass)) {
            Factory factory = factoryHashMap.get(klass);
            return (T) factory.create(this);
        } else if (constantHashMap.containsKey(klass)) {
            return (T) constantHashMap.get(klass);
        } else {
            throw new LocatorError("Name doesn't exist");
        }
    }
}
