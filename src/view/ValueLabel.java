/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package view;

import javax.swing.JLabel;

/**
 * A JLabel composed by a label and a value
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class ValueLabel extends JLabel {

	private String str;
	private static final long serialVersionUID = -2002923302303017240L;

	/**
	 * @param string The label
	 * @param defaultValue The default value to display
	 */
	public ValueLabel(String string, Object defaultValue) {
		this.str = string;
		this.setValue(defaultValue);
	}
	
	/**
	 * Set the value and update the view
	 * @param value The value to display
	 */
	public void setValue(Object value){
		this.setText(String.format("%s : %s", str, value));
	}

	


}
