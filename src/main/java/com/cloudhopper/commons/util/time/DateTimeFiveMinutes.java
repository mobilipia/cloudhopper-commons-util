/**
 * Copyright (C) 2011 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.cloudhopper.commons.util.time;

import org.joda.time.DateTime;

/**
 *
 * 
 * @author joelauer
 */
public class DateTimeFiveMinutes extends DateTimePeriod {

    protected DateTimeFiveMinutes(DateTime start, DateTime end) {
        super(start, end, DateTimeDuration.FIVE_MINUTES, "yyyy-MM-dd-HH-mm", "MMMM d, yyyy HH:mm", "HH:mm", "mm");
    }

    @Override
    public DateTimePeriod getNext() {
        DateTime next = getStart().plusMinutes(5);
        return DateTimePeriod.createFiveMinutes(next);
    }

    @Override
    public DateTimePeriod getPrevious() {
        DateTime previous = getStart().minusMinutes(5);
        return DateTimePeriod.createFiveMinutes(previous);
    }

    @Override
    public DateTimeDuration getDefaultSubDuration() {
        return DateTimeDuration.MINUTE;
    }
    
}