package com.zervlad.appnba.Core.Services;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Manages dependencies for the application
 */
public class DependenciesManagerNBA {

    static private DependenciesManagerNBA instance;
    HashMap<Type, Object> dependencies = new HashMap<>();

    private DependenciesManagerNBA() {
    }

    static public DependenciesManagerNBA getInstance() {
        if (instance == null) {
            synchronized (DependenciesManagerNBA.class) {
                if (instance == null) {
                    instance = new DependenciesManagerNBA();
                }
            }
        }
        return instance;
    }

    public void addDependency(Type type, Object dependency) {
        dependencies.put(type, dependency);
    }

    public <T> T getDependency(Class<T> type) {

        Object dependency = dependencies.get(type);

        if (!type.isInstance(dependency)) {
            return null;
        }

        return type.cast(dependency);

    }

}
