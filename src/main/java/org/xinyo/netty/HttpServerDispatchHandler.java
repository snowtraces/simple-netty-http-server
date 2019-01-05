package org.xinyo.netty;

import io.netty.handler.codec.http.FullHttpRequest;
import org.xinyo.init.ControllerInitializer;
import org.xinyo.util.HttpUtils;

import java.lang.reflect.Method;
import java.util.Map;

public class HttpServerDispatchHandler {
    public static String dispatch(FullHttpRequest request) {
        String result = "";

        HttpUtils.RequestParams params = HttpUtils.extractRequestParams(request);

        System.err.println(params);

        try {
            String uri = params.getUri();
            Map<String, Object[]> mappingMap = ControllerInitializer.getMappingMap();
            if (mappingMap.containsKey(uri)) {
                Object[] objects = mappingMap.get(uri);
                Class clazz = (Class) objects[0];
                Method method = (Method) objects[1];

                result = (String) method.invoke(clazz.newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
