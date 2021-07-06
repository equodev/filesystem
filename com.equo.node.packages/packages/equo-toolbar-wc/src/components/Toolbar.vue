<template>
    <div data-app class="toolbar-container">
        <v-toolbar height="35px" :color="color">
          <slot></slot>
          <v-spacer></v-spacer>
          <v-tooltip bottom v-if="crossenable === 'true'">
            <template v-slot:activator="{ on: tooltip }">
              <v-btn
                dark
                icon
                text
                v-on:click="eventhandlerEval"
                v-on="{...tooltip}"
              >
              <equo-toolicon :icon="icon"/>
              </v-btn>
            </template>
            <span>{{crosstooltip}}</span>
          </v-tooltip>
        </v-toolbar>
    </div>
</template>

<script>
import {VToolbar, VBtn, VSpacer, VTooltip} from 'vuetify/lib';
import EquoToolicon from '../components/Toolicon.vue';

export default {
  name: 'equo-toolbar',
  components: { VToolbar, VBtn, VSpacer, VTooltip, EquoToolicon},
  props: {
    color: {
      type: String,
      default: "#07F"
    },
    eventhandler: {
      type: String,
      default: (() => {}).toString()
    },
    crossenable: {
      type: String,
      default: "true"
    },
    crosstooltip: {
      type: String,
      default: "Tooltip"
    },
    icon: {
      type: String,
      default: ""
    }
  },
  methods: {
    eventhandlerEval(){
      var f = new Function("return " + this.eventhandler.toString())();
      f();
    }
  }
}

</script>
<style>
.toolbar-container{
  height: 35px;
}
.v-toolbar__content, .v-toolbar__extension {
    padding: 0px 0px;
}
@import url("./../styles/vuetify.css");
@import url("./../styles/styles.css");

</style>
