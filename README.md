## Equo Extras

Equo Extras contains a set of optional APIs with extra functionalities

## How to use Extras in an Equo app

To add Extras in an app you must do two things:

* **Add the repository.** Open `cnf/build.bnd` file in your app project and add the following code:

    ```
    -plugin.1.EquoExtras: \
        aQute.bnd.repository.p2.provider.P2Repository; \
            name = EquoExtras; \
            url = "https://equo-framework-extras.ams3.digitaloceanspaces.com/1.0.0/repo/"; \
            poll.time = -1
    ```

* **Enable Extras in your app.** Open the `bnd.bnd` file of your app and add `https://equo-framework-extras.ams3.digitaloceanspaces.com/1.0.0/extras.bnd` into the _-include_ sentence.

    The file will look like this:

    ```
    -include: https://equo-framework.ams3.digitaloceanspaces.com/1.0.0/equoapp.bnd,\
	          https://equo-framework-extras.ams3.digitaloceanspaces.com/1.0.0/extras.bnd
    ```

## How to develop

The process of developing is the same as any other part of Equo framework. Refer to [Framework guide of development](https://gitlab.com/maketechnology/equo/framework#developing-the-equo-framework)

## Bundles involved

### Extras bundles

The bundles that provide the extras functionality of the framework:

| Bundle | Description |
| ----------- | ----------- |
| com.make.equo.filesystem.api| API to manage the filesystem to Create/Open/Read/Write/Copy/Rename/Move/Delete folders or files |
| com.make.equo.filesystem.provider | The implementation of the filesystem API. Has the logic of filesystem managment and contributes a js API to make filesystem calls from javascript | 
| com.make.node.packages | Contains extra Node packages components. It currently has packages for a web toolbar creation | 

### Release bundle

As every other Framework project, there is the `com.make.equo.p2repo`, which is responsible of the p2 repository generation of the project and dependencies for its release.