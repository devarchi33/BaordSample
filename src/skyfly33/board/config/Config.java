package skyfly33.board.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {
	static Logger logger = LoggerFactory.getLogger(Config.class);

	private static Config config;
	private Properties properties;
	private String propPath;

	public static Config getInstance() {
		if (config == null) {
			config = new Config();
		}

		return config;
	}

	public static Config getInstance(String configPath) {
		if (config == null) {
			config = new Config();
		}

		return config;
	}

	private Config() {
		ClassLoader cl;
		cl = Thread.currentThread().getContextClassLoader();//was에서 돌아가는 web application일 때.

		if (cl == null) {
			cl = ClassLoader.getSystemClassLoader();//독립형 java application일 때.
		}

		propPath = cl.getResource("board.properties").getPath();
//		propPath = "/home/jeus/jeus6/webhome/app_home/BoardSample/WEB-INF/classes";

		properties = new Properties();

		// file read
		File src = new File(propPath);
//		File src = new File("classpath:/board.properties");
		if (!src.exists()) {
			logger.debug("####### can't find board config property src file...");
			logger.debug("####### now propPath : " + propPath);
		} else {
			InputStream in = null;
			try {
				in = new FileInputStream(src);
				properties.load(in);
			} catch (FileNotFoundException e) {
				logger.debug("####### can't find board config properties...");
			} catch (IOException e) {
				logger.debug("####### can't load board config properties...");
			} finally {
				try {
					if (in != null)
						in.close();
				} catch (Exception e) {
					logger.debug("Exception : " +e.getMessage());
				}
			}
		}
	}

	public String getProperties(String key) {
		try {
			logger.debug("### property[" + key + "], value["+properties.getProperty(key) + "]");
			logger.debug("####### now propPath : " + propPath);
			return (String) properties.get(key);
		} catch (NullPointerException e) {
			logger.debug("board property file is null!!");
			return null;
		}
	}
}
