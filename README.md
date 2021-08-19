## Equo Extras

Equo Extras contains a set of optional APIs with extra functionalities

## How to use Extras in an Equo app

To add Extras in an app you must do two things:

* **Add repositories and build settings.** Open `cnf/build.bnd` file in your app project and add `https://dl.equoplatform.com/framework-extras/1.0/equobuild.bnd` into the includes. It will look like this:

    ```
    -include: https://dl.equoplatform.com/framework/1.0/equobuild.bnd,\
                https://dl.equoplatform.com/framework-extras/1.0/equobuild.bnd
    ```

* **Enable Extras in your app.** Open the `bnd.bnd` file of your app and add `https://dl.equoplatform.com/framework-extras/1.0/extras.bnd` into the _-include_ sentence.

    The file will look like this:

    ```
    -include: https://dl.equoplatform.com/framework/1.0/equoapp.bnd,\
	          https://dl.equoplatform.com/framework-extras/1.0/extras.bnd
    ```

## How to develop

The process of developing is the same as any other part of Equo framework. Refer to [Framework guide for contributions](https://github.com/equoplatform/framework#contributing)

## Bundles involved

### Extras bundles

The bundles that provide the extras functionality of the framework:

| Bundle | Description |
| ----------- | ----------- |
| com.equo.filesystem.api| API to manage the filesystem to Create/Open/Read/Write/Copy/Rename/Move/Delete folders or files |
| com.equo.filesystem.provider | The implementation of the filesystem API. Has the logic of filesystem managment and contributes a js API to make filesystem calls from javascript | 
| com.make.node.packages | Contains extra Node packages components. It currently has packages for a web toolbar creation | 
