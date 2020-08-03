package cherryrush;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cherryrush.config.ApplicationConfiguration;
import cherryrush.factory.ICherryRushFactory;

@SpringBootApplication
public class Application {

	
	private static ApplicationContext applicationContext;
	
	private ICherryRushFactory cherryRushFactory;

	private JFrame frame;
	private JPanel startPanel;
	private JPanel levelSelectPanel;
	
	private List<JButton> levelButtonList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.setCherryRushFactory(applicationContext.getBean(ICherryRushFactory.class));
					window.initialize();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Application() {
//		this.setCherryRushFactory(applicationContext.getBean(CherryRushFactoryImpl.class));
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		startPanel = new JPanel();
		startPanel.setBackground(Color.WHITE);
		startPanel.setLayout(null);
		startPanel.setLayout(null);
		
		JLabel gameTitle = new JLabel("");
		gameTitle.setIcon(new ImageIcon("C:\\Users\\alex_\\Documents\\Projects\\cherryrush\\src\\main\\resources\\gameTitle.png"));
		gameTitle.setBounds(0, 139, 686, 254);
		startPanel.add(gameTitle);
		
		JButton startButton = new JButton("START");
		startButton.setBounds(174, 418, 329, 155);
		startButton.addActionListener(new StartAction());
		startPanel.add(startButton);
		
		frame.getContentPane().add(startPanel, BorderLayout.CENTER);
		
		levelSelectPanel = new JPanel();
		levelSelectPanel.setBackground(Color.WHITE);
		levelButtonList = cherryRushFactory.getLevelButtons();
		for (JButton btn : levelButtonList) {
			btn.setPreferredSize(new Dimension(200, 300));
			btn.setFont(new Font("Arial", Font.PLAIN, 40));
			btn.addActionListener(new SelectLevelAction());
			levelSelectPanel.add(btn);
		} 
	}
	
	private class StartAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			startPanel.setVisible(false);
			frame.getContentPane().add(levelSelectPanel, BorderLayout.CENTER);
			
		}
		
	}
	
	private class SelectLevelAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton contextButton = (JButton) e.getSource();
			String command = contextButton.getActionCommand();
			System.out.println("Button pressed: " + command + "\n");
			try {
				Properties properties = cherryRushFactory.getProperties();
				String levelCoordinates = properties.getProperty(CherryCrushConstant.LEVEL_PROPERTY_PREFIX + command);
				System.out.println("Coordinates from prop. file: " + levelCoordinates);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
	}
	
	public ICherryRushFactory getCherryRushFactory() {
		return cherryRushFactory;
	}

	public void setCherryRushFactory(ICherryRushFactory cherryRushFactory) {
		this.cherryRushFactory = cherryRushFactory;
	}
}
