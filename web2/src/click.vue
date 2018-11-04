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
            scale: scale,
            height: 400,
            width: 800
          };
      },
      methods: {
      },
      mounted() {
        var that=this;
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
      }
    };
</script>
<style>
  .index {
    margin-top: 50px;
  }

</style>
