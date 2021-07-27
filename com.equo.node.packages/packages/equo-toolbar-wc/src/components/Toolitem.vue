<template>
  <b-navbar-nav v-if="visible === 'true'">
    <b-nav-item>
      <button type="button" class="btnb btn" @mouseover="tooltipVisible = true" @mouseleave="tooltipVisible = false" ref="button" @click="eventhandler">
        <equo-toolicon :icon="icon"/>
      </button>
      <div v-if="tooltipVisible" ref="tooltip" role="tooltip" tabindex="-1" class="tooltip b-tooltip bs-tooltip-top" x-placement="top" :style="this.tooltipStyle">
        <div class="arrow" style="left: 0px;"></div>
        <div class="tooltip-inner">{{ tooltip }}</div>
      </div>
    </b-nav-item>
  </b-navbar-nav>
</template>

<script>
import EquoToolicon from '../components/Toolicon.vue';
import { EquoCommService } from '@equo/comm';

  export default {
    name: "equo-toolitem",
    components: {EquoToolicon},
    props: {
      commevent: {
        type: String
      },
      tooltip: {
        type: String,
        default: "Tooltip"
      },
      icon: {
        type: String,
        default: ""
      },
      visible: {
        type: String,
        default: "false"
      }
    },
    methods: {
      eventhandler(){
        if (this.commevent) {
          EquoCommService.get().send(this.commevent);
        }
      }
    },
    data() {
      return {
        tooltipVisible: false,
        tooltipStyle: ""
      }
    },
    updated() {
      if (this.$refs.button != undefined && this.$refs.tooltip != undefined) {
        let buttonRef = this.$refs.button.getBoundingClientRect();
        let tooltipRef = this.$refs.tooltip.getBoundingClientRect();
        let left = (buttonRef.left + buttonRef.width/2 - tooltipRef.width/2 );
        let minLeft = left < 0 ? 5 : ((left + tooltipRef.width) >= window.screen.width ? window.screen.width - tooltipRef.width - 5 : left);
        this.tooltipStyle = "position: absolute; transform: translate(0px," + buttonRef.bottom + "px); top: 0px; left:" + minLeft +"px;"
      }
    },
  }
</script>

<style>

.btnb {
  height: 30px;
  border-color: transparent;
  background-color:transparent;
  display: flex;
}

.btnb:hover {
  background-color:rgba(255,255,255,0.3);
}

.btn-check:focus + .btn,
.btn:focus {
  box-shadow: none;
}

@import url("./../styles/bootstrap-vue.css");
@import url("./../styles/bootstrap.css");
</style>