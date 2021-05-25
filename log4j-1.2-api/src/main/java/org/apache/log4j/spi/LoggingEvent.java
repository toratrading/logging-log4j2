/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package org.apache.log4j.spi;

import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.apache.log4j.bridge.LogEventAdapter;

import java.util.Map;
import java.util.Set;

/**
 *  No-op version of Log4j 1.2 LoggingEvent. This class is not directly used by Log4j 1.x clients but is used by
 *  the Log4j 2 LogEvent adapter to be compatible with Log4j 1.x components.
 */
public class LoggingEvent implements java.io.Serializable {

	private static final String[] EMPTY_STRING_ARRAY = new String[0];

	private Category logger;
	private Priority level;
    public String fqnOfCategoryClass;
    public long timeStamp;
	private Object message;
	private ThrowableInformation throwableInfo;
	private String threadName;

    public LoggingEvent() {
    }


	public LoggingEvent(String fqnOfCategoryClass, Category logger,
						Priority level, Object message, Throwable throwable) {
		this(fqnOfCategoryClass, logger, System.currentTimeMillis(), level, message, throwable);
	}

	public LoggingEvent(String fqnOfCategoryClass, Category logger,
						long timeStamp, Priority level, Object message, Throwable throwable) {
		this.fqnOfCategoryClass = fqnOfCategoryClass;
		this.logger = logger;
		this.level = level;
		this.message = message;
		if (throwable != null) {
			this.throwableInfo = new ThrowableInformation(throwable);
		}
		this.timeStamp = timeStamp;
	}

	public LoggingEvent(String fqnOfCategoryClass,
						Category logger,
						long timeStamp,
						Level level,
						Object message,
						String threadName,
						ThrowableInformation throwableInfo,
						String ndc,
						LocationInfo info,
						Map properties) {
		this.fqnOfCategoryClass = fqnOfCategoryClass;
		this.logger = logger;
		this.level = level;
		this.timeStamp = timeStamp;
		this.message = message;
		this.throwableInfo = throwableInfo;
		this.threadName = threadName;
	}

    /**
     Set the location information for this logging event. The collected
     information is cached for future use.
     @return Always returns null.
     */
    public LocationInfo getLocationInformation() {
        return null;
    }

    /**
     * Return the level of this event. Use this form instead of directly
     * accessing the <code>level</code> field.
     * @return Always returns null.
     */
    public Level getLevel() {
        return (Level)level;
    }

    /**
     * Return the name of the logger. Use this form instead of directly
     * accessing the <code>categoryName</code> field.
     * @return Always returns null.
     */
    public String getLoggerName() {
        return logger.getName();
    }

    public String getFQNOfLoggerClass() {
        return fqnOfCategoryClass;
    }

    public final long getTimeStamp() {
        return timeStamp;
    }

    /**
     * Gets the logger of the event.
     * Use should be restricted to cloning events.
     * @return Always returns null.
     * @since 1.2.15
     */
    public Category getLogger() {
        return logger;
    }

    /**
     Return the message for this logging event.

     <p>Before serialization, the returned object is the message
     passed by the user to generate the logging event. After
     serialization, the returned value equals the String form of the
     message possibly after object rendering.
     @return Always returns null.
     @since 1.1 */
    public
    Object getMessage() {
        return message;
    }

    public
    String getNDC() {
        return null;
    }

    public
    Object getMDC(String key) {
        return null;
    }

    /**
     Obtain a copy of this thread's MDC prior to serialization or
     asynchronous logging.
     */
    public void getMDCCopy() {
    }

    public String getRenderedMessage() {
        return message == null ? "" : String.valueOf(message);
    }

    /**
     Returns the time when the application started, in milliseconds
     elapsed since 01.01.1970.
     @return the JVM start time.
     */
    public static long getStartTime() {
        return LogEventAdapter.getStartTime();
    }

    public String getThreadName() {
        if (this.threadName == null) {
            this.threadName = Thread.currentThread().getName();
        }
        return this.threadName;
    }

    /**
     Returns the throwable information contained within this
     event. May be <code>null</code> if there is no such information.

     <p>Note that the {@link Throwable} object contained within a
     {@link ThrowableInformation} does not survive serialization.
     @return Always returns null.
     @since 1.1 */
    public ThrowableInformation getThrowableInformation() {
        return throwableInfo;
    }

    /**
     Return this event's throwable's string[] representaion.
     @return Always returns null.
     */
    public String[] getThrowableStrRep() {
        return this.throwableInfo == null ? EMPTY_STRING_ARRAY : this.throwableInfo.getThrowableStrRep();
    }

    public void setProperty(final String propName,
            final String propValue) {

    }

    public String getProperty(final String key) {
        return null;
    }

    public Set getPropertyKeySet() {
        return null;
    }

    public Map getProperties() {
        return null;
    }

    public Object removeProperty(String propName) {
        return null;
    }
}
