/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.spi.fixture;

import org.apache.shardingsphere.core.metadata.table.ShardingTableMetaData;
import org.apache.shardingsphere.core.parsing.parser.sql.SQLStatement;
import org.apache.shardingsphere.spi.hook.parsing.ParsingHook;

import java.util.Collection;
import java.util.LinkedList;

public final class ParsingHookFixture implements ParsingHook {
    
    private static final Collection<String> ACTIONS = new LinkedList<>();
    
    @Override
    public void start(final String sql) {
        ACTIONS.add("start");
    }
    
    @Override
    public void finishSuccess(final SQLStatement sqlStatement, final ShardingTableMetaData shardingTableMetaData) {
        ACTIONS.add("finishSuccess");
    }
    
    @Override
    public void finishFailure(final Exception cause) {
        ACTIONS.add("finishFailure");
    }
    
    /**
     * Contains action or not.
     * 
     * @param action action
     * @return contains action or not
     */
    public static boolean containsAction(final String action) {
        return ACTIONS.contains(action);
    }
    
    /**
     * Clear actions.
     */
    public static void clearActions() {
        ACTIONS.clear();
    }
}
