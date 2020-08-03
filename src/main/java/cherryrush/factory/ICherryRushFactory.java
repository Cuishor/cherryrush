package cherryrush.factory;

import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JPanel;

public interface ICherryRushFactory {

	public List<JButton> getLevelButtons();
	public Properties getProperties() throws Exception;
	public JPanel getLevelInstanceByLevel(String coordinates);
		
}
