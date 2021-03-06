package org.geogebra.web.web.gui.view.algebra;

import org.geogebra.web.html5.gui.inputfield.AutoCompleteW;
import org.geogebra.web.keyboard.KeyboardListener;

import com.google.gwt.dom.client.Element;

public interface EquationEditorListener extends AutoCompleteW {

	Element getLaTeXElement();

	void keypress(char c, boolean alt, boolean ctrl, boolean shift, boolean more);

	void keydown(int keycode, boolean alt, boolean ctrl, boolean shift);

	void keyup(int keycode, boolean alt, boolean ctrl, boolean shift);

	boolean popupSuggestions();

	void showOrHideSuggestions();

	void scrollCursorIntoView();

	boolean resetAfterEnter();

	/**
	 * @return latex content of editor
	 */
	String getLaTeX();


	/**
	 * @return keyboard listener
	 */
	KeyboardListener getKeyboardListener();

}
