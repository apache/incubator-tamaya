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
package org.apache.tamaya.core.internal.converters;

import org.apache.tamaya.spi.ConversionContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by atsti on 02.10.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class PathConverterTest {

    @Mock
    ConversionContext context;

    @Test
    public void convert() throws Exception {
        PathConverter conv = new PathConverter();
        String testRoot = FileSystems.getDefault().getRootDirectories().iterator().next().toString();
        Path value = conv.convert("testRoot", context);
        assertEquals(value, Paths.get("testRoot"));
        value = conv.convert("foo", context);
        assertNotNull(value);
    }

    @Test
    public void equalsAndHashcode() throws Exception {
        PathConverter conv1 = new PathConverter();
        PathConverter conv2 = new PathConverter();
        assertEquals(conv1, conv2);
        assertEquals(conv1.hashCode(), conv2.hashCode());
    }

}