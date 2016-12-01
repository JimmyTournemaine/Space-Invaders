package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameController;
import exception.NoMoreLevelException;
import model.GameModel;
import model.PlayerShip;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;

public class App extends JFrame implements ActionListener, MouseListener {

	public static final boolean DEBUG_MODE = true;

	private static final int LOOP_DELAY = 8;
	private static final long serialVersionUID = -3449937559620207851L;
	private JPanel contentPane;
	ValueLabel lblLife, lblScore;
	GameModel model;
	GameView canvas;
	GameController controller;
	Timer timer;
	private JProgressBar progressBar;

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
		setSize(GameModel.WIDTH, GameModel.HEIGHT + 40);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		lblScore = new ValueLabel("Score", 0);
		lblScore.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblScore, BorderLayout.EAST);

		model = new GameModel();

		lblLife = new ValueLabel("Life", model.getPlayer().getLife());
		panel.add(lblLife, BorderLayout.WEST);
		
		JPanel missiles = new JPanel();
		progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, PlayerShip.MAX_MISSILES);
		progressBar.setValue(PlayerShip.MAX_MISSILES);
		missiles.add(progressBar);
		panel.add(missiles, BorderLayout.CENTER);

		canvas = new GameView(model);
		canvas.addMouseListener(this);
		canvas.setPreferredSize(new Dimension(GameModel.WIDTH, GameModel.HEIGHT));
		this.setFocusable(true);
		this.requestFocusInWindow();

		contentPane.add(canvas, BorderLayout.CENTER);

		controller = new GameController(model, canvas);
		this.addKeyListener(this.controller);

		timer = new Timer(LOOP_DELAY, this);
	}

	public void stop() {
		timer.stop();
		controller.disable();
	}

	public void start() {
		timer.start();
		controller.enable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int res = model.move();
		this.lblLife.setValue(model.getPlayer().getLife());
		this.lblScore.setValue(model.getScore());
		this.progressBar.setValue(model.getPlayer().remainingMissiles());
		
		canvas.repaint();
		if (res == GameModel.GAME_OVER) {
			this.stop();
			if (JOptionPane.showConfirmDialog(this, "Start a new Game ?", "Game Over !",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				model.newGame();
				timer.restart();
			}
		} else if (res == GameModel.GAME_LEVEL_DONE) {
			try {
				model.nextLevel();
			} catch (NoMoreLevelException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
				this.stop();
				this.dispose();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (timer.isRunning())
			this.stop();
		else
			this.start();
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
			this.stop();
	}
}
