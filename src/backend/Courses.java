package backend;

public class Courses implements java.io.Serializable {
    private String course1;
    private String course2;
    private String course3;

    public Courses(){}
    public Courses(String course1, String course2, String course3){
        this.course1= course1;
        this.course2=course2;
        this.course3=course3;
    }

    //==================================Accessor====================================
    public String getCourse1(){
        return course1;
    }
    public String getCourse2(){
        return course2;
    }
    public String getCourse3(){
        return course3;
    }
}
