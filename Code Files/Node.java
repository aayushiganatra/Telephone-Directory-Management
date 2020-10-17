/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author aayus
 */

class Node
{
    protected String name, address, phoneNo;
    protected Node next, prev;

/* Constructor */
public Node(String name1,String address1, String phoneNo1)
{
    name = name1;
    address = address1;
    phoneNo = phoneNo1;
}

    public String getName() 
    {
      return name;
    }
    public void setName(String name1)
    {
        name = name1;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address1)
    {
        address = address1;
    }
    public String getPhoneNo()
    {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo1)
    {
        phoneNo = phoneNo1;
    }
    public Node getNext()
    {
        return next;
    }
    public void setNext(Node next1)
    {
        next = next1;
    }
}