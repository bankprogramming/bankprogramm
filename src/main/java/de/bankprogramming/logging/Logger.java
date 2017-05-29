/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.logging;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Logger {

	private static File logFile;

	private static ArrayList<String> log;

	private Gson gson;

	/**
	 * Loads or creates the text file for the logging.
	 */
	public Logger() {
		gson = new Gson();
		logFile = new File("log.json");
		boolean fileloaded = false;
		if (!logFile.exists()) {
			try {
				fileloaded = logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			fileloaded = true;
		}

		if (!fileloaded) {
			// TODO throw logging exception
		} else {
			try (FileReader reader = new FileReader(logFile)) {
				log = gson.fromJson(reader, (Type) log);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the log
	 */
	public ArrayList<String> getLog() {
		return log;
	}

	/**
	 *
	 * @param message
	 */
	public static void logToFile(String message) {
		log.add(message);
	}

	/**
	 *
	 * @param message
	 */
	public static void logToConsole(String message) {
		System.out.println(message);
	}
}
