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
package org.apache.tamaya.spisupport;

import org.apache.tamaya.spi.ConfigurationContext;
import org.apache.tamaya.spi.PropertySource;
import org.apache.tamaya.spi.PropertyValue;
import org.apache.tamaya.spisupport.propertysource.BuildablePropertySource;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConfigValueEvaluatorTest {

    private ConfigValueEvaluator evaluator = new ConfigValueEvaluator(){};
    private ConfigurationContext context = mock(ConfigurationContext.class);

    @Before
    public void initMock(){
        PropertySource ps = BuildablePropertySource.builder()
                .withName("MySource")
                .withSimpleProperty("foo", "bar")
                .build();
        when(context.getPropertySources()).thenReturn(Collections.singletonList(ps));
    }

    @Test
    public void evaluteRawValue() {
            PropertyValue value = evaluator.evaluateRawValue("foo", ConfigurationContext.EMPTY);
            assertThat(value).isNull();
    }

    @Test
    public void evaluteAllValues() {
        List<PropertyValue> values = evaluator.evaluateAllValues("foo", ConfigurationContext.EMPTY);
        assertThat(values).isNotNull();
        assertThat(values).isEmpty();
    }

    @Test
    public void evaluateRawValues() {
        Map<String, PropertyValue> map = evaluator.evaluateRawValues(ConfigurationContext.EMPTY);
        assertThat(map).isNotNull();
        assertThat(map).isEmpty();
    }
}
