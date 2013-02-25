package org.connerhansen.sprinkles.gui.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		this.add(Box.createVerticalGlue());
		constructPanel();
	}
	
	private void constructInformation(){
		JPanel information = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel idLabel = new JLabel( "Label: " );
		JLabel id = new JLabel( attribute.getId() );
		
		JLabel cssLabel = new JLabel( "CSS: " );
		JLabel css = new JLabel( attribute.getCss() );
		
		JLabel typeLabel = new JLabel( "Type: " );
		JLabel type = new JLabel( attribute.getType() );
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.0;
		information.add(idLabel, c);
		
		c.gridx = 1;
		c.weightx = 1.0;
		information.add(id, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0.0;
		information.add(cssLabel, c);
		
		c.gridx = 1;
		c.weightx = 1.0;
		information.add(css, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 0.0;
		information.add(typeLabel, c);
		
		c.gridx = 1;
		c.weightx = 1.0;
		information.add(type, c);
		
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
