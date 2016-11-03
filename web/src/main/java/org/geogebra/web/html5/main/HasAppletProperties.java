package org.geogebra.web.html5.main;

import org.geogebra.web.html5.gui.view.algebra.MathKeyboardListener;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author gabor suggests wheter the AppWapplet, AppWsimple has applet
 *         properties, so behaves like an applet.
 */
public interface HasAppletProperties {

	/**
	 * @param width
	 * 
	 *            sets the geogebra-web applet widht
	 */
	public void setWidth(int width);

	/**
	 * @param height
	 * 
	 *            sets the geogebra-web applet height
	 */
	public void setHeight(int height);

	/**
	 * sets the geogebra-web applet size (width, height)
	 * 
	 * @param width
	 *            width in px
	 * @param height
	 *            height in px
	 */
	public void setSize(int width, int height);

	/**
	 * After loading a new GGB file, the size should be set to "auto"
	 */
	public void resetAutoSize();



	/**
	 * @param show
	 * 
	 *            wheter show the toolbar in geogebra-web applets or not
	 */
	public void showToolBar(boolean show);

	/**
	 * @param show
	 * 
	 *            wheter show the menubar in geogebra-web applets or not
	 */
	public void showMenuBar(boolean show);

	/**
	 * @param show
	 * 
	 *            wheter show the algebrainput in geogebra-web applets or not
	 */
	public void showAlgebraInput(boolean show);

	/**
	 * @param show
	 * 
	 *            wheter show the reseticon in geogebra-web applets or not
	 */
	public void showResetIcon(boolean show);

	public JavaScriptObject getOnLoadCallback();

	public void showKeyBoard(boolean b, MathKeyboardListener textField,
	        boolean forceShow);

	public boolean isKeyboardShowing();

	public void showKeyboardOnFocus();

	public void updateKeyboardHeight();

	public double getKeyboardHeight();

	public void remove();
}
