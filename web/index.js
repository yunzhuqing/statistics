import Vue from 'vue';
import ViserVue from 'viser-vue';
Vue.use(ViserVue);

import Test from './test.vue';
import Line from './line.vue'

var app = new Vue({
    el: '#app',
    data: {
        message: 'hello world'
    },
    components: {
        'test-a': Test,
        'line-a': Line
    }
});