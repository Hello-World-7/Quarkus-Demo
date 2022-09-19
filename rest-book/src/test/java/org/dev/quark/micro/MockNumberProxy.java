package org.dev.quark.micro;

import org.dev.quark.micro.proxy.NumberProxy;
import org.dev.quark.micro.resource.IsbnThirteen;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.test.Mock;

@Mock
@RestClient
public class MockNumberProxy implements NumberProxy {

	@Override
	public IsbnThirteen generateIsbnNumbers() {
		IsbnThirteen isbn13 = new IsbnThirteen();
		isbn13.setIsbn13("13-mock");
		return isbn13;
	}

}
