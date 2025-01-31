# Implmenting Social Login with Spring Security

## Setting up GitHub as an OAuth Provider

1. Go to your GitHub account settings, and navigate to Developer settings > OAuth Apps.
2. Click "New OAuth App" and fill in the required fields.
3. For the "Authorization callback URL," use: http://localhost:8080/login/oauth2/code/github.
4. Register the application, and you'll receive a client_id and client_secret for your properties file.

## Setting up Google as an OAuth Provider
1. Visit the Google Cloud Console at console.cloud.google.com.
2. Set up the OAuth 2 consent screen if you haven't done so already.
3. Go to the Credentials section and create a new OAuth 2 client ID.
4. Select "Web application" as the type, and enter a name for the application.
5. Add an authorized redirect URI: http://localhost:8080/login/oauth2/code/google.
6. Click "Create" to obtain your client_id and client_secret for your properties file.


https://docs.github.com/en/apps/oauth-apps/building-oauth-apps/authorizing-oauth-apps
new app -> https://github.com/settings/applications/new


