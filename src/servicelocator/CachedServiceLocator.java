package servicelocator;

import java.util.HashMap;
import java.util.Map;

public class CachedServiceLocator implements ServiceLocator {
    private Map<String, Factory> factoryHashMap = new HashMap<>();
    private Map<String, Object> constantHashMap = new HashMap<>();

    @Override
    public void setService(String name, Factory factory) throws LocatorError {
        if (factoryHashMap.containsKey(name) || constantHashMap.containsKey(name)) {
            throw new LocatorError("Name allready in use");
        } else {
            factoryHashMap.put(name, factory);
        }
    }

    @Override
    public void setConstant(String name, Object value) throws LocatorError {
        if (constantHashMap.containsKey(name) || factoryHashMap.containsKey(name)) {
            throw new LocatorError("Name allready in use");
        } else {
            constantHashMap.put(name, value);
        }
    }

    @Override
    public Object getObject(String name) throws LocatorError {
        if (constantHashMap.containsKey(name)) {
            return constantHashMap.get(name);
        } else if (factoryHashMap.containsKey(name)) {
            Factory factory = factoryHashMap.get(name);
            factoryHashMap.remove(name);
            Object object = factory.create(this);
            setConstant(name, object);
            return object;
        } else {
            throw new LocatorError("Name doesn't exist");
        }
    }
}
