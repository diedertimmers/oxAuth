/*
 * oxAuth is available under the MIT License (2008). See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2014, Gluu
 */
package org.xdi.oxauth.model.fido.u2f;

import java.io.Serializable;

import org.gluu.site.ldap.persistence.annotation.LdapAttribute;
import org.gluu.site.ldap.persistence.annotation.LdapJsonObject;
import org.xdi.oxauth.model.fido.u2f.protocol.RegisterRequestMessage;

/**
 * U2F registration requests
 *
 * @author Yuriy Movchan Date: 06/02/2015
 */
public class RegisterRequestMessageLdap extends RequestMessageLdap implements Serializable {

	private static final long serialVersionUID = -2242931562244920584L;

	@LdapJsonObject
    @LdapAttribute(name = "oxRequest")
	private RegisterRequestMessage registerRequestMessage;

	public RegisterRequestMessageLdap() {}

	public RegisterRequestMessageLdap(RegisterRequestMessage registerRequestMessage) {
		this.registerRequestMessage = registerRequestMessage;
		this.requestId = registerRequestMessage.getRequestId();
	}

	public RegisterRequestMessage getRegisterRequestMessage() {
		return registerRequestMessage;
	}

	public void setRegisterRequestMessage(RegisterRequestMessage registerRequestMessage) {
		this.registerRequestMessage = registerRequestMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterRequestMessageLdap [id=").append(id).append(", registerRequestMessage=").append(registerRequestMessage).append(", requestId=")
				.append(requestId).append(", creationDate=").append(creationDate).append("]");
		return builder.toString();
	}

}
