/*
 * pragmatickm-password-style - Default style for passwords nested within SemanticCMS pages and elements.
 * Copyright (C) 2016, 2017, 2020, 2021, 2022  AO Industries, Inc.
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
 * along with pragmatickm-password-style.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.pragmatickm.password.style;

import com.aoapps.web.resources.registry.Group;
import com.aoapps.web.resources.registry.Style;
import com.aoapps.web.resources.servlet.RegistryEE;
import com.pragmatickm.password.model.Password;
import com.pragmatickm.password.model.PasswordTable;
import com.semanticcms.core.servlet.SemanticCMS;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Registers the styles for passwords in {@link RegistryEE} and {@link SemanticCMS}.
 */
@WebListener("Registers the styles for passwords in RegistryEE and SemanticCMS.")
public class PasswordStyle implements ServletContextListener {

  public static final Group.Name RESOURCE_GROUP = new Group.Name("pragmatickm-password-style");

  // TODO: Change to Group.Name once we have group-level ordering
  public static final Style PRAGMATICKM_PASSWORD = new Style("/pragmatickm-password-style/pragmatickm-password.css");

  @Override
  public void contextInitialized(ServletContextEvent event) {
    ServletContext servletContext = event.getServletContext();

    // Add our CSS file
    RegistryEE.Application.get(servletContext)
        .activate(RESOURCE_GROUP)// TODO: Activate as-needed
        .getGroup(RESOURCE_GROUP)
            .styles
            .add(PRAGMATICKM_PASSWORD);

    SemanticCMS semanticCms = SemanticCMS.getInstance(servletContext);
    // Add link CSS class
    semanticCms.addLinkCssClass(Password.class, "pragmatickm-password-password-link");
    // Add list item CSS classes
    semanticCms.addListItemCssClass(Password.class, "pragmatickm-password-password-list-item");
    semanticCms.addListItemCssClass(PasswordTable.class, "pragmatickm-password-password-table-list-item");
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    // Do nothing
  }
}
