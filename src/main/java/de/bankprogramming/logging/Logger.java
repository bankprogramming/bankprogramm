/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

	private static File logFile;
	private static FileWriter writer;

	/**
	 * Loads or creates the text file for the logging.
	 */
	public Logger() {
		logFile = new File("Log.txt");
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
			// throw logging exception
		} else {
			try {
				writer = new FileWriter(logFile, true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 *
	 * @param message
	 */
	public static void logToFile(String message) {
		if (logFile.exists() && logFile.canWrite()) {
			try {
				// should append the message to the files content
				// TODO test this!
				writer.write(message + "\n");
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 *
	 * @param message
	 */
	public static void logToConsole(String message) {
		System.out.println(message);
	}
}
