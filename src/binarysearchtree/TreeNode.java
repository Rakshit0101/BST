/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarysearchtree;

import binarysearchtree.builder.PanelBuilder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static javafx.scene.input.KeyCode.X;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author rakshit
 */
public class TreeNode extends Tree  {
    
                                  public static int TEXT_WIDTH =  40;
		public static int TEXT_HEIGHT = 40;
                
              public JLabel information;  
             public int data;
             public TreeNode leftChild;
             public TreeNode rightChild;
             public Points p;
    
    
    public TreeNode (int data){
   this.data = data;
   information   = new JLabel(data + "", SwingConstants.CENTER);
     information.setFont(new Font("Arial", Font.BOLD, 20));
     information.setBorder(BorderFactory.createLineBorder(Color.black));
    information.setOpaque(true);
    information.setBackground(Color.green);
			p = null;
    }
    
    public PanelBuilder add(int value, JPanel treePanel, PanelBuilder panelBuilder){
        TreeNode newNode = new TreeNode(value);
        		int width = panelBuilder.getWidth(newNode);

        if(value==data){
            JOptionPane.showMessageDialog(null, value + "  already exist.");
        return panelBuilder;
        }
        
        
       
                                                      int x = information.getX();
			int y = information.getY();
			Dimension preDimension = information.getSize();
			Dimension currDimension = new Dimension(width, TEXT_HEIGHT);
        panelBuilder =  panelBuilder.setX(panelBuilder.X/2);
        int X = panelBuilder.X;
        int Y = panelBuilder.Y;
        
        if(value<data){
     
    if(leftChild==null){
    leftChild = newNode;
           newNode.information.setBounds(x - X, y + Y, width, 40);
           newNode.p = new Points(x, y + preDimension.height / 2, x - X + currDimension.width / 2,y + Y + currDimension.height / 2);
						
    }
    else {
    leftChild.add(value, treePanel, panelBuilder);
    }
    }
        else{
          if(rightChild==null){
    rightChild = newNode;
    System.err.println(x + X - 3 +"="+ y + Y +"="+ width);
    newNode.information.setBounds(x + X, y + Y, width, 40);  
    newNode.p = new Points(x + preDimension.width, y + preDimension.height / 2,x + X + currDimension.width / 2, y + Y + currDimension.height / 2);
						
    }
    else {
    rightChild.add(value, treePanel, panelBuilder);
    }
        }
        
 panelBuilder.addComp (newNode.information, panelBuilder);

 return panelBuilder.setRoot(newNode);
    }
    
     public void preOrderTraversal(){
           System.out.print(data +",");
         
      if(leftChild!=null){
      leftChild.preOrderTraversal();
      }
      
        if(rightChild!=null){
      rightChild.preOrderTraversal();
      }
      }
    
    
      public void  InOrderTraversal(){
      if(leftChild!=null){
      leftChild.InOrderTraversal();
      }
      System.out.print(data +",");
        if(rightChild!=null){
      rightChild.InOrderTraversal();
      }
      }
      
      
      public void postOrderTraversal(){
      if(leftChild!=null){
      leftChild.postOrderTraversal();
      }
      
        if(rightChild!=null){
      rightChild.postOrderTraversal();
      }
        
          System.out.print(data +",");
      }
      
      public TreeNode delete(TreeNode root,int value){
      if(root==null){
      return root;
      }
     
     if(value<root.data){
     root.leftChild  =  delete(root.leftChild,value);
     }
     
     else if(value>root.data){
     root.rightChild  =  delete(root.rightChild,value);
     }
     
     else{
         
     if(root.leftChild==null){
     return root.rightChild;
     }
     
     else if(root.rightChild==null){
     return root.leftChild;
     }
     
     else{
     root.data = root.leftChild.max();
     root.leftChild = delete(root.leftChild,root.data);
     }
     
     }
     
     return root;
      }
      
      public int max(){
      if(rightChild==null){
      return data;
      }
      else{
      return rightChild.max();
      }
      }
      
      public Height calculateHeight(TreeNode root) {
		if (root == null) {
			return new Height();
		}
		Height leftChild = calculateHeight(root.leftChild);
		Height rightChild = calculateHeight(root.rightChild);
		Height current = new Height(leftChild.root, rightChild.root);
		current.root = 1 + Math.max(leftChild.root, rightChild.root);
		return current;
	}
      
      	public static class Height {
		public int root, left, right;

		Height() {
			this.root = 0;
			this.left = 0;
			this.right = 0;
		}

		Height(int left, int right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return Integer.toString(this.root);
		}
	}

}
