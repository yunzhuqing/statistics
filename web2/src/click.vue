<template>
    <div id="index" class="index">
      <div>
        <label>首页加载</label>
        <v-chart :forceFit="true" :height="height" :data="coordinates" :scale="scale" :width="width">
          <v-tooltip />
          <v-axis />
          <v-bar position="x*y" />
        </v-chart>
      </div>

      <div>
        <label>点击最高的组件</label>
        <v-chart :forceFit="true" :height="height" :data="maxKeys" :scale="scale" :width="width">
          <v-tooltip />
          <v-axis />
          <v-bar position="x*y" />
        </v-chart>
      </div>
    </div>

</template>
<script>
    const scale = [{
      dataKey: 'y',
      min: 0,
    },{
      dataKey: 'x'
    }];

    export default {
      name:'click',
      data() {
          return {
            coordinates: [],
            maxKeys: [],
            scale: scale,
            height: 400,
            width: 800
          };
      },
      methods: {
      },
      mounted() {
        this.axios.get(
          '/api/data', {
            params: {
              key: 'index',
              groupType: 0,
              start: 86400000
            }
          }
        ).then(resp => {
          this.coordinates = resp.data;
        });
        this.axios.get(
          '/api/maxKeys', {
            params: {
              groupType: 1,
              diff: 86400000
            }
          }
        ).then(resp => {
          this.maxKeys = resp.data;
        });
      }
    };
</script>
<style>
  .index {
    margin-top: 50px;
  }

</style>
