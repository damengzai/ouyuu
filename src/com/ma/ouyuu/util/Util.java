package com.ma.ouyuu.util;

import android.widget.EditText;
import android.widget.Spinner;

public class Util {

	public static String getText(EditText tv) {
		return tv.getText().toString() == null ? "" : tv.getText().toString();
	}

	public static String getSelectedSpinnerItem(Spinner spinner, String[] array) {
		String itemText = array[spinner.getSelectedItemPosition()];
		return (itemText == null || itemText.equals("请选择")) ? "" : itemText;
	}
}
