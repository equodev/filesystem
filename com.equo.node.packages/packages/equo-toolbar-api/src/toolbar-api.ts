/****************************************************************************
**
** Copyright (C) 2021 Equo
**
** This file is part of Equo Framework.
**
** Commercial License Usage
** Licensees holding valid commercial Equo licenses may use this file in
** accordance with the commercial license agreement provided with the
** Software or, alternatively, in accordance with the terms contained in
** a written agreement between you and Equo. For licensing terms
** and conditions see https://www.equoplatform.com/terms.
**
** GNU General Public License Usage
** Alternatively, this file may be used under the terms of the GNU
** General Public License version 3 as published by the Free Software
** Foundation. Please review the following
** information to ensure the GNU General Public License requirements will
** be met: https://www.gnu.org/licenses/gpl-3.0.html.
**
****************************************************************************/

//require ('./../../equo-toolbar-wc/dist/equotoolbarwc.min.js');
import '@equo/equo-toolbar-wc';
import { EquoCommService, EquoComm } from '@equo/comm'

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
  private toolbar: HTMLElement= document.createElement('equotoolbarwc-toolbar');
  private id: string;
  private comm: EquoComm; 

  /**
   * @name ToolbarBuilder
   * @class
   */
  constructor(linker: Linker) {
    this.linker = linker;
    this.equoToolbar = new EquoToolbar();
    this.id = Math.random().toString(36).substr(2, 9).trim();
    this.comm = EquoCommService.get();
  }
  /**
   * Changes the toolbar's background color using rgb or hexacode.
   * @param {string} color 
   * @returns {ToolbarBuilder}
   */
  public withBackgroundColor(color: string): ToolbarBuilder {
    this.equoToolbar.setColour(color);
    return this;
  }
  /**
   * Sets value "true" for enable close  button or "false" for disabled. Default is disabled.
   * @param {string} value 
   * @returns {ToolbarBuilder}
   */
  public closeEnable(value: boolean): ToolbarBuilder {
    this.toolbar.setAttribute('close-visible', String(value));
    return this;
  }
  /**
   * Sets icon for close button.
   * @param icon 
   * @returns {ToolbarBuilder}
   */
  public setCloseIcon(icon: string): ToolbarBuilder {
    this.toolbar.setAttribute('close-icon', icon);
    return this;
  }
  /**
   * Sets text for close button tooltip.
   * @param {string} value
   * @returns {ToolbarBuilder}
   */
  public setCloseTooltip(value: string): ToolbarBuilder {
    this.toolbar.setAttribute('close-tooltip', value);
    return this;
  }
  /**
   * Gets whether close button is enabled or not.
   * @returns {string | null}
   */
  public getCrossEnable(): string | null {
    return this.toolbar.getAttribute('close-visible');
  }
  /**
   * @callback eventHandlerCallback
   * @param {EquoComm} [comm] - Optional. EquoComm instance.
   */
  /**
   * Adds the functionality when the close button is clicked.
   * @param {eventHandlerCallback} eventHandler
   * @returns {ToolbarBuilder}
   */
  public setCloseFunction(eventHandler: (comm?: EquoComm) => void): ToolbarBuilder {
    this.comm.on(this.id, () => { eventHandler(this.comm) });
    this.toolbar.setAttribute('close-event', this.id);
    return this;
  }
  /**
   * Sets the shortcut for close button.
   * @param {string} shortcut
   * @returns {ToolItemBuilder}
   */
  public setCloseShortcut(shortcut: String): ToolbarBuilder {
    this.comm.send("_addShortcut", {
      shortcut: shortcut,
      event: this.id
    });
    return this;
  }
  /**
   * Adds a new item to the toolbar.
   * @returns {ToolItemBuilder}
   */
  public addToolItem(): ToolItemBuilder {
    return this.linker.createNewToolItemBuilder(this.equoToolbar);
  }
  /**
   * Builds the HTML body with all the customization previously added.
   * @returns {void}
   */
  public build(): void {
    let toolbarColor = this.equoToolbar.getColour();
    if (typeof toolbarColor !== undefined) {
      this.toolbar.setAttribute('toolbar-color', toolbarColor);
    }

    var toolitems: Array<EquoToolItem> = this.equoToolbar.getToolItems();

    for (let i = 0; i < toolitems.length; i++) {
      this.defineToolItem(toolitems, i, this.toolbar);
    }

    document.body.insertBefore(this.toolbar,document.body.firstChild);
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
    var action = toolitems[index].getAction();
    if (action) {
      toolitem.setAttribute("commevent", action);
    }

    toolitem.setAttribute("visible", "true");

    toolbar.appendChild(toolitem);
  }
}

//-------------------------------------------
export class ToolItemBuilder {
  private linker: Linker;
  private toolItem: EquoToolItem
  private toolbar: EquoToolbar
  private comm = EquoCommService.get();
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
   * Adds a new item to the toolbar.
   * @returns {ToolItemBuilder}
   */
  public addToolItem(): ToolItemBuilder {
    return this.linker.createNewToolItemBuilder(this.toolbar);
  }
  /**
   * @callback eventHandlerCallback
   * @param {EquoComm} [comm] - Optional. EquoComm instance.
   */
  /**
   * Adds the functionality when the item is clicked.
   * @param {eventHandlerCallback} eventHandler
   * @returns {ToolItemBuilder}
   */
  public onClick(eventHandler: (comm?: EquoComm) => void): ToolItemBuilder {
    this.toolItem.setEventHandler(eventHandler);
    this.comm.on(this.toolItem.getAction(), () => { eventHandler(this.comm) });
    return this;
  }
  /**
   * Sets the shortcut for toolItem.
   * @param {string} shortcut
   * @returns {ToolItemBuilder}
   */
  public setShortcut(shortcut: string): ToolItemBuilder {
    this.toolItem.setShortcut(shortcut);
    this.comm.send("_addShortcut", {
      shortcut: shortcut,
      event: this.toolItem.getAction()
    });
    return this;
  }
  /**
   * Sets an specific icon on the new toolItem. Use from assets folder or link.
   * @param {string} icon
   * @returns {ToolItemBuilder}
   */
  public setIcon(icon: string): ToolItemBuilder {
    this.toolItem.setIcon(icon);
    return this;
  }
  /**
   * Defines a toolitem's description.
   * @param {string} tooltip
   * @returns {ToolItemBuilder}
   */
  public addTooltip(tooltip: string): ToolItemBuilder {
    this.toolItem.setTooltip(tooltip);
    return this;
  }
  /**
   * Builds the HTML body with all the customization previously added.
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
  private shortcut!: string;
  private id: string;

  constructor() {
    this.icon = "";
    this.tooltip = "";
    this.id = Math.random().toString(36).substr(2, 9).trim();
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

  public setShortcut(shortcut: string): void {
    this.shortcut = shortcut;
  }

  public getShortcut(): string {
    return this.shortcut;
  }

  public getAction(): string {
    return this.id;
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
