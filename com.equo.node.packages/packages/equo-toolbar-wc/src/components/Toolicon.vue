<template>
    <img :src="getImg" class="tool-icon"/>
</template>
<script>

import iconFolder from '../assets/folder.png';
import iconSearch from '../assets/search.png';
import iconTimes from '../assets/times.svg';

export default {
    name: "equo-toolicon",
    props: {
        icon: {
            type: String,
            required: true
        }
    },
    computed: {
        getImg() {
            if (this.icon.startsWith("./assets/")) {
                if (this.icon.endsWith("folder.png")) {
                    return iconFolder
                } else if (this.icon.endsWith("times.svg")) {
                    return iconTimes;
                }
                return iconSearch;
            }
            return this.icon;
        }
    }
}
</script>
<style scope>
.tool-icon {
    width: 1.2em;
    height: 1.2em;
}
</style>
