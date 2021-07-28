<template>
  <div class="toolbar-container" :style="getBgColor">
    <b-navbar class="toolbar-nav">
      <slot></slot>
    </b-navbar>
    <equo-toolitem :tooltip="closeTooltip" :icon="closeIcon" :visible="closeVisible" :commevent="closeEvent" class="close-item"></equo-toolitem>
  </div>
</template>

<script>
import EquoToolitem from '../components/Toolitem.vue';
export default {
  name: 'equo-toolbar',
  components: {EquoToolitem},
  props: {
    toolbarColor: {
      type: String,
      default: "#007bff"
    },
    closeTooltip: {
      type: String,
      default: "Tooltip"
    },
    closeIcon: {
      type: String,
      default:""
    },
    closeVisible: {
      type: String,
      default: "false"
    },
    closeEvent: {
      type: String
    }
  },
  computed: {
    getBgColor() {
      return {background:this.toolbarColor};
    }
  }
}

</script>
<style>
.toolbar-nav,
.toolbar-container {
  display: flex;
  min-height: 35px;
  padding-left: 5px;
  padding-right: 5px;
  align-items: center;
}

.toolbar-nav {
  flex-wrap: wrap;
}

.close-item {
  margin-left: auto;
  align-self: normal;
}

</style>
