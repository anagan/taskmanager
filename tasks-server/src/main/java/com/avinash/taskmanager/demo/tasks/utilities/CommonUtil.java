/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.utilities;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author Avinash
 *
 */
public class CommonUtil {

	private CommonUtil() {
	}

	public static String UUID() {
		return java.util.UUID.randomUUID().toString();
	}

	public static Timestamp currentSqlTimeStamp() {
		return Timestamp.from(Instant.now());
	}
}
