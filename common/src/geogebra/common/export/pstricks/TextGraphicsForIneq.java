package geogebra.common.export.pstricks;

import geogebra.common.euclidian.EuclidianView;
import geogebra.common.export.TextGraphics;
import geogebra.common.kernel.arithmetic.FunctionalNVar;
import geogebra.common.kernel.arithmetic.Inequality;
import geogebra.common.kernel.geos.GeoElement;



public class TextGraphicsForIneq extends TextGraphics {
	public TextGraphicsForIneq(FunctionalNVar geo2, Inequality ineq2,
			EuclidianView euclidianView) {
		this.geo = geo2;
		this.ineq = ineq2;
		this.view = euclidianView;
		this.ds = geo.getKernel().getViewBoundsForGeo((GeoElement) geo);
	}
	protected double[] ds;
	protected Inequality ineq;
	protected EuclidianView view;
	protected FunctionalNVar geo;
}
