<template>
  <b-navbar-nav v-if="visible === 'true'">
    <b-nav-item>
      <button type="button" class="btnb btn" data-toggle="tooltip" data-placement="bottom" :title="tooltip" @click="eventhandler">
        <equo-toolicon :icon="icon"/>
      </button>
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
    }
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

@import url("./../styles/bootstrap-vue.css");
@import url("./../styles/bootstrap.css");
</style>