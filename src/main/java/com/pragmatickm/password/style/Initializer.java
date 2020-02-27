/*
 * pragmatickm-password-style - Default style for passwords nested within SemanticCMS pages and elements.
 * Copyright (C) 2016, 2017, 2020  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of pragmatickm-password-style.
 *
 * pragmatickm-password-style is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * pragmatickm-password-style is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with pragmatickm-password-style.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.pragmatickm.password.style;

import com.pragmatickm.password.model.Password;
import com.pragmatickm.password.model.PasswordTable;
import com.semanticcms.core.renderer.html.HtmlRenderer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("Registers the styles for passwords in HtmlRenderer.")
public class Initializer implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		HtmlRenderer htmlRenderer = HtmlRenderer.getInstance(event.getServletContext());
		// Add our CSS file
		htmlRenderer.addCssLink("/pragmatickm-password-style/styles.css");
		// Add link CSS class
		htmlRenderer.addLinkCssClass(Password.class, "pragmatickm-password-password-link");
		// Add list item CSS classes
		htmlRenderer.addListItemCssClass(Password.class, "pragmatickm-password-password-list-item");
		htmlRenderer.addListItemCssClass(PasswordTable.class, "pragmatickm-password-password-table-list-item");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// Do nothing
	}
}
