/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarysearchtree;

import binarysearchtree.builder.PanelBuilder;
import javax.swing.JPanel;

/**
 *
 * @author rakshit
 */
public
        class Tree
      {
      
      public
              TreeNode root;

//      public
//              PanelBuilder panelBuilder;

      public
              JPanel topPanel, infoPanel;

      public
              Tree()
            {
//              panelBuilder = builtPanel;
//              treePanel = panelBuilder.treePanel;
            System.out.println("** cons ***");

            }
            
      public
              void InOrderTraversal()
            {
            if (root != null)
                  {
                  root.InOrderTraversal();
                  }
            }

      public
              void preOrderTraversal()
            {
            if (root != null)
                  {
                  root.preOrderTraversal();
                  }
            }

      public
              void postOrderTraversal()
            {
            if (root != null)
                  {
                  root.postOrderTraversal();
                  }
            }

      public
              TreeNode delete(int value)
            {
            root = root.delete(root, value);
            return root;
            }

      public
              Pair insertion(int value, TreeNode root, JPanel treePanel, PanelBuilder panelBuilder, Boolean notFirst)
            {
            if (notFirst)
                  {
                  panelBuilder = panelBuilder.setX(treePanel.getBounds().width / 2);
                  panelBuilder = root.add(value, treePanel, panelBuilder);
                  return new Pair(root, panelBuilder.X);
                  }
            
            return new Pair(root, panelBuilder.X);
            }

      }
