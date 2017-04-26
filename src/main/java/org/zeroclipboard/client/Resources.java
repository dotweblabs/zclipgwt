/*
*
* Copyright (c) 2017 Kerby Martino and Dotweblabs Web Technologies. All Rights Reserved.
* Licensed under Dotweblabs Commercial License, Version 1.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*   http://www.weblabs.ph/licenses/LICENSE-1.0
*
* Unless required by applicable law or agreed to in writing, software distributed
* under the License is distributed as Proprietary and Confidential to
* Dotweblabs Web Technologies and must not be redistributed in any form.
*
*/
package org.zeroclipboard.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Javascript Resources
 *
 * @author kerbymart
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source("ZeroClipboard.js")
    public TextResource zeroClipboardJs();

}
