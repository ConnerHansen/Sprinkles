package org.connerhansen.sprinkles.gui.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.connerhansen.sprinkles.attributes.Attribute;

public class AttributePanel extends JPanel {
	private Attribute attribute;
	
	public AttributePanel(Attribute attribute){
		super();
		BoxLayout l = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout( l );
		
		if( attribute.isGroup() == false )
			this.add( Box.createHorizontalGlue() );
		
		this.attribute = attribute;
		constructInformation();
		
//		if( attribute.isGroup() == false )
			this.add(Box.createVerticalGlue());
		
		constructPanel();
	}
	
	private JPanel createVerticalList( String[] strings, boolean decorate ){
		JPanel list = new JPanel();
		BoxLayout l = new BoxLayout( list, BoxLayout.Y_AXIS );
		list.setLayout( l );
		list.setAlignmentX( JPanel.RIGHT_ALIGNMENT );
		
		for( String s : strings ){
//			JLabel label = new JLabel( s );
//			
//			list.add( label );
			if( decorate ){
				JTextField field = new JTextField( s );
				field.setEditable( false );
				field.setColumns( 10 );
				
				list.add( field );
			} else {
				JLabel label = new JLabel( s );
				list.add( label );				
			}
		}
		
		if( decorate ){
//			list.setBackground( Color.white );
//			list.setBorder( BorderFactory.createEtchedBorder() );
		}
		
		return list;
	}
	
	private JPanel createHorizontalSet( Component[] comps ){
		JPanel list = new JPanel();
		BoxLayout l = new BoxLayout( list, BoxLayout.X_AXIS );
		list.setLayout( l );
		
		for( Component c : comps ){
			list.add( c );
		}
		
		return list;
	}
	
	private JTextField createLockedTextField( String s ){
		JTextField t = new JTextField( s );
		
		t.setEditable( false );
		t.setMaximumSize( t.getPreferredSize() );
		
		return t;
	}
	
	private void constructInformation(){
//		JPanel information = new JPanel(new GridBagLayout());
//		GridBagConstraints c = new GridBagConstraints();
//		
//		information.setBackground(Color.GREEN);
//		
//		c.fill = GridBagConstraints.HORIZONTAL;
		JPanel information = new JPanel();
		BoxLayout iLayout = new BoxLayout( information, BoxLayout.Y_AXIS );
		
		information.setLayout( iLayout );
		
		information.add( createHorizontalSet(
				new Component[]{
					new JLabel("Label: "),
					createLockedTextField(attribute.getId()),
					Box.createHorizontalGlue()}
				));
		
		if( !attribute.isGroup() )
			information.add( createHorizontalSet(
					new Component[]{
						new JLabel("CSS: "),
						createLockedTextField(attribute.getCss()),
						Box.createHorizontalGlue()}
					));
		
		information.add( createHorizontalSet(
				new Component[]{
					new JLabel("Type: "),
					createLockedTextField(attribute.getType()),
					Box.createHorizontalGlue()}
				));
		
//		if( attribute.isGroup() ){
//			information.add( createVerticalList( new String[]{
//					"Label: ",
//					"Type: "
//			}, false));
//			
//			information.add( createVerticalList( new String[]{
//					attribute.getId() + " ",
//					attribute.getType() + " "
//			}, true));
//		} else {
//			information.add( createVerticalList( new String[]{
//					"Label: ",
//					"CSS: ",
//					"Type: "
//			}, false));
//			
//			information.add( createVerticalList( new String[]{
//					attribute.getId() + " ",
//					attribute.getCss() + " ",
//					attribute.getType() + " "
//			}, true));
//		}
//		
		information.add( Box.createVerticalGlue() );
		
		
//		JLabel idLabel = new JLabel( "Label: " );
//		JLabel id = new JLabel( attribute.getId() );
//		
//		JLabel cssLabel = new JLabel( "CSS: " );
//		JLabel css = new JLabel( attribute.getCss() );
//		
//		JLabel typeLabel = new JLabel( "Type: " );
//		JLabel type = new JLabel( attribute.getType() );
		
//		c.gridx = 0;
//		c.gridy = 0;
////		c.weightx = 0.0;
//		information.add(idLabel, c);
//		
//		c.gridx = 1;
////		c.weightx = 1.0;
//		information.add(id, c);
//		
//		c.gridx = 0;
//		c.gridy = 1;
////		c.weightx = 0.0;
//		information.add(cssLabel, c);
//		
//		c.gridx = 1;
////		c.weightx = 1.0;
//		information.add(css, c);
//		
//		c.gridx = 0;
//		c.gridy = 2;
////		c.weightx = 0.0;
//		information.add(typeLabel, c);
//		
//		c.gridx = 1;
////		c.weightx = 1.0;
//		information.add(type, c);
		
//		information.setMinimumSize( information.getSize() );
//		information.setMaximumSize( information.getSize() );
//		information.setPreferredSize( information.getSize() );
		
		this.add(information);
	}
	
	private void constructPanel(){
		this.setBorder( BorderFactory.createTitledBorder( attribute.getId() ));
		
		if( attribute.isGroup() )
			for(Attribute a : attribute.getChildren() ){
				this.add( new AttributePanel( a ));
				this.add( Box.createVerticalStrut(5) );
			}
	}
}
