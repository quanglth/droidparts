/**
 * Copyright 2013 Alex Yanchenko
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.droidparts.inner.handler;

import org.droidparts.inner.TypeHelper;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentValues;
import android.database.Cursor;

public class StringHandler extends TypeHandler<String> {

	@Override
	public boolean canHandle(Class<?> cls) {
		return TypeHelper.isString(cls);
	}

	@Override
	public String getDBColumnType() {
		return TEXT;
	}

	@Override
	public <V> String readFromJSON(Class<String> valType,
			Class<V> arrCollItemType, JSONObject obj, String key)
			throws JSONException {
		return obj.getString(key);
	}

	@Override
	protected <V> String parseFromString(Class<String> valType,
			Class<V> arrCollItemType, String str) {
		return str;
	}

	@Override
	public <V> void putToContentValues(Class<String> valueType,
			Class<V> arrCollItemType, ContentValues cv, String key, String val) {
		cv.put(key, val);
	}

	@Override
	public <V> String readFromCursor(Class<String> valType,
			Class<V> arrCollItemType, Cursor cursor, int columnIndex) {
		return cursor.getString(columnIndex);
	}

	@Override
	public Object parseTypeArr(Class<String> valType, String[] arr) {
		return arr;
	}

}
