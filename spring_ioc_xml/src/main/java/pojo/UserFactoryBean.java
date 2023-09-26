package pojo;

import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean<student> {
    @Override
    public student getObject() throws Exception {
        return new student();
    }
    @Override
    public Class<?> getObjectType() {
        return student.class;
    }
}