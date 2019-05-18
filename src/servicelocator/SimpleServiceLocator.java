package servicelocator;

import java.util.HashMap;
import java.util.Map;

public class SimpleServiceLocator implements ServiceLocator {
    private Map<String, Factory> factoryHashMap = new HashMap<>();
    private Map<String, Object> constantHashMap = new HashMap<>();

    @Override
    public void setService(String name, Factory factory) throws LocatorError {
        if (factoryHashMap.containsKey(name) || constantHashMap.containsKey(name)) {
            throw new LocatorError("Name allredy in use");
        } else {
            factoryHashMap.put(name, factory);
        }
    }

    @Override
    public void setConstant(String name, Object value) throws LocatorError {
        if (constantHashMap.containsKey(name) || factoryHashMap.containsKey(name)) {
            throw new LocatorError("Name allredy in use");
        } else {
            constantHashMap.put(name, value);
        }
    }

    @Override
    public Object getObject(String name) throws LocatorError {
        if (factoryHashMap.containsKey(name)) {
            Factory factory = factoryHashMap.get(name);
            return factory.create(this);
        } else if (constantHashMap.containsKey(name)) {
            return constantHashMap.get(name);
        } else {
            throw new LocatorError("Name doesn't exist");
        }
    }
}
