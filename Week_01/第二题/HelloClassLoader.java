import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Object object = new HelloClassLoader().findClass("Hello").newInstance();
            Class<?> classType = object.getClass();
            Method addMethod = classType.getMethod("hello");
            addMethod.invoke(object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = new byte[0];
        try {
            bytes = decode(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] decode(String name) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(name + ".xlass");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int byteValue;
        while ((byteValue = inputStream.read()) != -1) {
            outputStream.write(255 - byteValue);
        }
        return outputStream.toByteArray();
    }
}
