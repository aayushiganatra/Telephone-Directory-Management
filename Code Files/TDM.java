/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author aayus
 */
public class TDM
{
    static Node newnew;

    public static void main(String[] args) throws IOException
    {   
        LinkedList tdm = new LinkedList();
        Scanner s = new Scanner(System.in);
        int choice, ch;
        boolean eof = false;
        File Out = new java.io.File("Entries.txt");
        FileOutputStream fOut = new FileOutputStream(Out, true);
        DataOutputStream dOut = new DataOutputStream(fOut);

        System.out.println("Doubly Linked List\n");
        System.out.println("*********Telephone Directory Management*********");
        
        do
        {
	System.out.println("1. Admin User");
        System.out.println("2. Customer User");
        System.out.println("3. Exit");
        ch = s.nextInt();
	int Password = 12345;
	
	int password = 0;
	String username;
        if(ch==1)
	{
            System.out.println("Enter username");
            username = s.next();
            System.out.println("Enter password");
            password = s.nextInt();

            if(Password == password)
            {
                System.out.println("Welcome Admin");
            
            do
            {
                System.out.println("Enter your choice");
                System.out.println("1.Add Entry:" );
                System.out.println("2.Delete an entry:");
                System.out.println("3.Search an entry:");
                System.out.println("4.Update the entry:");
                System.out.println("5.Display all the entries:");
                System.out.println("6.Back to Main Menu");
                System.out.println("Select an option");
                choice = s.nextInt();

            switch(choice)

                {
                case 1:

                    System.out.println("Enter Name :");
                    String name=s.next();
                    name += s.nextLine();
                    String newLine = System.getProperty("line.separator");
                    dOut.writeUTF("NAME: " + name + newLine);
                    
                    System.out.println("Enter Address :");
                    String address = s.next();
                    address += s.nextLine();
                    dOut.writeUTF("ADDRESS: " + address + newLine);
                    
                    System.out.println("Enter Phone Number :");
                    String phoneNo = s.next();
                    dOut.writeUTF("PHONE NUMBER: " + phoneNo + newLine + newLine);
                    
                    if(phoneNo.length() == 10)
                    {
                        tdm.InsertEntry(name,address,phoneNo);
                    }
                    else
                    {
                        System.out.println("Enter valid number. The Phone Number consists of 10 digits\n");
                    }
                    break;

                    case 2:

                        System.out.println("Enter name you want to delete\n");
                        String c1=s.next();
                        c1 += s.nextLine();
                        tdm.DeleteNodeOfPos(tdm.head,c1);

                        break;
                    
                    case 3:
                        
                        System.out.println("Enter the name to be searched");
                        String search = s.next();
                        search += s.nextLine();
                        newnew = tdm.searchEntry(tdm.head,search);
                        System.out.println("Name: " + newnew.getName() + "\nAddress: " + newnew.getAddress() + "\nPhone Number: "  + newnew.getPhoneNo() + "\n");
                        break;
                        
                    case 4: 

                        System.out.println("What do you want to update?");
                        System.out.println("1.Phone Number :");
                        System.out.println("2.Address :");
                        int select = s.nextInt();

                            if(select == 1)
                            {
                                System.out.println("Enter the name of the number you want to update :");
                                String old = s.next();
                                old += s.nextLine();
                                System.out.println("Enter new number :");
                                String new_num=s.next();
                                if(new_num.length() == 10)
                                {
                                    tdm.updatePhoneNo(old, new_num);
                                }
                                else
                                {
                                    System.out.println("Enter valid number. The Phone Number consists of 10 digits\n");
                                }
                            }

                            else
                            {
                                System.out.println("Enter the name of the address you want to update :");
                                String old = s.next();
                                old += s.nextLine();
                                System.out.println("Enter new address :");
                                String new_add=s.next();
                                new_add += s.nextLine();
                                tdm.updateAddress(old, new_add);
                            }

                        break;

                    case 5:
                        
                        FileInputStream fin = new FileInputStream("Entries.txt");
                        DataInputStream din = new DataInputStream(fin);
                        System.out.println("Entries from file are: ");
                        
                        while(!eof)
                        {
                            try
                            {
                                System.out.println(din.readUTF() + din.readUTF() + din.readUTF());
                            }
                            catch (EOFException e)
                            {
                                eof=true;
                                System.out.println("End of file");
                            }
                        }
                        din.close();
                        fin.close();
                        
                        Node node = null; 
                        node = tdm.mergeSort(tdm.head);
                        System.out.println("Created Telephone Directory after sorting is :\n");
                        tdm.DisplayList(node);
                        break;
                        
                    case 6:
                        break;

                    default:
                        System.out.println("Incorrect choice! \nPlease Enter a valid choice!!\n");
                }
            }while(choice!=6);
            //sc.close();
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
            System.out.println("******Welcome Customer User******");
            
            do
            {
                System.out.println("1.Search Entry:");
                System.out.println("2.Display all the entries:");
                System.out.println("3.Back to Main Menu");
                c1 = s.nextInt();
                
                switch(c1)
                {
                    case 1:
                    
                        System.out.println("Enter the name to be searched");
                        String search = s.next();
                        search += s.nextLine();
                        newnew = tdm.searchEntry(tdm.head,search);
                        System.out.println("Name: " + newnew.getName() + "\nAddress: " + newnew.getAddress() + "\nPhone Number: "  + newnew.getPhoneNo() + "\n");
                        break;
                    
                    case 2:
                        
                        FileInputStream fin = new FileInputStream("Entries.txt");
                        DataInputStream din = new DataInputStream(fin);
                        System.out.println("Entries from file are: ");
                        
                        while(!eof)
                        {
                            try
                            {
                                System.out.println(din.readUTF() + din.readUTF() + din.readUTF());
                            }
                            catch (EOFException e)
                            {
                                eof=true;
                                System.out.println("End of file");
                            }
                        }
                        din.close();
                        fin.close();
                        
                        Node node = null; 
                        node = tdm.mergeSort(tdm.head);
                        System.out.println("Created Telephone Directory after sorting is :\n");
                        tdm.DisplayList(node);
                        break;
                    
                    case 3:
                        break;
                    
                    default:
                        System.out.println("Incorrect choice! \nPlease Enter a valid choice!!\n");
                        dOut.flush(); 
                        fOut.close();
                        dOut.close();
                }
            }while(c1 != 3);
            }
        else
        {
            while(ch!=3);
            s.close();
        }
    }while(ch!=3);
    s.close();
}
}       