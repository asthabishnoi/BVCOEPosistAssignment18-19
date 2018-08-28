/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentposist;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.UUID;


/**
 *
 * @author mca
 */
public class AssignmentPosist {
    static int i=2;
    static int h;
     static Node genesis=null;
    private static String getOwnerid() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static float getValue() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

      private static class Node{

       
          Node left, right;
          Node leftChild;
Node rightChild;
   static Date timestamp;
    static int nodeNumber;
    static String data;
    static String nodeId;
    static String referenceNodeId;
   static String childReferenceNodeId[]= new String[20];
    static String genesisRefernceNodeId;
    static String HashValue;
      
    
      public Node(String data){
          this.data=data;
          right=null;
          left=null;
           CreateDataValues();
          timestamp=new Date();
          nodeNumber= createnodeNumber();
          nodeId= String.valueOf(UUID.randomUUID());
          referenceNodeId= createreferenceNodeId();
          childReferenceNodeId= createchildReferenceNodeId();
          genesisRefernceNodeId= creategenesisRefernceNodeId();
          HashValue= createHashValue();
      }
     

        private static String createnodeId() {
            System.out.println("Enter nodeId");
            Scanner s= new Scanner(System.in);
            return s.next();
            
            
        }
      

        private static int createnodeNumber() {
            return i++;
        }

        private static String createreferenceNodeId() {
           
           return null;
        }

        private static String[] createchildReferenceNodeId() {
            Node foundNode= search(data,genesis);
            String childrefid[]= new String[4];
            childrefid[0]=foundNode.left.nodeId;
            childrefid[1]=foundNode.right.nodeId;
             return childrefid;
        }

        private static String creategenesisRefernceNodeId() {
            if(genesis==null){
                return null;
            }
            else return genesis.toString();
        }

        private  String createHashValue() {
           
            h = timestamp.hashCode() * 23;
    h += data.hashCode() * 17;
    h += nodeNumber * 19;
    h += nodeId.hashCode() * 29;
    h += referenceNodeId.hashCode() * 2;
    h += childReferenceNodeId.hashCode() * 5;
    h += genesisRefernceNodeId.hashCode() * 7;
    h += hashCode();
    return String.valueOf(h);
        }
       


        private static void CreateDataValues() {
             Scanner s= new Scanner(System.in);
             String ownerId=getOwnerid();
             float value=getValue();
             System.out.print("Enter Owner Name");
             String name=s.next();
             int h1 = ownerId.hashCode() * 31;
             h1+=value*37;
             h1+=name.hashCode()*41;
             
        }
     }
       public static void CreategenesisNode(){
           Scanner s= new Scanner(System.in);
           String data= s.next();
            genesis= new Node(data);
       }
      
       public static void createChildNode(){
           System.out.println("Enter the value of the node whose child you want to be created");
           
           Scanner s=new Scanner(System.in);
           String nodeData=s.next();
           if(genesis==null){
               CreategenesisNode();
           }
           else{
              Node foundNode= search(nodeData,genesis);
               System.out.println("Enter the value of the child node  you want to be created");
               String data=s.next();
               if(foundNode.left==null){
               foundNode.left=new Node(data);}
                       
           else{
    if(foundNode.right==null){
               foundNode.right=new Node(data);}
                       }
           }
}
       
       private static Node search(String name, Node node){
    if(node != null){
        if(Node.data.equals(name)){
           return node;
        } else {
            Node foundNode = search(name, node.left);
            if(foundNode == null) {
                foundNode = search(name, node.right);
            }
            return foundNode;
         }
    } else {
        return null;
    }
}
    public static void main(String[] args) {
         // TODO code application logic here
    }
}
