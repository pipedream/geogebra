package org.geogebra.web.geogebra3D.web.input3D;

import org.geogebra.common.util.debug.Log;
import org.geogebra.web.geogebra3D.web.euclidian3D.openGL.RendererImplShadersW;
import org.geogebra.web.geogebra3D.web.euclidian3D.openGL.RendererWithImplW;

import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Window;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;

/**
 * web renderer for zSpace
 * 
 *
 */
public class RendererWithImplZSpaceW extends RendererWithImplW {

	private ZSpaceGwt zSpace;

	public RendererWithImplZSpaceW(EuclidianViewInput3DW view) {
		super(view);
		zSpace = new ZSpaceGwt(glContext, webGLCanvas.getElement());
		((InputZSpace3DW) view.getInput3D()).setZSpace(zSpace);

	}


	@Override
	protected void createGLContext(boolean preserveDrawingBuffer) {
		if (preserveDrawingBuffer) {
			glContext = getBufferedContext(webGLCanvas.getElement());

		} else {
			// glContext = (WebGLRenderingContext) webGLCanvas
			// .getContext("webgl");
			glContext = getBufferedContextNoPDB(webGLCanvas.getElement());
			((RendererImplShadersW) rendererImpl).setGL(glContext);
		}
		if (glContext == null) {
			Window.alert("Sorry, Your Browser doesn't support WebGL!");
		}

	}

	private static native WebGLRenderingContext getBufferedContext(
			Element element) /*-{
		return element.getContext("webgl", {
			preserveDrawingBuffer : true,
			alpha : false,
			antialias : true
		});
	}-*/;

	private static native WebGLRenderingContext getBufferedContextNoPDB(
			Element element) /*-{
		return element.getContext("webgl", {
			alpha : false,
			antialias : true
		});
	}-*/;

	@Override
	public void drawScene() {

		zSpace.zspaceUpdate();
		clearColorBuffer();
		clearDepthBuffer();

		super.drawScene();

		zSpace.zspaceFrameEnd();

	}

	@Override
	final protected void setBufferLeft() {
		zSpace.zspaceLeftView();
		JsArrayNumber matrix = zSpace.getLeftViewMatrix();
		String s = "\n(renderer) left\n";
		for (int i = 0; i < 16; i++) {
			if (i % 4 == 0) {
				s += "\n";
			}
			s += " " + matrix.get(i);
		}
		Log.debug(s);
	}

	@Override
	final protected void setBufferRight() {
		zSpace.zspaceRightView();
	}

	public ZSpaceGwt getZSpace() {
		return zSpace;
	}

}
