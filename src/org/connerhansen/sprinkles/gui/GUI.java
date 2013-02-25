package org.connerhansen.sprinkles.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TreeModelEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;

import org.connerhansen.sprinkles.Driver;
import org.connerhansen.sprinkles.Sprinkles;
import org.connerhansen.sprinkles.attributes.Attribute;
import org.connerhansen.sprinkles.settings.SettingExecutor;
import org.connerhansen.sprinkles.settings.UserSetting;

import sun.font.FontFamily;

public class GUI extends JFrame {
//	private JComponent elements[];
	private Sprinkles s;
	private JSplitPane p;
	private JPanel guiContents;
//	private JPanel splitContent;
	private JScrollPane left;
	private JScrollPane right;
	private JTree attributeTree;
	private JProgressBar pb;
	
	public GUI(Sprinkles s){
		super("Sprinkles");
		this.s = s;
		this.setSize(200, 200);
		this.setTitle("Sprinkles");
		
		this.setJMenuBar(createMenubar());
		this.s = s;
		this.s.setGui( this );
		
		left = new JScrollPane( new JPanel() );
		right = new JScrollPane( new JPanel() );
		
		left.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		left.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
		
		p = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, left, right);
		p.setDividerLocation(150);
		p.setOneTouchExpandable( true );
		
		pb = new JProgressBar(0, 100);
		pb.setVisible( false );
		
		guiContents = new JPanel();
		BoxLayout b = new BoxLayout(guiContents , BoxLayout.Y_AXIS);
		
		guiContents.setLayout( b );
		guiContents.add( p );
		
		guiContents.setPreferredSize( new Dimension(640, 480));
		
		this.getContentPane().add( guiContents, BorderLayout.CENTER );
		this.getContentPane().add( pb, BorderLayout.SOUTH );
		
		try {
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    	e.printStackTrace();
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    	e.printStackTrace();
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    	e.printStackTrace();
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    	e.printStackTrace();
	    }
		
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	/**
	 * Builds the left bar tree list
	 * @param attributes
	 */
	public void constructLeftBar(List<Attribute> attributes){
		DefaultMutableTreeNode top =
		        new DefaultMutableTreeNode("Root");
		attributesToObject( attributes, top );
		
		attributeTree = new JTree(top);
		attributeTree.setBackground(Color.WHITE);
		attributeTree.setRootVisible(false);
		
		left = new JScrollPane( attributeTree );
		
		p.setLeftComponent( left );
	}
	
	private void attributesToObject(Attribute[] attributes, DefaultMutableTreeNode root){
		for(Attribute a : attributes){
			DefaultMutableTreeNode newNode = 
					new DefaultMutableTreeNode( a );
			if( a.isGroup() )
				attributesToObject( a.getChildren(), newNode );
			
			root.add( newNode );
		}
	}
	
	private void attributesToObject(List<Attribute> attributes, DefaultMutableTreeNode root){
		attributesToObject( attributes.toArray( new Attribute[ attributes.size() ]), root );
	}
	
	private JMenuBar createMenubar(){
		final JMenuBar m = new JMenuBar();
		JMenu file = new JMenu( "File" );
//		JMenu edit = new JMenu( "Edit" );
//		JMenu view = new JMenu( "View" );
		JMenu about = new JMenu( "About" );
		
		JMenuItem fileNew = new JMenuItem( "New Theme" );
		JMenuItem fileOpen = new JMenuItem( "Open Theme" );
		JMenuItem fileExit = new JMenuItem( "Exit" );
		fileExit.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.this.dispose();
			}
			
		});
		
		
		JMenuItem aboutAbout = new JMenuItem( "About Sprinkles" );
		aboutAbout.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog( GUI.this, "Contributors: Conner Hansen\n\n" +
						"Sprinkles Version: " + Driver.VERSION,
						"About Sprinkles", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		file.add(fileNew);
		file.add(fileOpen);
		file.add(fileExit);
		
		file.getPopupMenu().setBorderPainted( true );
		file.getPopupMenu().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		about.add(aboutAbout);
		
		about.getPopupMenu().setBorderPainted( true );
		about.getPopupMenu().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		m.add(file);
		m.add(about);
//		m.add(edit);
//		m.add(view);
		
		return m;
	}
}
