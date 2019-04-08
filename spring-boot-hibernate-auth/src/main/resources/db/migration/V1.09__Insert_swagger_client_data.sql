INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('swagger-client', 
	/*1234*/'$2a$04$EDhc4iSrKvJn1USNPoAO/..ao60m11nc7lnMn8CighIrW6p9fAMmC', 
	'read,write,delete',
	'password,authorization_code,refresh_token,implicit', 'http://localhost:8081/webjars/springfox-swagger-ui/oauth2-redirect.html', null, 36000, 36000, null, 'true');
