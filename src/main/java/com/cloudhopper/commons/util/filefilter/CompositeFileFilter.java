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

package com.cloudhopper.commons.util.filefilter;

import java.io.File;
import java.io.FileFilter;

/**
 * Filters a file based on a composition of several other filters.
 * 
 * @author joelauer (twitter: @jjlauer or <a href="http://twitter.com/jjlauer" target=window>http://twitter.com/jjlauer</a>)
 */
public class CompositeFileFilter implements FileFilter {

    private FileFilter[] filters;

    public CompositeFileFilter(FileFilter[] filters) {
        this.filters = filters;
    }
    
    @Override
    public boolean accept(File file) {
        // loop thru every filter
        for (FileFilter filter : filters) {
            if (!filter.accept(file)) {
                return false;
            }
        }
        // if we get here then everything matched!
        return true;
    }

}
