package Cal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target; //不知道目标类的类型，所以声明为Object类型
    public ProxyFactory(Object target) {
        this.target = target;
    }
    public Object getProxy(){
        /**
         * newProxyInstance()：创建一个代理实例
         * 类想被执行就必须先被加载
         * 其中有三个参数：
         * 1、classLoader：加载动态生成的代理类的类加载器
         *  根类加载器：底层C实现的，主要加载核心类库
         *  扩展类加载器：加载扩展类库
         *  应用类加载器：加载自己写的类或者引入的第三方jar包的类
         *  自定义类加载器
         * 2、interfaces：目标对象实现的所有接口的class对象所组成的数组
         * 动态生成的类必须要和目标对象实现相同接口，才能保证代理对象和目标对象实现功能一致
         * 3、invocationHandler：设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();//某个类型所实现的所有接口的Class对象所组成的数组
        InvocationHandler h=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //来设置代理类的方法该如何重写
                //proxy代理对象，method要重写/执行的抽象方法，要执行的方法的参数列表
                System.out.println("日志,方法："+method.getName()+"，参数:"+ Arrays.toString(args));
                Object result = method.invoke(target, args);//invoke有两个参数：当前要使用的对象，参数列表(因为代理方法要实现目标方法，所以要传入目标对象)
                System.out.println("日志,方法:"+method.getName()+",结果:"+result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,h);
    }
}
