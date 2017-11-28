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

import java.util.Map;

/**
 * No-op version of Log4j 1.2 LoggingEvent.
 */
public class LoggingEvent implements java.io.Serializable {

	public static final String[] EMPTY_STRING_ARRAY = new String[0];
	private Category logger;
	private Priority level;
	public String fqnOfCategoryClass;
	public long timeStamp;

	public LoggingEvent(String fqnOfCategoryClass, Category logger,
						Priority level, Object message, Throwable throwable) {
		this.fqnOfCategoryClass = fqnOfCategoryClass;
		this.logger = logger;
		this.level = level;
		this.timeStamp = System.currentTimeMillis();
	}

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
		this.fqnOfCategoryClass = fqnOfCategoryClass;
		this.logger = logger;
		this.level = level;
		this.timeStamp = timeStamp;
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
		return (Level) level;
	}

	public String getThreadName() {
		return Thread.currentThread().getName();
	}
}
