/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarysearchtree;

import binarysearchtree.builder.PanelBuilder;
import java.util.Scanner;

/**
 *
 * @author rakshit
 */
public class Main {

  
    public static void main(String[] args) {
      
       Tree obj  = new Tree();
        PanelBuilder panelBuilder = new PanelBuilder(obj);
        
       // new Pnel
       Scanner sc = new Scanner(System.in);
                int noOfNodes = sc.nextInt();
                for(int i =1;i<=noOfNodes;i++){
                    panelBuilder.insertion(sc.nextInt());
                }
                int delete = sc.nextInt();
                obj.InOrderTraversal();
                  System.out.println();
                obj.preOrderTraversal();
                  System.out.println();
                obj.postOrderTraversal();
                  System.out.println();
                obj.delete(delete);
                
                 obj.InOrderTraversal();
                   System.out.println();
                obj.preOrderTraversal();
                  System.out.println();
                obj.postOrderTraversal();
    }
    
}
