openfire-shared-secret-auth-provider
==========================

AuthProvider for Openfire which will accept a shared secret, instead of a password, for a user. 

Installation
------------
1. Build the package

		mvn clean package

2. Copy the jar-with-dependencies into the openfire/lib directory

		cp target/openfire-shared-secret-plugin-x.x.x-with-dependencies.jar /opt/openfire/lib
		
3. Add/update the following openfire server properties:

		hybridAuthProvider.primaryProvider.className = [current value of provider.auth.className]
		
		provider.auth.className = org.jivesoftware.openfire.auth.HybridAuthProvider
	
		hybridAuthProvider.secondaryProvider.className = com.marcelmika.openfire.auth.SharedSecretAuthProvider

4. Add any extra configuration properties as required (see *Configuration* below)

5. Restart openfire

		/etc/init.d/openfire restart
		
Configuration
-------------

The following properties are available:

| Property | Description | Required? |
| -------- | ----------- | --------- |
| `sharedSecretAuthProvider.sharedSecret` | Fill in the shared secret used for the authentication. Make the secret as hard to guess as possible. | Yes |

