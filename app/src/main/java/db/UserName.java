package db;


public class UserName {
    private Integer id;
    private  String name;
    private String pwd;

    public UserName() {
    }

    public UserName(String pwd, String name) {
        this.pwd = pwd;
        this.name = name;
    }

    public UserName(Integer id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
