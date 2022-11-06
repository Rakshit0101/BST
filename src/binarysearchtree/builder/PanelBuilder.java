/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package binarysearchtree.builder;

import binarysearchtree.Pair;
import binarysearchtree.Points;
import binarysearchtree.Tree;
import binarysearchtree.TreeNode;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author rakshit
 */
public
        class PanelBuilder extends JFrame implements ActionListener, KeyListener
      {

      public
              int X = 300, Y = 75;
      
      public
              JPanel topPanel, treePanel, infoPanel;

      public
              JPanel topLeftPanel, topRightPanel;

      public
              JButton btnAdd, btnDelete;

      public
              JTextField tf;

      public
              Graphics2D g2;

      public
              Rectangle size;

      public
              JLabel labelInorder, labelPreorder, labelPostorder, labelHeight;

      public
              JLabel ansInorder, ansPreorder, ansPostorder, ansHeight;

      public
              FontMetrics fontMatrix;

      public TreeNode root;

      Tree tree;

      public
              PanelBuilder(Tree importedTree)
            {
            tree = importedTree;
            initialize();
            }

         public PanelBuilder setX(int w) {
              X = w;
              return this;
              }
         
       public PanelBuilder setRoot(TreeNode root) {
              this.root = root;
              return this;
              }       
                
      private
              void initialize()
            {
            setSize(1300, 700); // frame size

            size = getBounds();
            X = size.width / 2;

            topPanel = new JPanel(new BorderLayout());
            Rectangle top = topPanel.getBounds();

            topLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
            topPanel.add(topLeftPanel, BorderLayout.WEST);

            topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            topPanel.add(topRightPanel, BorderLayout.EAST);

            treePanel = new JPanel(null);
            treePanel.setPreferredSize(new Dimension(size.width, size.height - 300));

            infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.setPreferredSize(new Dimension(size.width, 200));

            // Height of BST label
            labelHeight = new JLabel("BST Height : ");
            labelHeight.setFont(new Font("Calibri", Font.BOLD, 20));
            topLeftPanel.add(labelHeight);

            // Height of BST answer
            ansHeight = new JLabel("0");
            ansHeight.setFont(new Font("Calibri", Font.BOLD, 20));
            ansHeight.setPreferredSize(new Dimension(50, 30));
            topLeftPanel.add(ansHeight);

            // For geting data.
            tf = new JTextField("");
            tf.setFont(new Font("Arial", Font.BOLD, 20));
            tf.setPreferredSize(new Dimension(150, 30));
            tf.addKeyListener(this);
            topRightPanel.add(tf);

            // Add Button
            btnAdd = new JButton("Add");
            btnAdd.setFont(new Font("Arial", Font.BOLD, 20));
            btnAdd.addActionListener(this);
            topRightPanel.add(btnAdd);

            // Delete Button
            btnDelete = new JButton("Delete");
            btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
            btnDelete.addActionListener(this);
            topRightPanel.add(btnDelete);

            // Inorder label
            labelInorder = new JLabel("Inorder :");
            labelInorder.setFont(new Font("Times New Roman", Font.BOLD, 20));
            infoPanel.add(labelInorder);
            infoPanel.add(Box.createRigidArea(new Dimension(7, 5)));

            // Inorder traversal answer
            ansInorder = new JLabel("BST is empty.");
            ansInorder.setFont(new Font("Arial", Font.PLAIN, 18));
            infoPanel.add(ansInorder);

            infoPanel.add(Box.createRigidArea(new Dimension(7, 15)));

            // Preorder label
            labelPreorder = new JLabel("Preorder :");
            labelPreorder.setFont(new Font("Times New Roman", Font.BOLD, 20));
            infoPanel.add(labelPreorder);

            infoPanel.add(Box.createRigidArea(new Dimension(7, 5)));

            // Preorder traversal answer
            ansPreorder = new JLabel("BST is empty.");
            ansPreorder.setFont(new Font("Arial", Font.PLAIN, 18));
            infoPanel.add(ansPreorder);

            infoPanel.add(Box.createRigidArea(new Dimension(7, 15)));

            // Postorder label
            labelPostorder = new JLabel("Postorder :");
            labelPostorder.setFont(new Font("Times New Roman", Font.BOLD, 20));
            infoPanel.add(labelPostorder);

            // Postorder traversal answer
            ansPostorder = new JLabel("BST is empty.");
            ansPostorder.setFont(new Font("Arial", Font.PLAIN, 18));
            infoPanel.add(ansPostorder);

            tf.requestFocusInWindow();

            add(topPanel, BorderLayout.NORTH);
            add(treePanel, BorderLayout.CENTER);
            add(infoPanel, BorderLayout.SOUTH);

            setTitle("Binary Search Tree Visualization"); // Title Frame
            setResizable(false);
            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

      @Override
      public
              void paint(Graphics g)
            {
            super.paintComponents(g);

            g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3.0f));

            Stack<TreeNode> s = new Stack<>();
            TreeNode curr = root;
            Points pts;
            int offset = topPanel.getBounds().height;
            while (!s.isEmpty() || curr != null)
                  {
                  while (curr != null)
                        {
                        s.push(curr);
                        curr = curr.leftChild;
                        }
                  if (!s.isEmpty())
                        {
                        curr = s.pop();
                        }
                  pts = curr.p;
                  g2.drawLine(pts.x1 + 7, pts.y1 + 30 + offset, pts.x2 + 3, pts.y2 + 10 + offset);
                  curr = curr.rightChild;
                  }
            }

      public
              void keyPressed(KeyEvent evt)
            {
            }

      public
              void keyReleased(KeyEvent evt)
            {
            }

      public
              int getWidth(TreeNode node)
            {
            fontMatrix = getFontMetrics(node.information.getFont());
            int width = fontMatrix.stringWidth(node.information.getText());
            return width < TreeNode.TEXT_WIDTH ? TreeNode.TEXT_WIDTH : (width + 5);
            }

      @Override
      public
              void actionPerformed(ActionEvent evt)
            {
            if (tf.isEnabled())
                  {
                  try
                        {
                        int data = Integer.parseInt(tf.getText());
                        if (evt.getSource() == btnAdd)
                              {
                              insertion(data);
                              }
                        else
                              {
                              root = tree.delete(data);
                              }
                        tf.setText("");
                        tf.requestFocusInWindow();
                        }
                  catch (Exception e)
                        {
                        JOptionPane.showMessageDialog(null, "Please Enter Integer.");
                        }
                  }
            }
 
      public 
              void addComp(Component comp, PanelBuilder pb)
            { 
            treePanel.add(comp);
                  System.err.println(pb);
                   System.err.println(this);
                  treePanel.validate();
                  treePanel.repaint();
                 validate();
                 repaint();
            }
              
      public
              void insertion(int value)
            {
                 
            if (root == null)
                  {
                    root = new TreeNode(value);
                  int width = getWidth(root);
                  root.information.setBounds(getBounds().width / 2, 10, width, 40);
                  root.p = new Points(0, 0, 0, 0);
                 addComp(root.information, this);
                  } else {
                   Pair pair = tree.insertion(value, root, treePanel, this, true);
                  root = pair.tn;
                  X = pair.X;
            }
            }

      @Override
      public
              void keyTyped(KeyEvent evt)
            {
            char c = evt.getKeyChar();
            if (!tf.isEnabled())
                  {
                  return;
                  }
            else if (c == 'a' || c == 'A' || c == '\n')
                  {
                  try
                        {
                        String data = tf.getText();
                        evt.consume(); // Not type 'a' or 'A' character in textfield
                        if (!data.isEmpty())
                              {
                              insertion(Integer.parseInt(data));
                              }
                        else
                              {

                              throw new Exception();
                              }
                        tf.requestFocusInWindow();
                        }
                  catch (Exception e)
                        {
                        JOptionPane.showMessageDialog(null, "Please Enter Integer.");
                        }
                  tf.setText("");
                  }
            else if (c == 'd' || c == 'D')
                  {
                  try
                        {
                        String data = tf.getText();
                        evt.consume(); // Not type 'd' or 'D' character in textfield
                        if (!data.isEmpty())
                              {
                              root = tree.delete(Integer.parseInt(data));
                              }
                        tf.requestFocusInWindow();
                        }
                  catch (Exception e)
                        {
                        JOptionPane.showMessageDialog(null, "Please Enter Integer.");
                        }
                  tf.setText("");
                  }
            else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
                  {
                  evt.consume();
                  }
            }
              
//      public void setInfo() {
//		TreeNode.Height height = new calculateHeight(root);
//
//		if (height.root == 0) {
//			ansInorder.setText("BST is empty.");
//			ansPostorder.setText("BST is empty.");
//			ansPreorder.setText("BST is empty.");
//		} else {
//			ansInorder.setText(root.InOrderTraversal());
//			ansPostorder.setText(postorder(root));
//			ansPreorder.setText(preorder(root));
//		}
//
//		ansHeight.setText(height.root + "");
//	}
      

      }
