<template>
    <div>
        <v-chart :forceFit="true" :height="height" :data="data" :scale="scale">
            <v-tooltip />
            <v-axis />
            <v-bar position="year*sales" />
        </v-chart>
    </div>
</template>

<script>
    const data = [
        { year: '1', sales: 38 },
        { year: '2', sales: 38 },
        { year: '3', sales: 38 },
        { year: '4', sales: 38 },
        { year: '5', sales: 38 },
        { year: '6', sales: 38 },
        { year: '7', sales: 38 },
        { year: '8', sales: 38 },
        { year: '9', sales: 38 },
        { year: '10', sales: 38 },
        { year: '11', sales: 38 },
        { year: '12', sales: 38 },
        { year: '13', sales: 38 },
        { year: '14', sales: 38 },
        { year: '15', sales: 38 },
        { year: '16', sales: 38 },
        { year: '67', sales: 38 },
        { year: '18', sales: 38 },
        { year: '19', sales: 38 },
        { year: '20', sales: 38 },
        { year: '21', sales: 38 },
        { year: '22', sales: 38 },
        { year: '23', sales: 38 },
        { year: '24', sales: 38 },
        { year: '24', sales: 38 },
    ];

    const scale = [{
        dataKey: 'sales',
        tickInterval: 20,
    }];

    export default {
        data() {
            return {
                data: data,
                scale: scale,
                height: 400,
            };
        },
        methods: {

        },
        mounted() {

        }
    };
</script>