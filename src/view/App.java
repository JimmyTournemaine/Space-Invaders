package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.GameModel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Canvas;

public class App extends JFrame {

	private static final long serialVersionUID = -3449937559620207851L;
	private JPanel contentPane;
	GameModel model;
	JComponent canvas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
					frame.loop();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public App() throws IOException, InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblScore = new ValueLabel("Score", 0);
		lblScore.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblScore, BorderLayout.EAST);

		model = new GameModel();
		
		JLabel lblLife = new ValueLabel("Life", (int) model.getPlayer().getLife());
		panel.add(lblLife);

		model.addObserver((Observer) lblScore);
		model.getPlayer().addObserver((Observer) lblLife);
		
		canvas = new GameView(model);
		contentPane.add(canvas, BorderLayout.CENTER);
	}

	void loop() {
		Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				canvas.repaint();
            }
        });
		Timer timer2 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	model.moveInvaders();
				model.notifyObservers(model.getScore());
            }
        });
		
        timer.start();
        timer2.start();
	}
}
