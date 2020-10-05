package Year2020.September.day17;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo01 {

    public class Person {
        String name;
        int age;

        public Person(){
            name = null;
            age = 0;
        }
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + "," + age;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //定义的内部类使用newInstance找不到构造函数
        Class classzz = Class.forName("Year2020.September.day17.Demo01$Person");
        //Person p = (Person) classzz.newInstance();
        //System.out.println(p.toString());
        //定义的内部类使用Constructor也找不到构造函数
        Constructor c = classzz.getDeclaredConstructor(String.class,int.class);
        Person p2 = (Person)c.newInstance("test",12);
        System.out.println(p2.toString());
    }
}
