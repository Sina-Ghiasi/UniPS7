import java.util.Scanner;

public class Employe {
    Scanner in =new Scanner(System.in);

    private int id;
    private String name;
    private String father;
    private String meliCode;
    private String Semat;
    private int age;
    private int salary;
    private String workHistory;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMeliCode() {
        return meliCode;
    }

    public void setMeliCode(String meliCode) {
        this.meliCode = meliCode;
    }

    public String getSemat() {
        return Semat;
    }

    public void setSemat(String semat) {
        Semat = semat;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorkHistory() {
        return workHistory;
    }

    public void setWorkHistory(String workHistory) {
        this.workHistory = workHistory;
    }

    public Employe() {
        System.out.println("id :");
        this.id = Integer.parseInt(in.nextLine());
        System.out.println("name :");
        this.name = in.nextLine();
        System.out.println("father name :");
        this.father = in.nextLine();
        System.out.println("meli code :");
        this.meliCode = in.nextLine();
        System.out.println("semat :");
        this.Semat = in.nextLine();
        System.out.println("age :");
        this.age = Integer.parseInt(in.nextLine());
        System.out.println("salary :");
        this.salary = Integer.parseInt(in.nextLine());
        System.out.println("work history :");
        this.workHistory = in.nextLine();
    }
}
