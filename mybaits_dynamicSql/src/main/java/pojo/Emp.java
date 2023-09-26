package pojo;

public class Emp {
    private Integer empID;
    private String empName;
    private Integer age;
    private String gender;
    //表示当前员工所对应的部门
    private Dept dept;
    public Emp(Integer empID, String empName, Integer age, String gender) {
        this.empID = empID;
        this.empName = empName;
        this.age = age;
        this.gender = gender;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }


    public Integer getEmpID() {
        return empID;
    }

    public void setEmpID(Integer empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
