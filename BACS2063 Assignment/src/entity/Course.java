package entity;

/**
 *
 * @author Pang Jin Siang
 */

public class Course {
    private String code;
    private String name;
    private String detail; 

    public Course(String code, String name, String detail) {
        this.code = code;
        this.name = name;
        this.detail = detail; 
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

    public String getDetail() { // 
        return detail;
    }

    public void setDetail(String detail) { 
        this.detail = detail;
    }

    @Override
    public String toString() {
         StringBuilder sb = new StringBuilder();  
         sb.append("Course Code: ").append(code).append("\n");  
         sb.append("Course Name: ").append(name).append("\n");
         sb.append("Course Detail: ").append(detail).append("\n");
    return sb.toString();
    }
}