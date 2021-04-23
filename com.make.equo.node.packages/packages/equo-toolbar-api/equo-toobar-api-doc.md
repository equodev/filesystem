## Classes

<dl>
<dt><a href="#ToolbarBuilder">ToolbarBuilder</a></dt>
<dd></dd>
<dt><a href="#ToolItemBuilder">ToolItemBuilder</a></dt>
<dd></dd>
</dl>

## Objects

<dl>
<dt><a href="#Toolbar">Toolbar</a> : <code>object</code></dt>
<dd><p>Customize the Equo Toolbar using Toolbar var.</p>
</dd>
</dl>

## Functions

<dl>
<dt><a href="#create">create()</a> ⇒ <code><a href="#ToolbarBuilder">ToolbarBuilder</a></code></dt>
<dd><p>Initialize toolbar.</p>
</dd>
</dl>

<a name="ToolbarBuilder"></a>

## ToolbarBuilder
**Kind**: global class  

* [ToolbarBuilder](#ToolbarBuilder)
    * [.withBackgroundColor(color)](#ToolbarBuilder+withBackgroundColor) ⇒ [<code>ToolbarBuilder</code>](#ToolbarBuilder)
    * [.addToolItem()](#ToolbarBuilder+addToolItem) ⇒ [<code>ToolItemBuilder</code>](#ToolItemBuilder)
    * [.build()](#ToolbarBuilder+build) ⇒ <code>void</code>

<a name="ToolbarBuilder+withBackgroundColor"></a>

### toolbarBuilder.withBackgroundColor(color) ⇒ [<code>ToolbarBuilder</code>](#ToolbarBuilder)
Change the toolbar's background color using rgb or hexacode.

**Kind**: instance method of [<code>ToolbarBuilder</code>](#ToolbarBuilder)  

| Param | Type |
| --- | --- |
| color | <code>string</code> | 

<a name="ToolbarBuilder+addToolItem"></a>

### toolbarBuilder.addToolItem() ⇒ [<code>ToolItemBuilder</code>](#ToolItemBuilder)
Add a new item to the toolbar.

**Kind**: instance method of [<code>ToolbarBuilder</code>](#ToolbarBuilder)  
<a name="ToolbarBuilder+build"></a>

### toolbarBuilder.build() ⇒ <code>void</code>
Add to the HTML body with all the customization previously added.

**Kind**: instance method of [<code>ToolbarBuilder</code>](#ToolbarBuilder)  
<a name="ToolItemBuilder"></a>

## ToolItemBuilder
**Kind**: global class  

* [ToolItemBuilder](#ToolItemBuilder)
    * [.addToolItem()](#ToolItemBuilder+addToolItem) ⇒ [<code>ToolItemBuilder</code>](#ToolItemBuilder)
    * [.onClick(eventHandler)](#ToolItemBuilder+onClick) ⇒ [<code>ToolItemBuilder</code>](#ToolItemBuilder)
    * [.addIcon(icon)](#ToolItemBuilder+addIcon) ⇒ [<code>ToolItemBuilder</code>](#ToolItemBuilder)
    * [.addTooltip(tooltip)](#ToolItemBuilder+addTooltip) ⇒ [<code>ToolItemBuilder</code>](#ToolItemBuilder)
    * [.build()](#ToolItemBuilder+build) ⇒ <code>void</code>

<a name="ToolItemBuilder+addToolItem"></a>

### toolItemBuilder.addToolItem() ⇒ [<code>ToolItemBuilder</code>](#ToolItemBuilder)
Add a new item to the toolbar.

**Kind**: instance method of [<code>ToolItemBuilder</code>](#ToolItemBuilder)  
<a name="ToolItemBuilder+onClick"></a>

### toolItemBuilder.onClick(eventHandler) ⇒ [<code>ToolItemBuilder</code>](#ToolItemBuilder)
Add functionality when the item is clicked.

**Kind**: instance method of [<code>ToolItemBuilder</code>](#ToolItemBuilder)  

| Param | Type |
| --- | --- |
| eventHandler | <code>function</code> | 

<a name="ToolItemBuilder+addIcon"></a>

### toolItemBuilder.addIcon(icon) ⇒ [<code>ToolItemBuilder</code>](#ToolItemBuilder)
Add an specific icon on the new toolItem. The available icons to this toolbar belong to the fontawesome library. Here, in Fontawesome Icons website, we can choose the desired icon just adding the icon name as method's parameter.

**Kind**: instance method of [<code>ToolItemBuilder</code>](#ToolItemBuilder)  

| Param | Type |
| --- | --- |
| icon | <code>string</code> | 

<a name="ToolItemBuilder+addTooltip"></a>

### toolItemBuilder.addTooltip(tooltip) ⇒ [<code>ToolItemBuilder</code>](#ToolItemBuilder)
It defines a toolitem's description.

**Kind**: instance method of [<code>ToolItemBuilder</code>](#ToolItemBuilder)  

| Param | Type |
| --- | --- |
| tooltip | <code>string</code> | 

<a name="ToolItemBuilder+build"></a>

### toolItemBuilder.build() ⇒ <code>void</code>
Add to the HTML body with all the customization previously added.

**Kind**: instance method of [<code>ToolItemBuilder</code>](#ToolItemBuilder)  
<a name="Toolbar"></a>

## Toolbar : <code>object</code>
Customize the Equo Toolbar using Toolbar var.

**Kind**: global namespace  
<a name="create"></a>

## create() ⇒ [<code>ToolbarBuilder</code>](#ToolbarBuilder)
Initialize toolbar.

**Kind**: global function  
