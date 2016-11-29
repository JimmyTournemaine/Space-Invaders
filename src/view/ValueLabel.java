package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class ValueLabel extends JLabel implements Observer {

	private String str;
	private static final long serialVersionUID = -2002923302303017240L;

	public ValueLabel(String string, Object defaultValue) {
		str = string;
		this.setText(String.format("%s : %s", str, defaultValue));
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setText(String.format("%s : %s", str, arg));
	}

}
