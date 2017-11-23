package org.apache.log4j.spi;

import org.apache.log4j.Category;
import org.apache.log4j.Level;

import java.util.Map;

/**
 * No-op version of Log4j 1.2 LoggingEvent.
 */
public class LoggingEvent implements java.io.Serializable {

	public static final String[] EMPTY_STRING_ARRAY = new String[0];
	private Category logger;
	private final Level level;
	public String fqnOfCategoryClass;
	public long timeStamp;

	public LoggingEvent(String fqnOfCategoryClass,
						Category logger,
						long timeStamp,
						Level level,
						Object message,
						String threadName,
						ThrowableInformation throwable,
						String ndc,
						LocationInfo info,
						Map properties) {
		this.logger = logger;
		this.level = level;
	}

	public String getRenderedMessage() {
		return "";
	}

	public Category getLogger() {
		return logger;
	}

	public String[] getThrowableStrRep() {
		return EMPTY_STRING_ARRAY;
	}

	public Level getLevel() {
		return level;
	}

	public String getThreadName() {
		return Thread.currentThread().getName();
	}
}
