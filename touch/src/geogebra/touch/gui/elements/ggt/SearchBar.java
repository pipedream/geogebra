package geogebra.touch.gui.elements.ggt;

import geogebra.touch.gui.CommonResources;
import geogebra.touch.gui.elements.AuxiliaryHeaderPanel;
import geogebra.touch.gui.elements.StandardImageButton;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.user.client.ui.TextBox;

public class SearchBar extends AuxiliaryHeaderPanel {
	public interface SearchListener {
		void onSearch(String query);
	}

	private TextBox query;
	private StandardImageButton searchButton;
	private List<SearchListener> listeners;

	public SearchBar() {
		super();
		this.setStyleName("searchbar");

		this.listeners = new ArrayList<SearchListener>();

		this.query = new TextBox();
		this.query.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					SearchBar.this.fireSearchEvent();
				}
			}
		});

		this.searchButton = new StandardImageButton(
				CommonResources.INSTANCE.search());
		this.searchButton.addDomHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SearchBar.this.fireSearchEvent();
			}
		}, ClickEvent.getType());

		this.panel.add(this.query);
		this.panel.add(this.searchButton);
	}

	public boolean addSearchListener(SearchListener l) {
		return this.listeners.add(l);
	}

	public boolean removeSearchListener(SearchListener l) {
		return this.listeners.remove(l);
	}

	void fireSearchEvent() {
		for (SearchListener s : this.listeners) {
			s.onSearch(this.query.getText());
		}
	}

	public void setWidth(int width) {
		this.query.setWidth(width - 100 + "px");
	}

	public void onResize(ResizeEvent event) {
		this.setWidth(event.getWidth());
	}
}
