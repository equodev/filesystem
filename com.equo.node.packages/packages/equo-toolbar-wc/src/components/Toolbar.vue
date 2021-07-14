<template>
  <b-navbar class="toolbar-container " :style="getBgColor">
    <slot></slot>
  </b-navbar>
</template>

<script>
export default {
  name: 'equo-toolbar',
  props: {
    toolbarColor: {
      type: String,
      default: "#007bff"
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
.toolbar-container {
  display: flex;
  height: 35px;
  padding-left: 5px;
  padding-right: 5px;
  align-items: center;
}

</style>
