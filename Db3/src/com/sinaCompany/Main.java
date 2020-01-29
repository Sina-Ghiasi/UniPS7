package com.sinaCompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<User> userList=new ArrayList<>();
        int f2=1,oldUserlistSize = userList.size();;

        do{
            userList.add(new User());
            System.out.println("continue ? enter 1 else -1 ?");
            f2 =Integer.parseInt(in.nextLine());
            System.out.println("---------------");
        }while(f2!=-1);

        try{
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sina","sg159753");
            int i =0;
            System.out.println("s"+oldUserlistSize);
            for (i=i+oldUserlistSize;i<userList.size();i++){
                PreparedStatement preparedStatement=connection.prepareStatement("insert into employe (id,name,father,melicode,semat,age,salary,workHistory) values (?,?,?,?,?,?,?,?)");
                preparedStatement.setLong(1,userList.get(i).getCode());
                preparedStatement.setString(2,userList.get(i).getUser());
                preparedStatement.setString(3,userList.get(i).getPass());
                preparedStatement.setString(4,userList.get(i).getEmail());
                preparedStatement.setLong(6,userList.get(i).getAge());
                preparedStatement.setString(8,userList.get(i).getStudyLevel());

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
