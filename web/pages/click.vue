<template>
    <div id="index">
        <v-chart :forceFit="true" :height="height" :data="data" :scale="scale">
            <v-tooltip />
            <v-axis />
            <v-bar position="year*sales" />
        </v-chart>
    </div>
</template>

<script>

    export default {
        data() {
            return {
                data: [],
                scale: [],
                height: 400,
            };
        },
        methods: {
        },
        mounted() {
        }
    };
</script>