## Introduction
**quickblox-java-api** is Java wrapper around [quicblox REST APIs for the Users module] (https://quickblox.com/developers/Users).

You need to get these properties in order to retrieve a token from QuickBlox that authenticates:
applicationId
authKey
authSecret
login
String password

## Getting started

### Getting quickblox-java-api from this maven repo (not official):

```
<repository>
  <id>quickblox-java-api-mvn-repo</id>
  <name>Quickblox java API</name>
  <url>https://raw.github.com/Synkers/quickblox-java-api/mvn-repo/</url>
</repository>

<dependency>
  <groupId>com.synkers</groupId>
  <artifactId>quickblox-api</artifactId>
  <version>0.0.1</version>
</dependency>
```

## Usage

```java
// sets the properties needed to get the auth token
QuickBlox.init(applicationId, authKey, authSecret, login, password);

// retrieves a QB token.
QuickBlox.getSessionApi().getUserAuthorization(new QbSessionApi.SessionCallback() {
  @Override
  public void onSuccess(Session session){
    /**stub**/
  }
  @Override
  public void onFailure(String reason){
    /**stub**/
  }
}

// after you've successful retrieved auth, you can use the Users module.

QuickBlox.getUsersApi().signUp(...);

QuickBlox.getUsersApi().updateUser(...);

QuickBlox.getUsersApi().getUserByIdentifier(...);
```
