import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Employe> employeList=new ArrayList<>();
        int f2=1,oldEmployelistSize = employeList.size();;

        do{
            employeList.add(new Employe());
            System.out.println("continue ? enter 1 else -1 ?");
            f2 =Integer.parseInt(in.nextLine());
            System.out.println("---------------");
        }while(f2!=-1);

        try{
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sina","sg159753");
            int i =0;
            System.out.println("s"+oldEmployelistSize);
            for (i=i+oldEmployelistSize;i<employeList.size();i++){
                PreparedStatement preparedStatement=connection.prepareStatement("insert into employe (id,name,father,melicode,semat,age,salary,workHistory) values (?,?,?,?,?,?,?,?)");
                preparedStatement.setLong(1,employeList.get(i).getId());
                preparedStatement.setString(2,employeList.get(i).getName());
                preparedStatement.setString(3,employeList.get(i).getFather());
                preparedStatement.setString(4,employeList.get(i).getMeliCode());
                preparedStatement.setString(5,employeList.get(i).getSemat());
                preparedStatement.setLong(6,employeList.get(i).getAge());
                preparedStatement.setLong(7,employeList.get(i).getSalary());
                preparedStatement.setString(8,employeList.get(i).getWorkHistory());

                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            connection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
