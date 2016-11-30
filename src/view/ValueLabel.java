package view;

import javax.swing.JLabel;

public class ValueLabel extends JLabel {

	private String str;
	private static final long serialVersionUID = -2002923302303017240L;

	public ValueLabel(String string, Object defaultValue) {
		this.str = string;
		this.setValue(defaultValue);
	}
	
	public void setValue(Object value){
		this.setText(String.format("%s : %s", str, value));
	}

	


}
