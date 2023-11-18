package testeasycode.entity;

import java.io.Serializable;

/**
 * (TestEasyCode)实体类
 *
 * @author makejava
 * @since 2020-02-17 11:13:57
 */
public class TestEasyCode implements Serializable {
    private static final long serialVersionUID = -96871921606904343L;
    
    private String name;
    
    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}