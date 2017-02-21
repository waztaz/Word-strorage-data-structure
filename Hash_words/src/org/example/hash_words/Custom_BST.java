package org.example.hash_words;

import java.util.*;

/**
 * Created by Raza Agha on 12/4/16.
 */
public class Custom_BST {
    public static  Node root;
    public Custom_BST(){
        this.root = null;
    }

    public int find(String word_id){
        Node current = root;
        while(current!=null){
            if(current.Word.compareTo(word_id)==0){
                return current.getFrequeny();
            }else if(current.Word.compareTo(word_id)>0){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return 0;
    }
    public boolean delete(String word_id){
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while(current.Word.compareTo(word_id)==0){
            parent = current;
            if(current.Word.compareTo(word_id)>0){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }
            if(current ==null){
                return false;
            }
        }
        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild ==true){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if(current.right==null){
            if(current==root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left==null){
            if(current==root){
                root = current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if(current.left!=null && current.right!=null){

            //now we have found the minimum element in the right sub tree
            Node successor	 = getSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node deleleNode){
        Node successsor =null;
        Node successsorParent =null;
        Node current = deleleNode.right;
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if(successsor!=deleleNode.right){
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }
    public void insert(String word_id){
        Node newNode = new Node(word_id);
        if(root==null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(current.Word.compareTo(word_id)==0){
                current.frequency+=1;
                break;
            }
            if(current.Word.compareTo(word_id)>0){
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
    public void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.Word + ": " + root.frequency);
            display(root.right);
        }
    }
    public void display(){
        display(root);
    }
    public void find_max(Node root,ArrayList<String> words,int [] max_frequency){
        if (root==null)
            return;
        if (root.frequency>max_frequency[0]){
            max_frequency[0]=root.frequency;
            words.clear();
            words.add(root.Word);}
        else if (root.frequency==max_frequency[0])
            words.add(root.Word);
        find_max(root.left,words,max_frequency);
        find_max(root.right,words,max_frequency);
    }
    public void find_max(){
        ArrayList<String> words = new ArrayList<String>();
        int [] max_frequency=new int[1];
        max_frequency[0]=0;
        find_max(this.root,words,max_frequency);
        System.out.println();
        System.out.print("The words with greatest frequency ");
        if (words.size()==1)
            System.out.print("is: " + "'" + words.get(0) + "'");
        else
            System.out.print("are: " + words);
        System.out.println( " with frequency= " + max_frequency[0]);
    }
    public static void main(String arg[]){
        Custom_BST b = new Custom_BST();
    }
}

class Node{
    int frequency;
    String Word;
    Node left;
    Node right;
    public Node(String Word){
        this.Word = Word;
        left = null;
        right = null;
        frequency=1;
    }
    public int getFrequency(){
        return frequency;
    }

    public int getFrequeny() {
        return frequency;
    }
}