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
public class LinkedList
{
    Node head, newn;

void InsertEntry(String name1, String address1, String phoneNo1) 
{ 
    /* 1. allocate node  
    * 2. put in the data */
    Node new_node = new Node(name1, address1, phoneNo1); 

    Node last = head; /* used in step 5*/

    /* 3. This new node is going to be the last node, so 
    * make next of it as NULL*/
    new_node.next = null; 

    /* 4. If the Linked List is empty, then make the new 
     node as head */
    if (head == null)
    { 
        new_node.prev = null; 
        head = new_node; 
        return; 
    } 

    /* 5. Else traverse till the last node */
    while (last.next != null) 
        last = last.next; 

    /* 6. Change the next of last node */
    last.next = new_node; 

    /* 7. Make last node as previous of new node */
    new_node.prev = last; 
}

void DeleteSpecificNode(Node del)
{ 
    /* base case */
    if (head == null || del == null)
    { 
        return; 
    } 
    /* If node to be deleted is head node */
    if (head == del)
    { 
        head = del.next; 
            /* After making del's next as head, need to make head's prev null 
            because there is nothing in front of it anymore*/
            if (head != null)
            { /* it could be possible that del is the only node in list.
                in this case,head will be null and list is empty*/
                head.prev = null;
            }
    }
    else
    { // del is not head, means it is second or later node
        // First get prev and next of del and then adjust links to remove del
        Node delsPrev = del.prev;
        Node delsNext = del.next;

        // Now we need to make del's prev's next point to del's next 
        delsPrev.next = delsNext; 
/* if del had no next, we are still fine. del will always have prev because
it's not head so no need to check for prev null*/

        /* Now we need to make next's prev point to del's prev which is prev.
        Note that next may be null because del may be last node in the list so need to check for null*/
        if (delsNext != null)
        {
            delsNext.prev = delsPrev;
        }	
    }

    /* Finally, free the memory occupied by del*/
    return; 
} 
void DeleteNodeOfPos(Node head_ref, String c1) //TODO This should delete node with given name and not position?
{ 
    Node n = searchEntry(head_ref, c1);
    
    /* delete the node pointed to by 'n' */
    DeleteSpecificNode(n); 
    return;
}

public Node searchEntry(Node node, String name)
{
    String searchEntry = name;

    Node n = head;
	while (n != null)
        {
            if (n.name.equalsIgnoreCase(searchEntry))
            { 
                System.out.println("Found a matching entry\n");
                /* found our node so break the loop */
                break;
            }
        n=n.next;
        };  
	
	if (n == null)
        {
            System.out.println("No Matching entry found!\n");
	} 
    return n;
}

public void updatePhoneNo(String old, String update)
{  
   if(head == null)
   {
      System.out.println("Linked List is Empty\n");
      return;
   } 

   Node current = searchEntry(head,old);
   if(current!=null)
   {
       current.phoneNo = update;
       System.out.println("Phone Number updated Successfully!");
   }
   else
   {
        System.out.println("Updation Unsuccessful!! \nThe name does not exist in the list: " + old);
   }
}
public void updateAddress(String old, String updateadd)
{
   if(head == null)
   {
        System.out.println("Linked List is Empty\n");
        return;
   } 

   Node current = searchEntry(head,old);
   if(current!=null)
   {
        current.address = updateadd;
        System.out.println("Address updated Successfully!");
   }
   else
   {
       System.out.println("Updation Unsuccessful!! \nThe name does not exist in the list: " + old);
   }
}

Node split(Node head)
{ 
       Node fast = head, slow = head; 
       while (fast.next != null && fast.next.next != null)
       { 
           fast = fast.next.next; 
           slow = slow.next; 
       } 
       Node temp = slow.next; 
       slow.next = null; 
       return temp; 
} 

Node mergeSort(Node node)
{ 
       if (node == null || node.next == null)
       { 
           return node; 
       } 
       Node second = split(node); 

       // Recur for left and right halves 
       node = mergeSort(node); 
       second = mergeSort(second); 

       // Merge the two sorted halves 
       return merge(node, second); 
} 

   // Function to merge two linked lists 
Node merge(Node first, Node second)
{ 
    // If first linked list is empty 
    if (first == null)
    { 
        return second; 
    } 

    // If second linked list is empty 
    if (second == null)
    { 
        return first; 
    } 

    // Pick the smaller value 
    if (first.name.compareTo(second.name) < 0)
    { 
        first.next = merge(first.next,second); 
        first.next.prev = first; 
        first.prev = null; 
        return first; 
    }
    else
    { 
        second.next = merge(first, second.next); 
        second.next.prev = second; 
        second.prev = null; 
        return second; 
    } 
}

public void DisplayList(Node node) 
{ 
    while (node != null)
    { 
        System.out.println("Name: " + node.name + " ");
        System.out.println("Address: " + node.address +" ");
        System.out.println("Phone Number: " + node.phoneNo +" \n");
        node = node.next; 
    } 
    System.out.println(); 
}
}