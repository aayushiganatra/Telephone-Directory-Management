/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import project.DLL.Node;
import  java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.*;


public class Project {

  
    public static void main(String[] args)  throws Exception {
      
	DLL dll = new DLL(); 
        boolean eof=false;
        File Out = new java.io.File("Car.txt");
       // Out.createNewFile();
        FileOutputStream fOut = new FileOutputStream(Out,true);
        DataOutputStream dOut = new DataOutputStream(fOut);
	Scanner sc=new Scanner(System.in);
	System.out.println("Welcome To Honda");
        int c;
    do{
	System.out.println("Enter 1 for admin Enter 2 for customer");
	c=sc.nextInt();
	String Username = "Honda";
	int Password=123;
	
	int password = 0;
	String username = null;
        if(c==1)
	{
				
	  System.out.println("Enter username");
	  username = sc.next();
          System.out.println("Enter password");
          password = sc.nextInt();
          
          if(Username.equalsIgnoreCase(username)&& Password==password)
	{
  	  System.out.println("Welcome admin");
	
			
        
       int choice ;
        	
       do
  {
      System.out.println("Enter your choice 1.Add Data:\n2.Delete data\n3.Edit data\n4.Display data\n5.EXIT\n");
      System.out.println("Select an option");
       
       
      choice = sc.nextInt();
         
          
      switch(choice)
   {
         
          case 1:
		System.out.println("Enter car name:");
		String name=sc.next();
                dOut.writeUTF(name);
		System.out.println("Enter model :");
                String model=sc.next();
                dOut.writeUTF(model);
                System.out.println("Enter car price");
		long price=sc.nextLong();
                dOut.writeLong(price);
                System.out.println("Enter id of the car");
                int id=sc.nextInt();
               // dOut.writeInt(id);
                dll.append(price, model, name,id);
                
             
                break;
			
	  case 2:
                System.out.println("Enter the car name you want to delete");
                String s2=sc.next();
                int position;
                position = dll.findposition(dll.head, s2);
                System.out.println(position);
                
		dll.deleteNodeAtGivenPos(dll.head,position);
												
	        break;
	
          case 3:
              System.out.println("Select 1 to update price and 2 to update model:");
              int sel=sc.nextInt();
              System.out.println("Enter the id of car you want to update:");
              int id1=sc.nextInt();
              System.out.println("Enter car name:");
              String old_name=sc.next();

              if(sel==1)
              {
              System.out.println("Enter new price of car ");
              int new_price=sc.nextInt();
              dll.update_price( new_price,id1,old_name);
              }
              else if(sel==2)
              {
                  System.out.println("Enter new model of car:");
                  String new_model=sc.next();
                  dll.update_model(new_model, id1, old_name);
              }
              
              break;
          case 4:
               FileInputStream fin = new FileInputStream("Car.txt");
	       DataInputStream din = new DataInputStream(fin);
              
             System.out.println("Entries from file are:");
             while(!eof)
             {
                 try
                 {
             System.out.println("\n NAME:"+din.readUTF()+"\n MODEL:"+din.readUTF()+" \n PRICE:"+din.readLong());
                 }
             catch (EOFException e)
             {
                 eof=true;
                 System.out.println("End of file");
             }
             }
             din.close();
             fin.close();
             dll.printlist(dll.head);
             Node n= dll.mergeSort(dll.head);
             System.out.println("Sorted list is:");
             dll.printlist(n);
              
              break;
          case 5:
              break;
	  default:
	         System.out.println("Incorrect choice");
                
            
              dOut.flush(); 
              fOut.close();
              dOut.close();
              
   }
  }
								
 while(choice!=5);
 //sc.close();
        }
        
        else {
            System.out.println("Incorrect Username or Password");
        }
        }  
        else if(c==2)
        {
            int c1;
            
          System.out.println("Welcome to Honda Showroom!!!!!");
          System.out.println("Kindly enter your username:");
          String user=sc.next();
          
          if(Username.equalsIgnoreCase(user))
          {
              System.out.println("Welcome user");
              do{
              System.out.println("Select an option from the following:");
              System.out.println("1.View cars,2.View from a specific range,3.Exit");
              c1=sc.nextInt();
              switch(c1){
              
                  case 1:
                     // dll.printlist(dll.head);
                      Node n1=dll.mergeSort(dll.head);
                      dll.printlist(n1);
                      break;
                  case 2:
                      	  System.out.println("Enter the price of car you wish to search");
                	  int p=sc.nextInt();
                	  dll.Search(dll.head, p);
                	  

                      break;
              }
          }
              while(c1!=3);
             // sc.close();
        }
          else{
              System.out.println("Incorrect Username");
          }
        }
        } 
while(c!=3);
sc.close();

// System.out.println("Created DLL is: "); 
// dll.printlist(dll.head);
 
} 

    }
    

