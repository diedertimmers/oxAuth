package org.xdi.oxauth.model.fido.u2f;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.xdi.oxauth.crypto.cert.CertificateParser;
import org.xdi.oxauth.model.util.Base64Util;

/**
 * U2F Device registration key
 *
 * @author Yuriy Movchan Date: 05/29/2015
 */
public class DeviceRegistrationConfiguration {

	@JsonProperty
	public final String keyHandle;

	@JsonProperty
	public final String publicKey;

	@JsonProperty
	public final String attestationCert;

	public DeviceRegistrationConfiguration(@JsonProperty("keyHandle") String keyHandle, @JsonProperty("publicKey") String publicKey,
			@JsonProperty("attestationCert") String attestationCert) {
		this.keyHandle = keyHandle;
		this.publicKey = publicKey;
		this.attestationCert = attestationCert;
	}

	public String getKeyHandle() {
		return keyHandle;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public String getAttestationCert() {
		return attestationCert;
	}

	@JsonIgnore
	public X509Certificate getAttestationCertificate() throws CertificateException, NoSuchFieldException {
		if (attestationCert == null) {
			throw new NoSuchFieldException();
		}
		return CertificateParser.parseDer(Base64Util.base64urldecode(attestationCert));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeviceRegistrationConfiguration [keyHandle=").append(keyHandle).append(", publicKey=").append(publicKey).append(", attestationCert=")
				.append(attestationCert).append("]");
		return builder.toString();
	}

}