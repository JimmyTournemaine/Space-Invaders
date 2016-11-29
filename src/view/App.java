package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.GameModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class App extends JFrame implements ActionListener, MouseListener {

	private static final int LOOP_DELAY = 500;
	private static final long serialVersionUID = -3449937559620207851L;
	private JPanel contentPane;
	GameModel model;
	JComponent canvas;
	Timer timer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
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
		canvas.addMouseListener(this);
		contentPane.add(canvas, BorderLayout.CENTER);

		timer = new Timer(LOOP_DELAY, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		canvas.repaint();
		int res = model.move();
		if (res == GameModel.GAME_OVER) {
			timer.stop();
			if (JOptionPane.showConfirmDialog(this, "Start a new Game ?", "Game Over !",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				model.newGame();
				timer.restart();
			}
		} else if (res == GameModel.GAME_LEVEL_DONE) {
			model.nextLevel();
		}
		model.notifyObservers(model.getScore());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (timer.isRunning())
			timer.stop();
		else
			timer.start();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Nothing to do
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Nothing to do
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Nothing to do
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (timer.isRunning())
			timer.stop();
	}
}
