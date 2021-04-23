//require ('./../../equo-toolbar-wc/dist/equotoolbarwc.min.js');
import '@equo/equo-toolbar-wc';

export class Linker {

  private toolbarBuilder: ToolbarBuilder;
  private toolItemBuilder!: ToolItemBuilder;

  constructor() {
    this.toolbarBuilder = new ToolbarBuilder(this);
  }

  public getToolbarBuilder(): ToolbarBuilder {
    return this.toolbarBuilder;
  }

  public getToolItemBuilder(): ToolItemBuilder {
    return this.toolItemBuilder;
  }

  public createNewToolItemBuilder(toolbar: EquoToolbar): ToolItemBuilder {
    this.toolItemBuilder = new ToolItemBuilder(this, toolbar);
    return this.toolItemBuilder;
  }

  public createNewToolbarBuilder(): ToolbarBuilder {
    this.toolbarBuilder = new ToolbarBuilder(this);
    return this.toolbarBuilder;
  }

}

//----------------------------BUILDERS----------------------------
export class ToolbarBuilder {
  private linker: Linker;
  private equoToolbar: EquoToolbar;

  /**
   * @name ToolbarBuilder
   * @class
   */
  constructor(linker: Linker) {
    this.linker = linker;
    this.equoToolbar = new EquoToolbar();
  }
  /**
   * Change the toolbar's background color using rgb or hexacode.
   * @param {string} color 
   * @returns {ToolbarBuilder}
   */
  public withBackgroundColor(color: string) {
    this.equoToolbar.setColour(color);
    return this;
  }
  /**
   * Add a new item to the toolbar.
   * @returns {ToolItemBuilder}
   */
  public addToolItem(): ToolItemBuilder {
    return this.linker.createNewToolItemBuilder(this.equoToolbar);
  }
  /**
   * Add to the HTML body with all the customization previously added.
   * @returns {void}
   */
  public build(): void {
    let toolbar = document.createElement('equotoolbarwc-toolbar');

    let toolbarColor = this.equoToolbar.getColour();
    if (typeof toolbarColor !== undefined) {
      toolbar.setAttribute('color', toolbarColor);
    }

    var toolitems: Array<EquoToolItem> = this.equoToolbar.getToolItems();

    for (let i = 0; i < toolitems.length; i++) {
      this.defineToolItem(toolitems, i, toolbar);
    }

    document.body.insertBefore(toolbar,document.body.firstChild);
  }


  private defineToolItem(toolitems: EquoToolItem[], index: number, toolbar: HTMLElement) {
    let toolitem = document.createElement('equotoolbarwc-toolitem');

    var icon: string = toolitems[index].getIcon();
    if (icon !== "") {
      toolitem.setAttribute("icon", icon);
    }
    else{
      console.warn("ToolItem icon by Default, please check the Toolbar Api Documentation to change the Toolitem icon");
    }
    var tooltip: string = toolitems[index].getTooltip();
    if (tooltip !== "") {
      toolitem.setAttribute("tooltip", tooltip);
    }
    var eventHandlerToolItem: Function = toolitems[index].getEventHandler();
    if (eventHandlerToolItem) {
      toolitem.setAttribute("eventhandler", eventHandlerToolItem.toString());
    }

    toolbar.appendChild(toolitem);
  }
}

//-------------------------------------------
export class ToolItemBuilder {
  private linker: Linker;
  private toolItem: EquoToolItem
  private toolbar: EquoToolbar
  /**
   * 
   * @class
   * @name ToolItemBuilder
   */
  constructor(linker: Linker, toolbar: EquoToolbar) {
    this.linker = linker;
    this.toolItem = new EquoToolItem();
    this.toolbar = toolbar;
    this.toolbar.addToolItem(this.toolItem);
  }
  /**
   * Add a new item to the toolbar.
   * @returns {ToolItemBuilder}
   */
  public addToolItem(): ToolItemBuilder {
    return this.linker.createNewToolItemBuilder(this.toolbar);
  }
  /**
   * Add functionality when the item is clicked.
   * @param {Function} eventHandler 
   * @returns {ToolItemBuilder}
   */
  public onClick(eventHandler: Function): ToolItemBuilder {
    this.toolItem.setEventHandler(eventHandler);
    return this;
  }
  /**
   * Add an specific icon on the new toolItem. The available icons to this toolbar belong to the fontawesome library. Here, in Fontawesome Icons website, we can choose the desired icon just adding the icon name as method's parameter.
   * @param {string} icon 
   * @returns {ToolItemBuilder}
   */
  public addIcon(icon: string): ToolItemBuilder {
    this.toolItem.setIcon(icon);
    return this;
  }
  /**
   * It defines a toolitem's description.
   * @param {string} tooltip 
   * @returns {ToolItemBuilder}
   */
  public addTooltip(tooltip: string): ToolItemBuilder {
    this.toolItem.setTooltip(tooltip);
    return this;
  }
  /**
   * Add to the HTML body with all the customization previously added.
   * @returns {void}
   */
  public build(): void {
    this.linker.getToolbarBuilder().build();
  }

}
//--------------------------POJOS-----------------------
export class EquoToolbar {
  private colour: string;
  private childrens: Array<EquoToolItem>;

  constructor() {
    this.colour = "";
    this.childrens = [];
  }

  public setColour(colour: string): void {
    this.colour = colour;
  }

  public getColour(): string {
    return this.colour;
  }

  public getToolItems(): Array<EquoToolItem> {
    return this.childrens;
  }

  public addToolItem(toolItem: EquoToolItem): void {
    this.childrens.push(toolItem);
  }

  public clearToolItems(): void {
    this.childrens = [];
  }
}
//----------------------------------------------------------
export class EquoToolItem {
  private tooltip: string;
  private icon: string;
  private eventHandler!: Function;

  constructor() {
    this.icon = "";
    this.tooltip = "";
  }

  public setTooltip(tooltip: string): void {
    this.tooltip = tooltip;
  }

  public getTooltip(): string {
    return this.tooltip;
  }

  public setIcon(icon: string): void {
    this.icon = icon;
  }

  public getIcon(): string {
    return this.icon;
  }

  public setEventHandler(eventHandler: Function): void {
    this.eventHandler = eventHandler;
  }

  public getEventHandler(): Function {
    return this.eventHandler;
  }

}
/**
 * @namespace
 * @description Customize the Equo Toolbar using Toolbar var.
 */
export namespace Toolbar {
  /**
   * Initialize toolbar.
   * @function
   * @name create
   * @returns {ToolbarBuilder}
   */
  export function create(): ToolbarBuilder {
    return new Linker().getToolbarBuilder();
  }
}
