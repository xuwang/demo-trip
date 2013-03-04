<%@ page import="org.demo.trip.Airport" %>



<div class="fieldcontain ${hasErrors(bean: airportInstance, field: 'iata', 'error')} required">
	<label for="iata">
		<g:message code="airport.iata.label" default="Iata" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="iata" maxlength="3" required="" value="${airportInstance?.iata}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: airportInstance, field: 'city', 'error')} ">
	<label for="city">
		<g:message code="airport.city.label" default="City" />
		
	</label>
	<g:textField name="city" value="${airportInstance?.city}"/>
</div>

