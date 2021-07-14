# JS Toolbar API installation project

## Pre-requirements:
- You should have already installed npm/yarn.
- Npm version must be 6.14.13 or above.

## Step-by-Step Installation


1.  Execute the following command on Terminal:

```
npm login --scope=@equo --registry https://registry.dev.equoplatform.com
Username: AskForAdminCredentials
Password: AskForAdminCredentials
Email: (this IS public) AskForAdminCredentials
```

2. Open a Terminal on project folder and insert the following command:
   
```
yarn add @equo/toolbar-api 
``` 
or 
```
npm install @equo/toolbar-api
```

3. On JS script, import Toolbar:

```javascript
import { Toolbar } from '@equo/toolbar-api'
```

## How to use the Toolbar Equo API
 You can use several methods to customize the Equo Toolbar using Toolbar var.

**Contruction methods:**

*Toolbar.create()* :It allows to start the customization on our toolbar ( mandatory )

*.build()* : It allows to add to the HTML body with all the customization previously added.

**Behavioral methods:**

*.withBackgroundColor(String)*: It allows to change the toolbar's background color using rgb or hexacode.

*.crossEnable(boolean)*: Sets value "true" for enable cross  button or "false" for disabled. Default is disabled.

*.setCrossIcon(String)*: Sets icon for cross button. Use from assets folder or link. Support PNG, GIF (including animated GIFs), SVG and JPEG extensions.

*.setCrossTooltip(String)*: Sets text for cross button tooltip.

*.getCrossEnable()*: Gets if cross button is enabled. Return *true* or *false*.

*.setCloseFunction(Function)*: Adds the functionality when the cross button is clicked.

*.addToolItem()*: It allows to add a new item to the toolbar.


Once we add a item, we can specify the item, tooltip and onClick event function that it will have, using the following methods:

*.addTooltip(String)*: It defines a toolitem's description

*.addIcon(String)*: It allows to add an specific icon on the new toolItem. Use from assets folder or link. Support PNG, GIF (including animated GIFs), SVG and JPEG extensions.

*.onClick(Function)*: It allows to add functionality when the item is clicked.


## Configure webpack for use local icons

Go to root vue project and modify file vue.config.js with:

  ```javascript
    ...
    configureWebpack: {
      module: {
        rules: [
          {
            test: /\.(png|jpe?g|gif|svg)$/i,
            loader: 'file-loader',
            options: {
              name: 'img/[name].[ext]',
            },
          },
        ],
      },
      ...
    }
    ...
  ```

You will have a view of your project similar to this:

  -rootProject
    -src
      -assets
        myIcon.png
      -components
        yourComponen.vue
      App.vue
      ...
    ...

You will used *myIcon.png* from *yourComponent.vue* or *App.vue* with:

  ```javascript
  Toolbar.create().addToolItem().setIcon("myIcon.png").build();
  ```

**Note:** You only need this setting to use icons from the assets folder.