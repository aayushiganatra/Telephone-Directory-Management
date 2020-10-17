/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telephonedirectory;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TelephoneDirectory 
{
    //Node head; // head of list 
    static Node newnew;
public static void main(String[] args) throws IOException 
{ 
        
        //TelephoneDirectory td = new TelephoneDirectory(); 
        LinkedList list = new LinkedList();
	Scanner sc = new Scanner(System.in);
        int choice,ch;
        File Out = new java.io.File("Entries.txt");
        Out.createNewFile();
        FileOutputStream fOut = new FileOutputStream(Out);
        DataOutputStream dOut = new DataOutputStream(fOut);
        System.out.println("********Telephone Directory Management********* ");
    do{
	System.out.println("1. Admin User");
        System.out.println("2. Customer User");
        ch = sc.nextInt();
	String Username = "Telephone";
	int Password = 123;
	
	int password = 0;
	String username = null;
        if(ch==1)
	{
				
	  System.out.println("Enter username");
	  username = sc.next();
          System.out.println("Enter password");
          password = sc.nextInt();
          
          if(Username.equalsIgnoreCase(username)&& Password==password)
	{
  	  System.out.println("Welcome Admin");
	
        do
            {
                System.out.println("Enter your choice");
                System.out.println("1.Add Entry:" );
                System.out.println("2.Delete an entry:");
                System.out.println("3.Update the entry:");
                System.out.println("4. Exit");
                System.out.println("Select an option");
                choice = sc.nextInt();
        switch(choice)
            {
                    
                case 1:

                    System.out.println("Enter name :");
                    String name=sc.next();
                    name += sc.nextLine();
                    dOut.writeBytes(name);
                    System.out.println("Enter address :");
                    String address = sc.next();
                    address += sc.nextLine();
                    dOut.writeBytes(address);
                    System.out.println("Enter phone number :");
                    String phoneNo = sc.next();
                    dOut.writeBytes(phoneNo);
                    if(phoneNo.length() == 10)
                    {
                        list.insert(name,address,phoneNo);
                    }
//                else if(phoneNo.equals(newnew.getPhoneNo()))
//                {
//                }
                else
                {
                    System.out.println("Enter valid number. The Phone Number consists of 10 digits\n");
                }
                break;

                case 2:
                    
                    System.out.println("Enter name you want to delete\n");
                    String c1=sc.next();
                    c1 += sc.nextLine();
                    list.deleteNodeAtGivenPos(list.head,c1);
                    
                    break;

                case 3: 
                    
                    System.out.println("What do you want to update?");
                    System.out.println("1.Phone Number :");
                    System.out.println("2.Address :\n");
                    int select = sc.nextInt();

                        if(select == 1)
                        {
                            System.out.println("Enter the name of the number you want to update :");
                            String old = sc.next();
                            old += sc.nextLine();
                            System.out.println("Enter new number :");
                            String new_num=sc.next();
                            if(new_num.length() == 10)
                            {
                                 list.updatePhoneNo(old, new_num);
                            }
                            else
                            {
                                System.out.println("Enter valid number. The Phone Number consists of 10 digits\n");
                            }
                        }

                        else
                        {
                            System.out.println("Enter the name of the address you want to update :");
                            String old = sc.next();
                            old += sc.nextLine();
                            System.out.println("Enter new address :");
                            String new_add=sc.next();
                            list.updateAddress(old, new_add);
                        }

                    break;
                
                case 4:
                    break;
                    
                default:
                    System.out.println("Incorrect choice! \nPlease Enter a valid choice!!\n");
                    dOut.close();
                    dOut.flush();
            }
        }while(choice!=4);
              
    }
              
      else
        {
            System.out.println("Incorrect Username or Password");
        }
        }
          else if(ch==2)
        {
            int c1;
            
          System.out.println("*********Telephone Directory Management********");
          System.out.println("Kindly Enter The Username:");
          String user=sc.next();
          if(Username.equalsIgnoreCase(user))
          {
                    System.out.println("******Welcome Customer User******");
          do
          {
                        System.out.println("1.Search Entry:");
                        System.out.println("2.Display all the entries:");
                        System.out.println("3.Exit");
                        c1 = sc.nextInt();
           switch(c1)
           {
               case 1:
                    
                    System.out.println("Enter the name to be searched");
                    String search = sc.next();
                    search += sc.nextLine();
                    newnew = list.searchEntryNode(list.head,search);
                    System.out.println(newnew.getName() + " " + newnew.getAddress() + " "  + newnew.getPhoneNo() + "\n");
                    break;
                    
                    case 2:
                    
                    Node node = null; 
                    node = list.mergeSort(list.head);
                    System.out.println("Created Telephone Directory after sorting is :\n");
                    list.printlist(node);
                    break;
                    
                    case 3:
                    break;
                    
                    default:
                    System.out.println("Incorrect choice! \nPlease Enter a valid choice!!\n");
           }
          }while(c1 != 3);
         
         }
        }
    }while(ch!=3);
     sc.close();
}
}

       
        