package org.cap.app.util;

import org.cap.app.exceptions.*;

public class ValidationUtil {

	public static void checkName(String name) {

		if (name == null || name.isEmpty()) {
			throw new InvalidNameException("Name not valid.");
		}

	}

}
