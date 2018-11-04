<template>
    <div id="user" class="user">
      <div class="summary">
        用户总数: <label class="totalNum">{{totalPeople}}</label>
      </div>
      <div class="incre-chart">
        <label>每小时用户增长</label>
        <v-chart :forceFit="true" :height="height" :data="coordinates" :scale="scale" :width="width">
          <v-tooltip />
          <v-axis />
          <v-bar position="x*y" />
        </v-chart>
      </div>
      <div  class="incre-chart">
        <label>用户总数增长趋势</label>
        <v-chart :forceFit="true" :height="height" :data="totalCoor" :scale="scale" :width="width">
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
      name: 'user',
      data() {
          return {
            coordinates: [],
            totalCoor: [],
            scale: scale,
            height: 400,
            width: 1000,
            totalPeople: 100
          };
      },
      methods: {
      },
      mounted() {
        this.axios.get(
          '/api/data', {
            params: {
              key: 'user-total-hour',
              groupType: 0,
              start: 86400000
            }
          }
        ).then(resp => {
          this.coordinates = resp.data;
        });

        this.axios.get(
          '/api/data', {
            params: {
              key: 'user-total',
              groupType: 0,
              start: 86400000
            }
          }
        ).then(resp => {
          this.totalCoor = resp.data;
        });
      }
    };
</script>
<style>
  .index {
    margin-top: 50px;
  }

  .summary {
    margin-top: 20px;
  }

  .totalNum {
    color: #FF0033;
    font-size: 20px;
    size: 40px;
  }

  .incre-chart {
    margin-top: 30px;
  }

</style>
