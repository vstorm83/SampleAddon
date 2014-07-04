/**
 * Copyright (C) 2014 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.exoplatform.portal.webui.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.exoplatform.container.xml.InitParams;
import org.exoplatform.container.xml.ValueParam;
import org.exoplatform.portal.config.model.Application;

public class AddOnPluginImpl extends AddOnPlugin {

    private String containerId;
    private List<Application<?>> apps = new LinkedList<Application<?>>();
    private int priority;

    public AddOnPluginImpl(InitParams params) {
        if (params != null) {
            ValueParam containerParam = params.getValueParam("containerId");
            if (containerParam != null) {
                containerId = containerParam.getValue();
            }

            ValueParam priorityParam = params.getValueParam("priority");
            if (priorityParam != null) {
                priority = Integer.parseInt(priorityParam.getValue());
            }

            List<Application<?>> tmp = params.<Application<?>>getObjectParamValues((Class<Application<?>>)(Class<?>)Application.class);
            if (tmp != null) {
                apps.addAll(tmp);
            }
        }
    }

    @Override
    public List<Application<?>> getApplications() {
        return Collections.unmodifiableList(apps);
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String getContainerId() {
        return containerId;
    }

}