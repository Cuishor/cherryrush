package cherryrush.factory.impl;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cherryrush.factory.ICherryRushFactory;

@Component
public class CherryRushFactoryImpl implements ICherryRushFactory {

	@Value("${cherryrush.level.levels}")
	private String[] levels;
	
	public List<JButton> getLevelButtons() {
		List<JButton> levelButtonList = new ArrayList<>();
		try {
			//Properties properties = getProperties();
			
			for (String str : levels) {
				JButton button = new JButton();
				button.setText(String.valueOf(str.charAt(str.length() - 1)));
				levelButtonList.add(button);
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return levelButtonList;
	}
	
	@Override
	public Properties getProperties() throws Exception {
		Properties properties = new Properties();
		String propFileName = "level-design.properties";
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				properties.load(inputStream);
				
			} else {
				throw new FileNotFoundException("Property file " + propFileName + " has not been found.");
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
		
		return properties;
	}

	public String[] getLevels() {
		return levels;
	}

	public void setLevels(String[] levelCoordinates) {
		this.levels = levelCoordinates;
	}

	@Override
	public JPanel getLevelInstanceByLevel(String coordinates) {
		JPanel levelInstancePanel = new JPanel();
		String[] coordinatesArr = coordinates.split(",");
		System.out.println("Coordinates Array: " + coordinatesArr.toString());
		
		
		return levelInstancePanel;
	}


	

	

	
}
