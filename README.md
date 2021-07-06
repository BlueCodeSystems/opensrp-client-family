# OpenSRP Client Household
OpenSRP Client Household Library - Fork of OpenSRP Client Family Module

### Download Dependency from GitHub Packages)

This library is currently available as a [Git Package](https://github.com/BlueCodeSystems/opensrp-client-household/packages).

At the moment GitHub requires you to be authenticated in order to download Android Libraries hosted in GitHub packages.   To do so you will need your **personal access token** and your GitHub **userid/username**.

Follow these steps to add the library as a dependency to your app.

**Step 1** : Generate a Personal Access Token for GitHub [How to generate GitHub personal access token](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line)

**Step 2** : Store your GitHub — Personal Access Token details    
Add these content to the **`local.properties`** file inside the root directory of your project.

```properties 
gpr.usr=YOUR_GITHUB_USERID 
gpr.key=YOUR_PERSONAL_ACCESS_TOKEN 
```   

**Step 3** : Update `build.gradle` for the application module

```groovy def githubProperties = new Properties() //Read the github properties content githubProperties.load(new FileInputStream(rootProject.file("local.properties")))    
 android {    
    //...    
    // include inside the android closure    
    repositories {    
      maven {    
              name = "GitHubPackages"    
              /**    
             * Configure path of the package repository on Github using the GITHUB_USER_ID and * Git Repository */    
              url = uri("https://github.com/BlueCodeSystems/opensrp-client-household")    
              credentials {    
                  /** get credentials from local.properties in root project folder file with    
                 ** gpr.usr=GITHUB_USER_ID & gpr.key=PERSONAL_ACCESS_TOKEN otherwise ** Set env variable GPR_USER & GPR_API_KEY**/    
                  username = githubProperties['gpr.usr'] ?: System.getenv("GPR_USER")    
                  password = githubProperties['gpr.key'] ?: System.getenv("GPR_API_KEY")    
              }    
	      }   
	  }     
	//... 
} 
```   

Add the library in the dependency section of your application's `build.gradle` file (obtain the latest version from [GitHub Packages](https://github.com/BlueCodeSystems/opensrp-client-household))

```groovy 
dependencies {    
   //consume library - use the latest version available on github packages    
   implementation "org.smartregister:family:1.0.0-BCODE-RELEASE"    
   //....    
 } 
 ```   

### Publish

#### 1. Locally
Run the following command to build the release `.aar` file and publish the library locally:

```shell  
./gradlew opensrp-household:assembleRelease && ./gradlew opensrp-household:publishHouseholdPublicationToMavenLocal
```  

or (will publish all publications)

```shell  
./gradlew opensrp-household:assembleRelease && ./gradlew opensrp-household:publishToMavenLocal
```

#### 1. Remotely

Run the  following command to build the release `.aar`  and publish the library to GitHub Package Registry:

```shell  
./gradlew opensrp-household:assembleRelease && ./gradlew opensrp-household:publishHouseholdPublicationToGitHubPackagesRepository
```  

or (will publish all publications)

```shell  
./gradlew opensrp-household:assembleRelease && ./gradlew opensrp-household:publish
```

## Configurability

By placing a file named `app.properties` in your implementation assets folder (See sample app) , one can configure certain aspects of the app

### Configurable Settings

| Configuration                       | Type    | Default | Description                                   |  
| ----------------------------------- | ------- | ------- | ----------------------------------------------|  
| `family.head.first.name.enabled`         | Boolean | false    | Show First name of head of family next to family surname|  
