<template>
  <div id="app">
    <app-header></app-header>
    <router-view/>
    <app-footer></app-footer>
  </div>
</template>

<script>
import appFooter from './components/comment/Foot.vue';
import appHeader from './components/comment/Head.vue';
export default {
  name: 'App',
  components:{
    appFooter,
    appHeader
  }
}
</script>

<style>

</style>
