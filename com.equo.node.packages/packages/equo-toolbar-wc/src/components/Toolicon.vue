<template>
    <span class="v-btn__content"><img :src="getImg" class="tool-icon"/></span>
</template>
<script>

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
            if (this.icon.startsWith("http://") || this.icon.startsWith("https://")) {
                return this.icon;
            } else if (this.icon === "") {
                return "";
            }
            return '/img/' + this.icon;
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
