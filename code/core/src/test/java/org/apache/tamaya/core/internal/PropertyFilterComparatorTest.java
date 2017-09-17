/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tamaya.core.internal;

import org.apache.tamaya.spi.FilterContext;
import org.apache.tamaya.spi.PropertyFilter;
import org.apache.tamaya.spi.PropertyValue;
import org.junit.Test;

import javax.annotation.Priority;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class PropertyFilterComparatorTest {

    @Test
    public void comparationOfFiltersWithSamePriorityIsCorrect() {
        Comparator<PropertyFilter> comparator = PropertyFilterComparator.getInstance();

        int result = comparator.compare(new PropertyFilterA(), new PropertyFilterA());

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void comparationOfFiltersFirstHigherThenSecondWorksCorrectly() {
        Comparator<PropertyFilter> comparator = PropertyFilterComparator.getInstance();

        int result = comparator.compare(new PropertyFilterB(), new PropertyFilterA());

        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void comparationOfFiltersSecondHigherThenFirstWorksCorrectly() {
        Comparator<PropertyFilter> comparator = PropertyFilterComparator.getInstance();

        int result = comparator.compare(new PropertyFilterA(), new PropertyFilterB());

        assertThat(result).isLessThan(0);
    }


    @Priority(1)
    private static class PropertyFilterA  implements PropertyFilter {
        public PropertyValue filterProperty(PropertyValue value, FilterContext context) {
            throw new RuntimeException("Not implement or look at me!");
        }
    }

    @Priority(2)
    private static class PropertyFilterB  implements PropertyFilter {
        public PropertyValue filterProperty(PropertyValue value, FilterContext context) {
            throw new RuntimeException("Not implement or look at me!");
        }
    }
}