package org.xinyo.init;

import org.xinyo.annotation.RestMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerInitializer {
    private List<Class> controllerList = new ArrayList<>();
    private Map<String, Class> mappingMap = new HashMap<>();

    public ControllerInitializer add(Class clazz) {
        controllerList.add(clazz);
        return this;
    }

    public void init() {
        if (controllerList.size() == 0) {
            // TODO warning log
            return;
        }

        for (Class clazz : controllerList) {
            Method[] methods = clazz.getMethods();
            if (methods == null || methods.length == 0) {
                continue;
            }

            for (Method method : methods) {
                boolean isMappingMethod = method.isAnnotationPresent(RestMapping.class);
                if (isMappingMethod) {
                    RestMapping restMapping = method.getAnnotation(RestMapping.class);
                    String[] value = restMapping.value();


                }
            }


        }
    }




}
