package org.connerhansen.sprinkles.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TreeModelEvent;
import javax.swing.tree.TreeModel;

import org.connerhansen.sprinkles.Sprinkles;
import org.connerhansen.sprinkles.settings.SettingExecutor;
import org.connerhansen.sprinkles.settings.UserSetting;

import sun.font.FontFamily;

public class GUI extends JFrame {
//	private JComponent elements[];
	private Sprinkles s;
	private JSplitPane p;
	private JPanel left;
	private JPanel right;
	private JTree attributeTree;
	private JProgressBar pb;
	
	public GUI(Sprinkles s){
		super("Sprinkles");
		this.s = s;
		this.setSize(200, 200);
		this.setTitle("Sprinkles");
		
		this.setJMenuBar(createMenubar());
		
		left = new JPanel();
		left.setBackground( Color.white );
		
		JTree tree = new JTree();
		
		right = new JPanel();
		right.setBackground( Color.blue );
		
		p = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, left, right);
		p.setDividerLocation(150);
		p.setOneTouchExpandable( true );
		
		pb = new JProgressBar(0, 100);
		pb.setIndeterminate( true );
		pb.setPreferredSize( new Dimension( 400, 24) );
		
		JPanel content = new JPanel();
		BoxLayout b = new BoxLayout(content, BoxLayout.Y_AXIS);
		
		content.setLayout( b );
		content.add(p);
//		content.add(pb);
		
		this.getContentPane().add( content, BorderLayout.CENTER );
		this.getContentPane().add( pb, BorderLayout.SOUTH );
		
		try {
            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
	}
	
	private JMenuBar createMenubar(){
		JMenuBar m = new JMenuBar();
		JMenu file = new JMenu( "File" );
//		JMenu edit = new JMenu( "Edit" );
//		JMenu view = new JMenu( "View" );
		
		JMenuItem fileNew = new JMenuItem( "New Theme" );
		JMenuItem fileOpen = new JMenuItem( "Open Theme" );
		
		file.add(fileNew);
		file.add(fileOpen);
		
		file.getPopupMenu().setBorderPainted( true );
		file.getPopupMenu().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		m.add(file);
//		m.add(edit);
//		m.add(view);
		
		return m;
	}
}
