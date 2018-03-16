import java.util.Date;

/**
 * @author by hongbf on 2018/2/27.
 */
public class Person {
    private String code;
    private String name;
    private String sex;
    private Date createTime;
    private int year;

    public Person(String code, String name, String sex, Date createTime, int year) {
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.createTime = createTime;
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
