/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.corda;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.GeneratedPropertyConfigurer;
import org.apache.camel.spi.PropertyConfigurerGetter;
import org.apache.camel.util.CaseInsensitiveMap;
import org.apache.camel.support.component.PropertyConfigurerSupport;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
@SuppressWarnings("unchecked")
public class CordaEndpointConfigurer extends PropertyConfigurerSupport implements GeneratedPropertyConfigurer, PropertyConfigurerGetter {

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        CordaEndpoint target = (CordaEndpoint) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "basicpropertybinding":
        case "basicPropertyBinding": target.setBasicPropertyBinding(property(camelContext, boolean.class, value)); return true;
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": target.setBridgeErrorHandler(property(camelContext, boolean.class, value)); return true;
        case "contractstateclass":
        case "contractStateClass": target.getConfiguration().setContractStateClass(property(camelContext, java.lang.Class.class, value)); return true;
        case "exceptionhandler":
        case "exceptionHandler": target.setExceptionHandler(property(camelContext, org.apache.camel.spi.ExceptionHandler.class, value)); return true;
        case "exchangepattern":
        case "exchangePattern": target.setExchangePattern(property(camelContext, org.apache.camel.ExchangePattern.class, value)); return true;
        case "flowlogicarguments":
        case "flowLogicArguments": target.getConfiguration().setFlowLogicArguments(property(camelContext, java.lang.Object[].class, value)); return true;
        case "flowlogicclass":
        case "flowLogicClass": target.getConfiguration().setFlowLogicClass(property(camelContext, java.lang.Class.class, value)); return true;
        case "lazystartproducer":
        case "lazyStartProducer": target.setLazyStartProducer(property(camelContext, boolean.class, value)); return true;
        case "operation": target.getConfiguration().setOperation(property(camelContext, java.lang.String.class, value)); return true;
        case "pagespecification":
        case "pageSpecification": target.getConfiguration().setPageSpecification(property(camelContext, net.corda.core.node.services.vault.PageSpecification.class, value)); return true;
        case "password": target.getConfiguration().setPassword(property(camelContext, java.lang.String.class, value)); return true;
        case "processsnapshot":
        case "processSnapshot": target.getConfiguration().setProcessSnapshot(property(camelContext, boolean.class, value)); return true;
        case "querycriteria":
        case "queryCriteria": target.getConfiguration().setQueryCriteria(property(camelContext, net.corda.core.node.services.vault.QueryCriteria.class, value)); return true;
        case "sort": target.getConfiguration().setSort(property(camelContext, net.corda.core.node.services.vault.Sort.class, value)); return true;
        case "synchronous": target.setSynchronous(property(camelContext, boolean.class, value)); return true;
        case "username": target.getConfiguration().setUsername(property(camelContext, java.lang.String.class, value)); return true;
        default: return false;
        }
    }

    @Override
    public Map<String, Object> getAllOptions(Object target) {
        Map<String, Object> answer = new CaseInsensitiveMap();
        answer.put("basicPropertyBinding", boolean.class);
        answer.put("bridgeErrorHandler", boolean.class);
        answer.put("contractStateClass", java.lang.Class.class);
        answer.put("exceptionHandler", org.apache.camel.spi.ExceptionHandler.class);
        answer.put("exchangePattern", org.apache.camel.ExchangePattern.class);
        answer.put("flowLogicArguments", java.lang.Object[].class);
        answer.put("flowLogicClass", java.lang.Class.class);
        answer.put("lazyStartProducer", boolean.class);
        answer.put("operation", java.lang.String.class);
        answer.put("pageSpecification", net.corda.core.node.services.vault.PageSpecification.class);
        answer.put("password", java.lang.String.class);
        answer.put("processSnapshot", boolean.class);
        answer.put("queryCriteria", net.corda.core.node.services.vault.QueryCriteria.class);
        answer.put("sort", net.corda.core.node.services.vault.Sort.class);
        answer.put("synchronous", boolean.class);
        answer.put("username", java.lang.String.class);
        return answer;
    }

    @Override
    public Object getOptionValue(Object obj, String name, boolean ignoreCase) {
        CordaEndpoint target = (CordaEndpoint) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "basicpropertybinding":
        case "basicPropertyBinding": return target.isBasicPropertyBinding();
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": return target.isBridgeErrorHandler();
        case "contractstateclass":
        case "contractStateClass": return target.getConfiguration().getContractStateClass();
        case "exceptionhandler":
        case "exceptionHandler": return target.getExceptionHandler();
        case "exchangepattern":
        case "exchangePattern": return target.getExchangePattern();
        case "flowlogicarguments":
        case "flowLogicArguments": return target.getConfiguration().getFlowLogicArguments();
        case "flowlogicclass":
        case "flowLogicClass": return target.getConfiguration().getFlowLogicClass();
        case "lazystartproducer":
        case "lazyStartProducer": return target.isLazyStartProducer();
        case "operation": return target.getConfiguration().getOperation();
        case "pagespecification":
        case "pageSpecification": return target.getConfiguration().getPageSpecification();
        case "password": return target.getConfiguration().getPassword();
        case "processsnapshot":
        case "processSnapshot": return target.getConfiguration().isProcessSnapshot();
        case "querycriteria":
        case "queryCriteria": return target.getConfiguration().getQueryCriteria();
        case "sort": return target.getConfiguration().getSort();
        case "synchronous": return target.isSynchronous();
        case "username": return target.getConfiguration().getUsername();
        default: return null;
        }
    }
}

