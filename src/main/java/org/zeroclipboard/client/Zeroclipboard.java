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
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Element;
import elemental.client.Browser;

public class Zeroclipboard {

    public static boolean isInjected = false;
    public static boolean isReady = false;
    public static ZeroclipboardCallback callback;

    public static void zlip(ZeroclipboardCallback c) {
        Resources resources = GWT.create(Resources.class);
        ScriptInjector.fromString(resources.zeroClipboardJs().getText())
                .setWindow(ScriptInjector.TOP_WINDOW)
                .inject();
        zeroClipboardConfig("ZeroClipboard.swf");
        callback = c;
    }

    public static native void zeroClipboardConfig(String _swfPath)/*-{
        $wnd.ZeroClipboard.config( { swfPath: _swfPath } );
    }-*/;

    public static native void zeroClipboard(Element el, String textToCopy)/*-{
      var client = new $wnd.ZeroClipboard(el);
      client.on( 'ready', function(event) {
        @org.zeroclipboard.client.Zeroclipboard::onReady()();
        client.on( 'copy', function(event) {
            event.clipboardData.setData('text/plain', textToCopy);
        } );
        client.on( 'aftercopy', function(event) {
            @org.zeroclipboard.client.Zeroclipboard::onAfterCopy(Ljava/lang/String;)(event.data['text/plain']);
        } );
      } );
      client.on( 'error', function(event) {
            $wnd.console.log('ZeroClipboard error of type ' + event.name + ': ' + event.message);
            @org.zeroclipboard.client.Zeroclipboard::onError()();
            $wnd.ZeroClipboard.destroy();
      } );
    }-*/;

    public static native void destroy()/*-{
        $wnd.ZeroClipboard.destroy();
    }-*/;

    public static void onReady(){
        Zeroclipboard.isReady = true;
    }

    public static void onCopy(){

    }

    public static void onAfterCopy(String copied){
        callback.onCopy(copied);
    }

    public static void onError(){
        // TODO: Temporary remove this until the task to check for Flash is there
        Browser.getWindow().getConsole().log("Unable to copy clipboard");
        Zeroclipboard.isReady = false;
        callback.onError();
    }
}
