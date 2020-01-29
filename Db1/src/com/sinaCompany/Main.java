package com.sinaCompany;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList <Student> studentList = new ArrayList<>();
        boolean f = true;
        while (f){
            System.out.println("choose :1.creat 2.update 3.delete 4-delete all 5-show all ");
            switch (Integer.parseInt(in.nextLine())){
                case 1:
                    int f2=1,oldStudentlistSize =studentList.size();;

                    do{
                        studentList.add(new Student());
                        System.out.println("continue ? enter 1 else -1 ?");
                        f2 =Integer.parseInt(in.nextLine());
                        System.out.println("---------------");
                    }while(f2!=-1);

                    try{
                        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sina","sg159753");
                        int i =0;
                        System.out.println("s"+oldStudentlistSize);
                        for (i=i+oldStudentlistSize;i<studentList.size();i++){
                            PreparedStatement preparedStatement=connection.prepareStatement("insert into student (id,name,year,average) values (?,?,?,?)");
                            preparedStatement.setLong(1,studentList.get(i).getId());
                            preparedStatement.setString(2,studentList.get(i).getName());
                            preparedStatement.setLong(3,studentList.get(i).getYear());
                            preparedStatement.setLong(4,studentList.get(i).getAverage());
                            preparedStatement.executeUpdate();
                            preparedStatement.close();
                        }
                        connection.close();
                    }
                    catch(SQLException e){
                        e.printStackTrace();
                    }
                break;
                case 2:
                    try{
                        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sina","sg159753");
                        PreparedStatement preparedStatement=connection.prepareStatement("update student set name=? where id =?");
                        System.out.println("Enter the id :");
                        int tempId= Integer.parseInt(in.nextLine());
                        System.out.println("name :");
                        String tempName =in.nextLine();
                        preparedStatement.setString(1,tempName);
                        preparedStatement.setLong(2,tempId);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        connection.close();
                    }
                    catch(SQLException e){
                        e.printStackTrace();
                    }
                    break;
                case 3:

                    try{
                        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sina","sg159753");
                        PreparedStatement preparedStatement=connection.prepareStatement("delete from student where id =?");
                        System.out.println("Enter the id :");
                        int tempId= Integer.parseInt(in.nextLine());
                        preparedStatement.setLong(1,tempId);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        connection.close();
                    }
                    catch(SQLException e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {

                        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sina","sg159753");
                        PreparedStatement preparedStatement=connection.prepareStatement("delete student");
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        connection.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sina","sg159753");
                        PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while(resultSet.next()){
                            System.out.print("id : "+resultSet.getLong("id")+"  \t");
                            System.out.print("name : "+resultSet.getString("name")+"  \t");
                            System.out.print("year : "+resultSet.getLong("year")+"  \t");
                            System.out.println("average : "+resultSet.getLong("average")+"  \t");
                        }
                        System.out.println("\n");
                        preparedStatement.close();
                        connection.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }

            }
        }

    }
}
