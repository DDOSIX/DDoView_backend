package gdg.six.ddoview.common;

import com.google.gson.Gson;
import com.google.gson.internal.Primitives;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtils {

    private static Gson gson = new Gson();

    public static String toJson(Object data) {
        String str = gson.toJson(data);
        return str;
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws Exception {
        Object object = gson.fromJson(json, (Type) classOfT);
        return Primitives.wrap(classOfT).cast(object);
    }

    public static <T> List<T> toList(String json, Class<T> typeClass) {
        return gson.fromJson(json, new ListOfJson<T>(typeClass));
    }

    static class ListOfJson<T> implements ParameterizedType {
        private Class<?> wrapped;

        public ListOfJson(Class<T> wrapper) {
            this.wrapped = wrapper;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{wrapped};
        }

        @Override
        public Type getRawType() {
            return List.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }
}