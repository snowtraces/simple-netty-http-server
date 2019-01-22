package org.xinyo.init;

import org.xinyo.util.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseInitializer {
    List<Class> controllerList = new ArrayList<>();
    List<Class> serviceList = new ArrayList<>();

    public BaseInitializer addController(Class clazz) {
        controllerList.add(clazz);
        return this;
    }

    public BaseInitializer addService(Class clazz) {
        serviceList.add(clazz);
        return this;
    }

    public void init() {
        BeanUtils.addBean(controllerList);
        BeanUtils.addBean(serviceList);
        BeanUtils.init();

        ControllerInitializer controllerInitializer = new ControllerInitializer();
        controllerInitializer.add(controllerList).init();

        // TODO serviceInitializer

    }
}
