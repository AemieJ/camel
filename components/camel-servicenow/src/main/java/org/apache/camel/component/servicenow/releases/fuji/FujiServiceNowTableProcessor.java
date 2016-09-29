/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.camel.component.servicenow.releases.fuji;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.component.servicenow.ServiceNowConstants;
import org.apache.camel.component.servicenow.ServiceNowEndpoint;
import org.apache.camel.component.servicenow.ServiceNowParams;
import org.apache.camel.util.ObjectHelper;

class FujiServiceNowTableProcessor extends FujiServiceNowProcessor {
    FujiServiceNowTableProcessor(ServiceNowEndpoint endpoint) throws Exception {
        super(endpoint);
    }

    @Override
    protected void doProcess(Exchange exchange, Class<?> model, String action, String tableName, String sysId) throws Exception {
        Response response;
        if (ObjectHelper.equal(ServiceNowConstants.ACTION_RETRIEVE, action, true)) {
            response = retrieveRecord(exchange.getIn(), model, tableName, sysId);
        } else if (ObjectHelper.equal(ServiceNowConstants.ACTION_CREATE, action, true)) {
            response = createRecord(exchange.getIn(), model, tableName);
        } else if (ObjectHelper.equal(ServiceNowConstants.ACTION_MODIFY, action, true)) {
            response = modifyRecord(exchange.getIn(), model, tableName, sysId);
        } else if (ObjectHelper.equal(ServiceNowConstants.ACTION_DELETE, action, true)) {
            response = deleteRecord(exchange.getIn(), model, tableName, sysId);
        } else if (ObjectHelper.equal(ServiceNowConstants.ACTION_UPDATE, action, true)) {
            response = updateRecord(exchange.getIn(), model, tableName, sysId);
        } else {
            throw new IllegalArgumentException("Unknown action " + action);
        }

        setBodyAndHeaders(exchange.getIn(), model, response);
    }

    /*
     * GET
     * https://instance.service-now.com/api/now/table/{tableName}
     * https://instance.service-now.com/api/now/table/{tableName}/{sys_id}
     */
    private Response retrieveRecord(Message in, Class<?> model, String tableName, String sysId) throws Exception {
        return ObjectHelper.isEmpty(sysId)
            ? client.reset()
                .types(MediaType.APPLICATION_JSON_TYPE)
                .path("now")
                .path("table")
                .path(tableName)
                .query(ServiceNowParams.SYSPARM_QUERY, in)
                .query(ServiceNowParams.SYSPARM_DISPLAY_VALUE, in)
                .query(ServiceNowParams.SYSPARM_EXCLUDE_REFERENCE_LINK, in)
                .query(ServiceNowParams.SYSPARM_FIELDS, in)
                .query(ServiceNowParams.SYSPARM_LIMIT, in)
                .query(ServiceNowParams.SYSPARM_VIEW, in)
                .invoke(HttpMethod.GET)
            : client.reset()
                .types(MediaType.APPLICATION_JSON_TYPE)
                .path("now")
                .path("table")
                .path(tableName)
                .path(sysId)
                .query(ServiceNowParams.SYSPARM_DISPLAY_VALUE, in)
                .query(ServiceNowParams.SYSPARM_EXCLUDE_REFERENCE_LINK, in)
                .query(ServiceNowParams.SYSPARM_FIELDS, in)
                .query(ServiceNowParams.SYSPARM_VIEW, in)
                .invoke(HttpMethod.GET);
    }

    /*
     * POST
     * https://instance.service-now.com/api/now/table/{tableName}
     */
    private Response createRecord(Message in, Class<?> model, String tableName) throws Exception {
        validateBody(in, model);
        return client.reset()
            .types(MediaType.APPLICATION_JSON_TYPE)
            .path("now")
            .path("table")
            .path(tableName)
            .query(ServiceNowParams.SYSPARM_DISPLAY_VALUE, in)
            .query(ServiceNowParams.SYSPARM_EXCLUDE_REFERENCE_LINK, in)
            .query(ServiceNowParams.SYSPARM_FIELDS, in)
            .query(ServiceNowParams.SYSPARM_INPUT_DISPLAY_VALUE, in)
            .query(ServiceNowParams.SYSPARM_SUPPRESS_AUTO_SYS_FIELD, in)
            .query(ServiceNowParams.SYSPARM_VIEW, in)
            .invoke(HttpMethod.POST, in.getMandatoryBody());
    }

    /*
     * PUT
     * https://instance.service-now.com/api/now/table/{tableName}/{sys_id}
     */
    private Response modifyRecord(Message in, Class<?> model, String tableName, String sysId) throws Exception {
        validateBody(in, model);
        return client.reset()
            .types(MediaType.APPLICATION_JSON_TYPE)
            .path("now")
            .path("table")
            .path(tableName)
            .path(ObjectHelper.notNull(sysId, "sysId"))
            .query(ServiceNowParams.SYSPARM_DISPLAY_VALUE, in)
            .query(ServiceNowParams.SYSPARM_EXCLUDE_REFERENCE_LINK, in)
            .query(ServiceNowParams.SYSPARM_FIELDS, in)
            .query(ServiceNowParams.SYSPARM_INPUT_DISPLAY_VALUE, in)
            .query(ServiceNowParams.SYSPARM_SUPPRESS_AUTO_SYS_FIELD, in)
            .query(ServiceNowParams.SYSPARM_VIEW, in)
            .invoke(HttpMethod.PUT, in.getMandatoryBody());
    }

    /*
     * DELETE
     * https://instance.service-now.com/api/now/table/{tableName}/{sys_id}
     */
    private Response deleteRecord(Message in, Class<?> model, String tableName, String sysId) throws Exception {
        return client.reset()
            .types(MediaType.APPLICATION_JSON_TYPE)
            .path("now")
            .path("table")
            .path(tableName)
            .path(ObjectHelper.notNull(sysId, "sysId"))
            .invoke(HttpMethod.DELETE);
    }

    /*
     * PATCH
     * http://instance.service-now.com/api/now/table/{tableName}/{sys_id}
     */
    private Response updateRecord(Message in, Class<?> model, String tableName, String sysId) throws Exception {
        validateBody(in, model);
        return client.reset()
            .types(MediaType.APPLICATION_JSON_TYPE)
            .path("now")
            .path("table")
            .path(tableName)
            .path(ObjectHelper.notNull(sysId, "sysId"))
            .query(ServiceNowParams.SYSPARM_DISPLAY_VALUE, in)
            .query(ServiceNowParams.SYSPARM_EXCLUDE_REFERENCE_LINK, in)
            .query(ServiceNowParams.SYSPARM_FIELDS, in)
            .query(ServiceNowParams.SYSPARM_INPUT_DISPLAY_VALUE, in)
            .query(ServiceNowParams.SYSPARM_SUPPRESS_AUTO_SYS_FIELD, in)
            .query(ServiceNowParams.SYSPARM_VIEW, in)
            .invoke("PATCH", in.getMandatoryBody());
    }
}
