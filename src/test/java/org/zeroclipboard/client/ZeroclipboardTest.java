/**
 *
 * Copyright (c) 2017 Dotweblabs Web Technologies and others. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.zeroclipboard.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;

/**
 *
 * Unit tests of {@link ZeroclipboardTest}
 */
public class ZeroclipboardTest extends GWTTestCase {

    TestResources resources;

    @Override
    public String getModuleName() {
        return "org.zeroclipboard.Zeroclipboard";
    }

    public void gwtSetUp() {
        resources = GWT.create(TestResources.class);
    }

    public void test() {
    }
    public static void log(String s){
        System.out.println(s);
    }
}
